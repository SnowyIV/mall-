package com.geekaca.mall.geekmall.service;

import com.geekaca.mall.geekmall.controller.param.AdminLoginParam;
import com.geekaca.mall.geekmall.domain.MallAdminUser;
import com.geekaca.mall.geekmall.domain.MallUser;

public interface AdminUserService {

    public String login(AdminLoginParam loginParam);

    MallAdminUser getUserDetailById(Long adminUserId);

    void logout(Long adminUserId);


    MallAdminUser getUserById(long uidLong);

}
