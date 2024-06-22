package com.geekaca.news.mapper;

import com.geekaca.news.domain.News;
import com.geekaca.news.utils.PageResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 74168
* @description 针对表【tb_news】的数据库操作Mapper
* @createDate 2023-12-12 22:15:02
* @Entity com.geekaca.news.domain.News
*/
@Mapper
public interface NewsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    List<News> selectAll(@Param("start") Integer start, @Param("limit") Integer limit, String keyword);

    int selectCount(String keyword);


    int deleteByIds(Integer[] Ids);

    //前台的查询所有
    List<News> GetForeAll(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    int GetForeCount();

    List<News> selectNewsByTimeDesc();

    List<News> selectNewsByViewDesc();


    News selectById(Integer id);

    List<News> selectByTags(@Param("tagName") String tagName, @Param("start") int start,@Param("pageSize") int pageSize);

    int selectNewsCountByTagName(String tagName);

    PageResult getBlogsPageBySearch(String keyword, Integer page);
}
