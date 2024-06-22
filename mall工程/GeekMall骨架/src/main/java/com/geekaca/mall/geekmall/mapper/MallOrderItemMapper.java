package com.geekaca.mall.geekmall.mapper;

import com.geekaca.mall.geekmall.domain.MallOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author ytdag
* @description 针对表【tb_newbee_mall_order_item】的数据库操作Mapper
* @createDate 2023-07-14 20:17:03
* @Entity com.geekaca.mall.geekmall.domain.MallOrderItem
*/
public interface MallOrderItemMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallOrderItem record);

    int insertSelective(MallOrderItem record);

    MallOrderItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallOrderItem record);

    int updateByPrimaryKey(MallOrderItem record);

    /**
     * 根据订单id获取订单项列表
     *
     * @param orderId
     * @return
     */
    List<MallOrderItem> selectByOrderId(Long orderId);

    /**
     * 根据订单ids获取订单项列表
     *
     * @param orderIds
     * @return
     */
    List<MallOrderItem> selectByOrderIds(@Param("orderIds") List<Long> orderIds);

    /**
     * 批量insert订单项数据
     *
     * @param orderItems
     * @return
     */
    int insertBatch(@Param("orderItems") List<MallOrderItem> orderItems);


}
