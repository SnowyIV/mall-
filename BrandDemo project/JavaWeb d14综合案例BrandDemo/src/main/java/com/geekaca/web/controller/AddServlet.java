package com.geekaca.web.controller;

import com.alibaba.fastjson.JSON;
import com.geekaca.web.domain.Brand;
import com.geekaca.web.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addBrand")
public class AddServlet extends HttpServlet {
    //尽可能的私有，只对外暴露需要的功能
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //确保post提交的中文正常
//        req.setCharacterEncoding("UTF-8");
//        //从session中取值 role，有值才是管理员，有权限执行添加
//        HttpSession session = req.getSession();
//        Object role = session.getAttribute("role");
//        if (role == null) {
//            //说明不是管理员，不能调用添加功能
//            resp.sendRedirect(req.getContextPath() + "/brandList");
//            return;
//        }
//        String brandName = req.getParameter("brandName");
//        String companyName = req.getParameter("companyName");
//        String ordered = req.getParameter("ordered");
//        String description = req.getParameter("description");
//        String status = req.getParameter("status");
//        //String --> Integer  熟练掌握
//        int iOrdered = Integer.parseInt(ordered);
//        int iStatus = Integer.parseInt(status);
//        //自动装箱   自动的把 int 转换为了Integer
//        //实现 向数据库 新增数据
//        Brand brand1 = new Brand(null, brandName, companyName, iOrdered, description, iStatus);
//        int added = brandService.addBrand(brand1);
//
//        String contextPath = req.getContextPath();
//        if (added > 0) {
//            //跳转到显示所有的页面   ，重定向
//
//            resp.sendRedirect(contextPath + "/brandList");
////            req.getRequestDispatcher("/brandList").forward(req, resp);
//        } else {
//            //增加失败
//            req.setAttribute("error", "增加失败");
//            req.getRequestDispatcher("/addBrand.jsp").forward(req, resp);
//        }
        BufferedReader reader = req.getReader();
        String jsonStr = reader.readLine();
        //JSON格式的字符串 ----》Brand对象
        //前提： JSON字符串中的属性名字 能够和Brand 类的属性名对应上
        Brand brand = JSON.parseObject(jsonStr, Brand.class);
        int addBrand = brandService.addBrand(brand);
        String jsonString = JSON.toJSONString(addBrand);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}

