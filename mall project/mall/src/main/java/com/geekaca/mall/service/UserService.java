package com.geekaca.mall.service;

import com.geekaca.mall.controller.param.PageParam;
import com.geekaca.mall.controller.param.UserParam;
import com.geekaca.mall.domain.User;
import com.geekaca.mall.utils.PageResult;


public interface UserService {
    User login(UserParam userParam);

    int userRegister(String loginName, String password);

    User getUserById(long uidLong);

    int updateUserInfo(User userUpdateInfo);

    PageResult selectAllMember(PageParam pageParam);

    int updateUserLock(Long[] ids, int lockedFlag);
}
