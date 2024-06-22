package com.geekaca.mybatis.mapper;

import com.geekaca.mybatis.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询
     */
    List<Brand> selectAll();
    /**
     * 新增
     */
    int addBrand(Brand brand);
    /**
    * 删除
    * */
    void deleteById(int id);
    /**
     * 更新
     * */
    void update(Brand brand);

}

