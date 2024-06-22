package com.geekaca.mall.controller.vo;

import lombok.Data;

//商品载体
@Data
public class GoodsDTO {
    private Long cartItemId;
    private Long goodsId;
    private Integer goodsCount;
    private  String goodsName;
    private  Integer sellingPrice;
    private String goodsCoverImg;
    private Integer userId;
    private Integer goodsSellStatus;
}
