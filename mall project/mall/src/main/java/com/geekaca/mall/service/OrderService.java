package com.geekaca.mall.service;

import com.geekaca.mall.controller.param.UserOrderParam;
import com.geekaca.mall.controller.vo.GoodsDTO;
import com.geekaca.mall.controller.vo.OrderAndItemDTO;
import com.geekaca.mall.controller.vo.OrderDTO;
import com.geekaca.mall.domain.Order;
import com.geekaca.mall.utils.PageResult;

import java.util.List;

public interface OrderService {
    //  创建订单
    Order createOrder(OrderDTO orderDTO);

    Order findById(Integer orderId);

    List<GoodsDTO> selectGoodsListByUidAndItemIds(Integer uid, Integer[] cartItemIds);

    int updateOrderStatus(String orderNo, Integer orderStatus, int payType);

    PageResult getOrderList(UserOrderParam userOrderParam);

    int checkDone(Long[] ids);

    int checkOut(Long[] ids);

    int closeOrder(Long[] ids);

    OrderAndItemDTO getOrderDetailByOrderId(Long orderId);

    OrderAndItemDTO getOrderDetailByOrderNo(String orderNo);

    int cancelOrder(String orderNo);

    int finishOrder(String orderNo);
}
