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
    //封装部门和职位的信息
    Dept dept;
    Job job;

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
                ", dept=" + dept +
                ", job=" + job +
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

    public Integer getJobid() {
        return jobid;
    }

    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    public Integer getMgr() {
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

    public Integer getSalary() {
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

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public EmployeeMsg() {
        this.id = id;
        this.ename = ename;
        this.jobid = jobid;
        this.mgr = mgr;
        this.joindate = joindate;
        this.salary = salary;
        this.bonus = bonus;
        this.deptid = deptid;
        this.dept = dept;
        this.job = job;
    }
//    public EmployeeMsg(Integer id, String ename, Integer jobid, Integer mgr, String joindate, Integer salary, String bonus, Integer deptid) {
//        this.id = id;
//        this.ename = ename;
//        this.jobid = jobid;
//        this.mgr = mgr;
//        this.joindate = joindate;
//        this.salary = salary;
//        this.bonus = bonus;
//        this.deptid = deptid;
//    }
//
//    @Override
//    public String toString() {
//        return "EmployeeMsg{" +
//                "id=" + id +
//                ", ename='" + ename + '\'' +
//                ", jobid=" + jobid +
//                ", mgr=" + mgr +
//                ", joindate='" + joindate + '\'' +
//                ", salary=" + salary +
//                ", bonus='" + bonus + '\'' +
//                ", deptid=" + deptid +
//                '}';
//    }
//
//    public Integer getId() {
//
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getEname() {
//        return ename;
//    }
//
//    public void setEname(String ename) {
//        this.ename = ename;
//    }
//
//    public Integer getJob_id() {
//        return jobid;
//    }
//
//    public void setJob_id(Integer job_id) {
//        this.jobid = jobid;
//    }
//
//    public int getMgr() {
//        return mgr;
//    }
//
//    public void setMgr(Integer mgr) {
//        this.mgr = mgr;
//    }
//
//    public String getJoindate() {
//        return joindate;
//    }
//
//    public void setJoindate(String joindate) {
//        this.joindate = joindate;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(Integer salary) {
//        this.salary = salary;
//    }
//
//    public String getBonus() {
//        return bonus;
//    }
//
//    public void setBonus(String bonus) {
//        this.bonus = bonus;
//    }
//
//
//    public Integer getDept_id() {
//        return deptid;
//    }
//
//    public void setDept_id(Integer dept_id) {
//        this.deptid = deptid;
//    }
//

}
