package com.geekaca.news.service.impl;

import com.geekaca.news.domain.NewsComment;
import com.geekaca.news.mapper.NewsCommentMapper;
import com.geekaca.news.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private NewsCommentMapper commentMapper;

    @Override
    public int addComment(NewsComment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public List<NewsComment> selectAll(Integer page, Integer limit) {
        int start = (page - 1) * limit;
        return commentMapper.selectAll(start, limit);
    }

    @Override
    public int GetCount() {
        return commentMapper.GetCount();
    }

    @Override
    public int batchComments(Integer[] ids) {
        return commentMapper.batchComments(ids);
    }

    @Override
    public int replyComments(Integer commentId, String replyBody) {
        return commentMapper.replyComments(commentId,replyBody);
    }
}
