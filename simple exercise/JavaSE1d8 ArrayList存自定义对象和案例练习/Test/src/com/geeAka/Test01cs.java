package com.geeAka;

import java.util.ArrayList;

public class Test01cs {
    public static void main(String[] args) {
        //创建集合并添加数据
        Test01 stu1 = new Test01(20180302, "叶孤城", 23, "护理一班");
        Test01 stu2 = new Test01(20180303, "东方不败", 23, "推拿二班");
        Test01 stu3 = new Test01(20180304, "西门吹雪", 26, "护理一班");
        Test01 stu4 = new Test01(20180305, "叶超峰", 33, "神经一班");
        ArrayList<Test01> stuList = new ArrayList<>();
        stuList.add(stu1);
        stuList.add(stu2);
        stuList.add(stu3);
        stuList.add(stu4);
        String classmz = "护理一班";
        //调用方法查找并使年龄+1
        Test01 classname = findclas(stuList, classmz);
        if (classname != null) {
            System.out.println("找到了 班级为：" + classmz + " 年龄+1为： " + (classname.getAge() + 1));
        } else {
            System.out.println("没有找到班级为:" + classmz + " 的学生");
        }
        System.out.println("------------------------------");
    }

    //创建方法查找数组中符合条件的值
    public static Test01 findclas(ArrayList<Test01> list, String clas) {
        for (int i = 0; i < list.size(); i++) {
            Test01 classname = list.get(i);
            if (clas.equals(classname.getClas())) {
                return classname;
            }
        }
        return null;
    }
}
