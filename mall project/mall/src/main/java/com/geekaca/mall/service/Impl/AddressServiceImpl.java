package com.geekaca.mall.service.impl;

import com.geekaca.mall.domain.UserAddress;
import com.geekaca.mall.mapper.UserAddressMapper;
import com.geekaca.mall.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public UserAddress selectAddressByUserId(Long userId) {
        return userAddressMapper.selectByUserId(userId);
    }

    @Override
    public List<UserAddress> getUserAddressList(Integer uid) {
        return userAddressMapper.selectAddressListByUserId(uid);
    }

    @Override
    public int updateUserDefaultAddress(Integer uid) {
        return userAddressMapper.updateDefaultAddress(uid);
    }

    @Override
    public int addUserAddress(UserAddress userAddress) {
        return userAddressMapper.insertSelective(userAddress);
    }

    @Override
    public UserAddress getChooseAddr(Integer addrId) {
        return userAddressMapper.selectByPrimaryKey(Long.valueOf(addrId));
    }

    @Override
    public int updateUserAddr(UserAddress userAddress) {
        return userAddressMapper.updateByPrimaryKeySelective(userAddress);
    }
}
