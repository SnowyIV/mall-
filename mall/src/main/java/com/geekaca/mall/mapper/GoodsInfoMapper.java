package com.geekaca.mall.mapper;

import com.geekaca.mall.controller.param.GoodsParam;
import com.geekaca.mall.controller.param.SellStatusIdParam;
import com.geekaca.mall.domain.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 74168
* @description 针对表【tb_newbee_mall_goods_info】的数据库操作Mapper
* @createDate 2024-01-10 21:00:52
* @Entity com.geekaca.mall.domain.GoodsInfo
*/
@Mapper
public interface GoodsInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);

    List<GoodsInfo> selectGoodsListByCondition(GoodsParam goodsParam);

    int selectGoodsCountByCondition(GoodsParam goodsParam);

    int updateSellStatus(Long[] ids, int sellStatus);

}
