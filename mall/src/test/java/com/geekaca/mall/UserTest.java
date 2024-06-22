package com.geekaca.mall;


import com.geekaca.mall.controller.param.UserParam;
import com.geekaca.mall.domain.User;
import com.geekaca.mall.mapper.UserMapper;
import com.geekaca.mall.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void testReg() {
        boolean register = userService.register("guest", "5456421231");
        Assertions.assertFalse(register);
    }

    @Test
    public void testLogin() {
        UserParam userParam = new UserParam();
        userParam.setLoginName("test2");
        userParam.setPasswordMd5("ad0234829205b9033196ba818f7a872b");
        User user = userService.login(userParam);
        Assertions.assertNotNull(user);
    }
}
