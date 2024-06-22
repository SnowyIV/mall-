package com.geekaca.news.controller.admin;

import cn.hutool.captcha.ShearCaptcha;
import com.geekaca.news.domain.AdminUser;
import com.geekaca.news.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;


    @GetMapping("/login")
    public String login(){
        return "/admin/login";
    }
    @PostMapping("/dologin")
    public String doLogin(@RequestParam("userName") String userName, @RequestParam("password") String password,
                          @RequestParam("verifyCode") String verifyCode, HttpSession session) {

        if (userName == null || "".equals(userName.trim())){
            session.setAttribute("errorMsg", "用户名不能为空");
            return "redirect:/admin/login";
        }
        if (password == null || "".equals(password.trim())){
            session.setAttribute("errorMsg", "密码不能为空");
            return "redirect:/admin/login";
        }
        if (verifyCode == null || "".equals(verifyCode.trim())){
            session.setAttribute("errorMsg", "验证码不能为空");
            return "redirect:/admin/login";
        }
        ShearCaptcha verifyCode1 = (ShearCaptcha) session.getAttribute("verifyCode");
        if (!verifyCode.equals(verifyCode1.getCode())){
            session.setAttribute("errorMsg", "验证码错误");
            return "redirect:/admin/login";
        }
        AdminUser adminUser = new AdminUser();
        adminUser.setLoginUserName(userName);
        adminUser.setLoginPassword(password);
        AdminUser loginUser = adminUserService.login(adminUser);
        if (loginUser != null){
            return "redirect:/admin/index";
        }else {
            session.setAttribute("errorMsg", "登陆失败");
            return "redirect:/admin/login";
        }
    }

    @GetMapping({"", "/", "/index", "/index.html"})
    public String index(HttpServletRequest request) {
        request.setAttribute("path", "index");
        //类别数量  ctrl  + Alt 鼠标左键点击，跳转到函数实现
        //文章类别数量  单独的一个查询
        request.setAttribute("categoryCount", 0);
        //新闻总数
        request.setAttribute("blogCount", 200);
        //链接总数
        request.setAttribute("linkCount", 0);
        //标签总数
        request.setAttribute("tagCount", 0);
        //评论总数
        request.setAttribute("commentCount", 0);
        return "admin/index";
    }

}
