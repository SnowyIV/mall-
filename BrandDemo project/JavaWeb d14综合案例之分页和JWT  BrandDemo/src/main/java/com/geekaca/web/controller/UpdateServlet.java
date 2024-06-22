package com.geekaca.web.controller;

import com.geekaca.web.domain.Brand;
import com.geekaca.web.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateBrand")
public class UpdateServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //确保post提交的中文正常
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        String ordered = req.getParameter("ordered");
        String description = req.getParameter("description");
        String status = req.getParameter("status");
        //String --> Integer  熟练掌握
        int iOrdered = Integer.parseInt(ordered);
        int iStatus = Integer.parseInt(status);
        //自动装箱   自动的把 int 转换为了Integer
        //实现 向数据库 新增数据
        Brand brand = new Brand(Integer.parseInt(id), brandName, companyName, iOrdered, description, iStatus);
        int updated = brandService.update(brand);
        if (updated > 0) {
            resp.sendRedirect(req.getContextPath() + "/brandList");
        }else{
            //更新失败，提示信息
        }
    }
}
