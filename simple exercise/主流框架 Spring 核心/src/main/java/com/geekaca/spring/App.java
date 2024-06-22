package com.geekaca.spring;

import com.geekaca.spring.domain.Student;
import com.geekaca.spring.service.StudentService;
import com.geekaca.spring.service.StudentServicempl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        //自己new对象，会导致没人帮你传mapper类
        StudentServicempl studentServicempl = new StudentServicempl();
        studentServicempl.loadAll();

    }

    private static void testIOC() {
        //获取学生对象并调用方法
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService stuService = (StudentService) ctx.getBean("stuService");
        List<Student> students = stuService.loadAll();
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    private static void test() {
        //Spring的方式
        //1.获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student stu1 = (Student) ctx.getBean("stu");
        stu1.setName("张三");
        System.out.println(stu1.getName());
    }
}
