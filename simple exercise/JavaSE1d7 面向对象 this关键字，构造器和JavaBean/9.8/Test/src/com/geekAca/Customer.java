package com.geekAca;

//设计客户类(属性：名称、性别、电话)    行为：掏钱、取车
public class Customer {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        phone = 158888888;
        this.phone = phone;
    }

    private String name;
    private char sex;
    private int phone;

    public double giveMoney() {
        double money = 999;
        //一个成员方法调用另一个成员方法
        this.show();
        System.out.println("客户: " + this.name + "正在掏钱 " + money);
        return money;
    }

    public void show() {

    }

    public void fetchCar(Car car) {
        System.out.println("取车:" + car.name + " 价格:" + car.price);
    }
}





