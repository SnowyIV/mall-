package com.geeka;
/*
请根据下列描述，选用合适的数据类型定义变量，并输出变量的值。
1、班级里有100个学员。
2、某商品价格55.55元。
3、地球已经诞生超过46亿年。
4、“5是偶数”这句话的描述是假的。
* */
public class Tset04 {
    public static void main(String[] args) {
        int a = 100;//声明变量并赋值
        double b = 55.55;//声明变量并赋值
        String c = "46亿";//声明变量并赋值
        boolean d = false;//声明变量并赋值
        System.out.println("1.班级里有"+a+"个学员\t2.某商品价格"+b+"元\t3.地球已经诞生超过"+c+"年\t4.“5是偶数”这句话的描述是"+d+"的");
    }
}
