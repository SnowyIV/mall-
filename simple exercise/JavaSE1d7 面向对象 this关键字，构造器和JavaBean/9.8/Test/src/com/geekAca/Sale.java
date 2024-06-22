package com.geekAca;

//设计销售类(属性：名称、性别、电话)        行为：卖车
public class Sale {
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
        this.phone = phone;
    }

    private String name;
    private char sex;
    private int phone;

    public void saleCar(double money) {
        System.out.println("销售人员" + name + " 收到:" + money);
    }
}
