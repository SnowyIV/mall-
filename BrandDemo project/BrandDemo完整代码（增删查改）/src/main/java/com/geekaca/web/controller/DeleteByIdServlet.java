package com.geekaca.web.controller;

import com.geekaca.web.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteByIdServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int deleted = brandService.deleteById(id);
        deleted = 0;
        if (deleted > 0) {
            //删除成功
            resp.sendRedirect(req.getContextPath() + "/brandList");
        } else {
            //删除失败
            req.setAttribute("error", "删除失败");
            //页面显示所有list
            req.getRequestDispatcher("/brandList").forward(req, resp);
        }
    }
}

