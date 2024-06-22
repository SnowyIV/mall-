package com.geekaca;

import java.util.Objects;

public class Student1 {
    private String stuNO;
    private String name;
    private String addr;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student1 student1 = (Student1) o;
        return Objects.equals(stuNO, student1.stuNO) && Objects.equals(name, student1.name) && Objects.equals(addr, student1.addr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuNO);
    }

    public Student1(String stuNO, String name, String addr) {
        this.stuNO = stuNO;
        this.name = name;
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "stuNO='" + stuNO + '\'' +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }

    public String getStuNO() {
        return stuNO;
    }

    public void setStuNO(String stuNO) {
        this.stuNO = stuNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
