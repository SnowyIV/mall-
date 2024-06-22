package com.geekaca.news.mapper;

import com.geekaca.news.domain.Config;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author ytdag
* @description 针对表【tb_config】的数据库操作Mapper
* @createDate 2023-12-12 11:14:42
* @Entity com.geekaca.news.domain.Config
*/
@Mapper
public interface ConfigMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Config record);

    int insertSelective(Config record);

    Config selectByPrimaryKey(String configName);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);

    List<Config> selectAll();
}
