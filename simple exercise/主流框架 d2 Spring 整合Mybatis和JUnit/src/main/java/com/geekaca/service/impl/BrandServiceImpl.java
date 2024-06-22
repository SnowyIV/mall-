package com.geekaca.service.impl;

import com.geekaca.dao.BrandMapper;
import com.geekaca.domain.Brand;
import com.geekaca.service.BrandService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> selectAll() {
        return brandMapper.selectAll();
    }
    @Override
    public int addBrand(Brand brand) {
        return brandMapper.addBrand(brand);
    }
    @Override
    public int deleteById(Integer id) {
        return brandMapper.deleteById(id);
    }
    @Override
    public Brand selectById(@Param("id") Integer id) {
        return brandMapper.selectById(id);
    }
    @Override
    public int updateById(Brand brand) {
        return brandMapper.updateById(brand);
    }
    @Override
    public List<Brand> selectByName(Brand brand) {
        return brandMapper.selectByName(brand);
    }
}
