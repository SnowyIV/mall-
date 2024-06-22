package com.geekaca.web.controller;

import com.geekaca.web.domain.User;
import com.geekaca.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //确保post中文正常
        req.setCharacterEncoding("UTF-8");
        //确保 response 输出流 写出中文正常
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        StringBuilder st = new StringBuilder();
        PrintWriter writer = resp.getWriter();
        if (username == null ||"".equals(username.trim())){
            st.append("用户名不能为空<br/>");
        }
        if (password == null || "".equals(password.trim())){
            st.append("密码不能为空");
        }
        if (st.toString().length() > 0){
           req.setAttribute("error", st.toString());
           req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        //登陆校验
        boolean isLoginOk = userService.isLoginOk(new User(username, password));
        if (isLoginOk){
            //页面跳转 显示所有品牌list页面，而且显示当前用户名字
            HttpSession session = req.getSession();
            session.setAttribute("uname", username);
            resp.sendRedirect(req.getContextPath() + "/brandList");
        }else{
            req.setAttribute("error", "登陆失败");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
}
