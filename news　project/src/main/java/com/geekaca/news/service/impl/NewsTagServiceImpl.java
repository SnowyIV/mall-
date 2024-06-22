package com.geekaca.news.service.impl;


import com.geekaca.news.domain.NewsTag;
import com.geekaca.news.mapper.NewsTagMapper;
import com.geekaca.news.service.NewsTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NewsTagServiceImpl implements NewsTagService {
@Autowired
private NewsTagMapper newsTagMapper;


    @Override
    public List<NewsTag> SelectAll() {
        return newsTagMapper.SelectAll();
    }
}
