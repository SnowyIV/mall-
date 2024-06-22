package com.geekaca.employeesys.service.impl;


import com.geekaca.employeesys.domain.Emp;
import com.geekaca.employeesys.domain.EmpDTO;
import com.geekaca.employeesys.mapper.EmpMapper;
import com.geekaca.employeesys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> getAllEmployees(EmpDTO emp) {
        emp.setPageNo(( emp.getPageNo() - 1)* emp.getPageSize());
        return empMapper.getAll(emp);
    }
    }

