package com.geekaca.employeesys.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName salarygrade
 */
@Data
public class Salarygrade implements Serializable {
    /**
     * 
     */
    private Integer grade;

    /**
     * 
     */
    private Integer losalary;

    /**
     * 
     */
    private Integer hisalary;

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
        Salarygrade other = (Salarygrade) that;
        return (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()))
            && (this.getLosalary() == null ? other.getLosalary() == null : this.getLosalary().equals(other.getLosalary()))
            && (this.getHisalary() == null ? other.getHisalary() == null : this.getHisalary().equals(other.getHisalary()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
        result = prime * result + ((getLosalary() == null) ? 0 : getLosalary().hashCode());
        result = prime * result + ((getHisalary() == null) ? 0 : getHisalary().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", grade=").append(grade);
        sb.append(", losalary=").append(losalary);
        sb.append(", hisalary=").append(hisalary);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}