package com.geekaca.mall.controller.vo;

import lombok.Data;

//热销商品
@Data
public class NewGoodsVO {
    private Long goodsId;
    private Double sellingPrice;
    private String goodsCoverImg;

    private String goodsName;
}