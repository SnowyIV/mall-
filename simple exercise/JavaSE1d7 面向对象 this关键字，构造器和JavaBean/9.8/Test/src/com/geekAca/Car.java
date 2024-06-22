package com.geekAca;

//设计汽车类 (属性：名称、价格)
public class Car {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    String name;
    double price;
}
