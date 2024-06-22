package com.geekaca.web.service;

import com.geekaca.web.constant.WebConstant;
import com.geekaca.web.domain.User;
import com.geekaca.web.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UserService {


    public String register(User user) {
        //连接
        SqlSession sqlSession = openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int cntUname = userMapper.selectByUserName(user.getUsername());
        //判断用户名是否被占用
        if (cntUname > 0){
            return WebConstant.USERNAME_ALREADY_EXIST;
        }
        int added = userMapper.addUser(user);
        if (added > 0){
            return WebConstant.USER_REGISTER_OK;
        }
        return WebConstant.USER_REGISTER_FAIL;
    }

   public boolean isLoginOK(User user){
       SqlSession sqlSession = openSession();
       UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
       User user1 = userMapper.selectByUserNamePassword(user);
       if(user1 != null){
           //登陆成功
           return true;
       }
       return false;
    }

    private static SqlSession openSession() {
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }
}
