package com.geekaca.employeesys.service;

import com.geekaca.employeesys.domain.Emp;
import com.geekaca.employeesys.domain.EmpDTO;


import java.util.List;

public interface EmployeeService {

    List<Emp>  getAllEmployees(EmpDTO employee);

}
