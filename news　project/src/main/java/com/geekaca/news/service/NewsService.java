package com.geekaca.news.service;

import com.geekaca.news.domain.News;
import com.geekaca.news.utils.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsService {
    List<News> getAllNews(Integer page, Integer limit, String keyword);

    int getAllNewsCount(String keyword);

    News getById(Integer id);

    int updateById(News news);

    int addNews(News news);

    int deleteByIds(Integer[] ids);


    List<News> GetForeAll(Integer page, Integer pageSize);

    int GetForeCount();

    List<News> selectNewsByTimeDesc();

    List<News> selectNewsByViewDesc();

    News selectById(Integer id);


    List<News> getTop10LatestNews();

    PageResult getNewsByTagName(String tagName, Integer pageNo);

    PageResult getBlogsPageBySearch(String keyword, Integer page);
}
