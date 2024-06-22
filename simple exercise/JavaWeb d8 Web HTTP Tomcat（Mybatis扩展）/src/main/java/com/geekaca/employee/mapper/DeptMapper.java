package com.geekaca.employee.mapper;

import com.geekaca.employee.pojo.Dept;

import java.util.List;

public interface DeptMapper {

    List<Dept> selectDeptById(Integer deptID);


}
