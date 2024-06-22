package com.geekaca.mall.geekmall.mapper;

import com.geekaca.mall.geekmall.domain.MallAdminUserToken;

/**
* @author ytdag
* @description 针对表【tb_newbee_mall_admin_user_token】的数据库操作Mapper
* @createDate 2023-07-14 20:17:03
* @Entity com.geekaca.mall.geekmall.domain.MallAdminUserToken
*/
public interface MallAdminUserTokenMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallAdminUserToken record);

    int insertSelective(MallAdminUserToken record);

    MallAdminUserToken selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallAdminUserToken record);

    int updateByPrimaryKey(MallAdminUserToken record);

}
