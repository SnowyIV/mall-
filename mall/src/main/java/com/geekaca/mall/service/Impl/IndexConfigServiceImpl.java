package com.geekaca.mall.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.geekaca.mall.constants.MallConstants;
import com.geekaca.mall.controller.vo.HotGoodsInfoVO;
import com.geekaca.mall.controller.vo.NewGoodsVO;
import com.geekaca.mall.controller.vo.RecommendGoodsesVO;
import com.geekaca.mall.domain.IndexConfig;
import com.geekaca.mall.mapper.IndexConfigMapper;
import com.geekaca.mall.service.IndexConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexConfigServiceImpl implements IndexConfigService {
    @Autowired
    private IndexConfigMapper indexConfigMapper;
    @Override
    public List<HotGoodsInfoVO> getHotGoodsList() {
       List<IndexConfig> indexConfigList = indexConfigMapper.selectByConfigType(MallConstants.COFIG_TYPE_HOT,10);
        List<HotGoodsInfoVO> hotGoodsInfoVOList = new ArrayList<>();
        //复制集合并转换类型，前提： 双方的属性必须一模一样
        // 参数1： 从哪个集合复制，参数2： 转变为什么类型
        hotGoodsInfoVOList = BeanUtil.copyToList(indexConfigList, HotGoodsInfoVO.class);
        return hotGoodsInfoVOList;
    }

    @Override
    public List<NewGoodsVO> getNewGoodsList() {
        List<IndexConfig> indexConfigList = indexConfigMapper.selectByConfigType(MallConstants.COFIG_TYPE_NEW,10);
        List<NewGoodsVO> NewGoodsVOList = new ArrayList<>();
        NewGoodsVOList = BeanUtil.copyToList(indexConfigList, NewGoodsVO.class);
        return NewGoodsVOList;
    }

    @Override
    public List<RecommendGoodsesVO> getRecommendGoodsesList() {
        List<IndexConfig> indexConfigList = indexConfigMapper.selectByConfigType(MallConstants.COFIG_TYPE_RECOMMEND,10);
        List<RecommendGoodsesVO> RecommendGoodsesVOList = new ArrayList<>();
        RecommendGoodsesVOList = BeanUtil.copyToList(indexConfigList, RecommendGoodsesVO.class);
        return RecommendGoodsesVOList;
    }
}
