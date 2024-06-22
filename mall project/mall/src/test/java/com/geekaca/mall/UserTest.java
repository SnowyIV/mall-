package com.geekaca.mall;

import com.geekaca.mall.controller.param.UserParam;
import com.geekaca.mall.domain.User;
import com.geekaca.mall.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    @Transactional  // 事务注解
    @Rollback(true)  // 回滚注解，确保测试完成后回滚事务
    public void testReg(){
        int register = userService.userRegister("guest1", "skdjfklsjdf");
        Assertions.assertEquals(1, register);
    }

    @Test
    @Transactional  // 事务注解
    @Rollback(true)  // 回滚注解，确保测试完成后回滚事务
    public void testLogin(){
        UserParam userParam = new UserParam();
        userParam.setLoginName("guest");
        userParam.setPasswordMD5("e10adc3949ba59abbe56e057f20f883e");
        User user = userService.login(userParam);
        Assertions.assertNotNull(user);
    }
}
