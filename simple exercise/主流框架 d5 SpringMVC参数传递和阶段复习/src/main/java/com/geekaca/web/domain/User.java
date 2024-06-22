package com.geekaca.web.domain;

public class User {
    //null
    private String name;
    //默认值 0
    private int age;
    //引用类型 null
    private Address address;

    /**
     * JSON结构  对象
     *  {
     *      "name": "tom",
     *      "age": 19,
     *      "address": {
     *          ""province":"广东",
     *          "city": "深圳"
     *      }
     *  }
     *
     */

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
