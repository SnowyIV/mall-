package com.geekaca.mall.controller.vo;

import lombok.Data;

//推荐商品
@Data
public class RecommendGoodsesVO {
    private Long goodsId;
    private Double sellingPrice;
    private String goodsCoverImg;
    private String goodsName;
}