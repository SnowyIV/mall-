package com.geekaca.web.controller;


import com.geekaca.web.service.BrandService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int deleted = brandService.deleteById(id);
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (deleted > 0){
            //删除成功
            writer.write("ok");
        }else{
            //删除失败
            writer.write("fail");
        }
    }
}
