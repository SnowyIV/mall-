package com.geekaca.web;

import com.geekaca.web.constant.WebConstant;
import com.geekaca.web.domain.User;
import com.geekaca.web.service.UserService;
import org.junit.Assert;
import org.junit.Test;

public class TestService {
    @Test
    public void testUserNameExist(){
        UserService userService = new UserService();
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        String result = userService.register(user);
        Assert.assertEquals("用户名已存在测试失败", WebConstant.USERNAME_ALREADY_EXIST,result);
    }

    @Test
    public void testUserReg(){
        UserService userService = new UserService();
        User user = new User();
        user.setUsername("Tom");
        user.setPassword("123456");
        String result = userService.register(user);
        Assert.assertEquals("正常注册测试失败", WebConstant.USER_REGISTER_OK,result);
    }
}
