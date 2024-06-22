package com.geekaca.employeesys.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器 类似servlet 过滤器
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        //类似StringBuilder ，线程安全的
        StringBuffer requestURL = request.getRequestURL();
        if (requestURL.toString().contains("/admin")){
            //如果访问的是管理员相关的路径
            if (token == null || "".equals(token.trim())){
                //拦截，不允许访问指定的接口
                return false;
            }else{
                return true;
            }
            //token解析，提取用户的类型信息


        }
        return true;
    }
}
