package com.geekaca.mall.geekmall.service;

import com.geekaca.mall.geekmall.controller.vo.FrontPageVo;
import com.geekaca.mall.geekmall.controller.vo.PageVO;
import com.geekaca.mall.geekmall.domain.MallGoodsInfo;
import com.geekaca.mall.geekmall.utils.PageResult;

import java.util.List;


public interface GeekMallGoodsService {
    //展示所有商品
    List<MallGoodsInfo> selectAll();

    //分页展示所有商品
    PageResult selectAllByPage(PageVO pageVOparams);

    MallGoodsInfo getGoodsDetailById(Long gid);

    //修改商品信息
    Integer updateGeekMallGoods(MallGoodsInfo mallGoodsInfo);

    MallGoodsInfo getGeekMallGoodsById(Long id);


    String addGoods(MallGoodsInfo goodsInfo);

    boolean updateSellStatus(Long[] ids, int sellStatus);

    PageResult searchFrontMallGoods(FrontPageVo frontPageVo);
}
