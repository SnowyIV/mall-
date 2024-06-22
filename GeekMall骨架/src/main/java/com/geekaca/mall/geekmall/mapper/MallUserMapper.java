package com.geekaca.mall.geekmall.mapper;

import com.geekaca.mall.geekmall.controller.vo.PageVO;
import com.geekaca.mall.geekmall.domain.MallUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author ytdag
* @description 针对表【tb_newbee_mall_user】的数据库操作Mapper
* @createDate 2023-07-14 20:17:03
* @Entity com.geekaca.mall.geekmall.domain.MallUser
*/
public interface MallUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallUser record);

    int insertSelective(MallUser record);

    MallUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallUser record);

    int updateByPrimaryKey(MallUser record);

    MallUser selectByName(String loginName);

    MallUser selectByNameAndPass(@Param("loginName") String loginName, @Param("password") String password);

    List<MallUser> selectAllMember(PageVO pageVOparams);

    Integer selectAllRecord();

    int lockUserBatch(@Param("ids") Long[] ids, @Param("lockStatus") int lockStatus);
}
