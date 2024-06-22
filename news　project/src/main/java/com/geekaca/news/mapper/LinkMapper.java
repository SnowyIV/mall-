package com.geekaca.news.mapper;

import com.geekaca.news.domain.Link;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 74168
* @description 针对表【tb_link】的数据库操作Mapper
* @createDate 2023-12-12 22:15:02
* @Entity com.geekaca.news.domain.Link
*/
@Mapper
public interface LinkMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Link record);

    int insertSelective(Link record);

    Link selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Link record);

    int updateByPrimaryKey(Link record);

}
