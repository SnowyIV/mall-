package com.geekaca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//， LocalDateTime计算  抢单下单截至时间 2023-09-01 00:00:00,判断 2023-09-01 01:00:00 下单是否成功？
public class PanicBuy {
    public static void main(String[] args) throws ParseException {
        String enddate = "2023-09-01 00:00:00";
        String buydate = "2023-09-01 01:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf.parse(enddate);
        Date date2 = sdf.parse(buydate);
        if (date2.before(date1) ){
            System.out.println("秒杀成功");
        }else{
            System.out.println("秒杀失败");
        }
    }
}
