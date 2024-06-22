package com.geekaca.mall.service.Impl;

import com.geekaca.mall.controller.param.CategoryParam;
import com.geekaca.mall.domain.GoodsCategory;
import com.geekaca.mall.mapper.GoodsCategoryMapper;
import com.geekaca.mall.service.CategoryService;
import com.geekaca.mall.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private GoodsCategoryMapper categoryMapper;

    @Override
    public PageResult selectByLevelAndParentIds(CategoryParam categoryParam) {
        categoryParam.setPageNumber((categoryParam.getPageNumber() - 1) * categoryParam.getPageSize());
        List<GoodsCategory> categoryList = categoryMapper.selectByLevelAndParentIds(categoryParam);
        int total = categoryMapper.getCountByLevelAndParentIds(categoryParam);
        PageResult pageResult = new PageResult(categoryList, total, categoryParam.getPageSize(), categoryParam.getPageNumber());
        //todo: 计算总的页数
        /**
         *  总记录条数% 每页条数   == 0 ？
         *          YES： 刚好整除  类似 100/10 = 10
         *          NO：  有余数
         *          总页数 = 100/10 = 10 + 1
         *          （总记录条数/ 每页条数）+1
         */
        return pageResult;
    }

    @Override
    public GoodsCategory getGoodsCategoryById(Long goodsCategoryId) {
     return  categoryMapper.selectByPrimaryKey(goodsCategoryId);
    }
}
