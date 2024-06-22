package com.geekaca.dao;

import com.geekaca.domain.Brand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandMapper {

    List<Brand> selectAll();

    int addBrand(Brand brand);

    int deleteById(Integer id);

    Brand selectById(@Param("id") Integer id);

    int updateById(Brand brand);

    List<Brand> selectByName(Brand brand);
}