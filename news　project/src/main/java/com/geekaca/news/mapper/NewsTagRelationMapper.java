package com.geekaca.news.mapper;

import com.geekaca.news.domain.NewsTagRelation;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 74168
* @description 针对表【tb_news_tag_relation】的数据库操作Mapper
* @createDate 2023-12-12 22:15:02
* @Entity com.geekaca.news.domain.NewsTagRelation
*/
@Mapper
public interface NewsTagRelationMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NewsTagRelation record);

    int insertSelective(NewsTagRelation record);

    NewsTagRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsTagRelation record);

    int updateByPrimaryKey(NewsTagRelation record);

}
