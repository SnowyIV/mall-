package com.geekaca.web.controller;

import com.geekaca.web.domain.Brand;
import com.geekaca.web.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/addBrand")
public class AddServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //确保post提交的中文正常
        req.setCharacterEncoding("UTF-8");
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        String ordered = req.getParameter("ordered");
        String description = req.getParameter("description");
        String status = req.getParameter("status");
        //String类型转换成int类型
        int iOrdered = Integer.parseInt(ordered);
        int iStatus = Integer.parseInt(status);

        Brand brand = new Brand();
        int added = brandService.addBrand(brand);
        added = -1;
        String contextPath = req.getContextPath();
        if (added > 0) {
            //跳转到显示所有的页面   ，重定向
            resp.sendRedirect(contextPath + "/brandList");
        } else {
            //增加失败
            req.setAttribute("error", "增加失败");
            req.getRequestDispatcher("/addBrand.jsp").forward(req, resp);
        }

    }
}
