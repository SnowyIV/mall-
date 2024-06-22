package com.geekaca.spring.service;

import com.geekaca.spring.dao.StudentMapper;
import com.geekaca.spring.domain.Student;

import java.util.List;

//学生业务逻辑
public class StudentServicempl implements StudentService{
    private StudentMapper studentMapper;

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public int save(Student student) {
        return studentMapper.insertStudent(new Student("李四"));
    }
    @Override
    public List<Student> loadAll(){
        return studentMapper.findAll();
    }
}
