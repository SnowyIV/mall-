package com.geekaca.mall.mapper;

import com.geekaca.mall.controller.vo.GoodsDTO;
import com.geekaca.mall.domain.ShoppingCartItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 74168
* @description 针对表【tb_newbee_mall_shopping_cart_item】的数据库操作Mapper
* @createDate 2024-01-10 21:00:52
* @Entity com.geekaca.mall.domain.ShoppingCartItem
*/
@Mapper
public interface ShoppingCartItemMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingCartItem record);

    int insertSelective(ShoppingCartItem cartItem);

    List<ShoppingCartItem>  selectItemsByUid(Integer uid);

    int updateByPrimaryKeySelective(ShoppingCartItem record);

    int updateByPrimaryKey(ShoppingCartItem record);


    ShoppingCartItem selectItemByUidAndItemId(@Param("uid") Integer uid, @Param("cartItemId") Integer cartItemId);

    int deleteByIds(Integer[] id);

    List<ShoppingCartItem> selectItemsByUidAndPage(@Param("uid") Integer uid, @Param("limit") int limit, @Param("pageSize") Integer pageSize);

    int selectItemsCountByUid(Integer uid);
}
