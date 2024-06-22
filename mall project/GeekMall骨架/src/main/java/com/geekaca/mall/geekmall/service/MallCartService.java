package com.geekaca.mall.geekmall.service;

import com.geekaca.mall.geekmall.controller.front.param.MallShoppingCartItemVO;
import com.geekaca.mall.geekmall.controller.front.param.SaveCartItemParam;
import com.geekaca.mall.geekmall.controller.front.param.UpdateCartItemParam;
import com.geekaca.mall.geekmall.controller.vo.NewBeeMallShoppingCartItemVO;
import com.geekaca.mall.geekmall.domain.CartInfoDTO;
import com.geekaca.mall.geekmall.domain.MallShoppingCartItem;
import com.geekaca.mall.geekmall.utils.PageQueryUtil;
import com.geekaca.mall.geekmall.utils.PageResult;

import java.util.List;

public interface MallCartService {
    List<CartInfoDTO> getByUid(Long userId);
    /**
     * 我的购物车(分页数据)
     *
     * @param pageUtil
     * @return
     */
    PageResult getMyShoppingCartItems(PageQueryUtil pageUtil);

    /**
     * 保存商品至购物车中
     *
     * @param saveCartItemParam
     * @param userId
     * @return
     */
    String saveMallCartItem(SaveCartItemParam saveCartItemParam, Long userId);
    /**
     * 修改购物车中的属性
     *
     * @param updateCartItemParam
     * @param userId
     * @return
     */
    String updateMallCartItem(UpdateCartItemParam updateCartItemParam, Long userId);

    /**
     * 获取购物项详情
     *
     * @param newBeeMallShoppingCartItemId
     * @return
     */
    MallShoppingCartItem getMallCartItemById(Long newBeeMallShoppingCartItemId);

    /**
     * 删除购物车中的商品
     *
     *
     * @param shoppingCartItemId
     * @param userId
     * @return
     */
    Boolean deleteById(Long shoppingCartItemId, Long userId);

    /**
     * 根据userId和cartItemIds获取对应的购物项记录
     *
     * @param cartItemIds
     * @param UserId
     * @return
     */
    List<MallShoppingCartItemVO> getCartItemsForSettle(List<Long> cartItemIds, Long UserId);
}
