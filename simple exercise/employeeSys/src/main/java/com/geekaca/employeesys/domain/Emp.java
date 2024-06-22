package com.geekaca.employeesys.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * @TableName emp
 */
@Data
public class Emp implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String ename;

    /**
     *
     */
    private Integer jobId;

    /**
     *
     */
    private Integer mgr;

    /**
     *
     */
    private Date joindate;

    /**
     *
     */
    private BigDecimal salary;

    /**
     *
     */
    private BigDecimal bonus;

    /**
     *
     */
    private Integer deptId;
    private Job job;
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Emp other = (Emp) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getEname() == null ? other.getEname() == null : this.getEname().equals(other.getEname()))
                && (this.getJobId() == null ? other.getJobId() == null : this.getJobId().equals(other.getJobId()))
                && (this.getMgr() == null ? other.getMgr() == null : this.getMgr().equals(other.getMgr()))
                && (this.getJoindate() == null ? other.getJoindate() == null : this.getJoindate().equals(other.getJoindate()))
                && (this.getSalary() == null ? other.getSalary() == null : this.getSalary().equals(other.getSalary()))
                && (this.getBonus() == null ? other.getBonus() == null : this.getBonus().equals(other.getBonus()))
                && (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEname() == null) ? 0 : getEname().hashCode());
        result = prime * result + ((getJobId() == null) ? 0 : getJobId().hashCode());
        result = prime * result + ((getMgr() == null) ? 0 : getMgr().hashCode());
        result = prime * result + ((getJoindate() == null) ? 0 : getJoindate().hashCode());
        result = prime * result + ((getSalary() == null) ? 0 : getSalary().hashCode());
        result = prime * result + ((getBonus() == null) ? 0 : getBonus().hashCode());
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ename=").append(ename);
        sb.append(", jobId=").append(jobId);
        sb.append(", mgr=").append(mgr);
        sb.append(", joindate=").append(joindate);
        sb.append(", salary=").append(salary);
        sb.append(", bonus=").append(bonus);
        sb.append(", deptId=").append(deptId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}