package com.geekaca.mall.geekmall.mapper;

import com.geekaca.mall.geekmall.domain.MallUserAddress;

import java.util.List;

/**
* @author ytdag
* @description 针对表【tb_newbee_mall_user_address(收货地址表)】的数据库操作Mapper
* @createDate 2023-07-14 20:17:03
* @Entity com.geekaca.mall.geekmall.domain.MallUserAddress
*/
public interface MallUserAddressMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallUserAddress record);

    int insertSelective(MallUserAddress record);

    MallUserAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallUserAddress record);

    int updateByPrimaryKey(MallUserAddress record);

    List<MallUserAddress> findMyAddressList(Long userId);

    MallUserAddress getMyDefaultAddress(Long userId);
}
