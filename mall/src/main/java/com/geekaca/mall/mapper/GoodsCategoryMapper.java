package com.geekaca.mall.mapper;

import com.geekaca.mall.controller.param.CategoryParam;
import com.geekaca.mall.domain.GoodsCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 74168
* @description 针对表【tb_newbee_mall_goods_category】的数据库操作Mapper
* @createDate 2024-01-10 21:00:52
* @Entity com.geekaca.mall.domain.GoodsCategory
*/
@Mapper
public interface GoodsCategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);

    GoodsCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsCategory record);

    int updateByPrimaryKey(GoodsCategory record);

    List<GoodsCategory> selectByLevelAndParentIds(CategoryParam categoryParam);

    int getCountByLevelAndParentIds(CategoryParam categoryParam);
}
