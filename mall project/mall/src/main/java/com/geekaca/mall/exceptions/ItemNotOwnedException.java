package com.geekaca.mall.exceptions;

public class ItemNotOwnedException extends RuntimeException{
    private Integer code;
    private String msg;
    // 用户未登录
    public ItemNotOwnedException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
