package com.geekaca.news.mapper;

import com.geekaca.news.domain.NewsCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 74168
* @description 针对表【tb_news_category】的数据库操作Mapper
* @createDate 2023-12-12 22:15:02
* @Entity com.geekaca.news.domain.NewsCategory
*/
@Mapper
public interface NewsCategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NewsCategory record);

    int insertSelective(NewsCategory record);

    NewsCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsCategory record);

    int updateByPrimaryKey(NewsCategory record);

    List<NewsCategory> selectAll();
}
