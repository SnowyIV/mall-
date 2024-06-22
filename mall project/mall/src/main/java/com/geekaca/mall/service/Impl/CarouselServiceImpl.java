package com.geekaca.mall.service.impl;

import com.geekaca.mall.controller.param.CarouselParam;
import com.geekaca.mall.domain.Carousel;
import com.geekaca.mall.domain.IndexConfig;
import com.geekaca.mall.mapper.CarouselMapper;
import com.geekaca.mall.service.CarouselService;
import com.geekaca.mall.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;
    @Override
    public List<Carousel> getAll() {
        return carouselMapper.selectAll();
    }

    @Override
    public PageResult getAllInfo(CarouselParam carouselParam) {
        int count = carouselMapper.selectCount(carouselParam);
        if (count > 0) {
            carouselParam.setStart((carouselParam.getPageNO() - 1) * carouselParam.getPageSize());
            List<Carousel> carouselList = carouselMapper.selectInfo(carouselParam);
            PageResult pageResult = new PageResult(carouselList, count, carouselParam.getPageSize(), carouselParam.getPageNO());
            return pageResult;
        }
        return null;
    }

    @Override
    public int saveCarousel(Carousel carouselAddParam) {
        return carouselMapper.insertSelective(carouselAddParam);
    }

    @Override
    public boolean deleteBatch(Long[] ids) {
        return carouselMapper.deleteByIds(ids);
    }
}
