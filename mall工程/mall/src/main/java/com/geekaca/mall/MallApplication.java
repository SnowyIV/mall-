package com.geekaca.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//SpringBoot 约定大于配置
@SpringBootApplication
@MapperScan("com.geekaca.mall.mapper")
public class MallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }

}
