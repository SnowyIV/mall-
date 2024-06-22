package com.geekaca.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("/*")
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        req.setCharacterEncoding("UTF-8");
        //可以获得当前访问的路径
        String requestURI = req.getRequestURI();
        if (requestURI.contains("addBrand")|| requestURI.contains("delete")||requestURI.contains("updateBrand")){
            //从session中取值，检查是否有role变量
            HttpSession session = req.getSession();
            Object role = session.getAttribute("role");
            if (role != null) {
                //有role变量说明是管理员，才允许操作, 放行访问
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                //否则不允许
                req.setAttribute("error", "非管理员不允许新增，删除，修改操作");
                req.getRequestDispatcher("/brandList").forward(req, servletResponse);
                return;
            }
        }
        //其他放行
        filterChain.doFilter(servletRequest, servletResponse);
        /**
         * 针对需要保护的接口，统一进行权限判断
         * 如果session中有role数据，说明是管理员，可以进行delete， update，add操作
         * 没有就不允许
         */
//        System.out.println("before doFilter-----");
//
//        System.out.println("after 访问资源后---");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
