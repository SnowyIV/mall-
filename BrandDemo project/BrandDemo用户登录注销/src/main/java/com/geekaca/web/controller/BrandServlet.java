package com.geekaca.web.controller;

import com.geekaca.web.domain.Brand;
import com.geekaca.web.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/brandList")
public class BrandServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brandList = brandService.loadAll();
        req.setAttribute("bdList", brandList);
        req.getRequestDispatcher("brandList.jsp").forward(req, resp);
    }
}
