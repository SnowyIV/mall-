package com.geekaca.mall.service;

import com.geekaca.mall.controller.param.CarouselParam;
import com.geekaca.mall.domain.Carousel;
import com.geekaca.mall.utils.PageResult;

import java.util.List;

public interface CarouselService {
    List<Carousel> getAll();

    PageResult getAllInfo(CarouselParam carouselParam);

    int saveCarousel(Carousel carouselAddParam);

    boolean deleteBatch(Long[] ids);
}
