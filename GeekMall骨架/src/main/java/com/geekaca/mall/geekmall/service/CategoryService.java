package com.geekaca.mall.geekmall.service;

import com.geekaca.mall.geekmall.domain.MallGoodsCategory;
import com.geekaca.mall.geekmall.utils.PageQueryUtil;
import com.geekaca.mall.geekmall.utils.PageResult;

public interface CategoryService {
    PageResult getCategoryPage(PageQueryUtil pageQueryUtil);

    //查看三级分类
    MallGoodsCategory getGoodsCategoryById(Long goodsCategoryId);
}
