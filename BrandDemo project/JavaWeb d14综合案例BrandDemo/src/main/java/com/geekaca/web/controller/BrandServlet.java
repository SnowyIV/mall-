package com.geekaca.web.controller;

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
        List<Brand> brandList = brandService.loadAll();
        req.setAttribute("bdList", brandList);

        //不需要setContentType，因为servlet不负责展示
        //跳转页面，请求转发
        req.getRequestDispatcher("brandList.jsp").forward(req, resp);
    }
}
