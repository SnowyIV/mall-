package com.geekaca.mall.geekmall.domain;

import lombok.Data;

/**
 * Data Transfer Object
 * 数据传输对象
 */
@Data
public class CartInfoDTO extends MallShoppingCartItem{
    private String goodsName;
    private Double sellingPrice;
    private String goodsCoverImg;
}
