package com.geekaca.mall.geekmall.mapper;

import com.geekaca.mall.geekmall.domain.MallGoodsCategory;
import com.geekaca.mall.geekmall.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author ytdag
* @description 针对表【tb_newbee_mall_goods_category】的数据库操作Mapper
* @createDate 2023-07-14 20:17:03
* @Entity com.geekaca.mall.geekmall.domain.MallGoodsCategory
*/
public interface MallGoodsCategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallGoodsCategory record);

    int insertSelective(MallGoodsCategory record);

    MallGoodsCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallGoodsCategory record);

    int updateByPrimaryKey(MallGoodsCategory record);

    List<MallGoodsCategory> getCategoryList(PageQueryUtil pageUtil);

    /**
     * 查询符合条件的类别数量
     * @param pageQueryUtil
     * @return
     */
    int getTotalCategoryCounts(PageQueryUtil pageQueryUtil);


    List<MallGoodsCategory> selectByLevelAndParentIdsAndNumber(@Param("parentIds") List<Long> parentIds, @Param("categoryLevel") int categoryLevel, @Param("number") int number);

    MallGoodsCategory getGoodsCategoryById(Long goodsCategoryId);


}
