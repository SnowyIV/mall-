package com.geekaca.mall.geekmall.service;


import com.geekaca.mall.geekmall.controller.front.param.MallShoppingCartItemVO;
import com.geekaca.mall.geekmall.controller.vo.MallOrderDetailVO;
import com.geekaca.mall.geekmall.controller.vo.MallOrderItemVO;
import com.geekaca.mall.geekmall.controller.vo.NewBeeMallShoppingCartItemVO;
import com.geekaca.mall.geekmall.domain.MallOrder;
import com.geekaca.mall.geekmall.domain.MallUser;
import com.geekaca.mall.geekmall.domain.MallUserAddress;
import com.geekaca.mall.geekmall.utils.PageQueryUtil;
import com.geekaca.mall.geekmall.utils.PageResult;

import java.util.List;

public interface MallOrderService {
    /**
     * 获取订单详情
     *
     * @param orderId
     * @return
     */
    MallOrderDetailVO getOrderDetailByOrderId(Long orderId);

    /**
     * 获取订单详情
     *
     * @param orderNo
     * @param userId
     * @return
     */
    MallOrderDetailVO getOrderDetailByOrderNo(String orderNo, Long userId);

    /**
     * 我的订单列表
     *
     * @param pageUtil
     * @return
     */
    PageResult getMyOrders(PageQueryUtil pageUtil);

    /**
     * 手动取消订单
     *
     * @param orderNo
     * @param userId
     * @return
     */
    String cancelOrder(String orderNo, Long userId);

    /**
     * 确认收货
     *
     * @param orderNo
     * @param userId
     * @return
     */
    String finishOrder(String orderNo, Long userId);

    String paySuccess(String orderNo, int payType);

    String saveOrder(Long UserId, MallUserAddress address, List<MallShoppingCartItemVO> itemsForSave);

    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getNewBeeMallOrdersPage(PageQueryUtil pageUtil);

    /**
     * 订单信息修改
     *
     * @param newBeeMallOrder
     * @return
     */
    String updateOrderInfo(MallOrder newBeeMallOrder);

    /**
     * 配货
     *
     * @param ids
     * @return
     */
    String checkDone(Long[] ids);

    /**
     * 出库
     *
     * @param ids
     * @return
     */
    String checkOut(Long[] ids);

    /**
     * 关闭订单
     *
     * @param ids
     * @return
     */
    String closeOrder(Long[] ids);

    List<MallOrderItemVO> getOrderItems(Long orderId);
}
