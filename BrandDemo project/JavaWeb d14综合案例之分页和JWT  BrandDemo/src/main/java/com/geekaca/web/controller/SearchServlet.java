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
import java.util.List;

@WebServlet("/searchBrand")
public class SearchServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数 Json
        BufferedReader reader = req.getReader();
        String jsonStr = reader.readLine();
        Brand brand = JSON.parseObject(jsonStr, Brand.class);
        //1.调用service.dao查询
        List<Brand> brandList = brandService.search(brand);
        //2.将集合转换为json数据
        String jsonString = JSON.toJSONString(brandList);
        //3.响应数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}
