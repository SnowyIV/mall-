package com.geekaca.web.service;

import com.geekaca.web.dao.UserMapper;
import com.geekaca.web.domain.User;
import com.geekaca.web.utils.WebConstant;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 业务逻辑层 调用mapper
 * 还有可能调用第三方服务，比如：短信验证码服务  HTTP服务  API接口
 * 你： 开发者
 * Java语言 ：一方
 * 第三方： 既不是你自己开发的，也不是Java语言提供的
 */

public class UserService {


    public String register(User user) {
        SqlSession sqlSession = openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        /**
         * 1, 首先检查用户名是否已经被占用了
         * 2，增加用户
         */
        int cntUname = userMapper.selectByUserName(user.getUsername());
        if (cntUname > 0) {
            //用户名已经被占用了
            return WebConstant.USERNAME_ALREADY_EXIST;
        }
        int added = userMapper.addUser(user);
        if (added > 0) {
            return WebConstant.USER_REGISTER_OK;
        }
        return WebConstant.USER_REGISTER_FAIL;
    }

    public boolean isLoginOk(User user) {
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