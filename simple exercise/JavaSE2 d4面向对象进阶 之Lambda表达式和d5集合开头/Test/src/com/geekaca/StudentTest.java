package com.geekaca;

import java.util.HashSet;
import java.util.Set;


public class StudentTest {
    public static void main(String[] args) {
        Set<Student1> student1Set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            Student1 stu = new Student1(Integer.toString(i),"张三丰"+i,"昆仑山"+(i+1)+"号");
            student1Set.add(stu);
        }
        Student1 stu2 = new Student1(Integer.toString(0),"张三丰"+0,"昆仑山"+(0+1)+"号");
        student1Set.add(stu2);
        student1Set.forEach(stu -> {
            System.out.println(stu);
        });
    }
}
