package com.geekaca.news;

import com.geekaca.news.domain.News;
import com.geekaca.news.mapper.NewsMapper;
import com.geekaca.news.service.NewsService;
import com.geekaca.news.utils.PageResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class NewsApplicationTests {
    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private NewsService newsService;

    @Test
    public void testNews() {
        News news = newsMapper.selectByPrimaryKey(5L);
        Assertions.assertNotNull(news);

    }

    @Test
    public void selectForeAll() {
        List<News> ForeNewsList = newsService.GetForeAll(1, 5);
        Assertions.assertNotNull(ForeNewsList);
        Assertions.assertTrue(ForeNewsList.size() > 0);
    }

    @Test
    public void testGetById() {
        News newsDetail = newsService.selectById(6);
        Assertions.assertNotNull(newsDetail);
        Assertions.assertTrue(newsDetail.getCommentList() != null && newsDetail.getCommentList().size() > 0);
    }

    @Test
    public void testGetTagNewsList() {
        PageResult page = newsService.getNewsByTagName("Spring", 1);
        List<News> newsList = (List<News>) page.getList();
        Assertions.assertNotNull(newsList);
        Assertions.assertTrue(newsList.size() > 0);

        for (int i = 0; i < newsList.size(); i++) {
            News news = newsList.get(i);
            String newsTags = news.getNewsTags();
            if (newsTags != null) {
                boolean isCOntains =newsTags.contains("Spring");
                System.out.println(isCOntains);
            }

        }
    }

    @Test
    public void testBatchDelNews(){
        Integer[] Ids = {5, 6};
        int deleted = newsService.deleteByIds(Ids);
        Assertions.assertTrue(deleted > 0);
    }
}
