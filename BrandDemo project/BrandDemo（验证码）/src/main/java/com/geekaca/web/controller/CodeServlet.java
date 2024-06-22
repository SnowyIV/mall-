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
        ServletOutputStream outputStream = resp.getOutputStream();
        String code = CheckCodeUtil.outputVerifyImage(100, 50, outputStream, 4);
        HttpSession session = req.getSession();
        session.setAttribute("checkCode", code);

    }
}
