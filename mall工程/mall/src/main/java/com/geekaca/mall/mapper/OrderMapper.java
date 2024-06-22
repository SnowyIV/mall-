package com.geekaca.mall.mapper;

import com.geekaca.mall.controller.param.UserOrderParam;
import com.geekaca.mall.controller.vo.GoodsDTO;
import com.geekaca.mall.controller.vo.OrderAndItemDTO;
import com.geekaca.mall.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 74168
* @description 针对表【tb_newbee_mall_order】的数据库操作Mapper
* @createDate 2024-01-10 21:00:52
* @Entity com.geekaca.mall.domain.Order
*/

@Mapper
public interface OrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<GoodsDTO> selectGoodsListByUidAndItemIds(@Param("uid") Integer uid, @Param("cartItemIds") Integer[] cartItemIds);

    int updateStatusByOrderNo(Order order);

    List<OrderAndItemDTO> selectByStatus(UserOrderParam userOrderParam);

    int selectCountByStatus(UserOrderParam userOrderParam);
}
