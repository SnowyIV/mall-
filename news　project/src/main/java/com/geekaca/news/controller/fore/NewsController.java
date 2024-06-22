package com.geekaca.news.controller.fore;

import cn.hutool.captcha.ShearCaptcha;
import com.geekaca.news.domain.News;
import com.geekaca.news.domain.NewsComment;
import com.geekaca.news.domain.NewsTag;
import com.geekaca.news.service.*;
import com.geekaca.news.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;


@Controller

public class NewsController {
    @Autowired
    private NewsService newsService;
@Autowired
private ConfigService configService;
@Autowired
private NewsTagService newsTagService;
@Autowired
private CommentService commentService;
@Autowired
 private  TagService tagService;
    public static String theme = "amaze";
    /**
     * 首页
     *
     * @return
     */
    @GetMapping({"/", "/index", "index.html"})
    public String index(HttpServletRequest request) {

        return this.page(request, 1);
    }




    @GetMapping({"/page/{pageNum}"})
    private String page(HttpServletRequest request, @PathVariable("pageNum") int pageNum) {
//        PageResult pageNews = newsService.getPageNews(pageNum, 1);
//
//        request.setAttribute("blogPageResult", pageNews);
        int foreNewsCount = newsService.GetForeCount();
        List<News> foreNewsList = newsService.GetForeAll(pageNum, 10);
        PageResult pageResult = new PageResult(foreNewsList, foreNewsCount, pageNum, 10);
        request.setAttribute("blogPageResult", pageResult);
        //按照新闻创建时间倒序排列
        List<News> top10LatestNews = newsService.selectNewsByTimeDesc();
        request.setAttribute("newBlogs", top10LatestNews);//最新发布
        //点击最多新闻倒续排列
        List<News> Last10NewsViews = newsService.selectNewsByViewDesc();
        request.setAttribute("hotBlogs", Last10NewsViews);//点击最多
        //热门标签正续排列
        List<NewsTag> topTags = newsTagService.SelectAll();
        request.setAttribute("hotTags", topTags);//热门标签
        request.setAttribute("pageName", "首页");
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/index";
    }
//
//    @GetMapping("/fore/newsList")
//    @ResponseBody
//    public PageResult foreNewsList(@RequestParam(value = "pageNo", required = false) Integer pageNo,
//                                   @RequestParam(value = "pageSize", required = false) Integer pageSize){
//        if (pageNo == null ){
//            pageNo = 1;
//        }
//        if (pageSize == null){
//            pageSize = 10;
//        }
//        int foreNewsCount = newsService.GetForeCount();
//        List<News> foreNewsList = newsService.GetForeAll(pageNo, pageSize);
//        PageResult pageResult = new PageResult(foreNewsList, foreNewsCount, pageSize, pageNo);
//        return pageResult;
//    }

    @GetMapping("/blog/{id}")
    public String detail(HttpServletRequest req, @PathVariable("id") Integer id) {
        News newsDetail = newsService.selectById(id);
        String newsTags  = newsDetail.getNewsTags();
        String[] tagArr = newsTags.split(",");
        Collections.addAll(newsDetail.getNewsTagList(),tagArr);
        if (newsDetail != null) {
            req.setAttribute("blogDetailVO", newsDetail);
        }
        req.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/detail";
    }

    /**
     * 评论操作
     *
     * @param request
     * @param session
     * @param newsId      针对哪个新闻
     * @param verifyCode  验证码
     * @param commentator 评论者名字
     * @param email
     * @param websiteUrl
     * @param commentBody 评论内容
     * @return
     */
    @PostMapping(value = "/blog/comment")
    @ResponseBody
    public Result comment(HttpServletRequest request, HttpSession session,
                          @RequestParam Long newsId, @RequestParam String verifyCode,
                          @RequestParam String commentator, @RequestParam String email,
                          @RequestParam String websiteUrl, @RequestParam String commentBody) {
        if (!StringUtils.hasText(verifyCode)) {
            return ResultGenerator.genFailResult("验证码不能为空");
        }
        //从session中取出 生成验证码时候存入的code值
        ShearCaptcha shearCaptcha = (ShearCaptcha) session.getAttribute("verifyCode");
        if (shearCaptcha == null || !shearCaptcha.verify(verifyCode)) {
            return ResultGenerator.genFailResult("验证码错误");
        }
        //保护作用，防止你在别的新闻页面提交针对这个新闻的的评论
        String ref = request.getHeader("Referer");
        if (!StringUtils.hasText(ref)) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (null == newsId || newsId < 0) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (!StringUtils.hasText(commentator)) {
            return ResultGenerator.genFailResult("请输入称呼");
        }
        if (!StringUtils.hasText(email)) {
            return ResultGenerator.genFailResult("请输入邮箱地址");
        }
        if (!PatternUtil.isEmail(email)) {
            return ResultGenerator.genFailResult("请输入正确的邮箱地址");
        }
        if (!StringUtils.hasText(commentBody)) {
            return ResultGenerator.genFailResult("请输入评论内容");
        }
        if (commentBody.trim().length() > 200) {
            return ResultGenerator.genFailResult("评论内容过长");
        }

        NewsComment comment = new NewsComment();
        comment.setNewsId(newsId);
        comment.setCommentator(MyBlogUtils.cleanString(commentator));
        comment.setEmail(email);
        comment.setCommentatorIp(getIP(request));
//        if (PatternUtil.isURL(websiteUrl)) {
//            comment.setWebsiteUrl(websiteUrl);
//        }else{
//            return ResultGenerator.genFailResult("URL格式错误");
//        }
        comment.setCommentBody(MyBlogUtils.cleanString(commentBody));
        return ResultGenerator.genSuccessResult(commentService.addComment(comment));
    }


    public String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    @GetMapping({"/tag/{tagName}"})
    public String tag(HttpServletRequest request, @PathVariable("tagName") String tagName) {
        return tag(request, tagName, 1);
    }

    @GetMapping({"/tag/{tagName}/{page}"})
    public String tag(HttpServletRequest request, @PathVariable("tagName") String tagName, @PathVariable("page") Integer page) {
        PageResult blogPageResult = newsService.getNewsByTagName(tagName, page);
        request.setAttribute("blogPageResult", blogPageResult);
        request.setAttribute("pageName", "标签");
        request.setAttribute("pageUrl", "tag");
        request.setAttribute("keyword", tagName);
        request.setAttribute("newBlogs", newsService.getTop10LatestNews());
        request.setAttribute("hotBlogs", Collections.emptyList());
        request.setAttribute("hotTags",  newsTagService.SelectAll());
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/list";
    }

    @GetMapping({"/search/{keyword}/{page}"})
    public String search(HttpServletRequest request, @PathVariable("keyword") String keyword, @PathVariable("page") Integer page) {

        PageResult pageResult = newsService.getBlogsPageBySearch(keyword, page);
        request.setAttribute("blogPageResult", pageResult);
        request.setAttribute("pageName", "搜索");
        request.setAttribute("pageUrl", "search");
        request.setAttribute("keyword", keyword);
        //按照发布时间倒序 查询 新闻列表 10
        List<News> top10LatestNews = newsService.getTop10LatestNews();
        List<NewsTag> newsTags = tagService.selectAllTagNewsCnt();
        request.setAttribute("newBlogs", top10LatestNews);//最新发布

        request.setAttribute("hotBlogs", Collections.emptyList());//点击最多
//        热门标签 需要的结构List<NewsTag>
        request.setAttribute("hotTags", newsTags);//热门标签
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/list";
    }
    }


