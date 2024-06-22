package com.geekaca.mall.controller.admin;


import com.geekaca.mall.controller.param.UserOrderParam;
import com.geekaca.mall.service.OrderService;
import com.geekaca.mall.utils.PageResult;
import com.geekaca.mall.utils.Result;
import com.geekaca.mall.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/manage-api/v1")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public Result orders(HttpServletRequest req, @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                         @RequestParam(value = "orderStatus", required = false) Integer status,
                         @RequestParam(value = "orderNo", required = false) Integer orderNo ){
        if (pageNumber == null){
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

}
