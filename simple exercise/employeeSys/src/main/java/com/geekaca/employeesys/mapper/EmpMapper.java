package com.geekaca.employeesys.mapper;

import com.geekaca.employeesys.domain.Emp;
import com.geekaca.employeesys.domain.EmpDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 74168
* @description 针对表【emp】的数据库操作Mapper
* @createDate 2023-12-11 18:42:28
* @Entity com.geekaca.employeesys.domain.Emp
*/
@Mapper
public interface EmpMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    List<Emp> getAll(EmpDTO emp);
}
