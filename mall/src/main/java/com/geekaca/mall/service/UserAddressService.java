package com.geekaca.mall.service;

import com.geekaca.mall.domain.OrderAddress;
import com.geekaca.mall.domain.UserAddress;

import java.util.List;

public interface UserAddressService {
    List<UserAddress> getUserAddressList(Integer userId);

    UserAddress getUserAddressById(Integer addressId);

    int addUserAddress(UserAddress orderAddress);

    UserAddress getUserDefaultAddress(Integer uid);
}
