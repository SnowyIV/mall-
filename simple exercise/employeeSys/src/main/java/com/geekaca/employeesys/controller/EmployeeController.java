package com.geekaca.employeesys.controller;

import com.geekaca.employeesys.domain.Emp;
import com.geekaca.employeesys.domain.EmpDTO;
import com.geekaca.employeesys.domain.PageBean;
import com.geekaca.employeesys.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/queryEmployee")
    public Result queryEmployee(@RequestBody EmpDTO empDTO) {
        if (empDTO.getPageNo() == null) {
            empDTO.setPageNo(1);
        }
        if (empDTO.getPageSize() == null) {
            empDTO.setPageSize(10);
        }
        //发送一个查询数量的方法   符合条件的记录条数
        int counts = 0;
        List<Emp> allEmployees = employeeService.getAllEmployees(empDTO);
        Result result = new Result();
        if (allEmployees != null) {
            PageBean pageBean = new PageBean();
            pageBean.setTotal(counts);
            pageBean.setData(allEmployees);
            //手动复制
            BeanUtils.copyProperties(empDTO, pageBean);
//            pageBean.setPageNo(empDTO.getPageNo());
//            pageBean.setPageSize(empDTO.getPageSize());
            result.setCode(200);
            result.setData(pageBean);
        }
        return result;
    }
}
