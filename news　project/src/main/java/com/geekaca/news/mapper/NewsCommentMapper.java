package com.geekaca.news.mapper;

import com.geekaca.news.domain.NewsComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 74168
* @description 针对表【tb_news_comment】的数据库操作Mapper
* @createDate 2023-12-12 22:15:02
* @Entity com.geekaca.news.domain.NewsComment
*/
@Mapper
public interface NewsCommentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NewsComment record);

    int insertSelective(NewsComment record);

    NewsComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsComment record);

    int updateByPrimaryKey(NewsComment record);

    List<NewsComment> selectAll(@Param("start") int start, @Param("limit") Integer limit);

    int GetCount();

    int batchComments(Integer[] ids);

    int replyComments(Integer commentId, String replyBody);
}
