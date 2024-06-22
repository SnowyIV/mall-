package com.geekaca.employeesys.domain;

import lombok.Data;

@Data
public class EmpDTO extends Emp{
    private Integer pageNo;
    private Integer pageSize;
}
