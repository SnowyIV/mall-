package com.geekaca.employeesys.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @TableName dept
 */
@Data
public class Dept implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String dname;

    /**
     *
     */
    private String loc;
    private List<Emp> empList;
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
        Dept other = (Dept) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getDname() == null ? other.getDname() == null : this.getDname().equals(other.getDname()))
                && (this.getLoc() == null ? other.getLoc() == null : this.getLoc().equals(other.getLoc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDname() == null) ? 0 : getDname().hashCode());
        result = prime * result + ((getLoc() == null) ? 0 : getLoc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dname=").append(dname);
        sb.append(", loc=").append(loc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}