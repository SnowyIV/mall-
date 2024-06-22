package com.geekaca.mall.service.impl;

import com.geekaca.mall.controller.param.CategoryParam;
import com.geekaca.mall.domain.GoodsCategory;
import com.geekaca.mall.exceptions.MallException;
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
        return categoryMapper.selectByPrimaryKey(goodsCategoryId);
    }

    @Override
    public GoodsCategory getCategory(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateCategory(GoodsCategory goodsCategory) {
        return categoryMapper.updateById(goodsCategory);
    }

    @Override
    public int addCategory(GoodsCategory goodsCategory) {
        return categoryMapper.insertSelective(goodsCategory);
    }

    @Override
    public int deleteByIds(Long[] ids) {
        for (Long id : ids) {
            int selected = categoryMapper.selectByParentId(id);
            if (selected > 0) {
                GoodsCategory goodsCategory = categoryMapper.selectByPrimaryKey(id);
                throw new MallException(goodsCategory.getCategoryName() + "的分类下还有子类，无法删除");
            }
        }
        return categoryMapper.deleteByIds(ids);
    }
}
