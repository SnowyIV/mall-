package com.geekaca.mall.geekmall.mapper;

import com.geekaca.mall.geekmall.domain.MallOrder;
import com.geekaca.mall.geekmall.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author ytdag
* @description 针对表【tb_newbee_mall_order】的数据库操作Mapper
* @createDate 2023-07-14 20:17:03
* @Entity com.geekaca.mall.geekmall.domain.MallOrder
*/
public interface MallOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallOrder record);

    int insertSelective(MallOrder record);

    MallOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallOrder record);

    int updateByPrimaryKey(MallOrder record);

    MallOrder selectByOrderNo(String orderNo);

    int getTotalNewBeeMallOrders(PageQueryUtil pageUtil);

    List<MallOrder> findNewBeeMallOrderList(PageQueryUtil pageUtil);

    int closeOrder(@Param("orderIds") List<Long> orderIds, @Param("orderStatus") int orderStatus);

    List<MallOrder> selectByPrimaryKeys(@Param("orderIds") List<Long> orderIds);

    int checkOut(@Param("orderIds") List<Long> orderIds);

    int checkDone(@Param("orderIds") List<Long> asList);


}
