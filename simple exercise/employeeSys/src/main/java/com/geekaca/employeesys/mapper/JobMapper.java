package com.geekaca.employeesys.mapper;

import com.geekaca.employeesys.domain.Job;

/**
* @author 74168
* @description 针对表【job】的数据库操作Mapper
* @createDate 2023-12-11 18:42:28
* @Entity com.geekaca.employeesys.domain.Job
*/
public interface JobMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);

}
