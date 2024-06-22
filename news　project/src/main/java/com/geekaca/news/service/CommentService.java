package com.geekaca.news.service;

import com.geekaca.news.domain.NewsComment;

import java.util.List;

public interface CommentService {

    int addComment(NewsComment comment);

    List<NewsComment> selectAll(Integer page, Integer limit);

    int GetCount();

    int batchComments(Integer[] ids);

    int replyComments(Integer commentId, String replyBody);
}
