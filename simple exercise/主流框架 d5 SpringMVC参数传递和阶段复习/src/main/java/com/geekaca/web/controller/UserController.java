package com.geekaca.web.controller;


import com.geekaca.web.domain.LoginUser;
import com.geekaca.web.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {


    @RequestMapping("/save")
    @ResponseBody
    public String save(){
        System.out.println("save");
        return "{'info':'springmvc'}";
    }

    //普通参数：请求参数与形参名称对应即可完成参数传递
    @RequestMapping("/commonParam")
    @ResponseBody
    public String commonParam(String name ,int age){
        System.out.println("普通参数传递 name ==> "+name);
        System.out.println("普通参数传递 age ==> "+age);
        return "{'module':'common param'}";
    }

    //普通参数：请求参数名与形参名不同时，使用@RequestParam注解关联请求参数名称与形参名称之间的关系
    //http://localhost:8080/11_26/save/commonParamDifferentName?name=tony&age=25
    @RequestMapping("/commonParamDifferentName")
    @ResponseBody
    public String commonParamDifferentName(@RequestParam("name") String userName , int age){
        System.out.println("普通参数传递 userName ==> "+userName);
        System.out.println("普通参数传递 age ==> "+age);
        return "{'module':'common param different name'}";
    }

    //POJO参数：请求参数与形参对象中的属性对应即可完成参数传递

    /**
     * Spring 能够自动帮咱们把 前端提交过来的JSON结构
     * 自动转换 填充到User对象中
     *
     * 之前用户注册：一个一个参数接收，自己创建User对象，属性设置进去
     * @param user
     * @return
     */
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(@RequestBody User user){
        System.out.println("pojo参数传递 user ==> "+user);
        return "{'module':'pojo param'}";
    }

    //数组参数：同名请求参数可以直接映射到对应名称的形参数组对象中
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes){
        System.out.println("数组参数传递 likes ==> "+ Arrays.toString(likes));
        return "{'module':'array param'}";
    }

    //集合参数：同名请求参数可以使用@RequestParam注解映射到对应名称的集合对象中作为数据
    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> likes){
        System.out.println("集合参数传递 likes ==> "+ likes);
        return "{'module':'list param'}";
    }

    //集合参数：json格式
    //1.开启json数据格式的自动转换，在配置类中开启@EnableWebMvc
    //2.使用@RequestBody注解将外部传递的json数组数据映射到形参的集合对象中作为数据
    @RequestMapping("/listParamForJson")
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes){
        System.out.println("list common(json)参数传递 list ==> "+likes);
        return "{'module':'list common for json param'}";
    }
    //提交多个user数据
    //集合参数：json格式
    //1.开启json数据格式的自动转换，在配置类中开启@EnableWebMvc
    //2.使用@RequestBody注解将外部传递的json数组数据映射到形参的保存实体类对象的集合对象中，要求属性名称一一对应
    @RequestMapping("/listPojoParamForJson")
    @ResponseBody
    public String listPojoParamForJson(@RequestBody List<User> list){
        System.out.println("list pojo(json)参数传递 list ==> "+list);
        return "{'module':'list pojo for json param'}";
    }

    //提交日期 2023-11-26 12:00:00   转换成Date 日期
    //日期参数
    //使用@DateTimeFormat注解设置日期类型数据格式，默认格式yyyy/MM/dd
    @RequestMapping("/dateParam")
    @ResponseBody
    public String dataParam(
            Date date,
            @DateTimeFormat(pattern="yyyy-MM-dd") Date date1,
            @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") Date date2){
        System.out.println("参数传递 date ==> "+date);
        System.out.println("参数传递 date1(yyyy-MM-dd) ==> "+date1);
        System.out.println("参数传递 date2(yyyy/MM/dd HH:mm:ss) ==> "+date2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date1));
        return "{'module':'data param'}";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody LoginUser loginUser){
        if ("admin".equals(loginUser.getLoginName()) && ("123".equals(loginUser.getPassword()))){
            return "ok";
        }else{
            return  "fail";
        }
    }

    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestBody LoginUser loginUser){
        System.out.println(loginUser);
            return "ok";
    }
}
