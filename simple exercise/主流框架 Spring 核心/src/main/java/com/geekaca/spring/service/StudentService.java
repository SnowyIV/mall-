package com.geekaca.spring.service;

import com.geekaca.spring.domain.Student;

import java.util.List;

public interface StudentService {
    public int save(Student student);
    public List<Student> loadAll();
}
