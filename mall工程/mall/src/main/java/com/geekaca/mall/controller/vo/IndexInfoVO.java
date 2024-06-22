package com.geekaca.mall.controller.vo;

import com.geekaca.mall.domain.Carousel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
@Data
public class IndexInfoVO {
   //轮播图
    @ApiModelProperty("轮播图(列表)")
    private List<Carousel> carousels;

    @ApiModelProperty("首页热销商品(列表)")
    private List<HotGoodsInfoVO> hotGoodses;

    @ApiModelProperty("首页新品推荐(列表)")
    private List<NewGoodsVO> newGoodses;

    @ApiModelProperty("首页推荐商品(列表)")
    private List<RecommendGoodsesVO> recommendGoodses;
}
