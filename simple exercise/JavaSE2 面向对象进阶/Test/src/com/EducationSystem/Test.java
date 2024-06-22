package com.EducationSystem;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("张三");
        student.setAge(18);
        student.setLesson("查看课表");
        student.setCls("初三一班");
        student.setStuaction("填写听课反馈");
        System.out.println("学生姓名"+student.getName()+",年龄"+student.getAge()+"，所在班级"+student.getCls()+",正在"+student.getLesson()+"，并"+student.getStuaction());
        Teacher teacher = new Teacher();
        teacher.setName("李四");
        teacher.setAge(38);
        teacher.setLesson("查看课表");
        teacher.setDepartment("教务部");
        teacher.setTchaction("发布问题");
        System.out.println("老师姓名"+teacher.getName()+",年龄"+teacher.getAge()+",部门名称"+teacher.getDepartment()+",正在"+teacher.getLesson()+",并"+teacher.getTchaction());
    }
}
