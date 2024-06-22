package com.geekaca.mall.geekmall.service;

import com.geekaca.mall.geekmall.controller.vo.MallIndexCarouselVO;
import com.geekaca.mall.geekmall.domain.MallCarousel;
import com.geekaca.mall.geekmall.utils.PageQueryUtil;
import com.geekaca.mall.geekmall.utils.PageResult;

import java.util.List;

public interface MallCarouselService {
    /**
     * 返回固定数量的轮播图对象(首页调用)
     *
     * @param number
     * @return
     */
    List<MallIndexCarouselVO> getCarouselsForIndex(int number);

    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getCarouselPage(PageQueryUtil pageUtil);

    String saveCarousel(MallCarousel carousel);

    String updateCarousel(MallCarousel carousel);

    MallCarousel getCarouselById(Long id);

    Boolean deleteBatch(Long[] ids);
}
