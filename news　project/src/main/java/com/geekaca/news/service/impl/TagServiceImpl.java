package com.geekaca.news.service.impl;

import com.geekaca.news.domain.NewsTag;
import com.geekaca.news.mapper.NewsTagMapper;
import com.geekaca.news.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private NewsTagMapper tagMapper;

    @Override
    public List<NewsTag> selectAllTagNewsCnt() {
        return tagMapper.selectAllTagNewsCnt();
    }

    @Override
    public int deleteTagById(Integer tagId) {
//        if(查询到这个标签下文章数量>0){
//            //提示用户，就提示 ：请先删除类别下的文章，然后再删除类别
//            throw new BusinessException(502, "类别下有文章，不能删除");
//            //通过AOP 统一异常捕获，接口返回统一Result结构
//        }
        return 0;
    }
}
