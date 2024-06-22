package com.geekaca.mall.geekmall.config;

import com.geekaca.mall.geekmall.common.Constants;
import com.geekaca.mall.geekmall.exceptions.BusinessException;
import com.geekaca.mall.geekmall.exceptions.NotLoginException;
import com.geekaca.mall.geekmall.utils.Result;
import com.geekaca.mall.geekmall.utils.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//切面拦截   AOP  拦截自定义异常
@RestControllerAdvice
@Slf4j
public class ExceptionResolver {
    /**
     * 参数格式不符合要求，会触发
     * 参数不匹配异常
     * 函数返回值：
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Result methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("------->MethodArgumentNotValidException参数异常-------- ", e);
        //接口返回一个失败的结果     后面： 获取 违反了domain类声明的哪个规则
        return ResultGenerator.genFailResult("参数异常" + e.getBindingResult().getFieldError().getDefaultMessage());
        //getDefaultMessage()会返回message信息
    }

    @ExceptionHandler(value = BusinessException.class)
    public Result businessExceptionHandler(BusinessException be){
        log.error(" 业务异常 ", be);
        return ResultGenerator.genErrorResult(500, be.getMessage());
    }

    @ExceptionHandler(value = NotLoginException.class)
    public Result businessExceptionHandler(NotLoginException be){
        log.error(" 未登录异常 ", be);
        //让接口返回 这个结果
        return ResultGenerator.genErrorResult(Constants.NO_LOGIN, be.getMessage());
    }
}
