package com.geekaca;
//利用Date 和格式化，打印输出对你最有价值的日期
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IMPDate{
    public static void main(String[] args) throws ParseException {
        String datestr = "1996年08月16日";
        System.out.println(datestr);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Date dateParsed = sdf.parse(datestr);
        String rs = sdf.format(dateParsed);
        System.out.println("重要的时间为"+rs);
    }
}
