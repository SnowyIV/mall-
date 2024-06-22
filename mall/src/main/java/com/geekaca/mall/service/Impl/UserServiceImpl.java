package com.geekaca.mall.service.Impl;

import com.geekaca.mall.controller.param.UserParam;
import com.geekaca.mall.domain.User;
import com.geekaca.mall.exceptions.LoginNameExsistsException;
import com.geekaca.mall.mapper.UserMapper;
import com.geekaca.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.geekaca.mall.constants.MallConstants.LOGIN_NAME_EXSISTS;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(String loginName, String password) {
        int cnt = userMapper.selectCountByLoginName(loginName);
        //用户名已存在
        if (cnt > 0) {
            throw new LoginNameExsistsException(LOGIN_NAME_EXSISTS, "用户名" + loginName + "已经被占用");

        }
        User user = new User();
        user.setLoginName(loginName);
        user.setPasswordMd5(password);
        int inserted = userMapper.insert(user);
        return inserted > 0;

    }

    @Override
    public User login(UserParam userParam) {
      return   userMapper.selectByLoginNamePasswd(userParam);
    }
}
