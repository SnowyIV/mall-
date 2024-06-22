package com.geekaca.mall.geekmall.mapper;

import com.geekaca.mall.geekmall.controller.param.AdminLoginParam;
import com.geekaca.mall.geekmall.domain.MallAdminUser;
import com.geekaca.mall.geekmall.domain.MallUser;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ytdag
* @description 针对表【tb_newbee_mall_admin_user】的数据库操作Mapper
* @createDate 2023-07-14 20:17:03
* @Entity com.geekaca.mall.geekmall.domain.MallAdminUser
*/
@Mapper
public interface MallAdminUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallAdminUser record);

    int insertSelective(MallAdminUser record);

    MallAdminUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallAdminUser record);

    int updateByPrimaryKey(MallAdminUser record);

    MallAdminUser login(AdminLoginParam loginParam);

    MallAdminUser getUserById(long uidLong);

}
