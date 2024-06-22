package com.geeka;
/*
请编写程序，将某位学员的个人信息输出到屏幕上。信息包括姓名（字符串常量）、性别（字符常
量）、年龄（整型常量）、身高（单位米，小数常量）、婚否（布尔常量）。
 */
public class Test02 {
    public static void main(String[] args) {
        String name = "孙航";  //声明变量并赋值
        char sex ='男';  //声明变量并赋值
        int age =27;  //声明变量并赋值
        double height = 180.2; //声明变量并赋值
        boolean marry = false; //声明变量并赋值
        System.out.println("姓名："+name+",性别"+sex+",年龄"+age+",身高"+height+",婚否"+marry+"");
    }
}
