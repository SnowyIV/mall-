package com.geekaca;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 作业：
 * 给Movie 增加 上映时间 属性
 * 查找 上映时间在 2020年前的电影
 */

public class BurstForeach {
    public static void main(String[] args) {
        //创建array数组存储电影信息
        Collection<Moive> Moives = new ArrayList<>();
        Moives.add(new Moive("《死神》",9.5,"黑崎一护", LocalDateTime.of(2019,12,9,12,30)));
        Moives.add(new Moive("《火影》",9.5,"漩涡鸣人",LocalDateTime.of(2021,11,20,5,00)));
        Moives.add(new Moive("《海贼》",9.2,"路飞",LocalDateTime.of(2023,5,12,3,50)));
        System.out.println(Moives);
        System.out.println("上映在2020年前的电影");
        //创建变量存储所需查找上映时间并格式化
        String year = "2020-01-01 00:00:00";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime Stime = LocalDateTime.parse(year,dtf);
        //Lambda表达式遍历并判断
        Moives.forEach(mv ->{
        boolean isbefore = mv.getOnTime().isBefore(Stime);
        if (isbefore){
            System.out.println(mv);
        }
        });
    }
}
