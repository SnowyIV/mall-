package com.geekaca.mall.geekmall.controller.front;

import com.auth0.jwt.interfaces.Claim;
import com.geekaca.mall.geekmall.common.Constants;
import com.geekaca.mall.geekmall.common.NewBeeMallException;
import com.geekaca.mall.geekmall.common.ServiceResultEnum;
import com.geekaca.mall.geekmall.config.annotation.TokenToMallUser;
import com.geekaca.mall.geekmall.controller.front.param.MallShoppingCartItemVO;
import com.geekaca.mall.geekmall.controller.front.param.SaveCartItemParam;
import com.geekaca.mall.geekmall.controller.front.param.UpdateCartItemParam;
import com.geekaca.mall.geekmall.controller.vo.NewBeeMallShoppingCartItemVO;
import com.geekaca.mall.geekmall.domain.CartInfoDTO;
import com.geekaca.mall.geekmall.domain.MallShoppingCartItem;
import com.geekaca.mall.geekmall.domain.MallUser;
import com.geekaca.mall.geekmall.service.MallCartService;
import com.geekaca.mall.geekmall.utils.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车
 */
@RestController
@RequestMapping("/api/v1")
public class MallCartController {
    @Autowired
    private MallCartService cartService;

    @GetMapping("/shop-cart/page")
    @ApiOperation(value = "购物车列表(每页默认5条)", notes = "传参为页码")
    public Result<PageResult<List<MallShoppingCartItemVO>>> cartItemPageList(Integer pageNumber,HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim idClaim = stringClaimMap.get("id");
        String uid = idClaim.asString();
        long UserId = Long.parseLong(uid);
        Map params = new HashMap(8);
        if (pageNumber == null || pageNumber < 1) {
            pageNumber = 1;
        }
        params.put("userId", UserId);
        params.put("page", pageNumber);
        params.put("limit", Constants.SHOPPING_CART_PAGE_LIMIT);
        //封装分页请求参数
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(cartService.getMyShoppingCartItems(pageUtil));
    }

    @GetMapping("/shop-cart")
    public Result shopCart(HttpServletRequest request){
        //获取token
        String token = request.getHeader("token");
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim idClaim = stringClaimMap.get("id");
        String uid = idClaim.asString();
        long uidLong = Long.parseLong(uid);
        System.out.println(token);
        /**
         * 从token 解析出来userId，
         * 然后拿着userId去 查询他的购物车
         */
        //自动装箱
        List<CartInfoDTO> itemList = cartService.getByUid(uidLong);
//        {
//                totalPrice: 总价格
//            data:{
//                {商品1}，
//                {商品2}
//            }
//        }
        double totalPrice = 0;
        for (int i = 0; i < itemList.size(); i++) {
            CartInfoDTO cartInfoDTO = itemList.get(i);
            totalPrice += cartInfoDTO.getSellingPrice();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("totalPrice", totalPrice);
        map.put("goodList", itemList);
        //guest 123456   d0f023db3b68ff52cbc34d451c2ec264
        return ResultGenerator.genSuccessResult(map);
    }

    @PostMapping("/shop-cart")
    @ApiOperation(value = "添加商品到购物车接口", notes = "传参为商品id、数量")
    public Result saveNewBeeMallShoppingCartItem(@RequestBody SaveCartItemParam saveCartItemParam,
                                                HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim idClaim = stringClaimMap.get("id");
        String uid = idClaim.asString();
        long UserId = Long.parseLong(uid);
        String saveResult = cartService.saveMallCartItem(saveCartItemParam, UserId);
        //添加成功
        if (ServiceResultEnum.SUCCESS.getResult().equals(saveResult)) {
            return ResultGenerator.genSuccessResult();
        }
        //添加失败
        return ResultGenerator.genFailResult(saveResult);
    }
    @PutMapping("/shop-cart")
    @ApiOperation(value = "修改购物项数据", notes = "传参为购物项id、数量")
    public Result updateMallShoppingCartItem(@RequestBody UpdateCartItemParam updateCartItemParam,
                                                   HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim idClaim = stringClaimMap.get("id");
        String uid = idClaim.asString();
        long UserId = Long.parseLong(uid);
        String updateResult = cartService.updateMallCartItem(updateCartItemParam, UserId);
        //修改成功
        if (ServiceResultEnum.SUCCESS.getResult().equals(updateResult)) {
            return ResultGenerator.genSuccessResult();
        }
        //修改失败
        return ResultGenerator.genFailResult(updateResult);
    }

    @DeleteMapping("/shop-cart/{newBeeMallShoppingCartItemId}")
    @ApiOperation(value = "删除购物项", notes = "传参为购物项id")
    public Result updateNewBeeMallShoppingCartItem(@PathVariable("newBeeMallShoppingCartItemId") Long MallShoppingCartItemId,
                                                   @TokenToMallUser MallUser loginMallUser) {
        MallShoppingCartItem newBeeMallCartItemById = cartService.getMallCartItemById(MallShoppingCartItemId);
        if (!loginMallUser.getUserId().equals(newBeeMallCartItemById.getUserId())) {
            return ResultGenerator.genFailResult(ServiceResultEnum.REQUEST_FORBIDEN_ERROR.getResult());
        }
        Boolean deleteResult = cartService.deleteById(MallShoppingCartItemId,loginMallUser.getUserId());
        //删除成功
        if (deleteResult) {
            return ResultGenerator.genSuccessResult();
        }
        //删除失败
        return ResultGenerator.genFailResult(ServiceResultEnum.OPERATE_ERROR.getResult());
    }
    @GetMapping("/shop-cart/settle")
    @ApiOperation(value = "根据购物项id数组查询购物项明细", notes = "确认订单页面使用")
    public Result<List<NewBeeMallShoppingCartItemVO>> toSettle(Long[] cartItemIds,HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim idClaim = stringClaimMap.get("id");
        String uid = idClaim.asString();
        long UserId = Long.parseLong(uid);
        if (cartItemIds.length < 1) {
            NewBeeMallException.fail("参数异常");
        }
        int priceTotal = 0;
        List<MallShoppingCartItemVO> itemsForSettle = cartService.getCartItemsForSettle(Arrays.asList(cartItemIds), UserId);
        if (CollectionUtils.isEmpty(itemsForSettle)) {
            //无数据则抛出异常
            NewBeeMallException.fail("参数异常");
        } else {
            //总价
            for (MallShoppingCartItemVO newBeeMallShoppingCartItemVO : itemsForSettle) {
                priceTotal += newBeeMallShoppingCartItemVO.getGoodsCount() * newBeeMallShoppingCartItemVO.getSellingPrice();
            }
            if (priceTotal < 1) {
                NewBeeMallException.fail("价格异常");
            }
        }
        return ResultGenerator.genSuccessResult(itemsForSettle);
    }
}
