package com.geekaca.web.dao;

import com.geekaca.web.domain.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();

    int addBrand(Brand brand);

    Brand selectById(@Param("id") Integer id);

    int updateById(Brand brand);

    int deleteById(Integer id);
}
