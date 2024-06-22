package com.geekaca.mall.geekmall.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * Springboot 定时器
 * 定时任务场景
 *
 * 比如： 定时 每隔1小时 从DB读取商品类别信息
 * 写入Redis 缓存  （Jedis）
 *
 * 适合  间隔秒，分钟，小时
 *
 * 问卷调查
 * 表设计
 * 接口开发
 * POSTMan访问
 *
 *
 * spring redis
 */
@Component
public class TestSchedule {
//    @Scheduled(cron = "0/3 * * * * ?")
//    public void doTask(){
//        System.out.println("hello");
//    }
}
