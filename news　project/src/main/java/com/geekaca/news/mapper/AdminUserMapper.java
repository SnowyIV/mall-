package com.geekaca.news.mapper;

import com.geekaca.news.domain.AdminUser;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 74168
* @description 针对表【tb_admin_user】的数据库操作Mapper
* @createDate 2023-12-12 22:15:02
* @Entity com.geekaca.news.domain.AdminUser
*/
@Mapper
public interface AdminUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);

    AdminUser selectByUserNamePasswd(AdminUser adminUser);
}
