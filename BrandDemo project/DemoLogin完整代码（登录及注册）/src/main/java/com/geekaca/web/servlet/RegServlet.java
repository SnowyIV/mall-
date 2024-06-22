package com.geekaca.web.servlet;

import com.geekaca.web.domain.User;
import com.geekaca.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        StringBuilder st = new StringBuilder();
        if (username == null || "".equals(username.trim())) {
            st.append("用户名不能为空<br/>");
        }
        if (password == null || "".equals(password.trim())) {
            st.append("密码不能为空");
        }
        PrintWriter writer = resp.getWriter();
        if (st.toString().length() > 0){
            writer.write(st.toString());
            writer.flush();
            return;
        }
        User user = new User(username, password);
        String regResult = userService.register(user);
        writer.write(regResult);
        writer.flush();

    }
    }
