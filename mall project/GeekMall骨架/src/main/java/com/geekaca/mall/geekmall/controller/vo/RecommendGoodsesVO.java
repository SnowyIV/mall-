package com.geekaca.mall.geekmall.controller.vo;

import lombok.Data;
//goods_id, selling_price, goods_cover_img, config_name
@Data
public class RecommendGoodsesVO {
    private Long goodsId;
    private Double sellingPrice;
    private String goodsCoverImg;
    /**
     * 配置的 新品名
     */
    private String configName;
}
