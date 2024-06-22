package com.geekaca.employeesys.mapper;

import com.geekaca.employeesys.domain.Salarygrade;

/**
* @author 74168
* @description 针对表【salarygrade】的数据库操作Mapper
* @createDate 2023-12-11 18:42:28
* @Entity com.geekaca.employeesys.domain.Salarygrade
*/
public interface SalarygradeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Salarygrade record);

    int insertSelective(Salarygrade record);

    Salarygrade selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Salarygrade record);

    int updateByPrimaryKey(Salarygrade record);

}
