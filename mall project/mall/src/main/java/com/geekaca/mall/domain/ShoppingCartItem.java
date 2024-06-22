package com.geekaca.mall.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 
 * @TableName tb_newbee_mall_shopping_cart_item
 */
@Data
public class ShoppingCartItem implements Serializable {
    /**
     * 购物项主键id
     */
    private Long cartItemId;

    /**
     * 用户主键id
     */

    private Long userId;

    /**
     * 关联商品id
     */
    private Long goodsId;

    /**
     * 数量(最大为5)
     */
    @NotNull(message = "商品数量不能为空")
    private Integer goodsCount;



    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最新修改时间
     */
    private Date updateTime;

    private String goodsName;
    private Integer sellingPrice;
    private String goodsCoverImg;
    private static final long serialVersionUID = 1L;


}