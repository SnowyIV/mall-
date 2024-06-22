package com.geekaca.web.controller;

import com.alibaba.fastjson.JSON;
import com.geekaca.web.domain.Brand;
import com.geekaca.web.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/selectById")
public class SelectByIdServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1, 接收id，
        //2, 查询详情
        //3, 存入request作用域，转发到 update.jsp
        BufferedReader reader = req.getReader();
        String jsonStr = reader.readLine();
        Brand brand = JSON.parseObject(jsonStr, Brand.class);
        brandService.getById(brand.getId());
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
    }
}
