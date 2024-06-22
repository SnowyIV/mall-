package com.geekaca.employeesys.domain;

import lombok.Data;

import java.util.List;

@Data
public class PageBean {
    //页码
    private Integer pageNo;
    //页内记录条数
    private Integer pageSize;
    //总记录条数
    private Integer total;
    //当前页的数据
    private List data;
}
