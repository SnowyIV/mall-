package com.geekaca.mall.controller.admin;


import com.geekaca.mall.controller.param.BatchIdParam;
import com.geekaca.mall.controller.param.UserOrderParam;
import com.geekaca.mall.controller.vo.OrderAndItemDTO;
import com.geekaca.mall.service.OrderService;
import com.geekaca.mall.utils.PageResult;
import com.geekaca.mall.utils.Result;
import com.geekaca.mall.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/manage-api/v1")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public Result orders(HttpServletRequest req, @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                         @RequestParam(value = "orderStatus", required = false) Integer status,
                         @RequestParam(value = "orderNo", required = false) Integer orderNo) {
        if (pageNumber == null) {
            pageNumber = 1;
        }
        Integer pageSize = 10;
        UserOrderParam userOrderParam = new UserOrderParam();
        userOrderParam.setOrderStatus(status);
        userOrderParam.setPageNum(pageNumber);
        userOrderParam.setPageSize(pageSize);
        PageResult pageResult = orderService.getOrderList(userOrderParam);
        return ResultGenerator.genSuccessResult(pageResult);
    }

    @GetMapping("/orders/{orderId}")
    @ApiOperation(value = "订单详情接口", notes = "传参为订单号")
    public Result<OrderAndItemDTO> orderDetailPage(@ApiParam(value = "订单号") @PathVariable("orderId") Long orderId) {
        return ResultGenerator.genSuccessResult(orderService.getOrderDetailByOrderId(orderId));
    }

    /**
     * 配货
     */
    @RequestMapping(value = "/orders/checkDone", method = RequestMethod.PUT)
    @ApiOperation(value = "修改订单状态为配货成功", notes = "批量修改")
    public Result checkDone(@RequestBody BatchIdParam batchIdParam) {
        int result = orderService.checkDone(batchIdParam.getIds());
        if (result > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }

    /**
     * 出库
     */
    @RequestMapping(value = "/orders/checkOut", method = RequestMethod.PUT)
    @ApiOperation(value = "修改订单状态为已出库", notes = "批量修改")
    public Result checkOut(@RequestBody BatchIdParam batchIdParam) {
        int result = orderService.checkOut(batchIdParam.getIds());
        if (result > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }

    /**
     * 关闭订单
     */
    @RequestMapping(value = "/orders/close", method = RequestMethod.PUT)
    @ApiOperation(value = "修改订单状态为商家关闭", notes = "批量修改")
    public Result closeOrder(@RequestBody BatchIdParam batchIdParam) {
        int result = orderService.closeOrder(batchIdParam.getIds());
        if (result > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }
}
