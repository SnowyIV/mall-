package com.geekaca.mall.constants;

import java.util.HashMap;
import java.util.Map;

public class MallConstants {

    public final static String FILE_UPLOAD_DIC = "C:\\dev\\codes\\imgs\\goods-img\\";
    /**
     * 注册时，用户名已经存在
     */
    public static final int CODE_LOGIN_NAME_EXSISTS = 299;
    public static final int CODE_USER_NOT_LOGIN = 300;
    /**
     * 不是用户购物车商品
     */
    public static final int CODE_NOT_USER_CART_ITEM = 301;
    /**
     * 首页配置板块类型
     */
    public static final int CONFIG_TYPE_HOT = 3;
    public static final int CONFIG_TYPE_NEW = 4;
    public static final int CONFIG_TYPE_RECOMMOND = 5;
    /**
     * 商品上架状态 1-下架 0-上架
     */
    public static final int GOODS_SELLING_STATUS_ON = 0;
    public static final int GOODS_SELLING_STATUS_OFF = 1;
    /**
     * 支付状态:0.未支付,1.支付成功,-1:支付失败
     */
    public static final int ORDER_PAYED = 1;
    public static final int ORDER_NOT_PAY = 0;

    public static final Map<Integer, String> ORDER_STATUS_MAP = new HashMap<>();
    static{
//        0.待支付 1.已支付 2.配货完成 3:出库成功 4.交易成功 -1.手动关闭 -2.超时关闭 -3.商家关闭

        ORDER_STATUS_MAP.put(0, "待支付");
        ORDER_STATUS_MAP.put(1, "已支付");
        ORDER_STATUS_MAP.put(2, "配货完成");
        ORDER_STATUS_MAP.put(3, "出库成功");
        ORDER_STATUS_MAP.put(4, "交易成功");
        ORDER_STATUS_MAP.put(-1, "手动关闭");
        ORDER_STATUS_MAP.put(-2, "超时关闭");
        ORDER_STATUS_MAP.put(-3, "商家关闭");
    }
}
