package com.geekaca.mall.mapper;

import com.geekaca.mall.controller.param.PageParam;
import com.geekaca.mall.controller.param.UserParam;
import com.geekaca.mall.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 33
 * @description 针对表【tb_newbee_mall_user】的数据库操作Mapper
 * @createDate 2024-01-10 12:27:15
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

    User selectUser(UserParam userParam);

    int insertUser(User user);

    int selectCountByLoginName(String loginName);

    int updateUserInfo(User userUpdateInfo);

    List<User> selectAllUser(PageParam pageParam);

    int selectCounts(PageParam pageParam);

    int updateUserLock(Long[] ids, int lockedFlag);
}
