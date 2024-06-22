package com.geekaca.news.mapper;

import com.geekaca.news.domain.NewsTag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 74168
* @description 针对表【tb_news_tag】的数据库操作Mapper
* @createDate 2023-12-12 22:15:02
* @Entity com.geekaca.news.domain.NewsTag
*/
@Mapper
public interface NewsTagMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NewsTag record);

    int insertSelective(NewsTag record);

    NewsTag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsTag record);

    int updateByPrimaryKey(NewsTag record);

    List<NewsTag> SelectAll();

    int deleteByNewsId(Integer[] Ids);

    List<NewsTag> selectAllTagNewsCnt();
}
