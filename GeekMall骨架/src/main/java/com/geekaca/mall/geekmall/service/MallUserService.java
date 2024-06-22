package com.geekaca.mall.geekmall.service;

import com.geekaca.mall.geekmall.controller.param.MallUserLoginParam;
import com.geekaca.mall.geekmall.controller.param.MallUserRegisterParam;
import com.geekaca.mall.geekmall.controller.param.MallUserUpdateParam;
import com.geekaca.mall.geekmall.domain.MallUser;

public interface MallUserService {

    boolean register(MallUserRegisterParam userRegisterParam);

    String login(MallUserLoginParam userLoginParam);

    /**
     * 用户信息修改
     *
     * @param mallUser
     * @return
     */
    boolean updateUserInfo(MallUserUpdateParam mallUser, Long userId);

    Boolean logout(long uidLong);

    MallUser getUserById(long uidLong);

    Boolean lockUsers(Long[] ids, int lockStatus);
}
