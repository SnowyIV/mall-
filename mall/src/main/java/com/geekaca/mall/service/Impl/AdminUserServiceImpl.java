package com.geekaca.mall.service.Impl;

import com.geekaca.mall.controller.param.AdminLoginParam;
import com.geekaca.mall.domain.AdminUser;
import com.geekaca.mall.mapper.AdminUserMapper;
import com.geekaca.mall.service.AdminUserService;
import com.geekaca.mall.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;
//参照前台自己写的
//    @Override
//    public AdminUser login(AdminLoginParam adminLoginParam) {
//        return adminUserMapper.checkLogin(adminLoginParam);
//    }


    @Override
    public String login(AdminLoginParam adminLoginParam) {
        AdminUser adminUser = adminUserMapper.checkLogin(adminLoginParam);
        if (adminUser == null){
            //登陆失败
            return null;
        }
        // 可优化： 前台后台用户，通过类型字段区分开
        //生成token
        //Long -》String
        String token = JwtUtil.createToken(adminUser.getAdminUserId().toString(), adminUser.getLoginUserName());
        return token;
    }
}

