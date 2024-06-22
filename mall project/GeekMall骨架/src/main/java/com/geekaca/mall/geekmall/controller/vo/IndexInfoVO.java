  
package com.geekaca.mall.geekmall.controller.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * VO
 * Value Object 值对象 充当数据载体
 */
@Data
public class IndexInfoVO implements Serializable {

    @ApiModelProperty("轮播图(列表)")
    private List<MallIndexCarouselVO> carousels;

    @ApiModelProperty("首页热销商品(列表)")
    private List<HotGoodsesVO> hotGoodses;

    @ApiModelProperty("首页新品推荐(列表)")
    private List<NewGoodsVO> newGoodses;

    @ApiModelProperty("首页推荐商品(列表)")
    private List<RecommendGoodsesVO> recommendGoodses;
}
