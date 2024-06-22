package com.geekaca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//给定两个字符串 2023-09-01 12:00:00 2023-09-02 13:00:00，计算两个时间间隔的 毫秒数
public class JiSuan {
    public static void main(String[] args) throws ParseException {
        String str1 = "2023-09-01 12:00:00";
        String str2 = "2023-09-02 13:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf.parse(str1);
        Date date2 = sdf.parse(str2);
        long time1 = date1.getTime();
        long time2 = date2.getTime();
        System.out.println("时间间隔为"+(time2-time1));
    }
}
