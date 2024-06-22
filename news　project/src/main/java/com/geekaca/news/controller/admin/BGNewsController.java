package com.geekaca.news.controller.admin;

import com.geekaca.news.domain.News;
import com.geekaca.news.domain.NewsCategory;
import com.geekaca.news.service.CategoryService;
import com.geekaca.news.service.NewsService;
import com.geekaca.news.utils.PageResult;
import com.geekaca.news.utils.Result;
import com.geekaca.news.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BGNewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/blogs")
    public String list(HttpServletRequest request) {
        request.setAttribute("path", "edit");
        return "admin/blog";
    }

    @GetMapping("/blogs/list")
    @ResponseBody
    public Result blogList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit,@RequestParam(value = "keyword",required = false) String keyword) {

        //  1，先查询符合条件的总记录条数
        //   2， 查询符合条件的当前页数据list
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = 10;
        }

            int allNewsCount = newsService.getAllNewsCount(keyword);
            List<News> NewsList = newsService.getAllNews(page, limit,keyword);

            Result rs = new Result();
            rs.setResultCode(200);
            PageResult pageResult = new PageResult(NewsList, allNewsCount, limit, page);

            rs.setData(pageResult);
            return rs;
        }

    @GetMapping("/blogs/edit")
    public String edit(HttpServletRequest request) {
        request.setAttribute("path", "edit");
        request.setAttribute("categories", categoryService.getAllCategories());
        return "admin/edit";
    }

    @GetMapping("/blogs/edit/{id}")
    public String editNews(@PathVariable("id") Integer id,HttpServletRequest req) {
        //根据id查询某个新闻的详情
        News news = newsService.getById(id);
        //查询所有类别的数据
        List<NewsCategory> allCategories = categoryService.getAllCategories();
req.setAttribute("categories",allCategories);
        req.setAttribute("blog",news);
        return "admin/edit";
    }

    @PostMapping("/blogs/update")
    @ResponseBody
    public Result updateNews(@RequestParam("blogId") Long blogId,
                             @RequestParam("blogTitle") String blogTitle,
                             @RequestParam(name = "blogSubUrl", required = false) String blogSubUrl,
                             @RequestParam("blogCategoryId") Integer blogCategoryId,
                             @RequestParam("blogTags") String blogTags,
                             @RequestParam("blogContent") String blogContent,
                             @RequestParam("blogCoverImage") String blogCoverImage,
                             @RequestParam("blogStatus") Integer blogStatus,
                             @RequestParam("enableComment") Integer enableComment){
        if (!StringUtils.hasText(blogTitle)) {
            return ResultGenerator.genFailResult("请输入文章标题");
        }
        if (blogTitle.trim().length() > 150) {
            return ResultGenerator.genFailResult("标题过长");
        }
        if (!StringUtils.hasText(blogTags)) {
            return ResultGenerator.genFailResult("请输入文章标签");
        }
        if (blogTags.trim().length() > 150) {
            return ResultGenerator.genFailResult("标签过长");
        }
        if (blogSubUrl.trim().length() > 150) {
            return ResultGenerator.genFailResult("路径过长");
        }
        if (!StringUtils.hasText(blogContent)) {
            return ResultGenerator.genFailResult("请输入文章内容");
        }
        if (blogTags.trim().length() > 100000) {
            return ResultGenerator.genFailResult("文章内容过长");
        }
        if (!StringUtils.hasText(blogCoverImage)) {
            return ResultGenerator.genFailResult("封面图不能为空");
        }
        News news = new News();
        news.setNewsId(blogId);
        news.setNewsTitle(blogTitle);
        news.setNewsSubUrl(blogSubUrl);
        news.setNewsCategoryId(blogCategoryId);
        news.setNewsTags(blogTags);
        news.setNewsContent(blogContent);
        news.setNewsCoverImage(blogCoverImage);
        news.setNewsStatus(blogStatus);
        news.setEnableComment(enableComment);
        news.setUpdateTime(new Date());
        int updated = newsService.updateById(news);
        if (updated > 0){
            return ResultGenerator.genSuccessResult("更新成功");
        }else {
            return ResultGenerator.genFailResult("更新失败");
        }
    }

    @PostMapping("/blogs/save")
    @ResponseBody
    public Result addNews(@RequestParam("blogTitle") String blogTitle,
                          @RequestParam(name = "blogSubUrl", required = false) String blogSubUrl,
                          @RequestParam("blogCategoryId") Integer blogCategoryId,
                          @RequestParam("blogTags") String blogTags,
                          @RequestParam("blogContent") String blogContent,
                          @RequestParam("blogCoverImage") String blogCoverImage,
                          @RequestParam("blogStatus") Integer blogStatus,
                          @RequestParam("enableComment") Integer enableComment){
        if (!StringUtils.hasText(blogTitle)) {
            return ResultGenerator.genFailResult("请输入文章标题");
        }
        if (blogTitle.trim().length() > 150) {
            return ResultGenerator.genFailResult("标题过长");
        }
        if (!StringUtils.hasText(blogTags)) {
            return ResultGenerator.genFailResult("请输入文章标签");
        }
        if (blogTags.trim().length() > 150) {
            return ResultGenerator.genFailResult("标签过长");
        }
        if (blogSubUrl.trim().length() > 150) {
            return ResultGenerator.genFailResult("路径过长");
        }
        if (!StringUtils.hasText(blogContent)) {
            return ResultGenerator.genFailResult("请输入文章内容");
        }
        if (blogTags.trim().length() > 100000) {
            return ResultGenerator.genFailResult("文章内容过长");
        }
        if (!StringUtils.hasText(blogCoverImage)) {
            return ResultGenerator.genFailResult("封面图不能为空");
        }
        News news = new News();
        news.setNewsTitle(blogTitle);
        news.setNewsSubUrl(blogSubUrl);
        news.setNewsCategoryId(blogCategoryId);
        news.setNewsTags(blogTags);
        news.setNewsContent(blogContent);
        news.setNewsCoverImage(blogCoverImage);
        news.setNewsStatus(blogStatus);
        news.setEnableComment(enableComment);
        news.setCreateTime(new Date());
        news.setUpdateTime(new Date());
        news.setNewsViews(0L);
        int updated = newsService.addNews(news);
        if (updated > 0){
            return ResultGenerator.genSuccessResult("新增成功");
        }else {
            return ResultGenerator.genFailResult("新增失败");
        }
    }

@PostMapping("/blogs/delete")
@ResponseBody
public Result delete(@RequestBody Integer[] ids) {
    if (ids.length < 1) {
        return ResultGenerator.genFailResult("参数异常！");
    }
    int deleted = newsService.deleteByIds(ids);
    if (deleted > 0){
        return ResultGenerator.genSuccessResult("删除成功");
    }else{
        return ResultGenerator.genFailResult("删除失败");
    }
}

}

