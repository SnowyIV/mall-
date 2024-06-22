package com.geekaca.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.geekaca.web.domain.Brand;
import com.geekaca.web.service.BrandService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 控制器
 * 你访问这个servlet
 * 就可以获取 品牌 数据集合
 */
@WebServlet("/brandList")
public class BrandServlet extends HttpServlet {
    //servlet 依赖 service
    private BrandService brandService = new BrandService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNo = req.getParameter("pageNo");
        String pageSize = req.getParameter("pageSize");
        int iPageNo = Integer.parseInt(pageNo);
        int iPageSize = Integer.parseInt(pageSize);
        /**
         * 1, 查询总记录条数
         * 2，获取 第一页的数据（5条/页） limit 0, 5
         */
        int count = brandService.selectCount();
        //查询某一页的数据
        List<Brand> brandList = brandService.selectPage(iPageNo, iPageSize);
        /**
         * 多份数据如何利用JSON返回？
         */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count", count);
        jsonObject.put("brands", brandList);
        String jsonString = jsonObject.toJSONString();

        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}
