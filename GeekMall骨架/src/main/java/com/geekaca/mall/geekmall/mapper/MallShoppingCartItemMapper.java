package com.geekaca.mall.geekmall.mapper;

import com.geekaca.mall.geekmall.domain.CartInfoDTO;
import com.geekaca.mall.geekmall.domain.MallGoodsInfo;
import com.geekaca.mall.geekmall.domain.MallShoppingCartItem;
import com.geekaca.mall.geekmall.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author ytdag
* @description 针对表【tb_newbee_mall_shopping_cart_item】的数据库操作Mapper
* @createDate 2023-07-14 20:17:03
* @Entity com.geekaca.mall.geekmall.domain.MallShoppingCartItem
*/
public interface MallShoppingCartItemMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallShoppingCartItem record);

    int insertSelective(MallShoppingCartItem record);

    int updateByPrimaryKeySelective(MallShoppingCartItem record);

    int updateByPrimaryKey(MallShoppingCartItem record);

    int deleteBatch(List<Long> ids);

    List<CartInfoDTO> selectByUid(Long userId);

    MallShoppingCartItem selectByUserIdAndGoodsId(@Param("newBeeMallUserId") Long newBeeMallUserId, @Param("goodsId") Long goodsId);

    MallShoppingCartItem selectByPrimaryKey(Long goodsId);

    int selectCountByUserId(Long newBeeMallUserId);

    List<MallShoppingCartItem> findMyMallCartItems(PageQueryUtil pageUtil);

    int getTotalMallCartItems(PageQueryUtil pageUtil);

    List<MallShoppingCartItem> selectByUserIdAndCartItemIds(@Param("newBeeMallUserId") Long newBeeMallUserId, @Param("cartItemIds") List<Long> cartItemIds);
}
