package com.geekaca.mall.geekmall.service;

import com.geekaca.mall.geekmall.controller.vo.NewBeeMallIndexConfigGoodsVO;
import com.geekaca.mall.geekmall.domain.MallIndexConfig;
import com.geekaca.mall.geekmall.utils.PageQueryUtil;
import com.geekaca.mall.geekmall.utils.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MallIndexConfigService {
    /**
     * 返回固定数量的首页配置商品对象(首页调用)
     *
     * @param number
     * @return
     */
    List<NewBeeMallIndexConfigGoodsVO> getConfigGoodsesForIndex(int configType, int number);

    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getConfigsPage(PageQueryUtil pageUtil);

    String saveIndexConfig(MallIndexConfig indexConfig);

    String updateIndexConfig(MallIndexConfig indexConfig);

    MallIndexConfig getIndexConfigById(Long id);

    Boolean deleteBatch(Long[] ids);
}
