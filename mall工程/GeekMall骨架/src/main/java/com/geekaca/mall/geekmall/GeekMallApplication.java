package com.geekaca.mall.geekmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

//http://localhost:28019/swagger-ui/index.html testsdf
// net
@SpringBootApplication
//开启定时器
@EnableScheduling
/**
 * 告诉spring到哪里去找mapper类
 * mapper的xml文件
 */
@MapperScan("com.geekaca.mall.geekmall.mapper")
public class GeekMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeekMallApplication.class, args);
       test("haha");//invoke  diaoyong
    }

    //shengming
    public static void test(String s){

    }
    //bean定义，Spring容器会根据这个注解来创建对象，放入IOC容器管理
    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}
