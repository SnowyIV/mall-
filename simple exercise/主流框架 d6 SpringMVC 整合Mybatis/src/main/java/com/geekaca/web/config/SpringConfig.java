package com.geekaca.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//属于Spring IOC容器的配置类
//只负责 Spring 核心bean扫描（不负责扫描webMVC相关的类）
@Configuration
@ComponentScan({"com.geekaca.web.service"})
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class, MyBatisConfig.class})
//开启Spring 的事务管理
@EnableTransactionManagement
public class SpringConfig {
}
