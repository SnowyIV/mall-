package com.geekaca.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//SpringMVC 的配置类
// 只负责SpringMVC 相关类扫描(控制器)
@Configuration
@ComponentScan(basePackages = "com.geekaca.web.controller")
@EnableWebMvc
public class SpringMvcConfig {

}
