package com.geekaca.mall.mapper;

import com.geekaca.mall.controller.param.IndexConfigsParam;
import com.geekaca.mall.domain.IndexConfig;
import com.geekaca.mall.utils.PageResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 33
* @description 针对表【tb_newbee_mall_index_config(配置表，保存针对首页配置信息)】的数据库操作Mapper
* @createDate 2024-01-10 12:27:15
* @Entity com.geekaca.mall.domain.IndexConfig
*/
@Mapper
public interface IndexConfigMapper {

    int deleteByPrimaryKey(Long id);

    int insert(IndexConfig record);

    int insertSelective(IndexConfig record);

    IndexConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IndexConfig record);

    int updateByPrimaryKey(IndexConfig record);

    List<IndexConfig> selectByConfigType(@Param("configType") Integer configType, @Param("limit") Integer limit);

    List<IndexConfig> selectInfoByType(IndexConfigsParam indexConfigsParam);

    int selectCount(IndexConfigsParam indexConfigsParam);

    boolean deleteByIds(Long[] ids);
}
