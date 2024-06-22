package com.EducationSystem;

public class Teacher extends People {
    private String department;
    private String tchaction;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTchaction() {
        return tchaction;
    }

    public void setTchaction(String tchaction) {
        this.tchaction = tchaction;
    }
}

