package com.geekaca.mall.service.impl;

import com.geekaca.mall.controller.param.GoodsParam;
import com.geekaca.mall.domain.GoodsInfo;
import com.geekaca.mall.mapper.GoodsInfoMapper;
import com.geekaca.mall.service.GoodsService;
import com.geekaca.mall.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsInfoMapper goodsInfoMapper;
//
//    @Override
//    public int insert(GoodsInfo record) {
//        return goodsInfoMapper.insert(record);
//    }




    @Override
    public GoodsInfo getDetailById(Long id) {
        GoodsInfo goodsInfo = goodsInfoMapper.selectByPrimaryKey(id);
        String goodsCarouselURL = goodsInfo.getGoodsCarousel();
        goodsInfo.getGoodsCarouselList().add(goodsCarouselURL);
        return goodsInfo;
    }

    @Override
    public PageResult getGoodsList(GoodsParam goodsParam) {

        int count = goodsInfoMapper.selectGoodsCountByCondition(goodsParam);
        if (count > 0){
            goodsParam.setStart((goodsParam.getPageNO() - 1) * goodsParam.getPageSize());
            List<GoodsInfo> goodsInfoList = goodsInfoMapper.selectGoodsListByCondition(goodsParam);
            PageResult pageResult = new PageResult(goodsInfoList, count, goodsParam.getPageSize(), goodsParam.getPageNO());
            return pageResult;
        }
        return null;
    }



    @Override
    public int addGoods(GoodsInfo goodsInfo) {
        return goodsInfoMapper.insertSelective(goodsInfo);
    }

    @Override
    public int updateSellStatus(Long[] ids, int sellStatus) {
        return goodsInfoMapper.updateSellStatus(ids, sellStatus);
    }

    @Override
    public int updateGoodsInfo(GoodsInfo goodsEditInfo) {
        return goodsInfoMapper.updateByPrimaryKey(goodsEditInfo);
    }

    @Override
    public GoodsInfo getGoodsById(Long id) {
        return goodsInfoMapper.selectGoodsForBackEnd(id);
    }
}

