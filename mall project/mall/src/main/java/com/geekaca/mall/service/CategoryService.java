package com.geekaca.mall.service;

import com.geekaca.mall.controller.param.CategoryParam;
import com.geekaca.mall.domain.GoodsCategory;
import com.geekaca.mall.utils.PageResult;

public interface CategoryService {

    PageResult selectByLevelAndParentIds(CategoryParam categoryParam);

    GoodsCategory getGoodsCategoryById(Long goodsCategoryId);

    GoodsCategory getCategory(Long id);

    int updateCategory(GoodsCategory goodsCategory);

    int addCategory(GoodsCategory goodsCategory);

    int deleteByIds(Long[] ids);
}
