package com.geekaca;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Change {
    public static void main(String[] args) {
        //String转int和Integer
        String str = "123";
        int a = Integer.parseInt(str);
        Integer integer = Integer.valueOf(str);
        System.out.println(a + "," + integer);
        //int转String
        int b = 123;
        String str2 = Integer.toString(b);
        System.out.println(str2);
        //String和LocalDateTime相互转换
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = dateTime.format(dtf);
        String time2 = "2023-10-08 13:27:22";
        LocalDateTime dateTime2 = LocalDateTime.parse(time2, dtf);
        System.out.println(time);
        System.out.println(dateTime2);
    }
}
