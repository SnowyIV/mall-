package com.geekaca.employee.pojo;

public class EmployeeMsg {


    private Integer id;
    private String ename;
    private Integer jobid;
    private Integer mgr;
    private String joindate;
    private Integer salary;
    private String bonus;
    private Integer deptid;

    public EmployeeMsg(Integer id, String ename, Integer jobid, Integer mgr, String joindate, Integer salary, String bonus, Integer deptid) {
        this.id = id;
        this.ename = ename;
        this.jobid = jobid;
        this.mgr = mgr;
        this.joindate = joindate;
        this.salary = salary;
        this.bonus = bonus;
        this.deptid = deptid;
    }

    @Override
    public String toString() {
        return "EmployeeMsg{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", jobid=" + jobid +
                ", mgr=" + mgr +
                ", joindate='" + joindate + '\'' +
                ", salary=" + salary +
                ", bonus='" + bonus + '\'' +
                ", deptid=" + deptid +
                '}';
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getJob_id() {
        return jobid;
    }

    public void setJob_id(Integer job_id) {
        this.jobid = jobid;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }


    public Integer getDept_id() {
        return deptid;
    }

    public void setDept_id(Integer dept_id) {
        this.deptid = deptid;
    }


}
