package com.geekaca.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String uname = (String) session.getAttribute("uname");
        //清除当前用户的会话数据
        session.invalidate();
        ServletContext servletContext = req.getServletContext();
        List onlineUsers = (List) servletContext.getAttribute("onlineUsers");
        //从在线列表中把自己移除
        if (onlineUsers!= null){
            onlineUsers.remove(uname);
        }
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}
