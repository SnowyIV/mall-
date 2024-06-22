package com.geekaca.news.service.impl;

import com.geekaca.news.domain.News;
import com.geekaca.news.mapper.NewsMapper;
import com.geekaca.news.mapper.NewsTagMapper;
import com.geekaca.news.service.NewsService;
import com.geekaca.news.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
@Autowired
private NewsTagMapper newsTagMapper;
    @Override
    public News selectById(Integer id) {
        return newsMapper.selectById(id);
    }

    @Override
    public List<News> GetForeAll(Integer page,Integer pageSize) {
        int start = (page - 1) * pageSize;
        return newsMapper.GetForeAll(start,pageSize);
    }

    @Override
    public int GetForeCount() {
        return newsMapper.GetForeCount();
    }

    @Override
    public List<News> selectNewsByTimeDesc() {
        return newsMapper.selectNewsByTimeDesc();
    }

    @Override
    public List<News> selectNewsByViewDesc() {
        return newsMapper.selectNewsByViewDesc();
    }

    @Override
    public List<News> getAllNews(Integer page, Integer pageSize, String keyword) {
        int start = (page - 1) * pageSize;
        List<News> newsList = newsMapper.selectAll(start, pageSize,keyword);
        return newsList;
    }

    @Override
    public int getAllNewsCount(String keyword) {
        return newsMapper.selectCount(keyword);
    }

    @Override
    public News getById(Integer id) {
        return newsMapper.selectById(id);
    }

    @Override
    public int updateById(News news) {
        return newsMapper.updateByPrimaryKey(news);
    }

    @Override
    public int addNews(News news) {
        return newsMapper.insert(news);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByIds(Integer[] Ids) {
        int deletedTagRs = newsTagMapper.deleteByNewsId(Ids);
        int deleteNews = newsMapper.deleteByIds(Ids);
        return  deletedTagRs + deleteNews;
    }

    @Override
    public List<News> getTop10LatestNews() {
        return newsMapper.selectNewsByTimeDesc();
    }

    @Override
    public PageResult getNewsByTagName(String tagName, Integer pageNo) {
        int count = newsMapper.selectNewsCountByTagName(tagName);
        int pageSize = 10;
        int start = (pageNo - 1) * pageSize;
        List<News> newsList = newsMapper.selectByTags(tagName, start, pageSize);
        PageResult pageResult = new PageResult(newsList, count, pageSize, pageNo);
        return pageResult;
    }

    @Override
    public PageResult getBlogsPageBySearch(String keyword, Integer page) {
        return null;
    }
}
