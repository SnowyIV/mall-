package com.geekaca.mall.geekmall.mapper;

import com.geekaca.mall.geekmall.controller.vo.*;
import com.geekaca.mall.geekmall.domain.MallGoodsCategory;
import com.geekaca.mall.geekmall.domain.MallGoodsInfo;
import com.geekaca.mall.geekmall.domain.StockNumDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import java.util.List;

/**
 * @author ytdag
 * @description 针对表【tb_newbee_mall_goods_info】的数据库操作Mapper
 * @createDate 2023-07-14 20:17:03
 * @Entity com.geekaca.mall.geekmall.domain.MallGoodsInfo
 */
@Mapper
public interface MallGoodsInfoMapper {

    MallGoodsInfo selectByCategoryIdAndName(@Param("goodsName") String goodsName, @Param("goodsCategoryId") Long goodsCategoryId);

    int deleteByPrimaryKey(Long id);

    int insert(MallGoodsInfo record);

    //新增商品
    int insertSelective(MallGoodsInfo record);

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    MallGoodsInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallGoodsInfo record);

    int updateByPrimaryKey(MallGoodsInfo record);


    List<MallGoodsInfo> selectByPrimaryKeys(List<Long> goodsIds);

    int recoverStockNum(@Param("stockNumDTOS") List<StockNumDTO> stockNumDTOS);

    int updateStockNum(@Param("stockNumDTOS") List<StockNumDTO> stockNumDTOS);

    /**
     * 返回值？
     * List<?>
     * goods_id, selling_price, goods_cover_img, config_name
     * 查询新品上线
     */
    List<NewGoodsVO> selectNewGoodsList();

    List<MallGoodsInfo> selectAll();

    //函数声明要加类型
    List<MallGoodsInfo> selectAllByPage(PageVO pageVOparams);
    //函数声明要加类型
    Integer selectAllRecord(PageVO pageVOparams);

    List<HotGoodsesVO> selectHotGoodsesList();

    List<RecommendGoodsesVO> selectRecommendGoodsesList();

    Integer updateGeekMallGoods(MallGoodsInfo mallGoodsInfo);

    MallGoodsInfo getGeekMallGoodsById(Long goodsCategoryId);


    int batchUpdateSellStatus(@Param("orderIds") Long[] orderIds, @Param("sellStatus") int sellStatus);

    List<MallGoodsInfo> selectFrontAllByPage(FrontPageVo frontPageVo);

    Integer selectFrontAllRecord(FrontPageVo frontPageVo);

}
