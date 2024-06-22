package com.geekaca.web.controller;

import com.geekaca.web.domain.Brand;
import com.geekaca.web.service.BrandService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpDateServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        String ordered = req.getParameter("ordered");
        String description = req.getParameter("description");
        String status = req.getParameter("status");
        int iOrdered = Integer.parseInt(ordered);
        int iStatus = Integer.parseInt(status);
        Brand brand = new Brand(Integer.parseInt(id), brandName, companyName, iOrdered, description, iStatus);
        int updated = brandService.upDate(brand);
        if (updated > 0) {
            resp.sendRedirect(req.getContextPath() + "/brandList");
        }else{
            req.setAttribute("error", "修改失败");
        }
    }
}
