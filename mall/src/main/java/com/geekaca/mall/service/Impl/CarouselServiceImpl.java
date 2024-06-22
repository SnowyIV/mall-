package com.geekaca.mall.service.Impl;

import com.geekaca.mall.domain.Carousel;
import com.geekaca.mall.mapper.CarouselMapper;
import com.geekaca.mall.service.CarouselService;
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
}
