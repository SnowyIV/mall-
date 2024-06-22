package com.geekaca.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.geekaca")
//@PropertySource：加载类路径jdbc.properties文件
@PropertySource("classpath:jdbc.properties")
//用Spring的配置类 导入  其他两个配置类
@Import({JdbcConfig.class, MybatisConfig.class})

public class SpringConfig {
}
