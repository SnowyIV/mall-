package com.geekaca.web.controller;

import com.geekaca.web.utils.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/checkCode")
public class CodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //当你访问这个servlet时候，返回的是图片数据的字节流
        ServletOutputStream outputStream = resp.getOutputStream();
        String code = CheckCodeUtil.outputVerifyImage(100, 50, outputStream, 4);
        //生成验证码后，存入session，然后在检查登陆那里，比对，用户输入的验证码是否正确
        HttpSession session = req.getSession();
        session.setAttribute("checkCode", code);

    }
}
