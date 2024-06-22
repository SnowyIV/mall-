package com.EducationSystem;

public class Student extends People {
    private String cls;
    private String stuaction;

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getStuaction() {
        return stuaction;
    }

    public void setStuaction(String stuaction) {
        this.stuaction = stuaction;
    }
}
