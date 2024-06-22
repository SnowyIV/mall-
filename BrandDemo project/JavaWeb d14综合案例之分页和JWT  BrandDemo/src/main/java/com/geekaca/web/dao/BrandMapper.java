package com.geekaca.web.dao;

import com.geekaca.web.domain.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {

    List<Brand> selectAll();

    int addBrand(Brand brand);

    int deleteById(Integer id);

    Brand selectById(@Param("id") Integer id);

    int updateById(Brand brand);

    List<Brand> selectByName(Brand brand);

    int deleteByIds(@Param("idList") List<Integer> idList);

    //查询总记录条数
    int selectCount();
    //查询第一页数据
    List<Brand> selectFirstPage(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);
}
