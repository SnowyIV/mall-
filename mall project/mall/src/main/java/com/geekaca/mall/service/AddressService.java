package com.geekaca.mall.service;

import com.geekaca.mall.domain.UserAddress;

import java.util.List;

public interface AddressService {
    UserAddress selectAddressByUserId(Long userId);

    List<UserAddress> getUserAddressList(Integer uid);

    int updateUserDefaultAddress(Integer uid);

    int addUserAddress(UserAddress userAddress);

    UserAddress getChooseAddr(Integer addrId);

    int updateUserAddr(UserAddress userAddress);
}
