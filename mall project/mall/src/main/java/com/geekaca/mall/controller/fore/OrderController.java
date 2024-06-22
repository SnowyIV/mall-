package com.geekaca.mall.controller.fore;



import com.auth0.jwt.interfaces.Claim;
import com.geekaca.mall.controller.param.OrderParam;
import com.geekaca.mall.controller.param.UserOrderParam;
import com.geekaca.mall.controller.vo.GoodsDTO;
import com.geekaca.mall.controller.vo.NewBeeMallShoppingCartItemVO;
import com.geekaca.mall.controller.vo.OrderAndItemDTO;
import com.geekaca.mall.controller.vo.OrderDTO;
import com.geekaca.mall.domain.Order;
import com.geekaca.mall.exceptions.MallException;
import com.geekaca.mall.exceptions.UserNotLoginException;
import com.geekaca.mall.service.OrderService;
import com.geekaca.mall.utils.JwtUtil;
import com.geekaca.mall.utils.PageResult;
import com.geekaca.mall.utils.Result;
import com.geekaca.mall.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;

import static com.geekaca.mall.constants.MallConstants.CODE_USER_NOT_LOGIN;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

@Autowired
private OrderService orderService;

    @GetMapping("/shop-cart/settle")
    public Result<List<NewBeeMallShoppingCartItemVO>> createOrder(HttpServletRequest req,Integer[] cartItemIds){
        String token = req.getHeader("token");
        if (token == null) {
            throw new UserNotLoginException(CODE_USER_NOT_LOGIN, "用户未登录");
        }
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim claim = stringClaimMap.get("id");
        String sid = claim.asString();
        if (sid == null) {
            throw new UserNotLoginException(CODE_USER_NOT_LOGIN, "用户未登录");
        }
        Integer uid = Integer.parseInt(sid);
        if (cartItemIds== null|| cartItemIds.length == 0){
            throw new MallException("购物车不能为空");
        }
        OrderDTO orderDTO = new  OrderDTO();
        orderDTO.setUserId(uid);
        orderDTO.setCartItemIds(cartItemIds);
        /**
         *
         * 查询选中的商品列表
         * 手头有数据：
         * uid 和 cartItemIds
         * 目标：
         * data
         * List<GoodsDTO>
         */
        List<GoodsDTO> goodsDTOList = orderService.selectGoodsListByUidAndItemIds(uid, orderDTO.getCartItemIds());
        if (goodsDTOList != null) {
            return ResultGenerator.genSuccessResult(goodsDTOList);
        } else {
            return ResultGenerator.genFailResult("订单生成失败");
        }
    }
    @PostMapping("/saveOrder")
    public Result saveOrder(@RequestBody OrderParam orderParam, HttpServletRequest req) {
        String token = req.getHeader("token");
        if (token == null) {
            throw new UserNotLoginException(CODE_USER_NOT_LOGIN, "用户未登陆");
        }
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim claim = stringClaimMap.get("id");
        String sid = claim.asString();
        if (sid == null) {
            throw new UserNotLoginException(CODE_USER_NOT_LOGIN, "用户未登陆");
        }
        Integer uid = Integer.parseInt(sid);

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(uid);
        orderDTO.setCartItemIds(orderParam.getCartItemIds());
        orderDTO.setAddressId(orderParam.getAddressId());
        Order order = orderService.createOrder(orderDTO);
        if (order != null) {
            Result rs = new Result();
            rs.setResultCode(ResultGenerator.RESULT_CODE_SUCCESS);
            rs.setData(order.getOrderNo());
            return rs;
        } else {
            return ResultGenerator.genFailResult("订单生成失败");
        }
    }


    @ApiOperation(value = "模拟支付成功回调的接口", notes = "传参为订单号和支付方式")
    @GetMapping("/paySuccess")
    public Result paySuccess(@ApiParam(value = "订单编号") @RequestParam("orderNo") String orderNo, @ApiParam(value = "支付方式") @RequestParam("payType") int payType){
        Integer orderStatus = 1;
        int updated = orderService.updateOrderStatus(orderNo, orderStatus, payType);
        if (updated > 0){
            return ResultGenerator.genSuccessResult();
        }else{
            return ResultGenerator.genFailResult("支付失败");
        }
    }
    @GetMapping("/order")
    public Result orderList(HttpServletRequest req, @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                            @RequestParam(value = "status", required = false) Integer status){
        String token = req.getHeader("token");
        if (token == null) {
            throw new UserNotLoginException(CODE_USER_NOT_LOGIN, "用户未登陆");
        }
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim claim = stringClaimMap.get("id");
        String sid = claim.asString();
        if (sid == null) {
            throw new UserNotLoginException(CODE_USER_NOT_LOGIN, "用户未登陆");
        }
        Integer uid = Integer.parseInt(sid);
        if (pageNumber == null){
            pageNumber = 1;
        }
        Integer pageSize = 10;
        UserOrderParam userOrderParam = new UserOrderParam();
        userOrderParam.setUid(uid);
        userOrderParam.setOrderStatus(status);
        userOrderParam.setPageNum(pageNumber);
        userOrderParam.setPageSize(pageSize);
        PageResult pageResult = orderService.getOrderList(userOrderParam);
        return ResultGenerator.genSuccessResult(pageResult);
    }

    @GetMapping("/order/{orderNo}")
    @ApiOperation(value = "订单详情接口", notes = "传参为订单号")
    public Result<OrderAndItemDTO> orderDetail(@ApiParam(value = "订单号") @PathVariable("orderNo") String orderNo) {
        return ResultGenerator.genSuccessResult(orderService.getOrderDetailByOrderNo(orderNo));
    }

    @PutMapping("/order/{orderNo}/cancel")
    @ApiOperation(value = "订单取消接口", notes = "传参为订单号")
    public Result cancelOrder(@ApiParam(value = "订单号") @PathVariable("orderNo") String orderNo) {
        int result = orderService.cancelOrder(orderNo);
        if (result > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("取消失败");
        }
    }

    @PutMapping("/order/{orderNo}/finish")
    @ApiOperation(value = "确认收货接口", notes = "传参为订单号")
    public Result finishOrder(@ApiParam(value = "订单号") @PathVariable("orderNo") String orderNo) {
        int result = orderService.finishOrder(orderNo);
        if (result > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("取消失败");
        }
    }
}

