package com.geekaca.mall.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.geekaca.mall.constants.MallConstants;
import com.geekaca.mall.controller.param.IndexConfigsParam;
import com.geekaca.mall.controller.vo.HotGoodsInfoVO;
import com.geekaca.mall.controller.vo.NewGoodsVO;
import com.geekaca.mall.controller.vo.RecommendGoodsesVO;
import com.geekaca.mall.domain.IndexConfig;
import com.geekaca.mall.mapper.IndexConfigMapper;
import com.geekaca.mall.service.IndexConfigService;
import com.geekaca.mall.utils.PageResult;
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
        List<IndexConfig> indexConfigList = indexConfigMapper.selectByConfigType(MallConstants.CONFIG_TYPE_HOT, 10);
        //手动
        //        for (int i = 0; i < indexConfigList.size(); i++) {
//            IndexConfig indexConfig = indexConfigList.get(i);
//            HotGoodsInfoVO vo = new HotGoodsInfoVO();
//            vo.setGoodsId(indexConfig.getGoodsId());//....
//        }
        List<HotGoodsInfoVO> hotGoodsInfoVOList = new ArrayList<>();
        // 复制集合，转换类型，前提： 双方的属性必须一模一样
        // 参数1： 从哪个集合复制，参数2： 转变为什么类型
        hotGoodsInfoVOList = BeanUtil.copyToList(indexConfigList, HotGoodsInfoVO.class);
        return hotGoodsInfoVOList;
    }

    @Override
    public List<NewGoodsVO> getNewGoodsList() {
        List<IndexConfig> indexConfigList = indexConfigMapper.selectByConfigType(MallConstants.CONFIG_TYPE_NEW, 10);
        List<NewGoodsVO> newGoodsVOList = new ArrayList<>();
        newGoodsVOList = BeanUtil.copyToList(indexConfigList, NewGoodsVO.class);
        return newGoodsVOList;
    }

    @Override
    public List<RecommendGoodsesVO> getRecommondGoodsList() {
        List<IndexConfig> indexConfigList = indexConfigMapper.selectByConfigType(MallConstants.CONFIG_TYPE_RECOMMOND, 10);
        List<RecommendGoodsesVO> recommendGoodsesVOList = new ArrayList<>();
        recommendGoodsesVOList = BeanUtil.copyToList(indexConfigList, RecommendGoodsesVO.class);
        return recommendGoodsesVOList;
    }

    @Override
    public PageResult getAllInfo(IndexConfigsParam indexConfigsParam) {
        int count = indexConfigMapper.selectCount(indexConfigsParam);
        if (count > 0) {
            indexConfigsParam.setStart((indexConfigsParam.getPageNO() - 1) * indexConfigsParam.getPageSize());
            List<IndexConfig> indexConfigList = indexConfigMapper.selectInfoByType(indexConfigsParam);
            PageResult pageResult = new PageResult(indexConfigList, count, indexConfigsParam.getPageSize(), indexConfigsParam.getPageNO());
            return pageResult;
        }
        return null;
    }

    @Override
    public IndexConfig getIndexConfigById(Long id) {
        return indexConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateIndexConfig(IndexConfig indexConfig) {
        return indexConfigMapper.updateByPrimaryKey(indexConfig);
    }

    @Override
    public boolean deleteBatch(Long[] ids) {
        return indexConfigMapper.deleteByIds(ids);
    }

    @Override
    public int saveIndexConfig(IndexConfig indexConfig) {
        return indexConfigMapper.insertSelective(indexConfig);
    }
}
