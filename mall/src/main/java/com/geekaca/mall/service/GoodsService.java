package com.geekaca.mall.service;

import com.geekaca.mall.controller.param.GoodsParam;
import com.geekaca.mall.controller.param.SellStatusIdParam;
import com.geekaca.mall.domain.GoodsInfo;
import com.geekaca.mall.utils.PageResult;


public interface GoodsService {
//    int insert(GoodsInfo record);


    GoodsInfo getDetailById(Long id);

    PageResult getGoodsList(GoodsParam goodsParam);

    int addGoods(GoodsInfo goodsInfo);

    int updateSellStatus(Long[] ids, int sellStatus);

    GoodsInfo getGoodsById(Long id);

    int updateGoodsInfo(GoodsInfo goodsEditInfo);

    // int deleteGoods(Long id);
}

