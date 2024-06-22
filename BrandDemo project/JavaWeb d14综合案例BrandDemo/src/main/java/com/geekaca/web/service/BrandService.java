package com.geekaca.web.service;

import com.geekaca.web.dao.BrandMapper;
import com.geekaca.web.domain.Brand;
import com.geekaca.web.utils.SqlUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

//业务逻辑层
public class BrandService {

    public List<Brand> loadAll() {
        SqlSession sqlSession = SqlUtil.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brandList = brandMapper.selectAll();
        return brandList;
    }

    public int addBrand(Brand brand) {
        SqlSession sqlSession = SqlUtil.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int i = brandMapper.addBrand(brand);
        return i;
    }

    public Brand getById(Integer id) {
        SqlSession sqlSession = SqlUtil.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        return brandMapper.selectById(id);
    }

    public int update(Brand brand) {
        SqlSession sqlSession = SqlUtil.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int updated = brandMapper.updateById(brand);
        return updated;
    }

    public int deleteById(String id) {
        SqlSession sqlSession = SqlUtil.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        return brandMapper.deleteById(Integer.parseInt(id));
    }

    public List<Brand> search(Brand brand) {
        SqlSession sqlSession = SqlUtil.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brandList = brandMapper.selectByName(brand);
        return brandList;
    }
}
