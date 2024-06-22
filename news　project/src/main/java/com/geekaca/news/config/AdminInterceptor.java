package com.geekaca.news.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //放行 true, 拒绝 false
        //判断 用户访问路径
        StringBuffer requestURL = request.getRequestURL();
        String servletPath = request.getServletPath();
        System.out.println("requestURL:" + requestURL);
        System.out.println("servletPath:" + servletPath);
//        requestURL:http://localhost/admin/blogs
//        servletPath:/admin/blogs
        if (servletPath.startsWith("/admin")) {
            //判断是否是管理员，从session中取值 loginUserId ，能得到值：是管理员，否则：不是管理员
            HttpSession session = request.getSession();
            Object loginUserId = session.getAttribute("loginUserId");
            if (loginUserId == null) {
                //说明未登陆
                request.getSession().setAttribute("errorMsg", "受保护页面，需要登陆");
                response.sendRedirect(request.getContextPath() + "/admin/login");
                return false;
            } else {
                //说明已登陆
                return true;
            }
        }
        //其他非保护的路径
        return true;
    }
}
