package com.geekaca.mall;

import com.geekaca.mall.controller.vo.OrderDTO;
import com.geekaca.mall.domain.Order;
import com.geekaca.mall.domain.OrderItem;
import com.geekaca.mall.exceptions.MallException;
import com.geekaca.mall.mapper.OrderItemMapper;
import com.geekaca.mall.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional(rollbackFor = Exception.class)
public class OderTest {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Test
    public void testCreateOrder1() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(13);
        orderDTO.setCartItemIds(new Integer[]{31, 32});
        Order order = orderService.createOrder(orderDTO);
        Assertions.assertNotNull(order);

        /**
         * 验证，断言，预期
         * 1, 确实能够生成订单，保存到数据库
         * 2， 订单item表也能够查到
         */
        Long orderId = order.getOrderId();
        Order ord = orderService.findById(orderId.intValue());
        Assertions.assertNotNull(ord);

        /**
         * 订单item断言
         * 要能够根据orderID，查询到 两条item数据
         */

        List<OrderItem> orderItems = orderItemMapper.selectByOrderId(orderId.intValue());
        Assertions.assertNotNull(orderItems);
        Assertions.assertTrue(orderItems.size() == 2);
    }

    /**
     * 包含已经下架的商品
     */
    @Test
    public void testCreateOrder2() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(13);
        //33 这个商品已经下架的
        orderDTO.setCartItemIds(new Integer[]{33, 32});
        //断言， 预期 这个方法的执行 会抛出异常
        Assertions.assertThrows(MallException.class, () -> {
            Order order = orderService.createOrder(orderDTO);
            Assertions.assertNotNull(order);
        });


    }
}
