package com.geekaca.mall.exceptions;

public class LoginNameExsistsException extends RuntimeException{
    private int code;
    public LoginNameExsistsException(int code,String message){
        super(message);
        this.code = code;
    }
}
