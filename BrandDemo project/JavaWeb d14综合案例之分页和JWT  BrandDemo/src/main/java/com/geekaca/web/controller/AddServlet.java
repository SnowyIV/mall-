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

@WebServlet("/addBrand")
public class AddServlet extends HttpServlet {
    //尽可能的私有，只对外暴露需要的功能
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String jsonStr = reader.readLine();
        Brand brand = JSON.parseObject(jsonStr, Brand.class);
        int added = brandService.addBrand(brand);
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (added > 0) {
            writer.write("ok");
        } else {
            //增加失败
            writer.write("fail");
        }
    }
}

