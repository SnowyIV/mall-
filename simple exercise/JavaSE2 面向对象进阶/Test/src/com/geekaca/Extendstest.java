package com.geekaca;

public class Extendstest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setName("李四");
        teacher.setAge(38);
        teacher.teach();
        System.out.println("老师名字" + teacher.getName() + "老师年龄" + teacher.getAge());
        Student student = new Student();
        student.setName("张三");
        student.setAge(18);
        student.study();
        System.out.println("学生名字" + student.getName() + "学生年龄" + student.getAge());
    }
}
