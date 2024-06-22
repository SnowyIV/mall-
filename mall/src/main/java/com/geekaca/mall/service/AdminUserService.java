package com.geekaca.mall.service;

import com.geekaca.mall.controller.param.AdminLoginParam;
import com.geekaca.mall.domain.AdminUser;

public interface AdminUserService {
//参照前台自己写的
//    AdminUser login(AdminLoginParam adminLoginParam);
    String login(AdminLoginParam adminLoginParam);

}