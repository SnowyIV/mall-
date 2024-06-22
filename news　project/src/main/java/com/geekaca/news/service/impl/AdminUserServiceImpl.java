package com.geekaca.news.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.geekaca.news.domain.AdminUser;
import com.geekaca.news.mapper.AdminUserMapper;
import com.geekaca.news.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;



@Service
public class AdminUserServiceImpl implements AdminUserService {
@Autowired
private AdminUserMapper adminUserMapper;
    @Override
    public AdminUser login(AdminUser adminUser) {
        String mdPasswd = SecureUtil.md5(adminUser.getLoginPassword());
        adminUser.setLoginPassword(mdPasswd);
       AdminUser user = adminUserMapper.selectByUserNamePasswd(adminUser);
        return user;
    }
}
