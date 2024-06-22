package com.geekaca.mall.controller.fore;

import com.auth0.jwt.interfaces.Claim;
import com.geekaca.mall.constants.MallConstants;
import com.geekaca.mall.controller.vo.GoodsDTO;
import com.geekaca.mall.domain.ShoppingCartItem;
import com.geekaca.mall.exceptions.UserNotLoginException;
import com.geekaca.mall.service.CartService;
import com.geekaca.mall.utils.JwtUtil;
import com.geekaca.mall.utils.PageResult;
import com.geekaca.mall.utils.Result;
import com.geekaca.mall.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;


import static com.geekaca.mall.constants.MallConstants.CODE_USER_NOT_LOGIN;


@RestController
@RequestMapping("/api/v1")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/shop-cart")
    public Result addToCart(@RequestBody @Valid ShoppingCartItem cartItem, HttpServletRequest req) {
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
        //String ---》Long
//        Integer.parseInt(sid)
        cartItem.setUserId(Long.parseLong(sid));
        //要拿到user_id ，需要接收token然后解析
        int added = cartService.addToCart(cartItem);
        if (added > 0) {
            return ResultGenerator.genSuccessResult("加入购车成功");
        }
        return ResultGenerator.genFailResult("加入购物车失败");
    }

    @ApiOperation(value = "购物车商品列表  和总价格")
    @GetMapping("/shop-cart")
    public Result shop_cart(HttpServletRequest req) {
        /**
         * 根据用户的id 查询 该用户的购物车 中
         * 商品列表
         */
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
        List<GoodsDTO> goodsList = cartService.getGoodsList(uid);
//        Integer totalPrice = 0;
//        for (int i = 0; i < goodsList.size(); i++) {
//            GoodsDTO goodsDTO = goodsList.get(i);
//            totalPrice += (goodsDTO.getSellingPrice() * goodsDTO.getGoodsCount());
//
//        }
//        Map<String, Object> map = new HashMap<>();
//        map.put("totalPrice", totalPrice);
//        map.put("goodList", goodsList);
        if (goodsList != null) {
            return ResultGenerator.genSuccessResult(goodsList);
        } else {
            return ResultGenerator.genFailResult("获取购物车商品失败");
        }
    }

    @DeleteMapping("/shop-cart/{cartItemId}")
    public Result deleteShopCartItem(@PathVariable("cartItemId") Integer cartItemId, HttpServletRequest request) {
        //保护校验，当前用户在删除的是自己的购物车
        String token = request.getHeader("token");
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
        //判断是否是用户自己购物车里的商品
        boolean isUserHave = cartService.isUserCartItem(uid, cartItemId);
        if (!isUserHave) {
            /**
             * 1，抛出自定义异常
             * 2，返回失败结果
             */
            Result rs = new Result();
            rs.setResultCode(MallConstants.CODE_NOT_USER_CART_ITEM);
            return rs;
        }
        int deleted = cartService.deleteCartItemById(cartItemId);
        if (deleted > 0) {
            return ResultGenerator.genSuccessResult("删除成功");
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    @GetMapping("/shop-cart/page")
    @ApiOperation(value = "购物车列表(每页默认5条)", notes = "传参为页码")
    public Result cartItemList(Integer pageNumber, HttpServletRequest req) {
        //保护校验，当前用户在删除的是自己的购物车
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
        if (pageNumber == null || pageNumber < 1) {
            pageNumber = 1;
        }
        Integer pageSize = 5;
        PageResult pageRs = cartService.getCartItemList(uid, pageNumber, pageSize);
        return ResultGenerator.genSuccessResult(pageRs);
    }
}