package com.geekaca.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//springmvc配置类，本质上还是一个spring配置类
@Configuration
//告诉Spring去哪里搜索，扫描 控制器类
@ComponentScan("com.geekaca.web.controller")
//开启json数据类型自动转换
@EnableWebMvc
public class SpringMvcConfig {
}
