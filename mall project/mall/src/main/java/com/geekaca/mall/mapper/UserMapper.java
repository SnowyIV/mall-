package com.geekaca.mall.mapper;

import com.geekaca.mall.controller.param.UserParam;
import com.geekaca.mall.domain.User;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.ManagedBean;

/**
* @author 74168
* @description 针对表【tb_newbee_mall_user】的数据库操作Mapper
* @createDate 2024-01-10 21:00:52
* @Entity com.geekaca.mall.domain.User
*/
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int selectCountByLoginName(String loginName);

    User selectByLoginNamePasswd(UserParam userParam);
}
