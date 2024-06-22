package com.geekaca.web.controller;

import com.alibaba.fastjson.JSON;
import com.geekaca.web.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/deleteBatch")
public class DeleteBatchServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String jsonStr = reader.readLine();
        List<Integer> idList = JSON.parseArray(jsonStr, Integer.class);
        int deleted = brandService.deleteBatchIds(idList);
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (deleted > 0) {
            writer.write("ok");
        } else {
            //增加失败
            writer.write("fail");
        }
    }
}

