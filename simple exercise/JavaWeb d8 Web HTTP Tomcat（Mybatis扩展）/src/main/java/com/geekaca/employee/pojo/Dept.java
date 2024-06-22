package com.geekaca.employee.pojo;

import java.util.List;

public class Dept {
    private Integer id;
    private String dName;
    private String loc;
    private List<EmployeeMsg> empList;

    public List<EmployeeMsg> getEmpList() {
        return empList;
    }

    public void setEmpList(List<EmployeeMsg> empList) {
        this.empList = empList;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", dname='" + dName + '\'' +
                ", loc=" + loc +
                '}';
    }

    public Dept() {
        this.id = id;
        this.dName = dName;
        this.loc = loc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dName;
    }

    public void setDname(String dname) {
        this.dName = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
