package com.geekaca.mall.service;

import com.geekaca.mall.controller.param.IndexConfigsParam;
import com.geekaca.mall.controller.vo.HotGoodsInfoVO;
import com.geekaca.mall.controller.vo.NewGoodsVO;
import com.geekaca.mall.controller.vo.RecommendGoodsesVO;
import com.geekaca.mall.domain.IndexConfig;
import com.geekaca.mall.utils.PageResult;

import java.util.List;

public interface IndexConfigService {
    /**
     * 热销
     * @return
     */
    List<HotGoodsInfoVO> getHotGoodsList();

    /**
     * 新品上线
     * @return
     */
    List<NewGoodsVO> getNewGoodsList();

    /**
     * 首页推荐
     * @return
     */
    List<RecommendGoodsesVO> getRecommondGoodsList();

    PageResult getAllInfo(IndexConfigsParam indexConfigsParam);

    IndexConfig getIndexConfigById(Long id);

    int updateIndexConfig(IndexConfig indexConfig);

    boolean deleteBatch(Long[] ids);

    int saveIndexConfig(IndexConfig indexConfig);
}
