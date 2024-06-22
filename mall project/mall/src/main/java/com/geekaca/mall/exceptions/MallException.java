package com.geekaca.mall.exceptions;

/**
 * 业务逻辑异常
 */
public class MallException extends RuntimeException{
    public MallException(String message) {
        super(message);
    }
}
