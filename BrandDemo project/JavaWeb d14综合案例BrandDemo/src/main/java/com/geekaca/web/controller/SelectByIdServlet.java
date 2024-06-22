package com.geekaca.web.controller;

import com.geekaca.web.domain.Brand;
import com.geekaca.web.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectById")
public class SelectByIdServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1, 接收id，
        //2, 查询详情
        //3, 存入request作用域，转发到 update.jsp
        String brdId = req.getParameter("brdId");
        Brand brand = brandService.getById(Integer.parseInt(brdId));
        req.setAttribute("brand", brand);
        req.getRequestDispatcher("/update.jsp").forward(req, resp);
    }
}
