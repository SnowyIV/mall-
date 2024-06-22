package com.geekaca.employeesys;

import com.geekaca.employeesys.domain.Dept;
import com.geekaca.employeesys.domain.Emp;
import com.geekaca.employeesys.domain.EmpDTO;
import com.geekaca.employeesys.domain.Job;
import com.geekaca.employeesys.mapper.DeptMapper;
import com.geekaca.employeesys.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EmployeeSysApplicationTests {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DeptMapper deptMapper;

    @Test
    void testLike() {
        EmpDTO emp = new EmpDTO();
        emp.setEname("白");
        Job job = new Job();
        job.setJname("文员");
        emp.setJob(job);
        List<Emp> allEmployees = employeeService.getAllEmployees(emp);
        Assertions.assertNotNull(allEmployees);
        Assertions.assertTrue(allEmployees.size() > 0);
        System.out.println(allEmployees);
    }

    @Test
    void testGetAll() {
        EmpDTO emp = new EmpDTO();
        Job job = new Job();
        emp.setJob(job);
        List<Emp> allEmployees = employeeService.getAllEmployees(emp);
        Assertions.assertNotNull(allEmployees);
        Assertions.assertTrue(allEmployees.size() > 5);
    }

    @Test
    public void testDept() {
        Dept dept = deptMapper.selectByIdWithEmps(10L);
        Assertions.assertNotNull(dept);
        Assertions.assertNotNull(dept.getEmpList());
        Assertions.assertTrue(dept.getEmpList().size() > 0);
    }
}