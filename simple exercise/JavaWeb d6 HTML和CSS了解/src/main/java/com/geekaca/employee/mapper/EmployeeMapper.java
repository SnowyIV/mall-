package com.geekaca.employee.mapper;

import com.geekaca.employee.pojo.Dept;
import com.geekaca.employee.pojo.EmployeeMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
//    //新增了一个部门：旅游部 insert 部门表
//    int addDept(Dept dept);
//    /**
//     * 查询
//     */
//    List<Dept> selectAll1();
//    //向该旅游部门加入员工白龙马
//    int addEmployeeMsg(EmployeeMsg emp);
//    /**
//     * 查询
//     */
//    List<EmployeeMsg> selectAll();
//
//    //职位是经理的员工，所有人工资扣除1000
//    void update(int jobid);
//    /**
//     * 查询
//     */
//    List<EmployeeMsg> selectJobId(int jobid);
    //员工，职位，部门组合查询
    List<EmployeeMsg> selectFind(EmployeeMsg employeeMsg);

}
