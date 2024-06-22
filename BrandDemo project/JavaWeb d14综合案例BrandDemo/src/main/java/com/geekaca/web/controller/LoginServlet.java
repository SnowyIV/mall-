package com.geekaca.web.controller;

import com.geekaca.web.domain.User;
import com.geekaca.web.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
        String isRemember = req.getParameter("isRemember");

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
        HttpSession session = req.getSession();
        //检查验证码是否正确
        String checkcodeInput = req.getParameter("checkcode");
        Object checkCode = session.getAttribute("checkCode");
        if (checkCode != null && checkcodeInput != null && !"".equals(checkcodeInput)){
            String cheCodeStr = (String)checkCode;
            //忽略大小写比较值
            if (!checkcodeInput.equalsIgnoreCase(cheCodeStr)){
                req.setAttribute("error", "验证码错误");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
                return;
            }

        }else{
            req.setAttribute("error", "验证码不能为空");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        //登陆校验
        boolean isLoginOk = userService.isLoginOk(new User(username, password));
        if (isLoginOk){
            if(isRemember != null && "on".equals(isRemember)){
                //登陆成功，并且勾选了记住我， 把用户名存入cookie
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(60 * 60 * 24 * 7);//保存一周
                resp.addCookie(cookie);
            }
            //页面跳转 显示所有品牌list页面，而且显示当前用户名字

            session.setAttribute("uname", username);
            ServletContext servletContext = req.getServletContext();
            /**
             * 类似于
             * Map
             * map中存list<String>
             */
            List onlineUsers = (List) servletContext.getAttribute("onlineUsers");
            if (onlineUsers == null){
                //说明你是第一个访问系统的人
                onlineUsers = new ArrayList();
            }else{
                //说明已经有人登陆了，已经创建过集合了

            }
            onlineUsers.add(username);
            servletContext.setAttribute("onlineUsers", onlineUsers);

            if ("admin".equals(username)){
                //假定他是管理员
                session.setAttribute("role", "admin");
            }
            resp.sendRedirect(req.getContextPath() + "/brandList");
//            resp.sendRedirect("http://192.168.1.223:8080/web/brandList");
//            session.removeAttribute("uname");//删除自己的信息
//            session.invalidate();//测试
        }else{
            req.setAttribute("error", "登陆失败");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
}
