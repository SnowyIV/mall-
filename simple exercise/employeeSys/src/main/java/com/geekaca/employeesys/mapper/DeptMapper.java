package com.geekaca.employeesys.mapper;

import com.geekaca.employeesys.domain.Dept;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 74168
* @description 针对表【dept】的数据库操作Mapper
* @createDate 2023-12-11 18:42:28
* @Entity com.geekaca.employeesys.domain.Dept
*/
@Mapper
public interface DeptMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    Dept selectByIdWithEmps(Long id);
}
