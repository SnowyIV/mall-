package com.geekaca.mall.geekmall.mapper;

import com.geekaca.mall.geekmall.domain.MallCarousel;
import com.geekaca.mall.geekmall.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author ytdag
* @description 针对表【tb_newbee_mall_carousel】的数据库操作Mapper
* @createDate 2023-07-14 20:17:03
* @Entity com.geekaca.mall.geekmall.domain.MallCarousel
*/
public interface MallCarouselMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallCarousel record);

    int insertSelective(MallCarousel record);

    MallCarousel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallCarousel record);

    int updateByPrimaryKey(MallCarousel record);

    List<MallCarousel> findCarouselsByNum(@Param("number") int number);

    List<MallCarousel> findCarouselList(PageQueryUtil pageUtil);

    int getTotalCarousels(PageQueryUtil pageUtil);

    int deleteBatch(Long[] ids);

}
