package com.geekaca.mall.geekmall.mapper;

import com.geekaca.mall.geekmall.domain.MallOrderAddress;

/**
* @author ytdag
* @description 针对表【tb_newbee_mall_order_address(订单收货地址关联表)】的数据库操作Mapper
* @createDate 2023-07-14 20:17:03
* @Entity com.geekaca.mall.geekmall.domain.MallOrderAddress
*/
public interface MallOrderAddressMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallOrderAddress record);

    int insertSelective(MallOrderAddress record);

    MallOrderAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallOrderAddress record);

    int updateByPrimaryKey(MallOrderAddress record);

}
