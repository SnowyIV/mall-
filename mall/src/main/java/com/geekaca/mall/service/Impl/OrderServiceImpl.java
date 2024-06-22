package com.geekaca.mall.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.geekaca.mall.constants.MallConstants;
import com.geekaca.mall.controller.param.UserOrderParam;
import com.geekaca.mall.controller.vo.GoodsDTO;
import com.geekaca.mall.controller.vo.OrderAndItemDTO;
import com.geekaca.mall.controller.vo.OrderDTO;
import com.geekaca.mall.domain.Order;
import com.geekaca.mall.domain.OrderAddress;
import com.geekaca.mall.domain.OrderItem;
import com.geekaca.mall.domain.UserAddress;
import com.geekaca.mall.exceptions.MallException;
import com.geekaca.mall.mapper.*;
import com.geekaca.mall.service.OrderService;
import com.geekaca.mall.utils.NumberUtil;
import com.geekaca.mall.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.geekaca.mall.constants.MallConstants.ORDER_STATUS_MAP;

@Service
public class OrderServiceImpl implements OrderService {
  @Autowired
    private OrderMapper orderMapper;
  
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private ShoppingCartItemMapper cartItemMapper;

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Autowired
    private OrderAddressMapper orderAddressMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Order createOrder(OrderDTO orderDTO) {
        Long generateNo = NumberUtil.generateId();
        List<GoodsDTO> goodsDTOList = orderMapper.selectGoodsListByUidAndItemIds(orderDTO.getUserId(), orderDTO.getCartItemIds());
        // 计算总价
        Integer totalPrice = 0;
        for (int i = 0; i < goodsDTOList.size(); i++) {
            GoodsDTO goodsDTO = goodsDTOList.get(i);
            totalPrice += goodsDTO.getSellingPrice() * goodsDTO.getGoodsCount();
            if (goodsDTO.getGoodsSellStatus() == MallConstants.GOODS_SELLING_STATUS_OFF){
                throw new MallException("商品"+goodsDTO.getGoodsName()+"已下架");
            }
        }
        Order order = new Order();
        order.setUserId(Long.valueOf(orderDTO.getUserId()));
        order.setTotalPrice(totalPrice);
        order.setOrderNo(String.valueOf(generateNo));
        int inserted = orderMapper.insert(order);
        if (inserted == 0){
            throw new MallException("订单增加失败");
        }
        // 保存订单项
        List<OrderItem> orderItemList = BeanUtil.copyToList(goodsDTOList, OrderItem.class);
        for (int i = 0; i < orderItemList.size(); i++) {
            OrderItem item = orderItemList.get(i);
            item.setOrderId(order.getOrderId());
        }
        int insertBatched = orderItemMapper.insertBatchItems(orderItemList);
        if (insertBatched == 0){
            throw new MallException("订单商品列表增加失败");
        }
        UserAddress userAddress = userAddressMapper.selectByPrimaryKey(Long.valueOf(orderDTO.getAddressId()));
        OrderAddress orderAddr  = BeanUtil.copyProperties(userAddress, OrderAddress.class);
        orderAddr.setOrderId(order.getOrderId());
        int addrInserted = orderAddressMapper.insertSelective(orderAddr);
        if (addrInserted == 0){
            throw new MallException("订单地址增加失败");
        }
        // 删除购物车项
        int deleted = cartItemMapper.deleteByIds(orderDTO.getCartItemIds());
        if (deleted == 0){
            throw new MallException("删除购物车商品失败");
        }
        return order;
    }

    @Override
    public Order findById(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public List<GoodsDTO> selectGoodsListByUidAndItemIds(Integer uid, Integer[] cartItemIds) {
        return orderMapper.selectGoodsListByUidAndItemIds(uid, cartItemIds);
    }

    @Override
    public int updateOrderStatus(String orderNo, Integer orderStatus, int payType) {
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setOrderStatus(orderStatus);
        order.setPayType(payType);
        order.setPayStatus(MallConstants.ORDER_PAYED);
        order.setUpdateTime(new Date());
        order.setPayTime(new Date());
        return orderMapper.updateStatusByOrderNo(order);
    }
    @Override
    public PageResult getOrderList(UserOrderParam userOrderParam) {
        int limit = (userOrderParam.getPageNum() - 1) * userOrderParam.getPageSize();
        Integer pageNO = userOrderParam.getPageNum();
        userOrderParam.setPageNum(limit);

        List<OrderAndItemDTO> orderAndItemDTOS = orderMapper.selectByStatus(userOrderParam);
        if (orderAndItemDTOS == null){
            orderAndItemDTOS = Collections.emptyList();
        }
        for (int i = 0; i < orderAndItemDTOS.size(); i++) {
            OrderAndItemDTO orDTO = orderAndItemDTOS.get(i);
            Integer orderStatus = orDTO.getOrderStatus();
            String str = ORDER_STATUS_MAP.get(orderStatus);
            orDTO.setOrderStatusString(str);
        }
        int count = orderMapper.selectCountByStatus(userOrderParam);
        PageResult pageResult = new PageResult(orderAndItemDTOS, count, userOrderParam.getPageSize(), pageNO);
        return pageResult;
    }
}
