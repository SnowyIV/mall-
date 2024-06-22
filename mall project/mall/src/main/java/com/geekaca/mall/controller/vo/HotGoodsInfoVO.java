package com.geekaca.mall.controller.vo;

import lombok.Data;

//热销商品
@Data
public class HotGoodsInfoVO {

    private Long goodsId;
    private String goodsName;
    private String goodsCoverImg;
    private Double sellingPrice;

    // 省略getter和setter方法
}
