package com.geekaca.mall.mapper;

import com.geekaca.mall.controller.param.CarouselParam;
import com.geekaca.mall.domain.Carousel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 33
* @description 针对表【tb_newbee_mall_carousel(前台首页轮播图)】的数据库操作Mapper
* @createDate 2024-01-16 00:13:39
* @Entity com.geekaca.mall.domain.Carousel
*/
@Mapper
public interface CarouselMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Carousel record);

    int insertSelective(Carousel record);

    Carousel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Carousel record);

    int updateByPrimaryKey(Carousel record);

    List<Carousel> selectAll();

    int selectCount(CarouselParam carouselParam);

    List<Carousel> selectInfo(CarouselParam carouselParam);

    boolean deleteByIds(Long[] ids);
}
