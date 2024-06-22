package com.geekaca.mall.service;

import com.geekaca.mall.controller.param.UserParam;
import com.geekaca.mall.domain.User;

public interface UserService {
   boolean register(String username,String password);

   User login(UserParam userParam);
}
