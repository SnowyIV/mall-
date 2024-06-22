package com.geekaca.web.mapper;

import com.geekaca.web.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    //注册
    int addUser(User user);

    //查询
    User selectByUserNamePassword(User user);

    int selectByUserName(@Param("uname") String uname);

}
