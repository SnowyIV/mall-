package com.geekaca.spring.dao;

import com.geekaca.spring.domain.Student;

import java.util.ArrayList;
import java.util.List;

//模拟mapper
public class StudentMapper {
    public List<Student> findAll() {
        System.out.println("findAll().........");
        List<Student> list = new ArrayList<>();
        Student stu = new Student();
        stu.setName("张三");
        list.add(stu);
        return list;
    }

    public  int insertStudent(Student stu){
        return 1;
    }
}
