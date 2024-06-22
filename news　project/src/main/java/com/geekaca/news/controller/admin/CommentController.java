package com.geekaca.news.controller.admin;

import com.geekaca.news.domain.NewsComment;
import com.geekaca.news.service.CommentService;
import com.geekaca.news.utils.PageResult;
import com.geekaca.news.utils.Result;
import com.geekaca.news.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public String list(HttpServletRequest request) {
        request.setAttribute("path", "comments");
        return "admin/comment";
    }

    @GetMapping("/comments/list")
    @ResponseBody
    public Result list(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit){
        //分页查询
        int count = commentService.GetCount();
        List<NewsComment> commentList = commentService.selectAll(page, limit);
        PageResult pageResult = new PageResult(commentList, count, limit, page);
        return ResultGenerator.genSuccessResult(pageResult);
    }


    @PostMapping("/comments/checkDone")
    @ResponseBody
    public Result checkDone(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (commentService.batchComments(ids) > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("审核失败");
        }
    }


    @PostMapping("/comments/reply")
    @ResponseBody
    public Result doReply(@RequestParam("commentId") Integer commentId,
                          @RequestParam("replyBody") String replyBody) {
        if (commentId == null || commentId < 1 || !StringUtils.hasText(replyBody)) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (commentService.replyComments(commentId, replyBody) > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("回复失败");
        }
    }
}
