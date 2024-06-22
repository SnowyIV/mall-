package com.geekaca.mall.geekmall.service;

import com.geekaca.mall.geekmall.controller.vo.HotGoodsesVO;
import com.geekaca.mall.geekmall.controller.vo.NewGoodsVO;
import com.geekaca.mall.geekmall.controller.vo.RecommendGoodsesVO;

import java.util.List;

public interface HomePageService {
    List<NewGoodsVO> getAllNewGoods();

    List<HotGoodsesVO> getAllHotGoodses();

    List<RecommendGoodsesVO> getAllRecommendGoodses();
}
