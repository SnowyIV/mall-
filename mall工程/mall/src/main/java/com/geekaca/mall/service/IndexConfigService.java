package com.geekaca.mall.service;

import com.geekaca.mall.controller.vo.HotGoodsInfoVO;
import com.geekaca.mall.controller.vo.NewGoodsVO;
import com.geekaca.mall.controller.vo.RecommendGoodsesVO;


import java.util.List;

public interface IndexConfigService {
    //热销商品
    List<HotGoodsInfoVO> getHotGoodsList();
    //新品上新
    List<NewGoodsVO> getNewGoodsList();
    //首页推荐
    List<RecommendGoodsesVO> getRecommendGoodsesList();


}
