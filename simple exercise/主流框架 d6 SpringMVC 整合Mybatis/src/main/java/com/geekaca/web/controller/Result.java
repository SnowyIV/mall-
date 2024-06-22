package com.geekaca.web.controller;

public class Result {
    private Integer code;
    private String msg;
    //是所有引用类型的父类，任何引用类型的变量都可以赋值给data
    //父类类型 指向 子类对象
    //动物  ---> 猫，狗
    private Object data;

    public Result() {
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
