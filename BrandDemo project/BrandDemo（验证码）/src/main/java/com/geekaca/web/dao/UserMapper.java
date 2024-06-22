package com.geekaca.web.dao;

import com.geekaca.web.domain.User;
import org.apache.ibatis.annotations.Param;

//DAO 数据访问层 Data access Object
public interface UserMapper {
    /**
     * 业务逻辑  service
     * 注册，登陆
     */

    int addUser(User user);

    User selectByUserNamePassword(User user);

    int selectByUserName(@Param("uname") String uname);



}
