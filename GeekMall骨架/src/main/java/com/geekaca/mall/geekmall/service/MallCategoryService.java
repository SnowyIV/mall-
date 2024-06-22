package com.geekaca.mall.geekmall.service;

import com.geekaca.mall.geekmall.controller.vo.MallIndexCategoryVO;

import java.util.List;

public interface MallCategoryService {
    /**
     * 返回分类数据(首页调用)
     *
     * @return
     */
    List<MallIndexCategoryVO> getCategoriesForIndex();

}
