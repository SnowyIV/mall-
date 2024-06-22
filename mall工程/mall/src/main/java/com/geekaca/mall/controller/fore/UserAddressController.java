package com.geekaca.mall.controller.fore;

import com.auth0.jwt.interfaces.Claim;
import com.geekaca.mall.domain.UserAddress;
import com.geekaca.mall.exceptions.UserNotLoginException;
import com.geekaca.mall.service.UserAddressService;
import com.geekaca.mall.service.UserService;
import com.geekaca.mall.utils.JwtUtil;
import com.geekaca.mall.utils.Result;
import com.geekaca.mall.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.geekaca.mall.constants.MallConstants.CODE_USER_NOT_LOGIN;

@RestController
@RequestMapping("/api/v1")
public class UserAddressController {
    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("/address")
    public Result getAddressList(HttpServletRequest req) {
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
        List<UserAddress> userAddressList = userAddressService.getUserAddressList(uid);
        if (userAddressList != null) {
            return ResultGenerator.genSuccessResult(userAddressList);
        } else {
            return ResultGenerator.genFailResult("地址获取异常");
        }
    }

    @GetMapping("/address/default")
    public Result getDefaultAddress(HttpServletRequest req) {
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
        UserAddress userDefaultAddr = userAddressService.getUserDefaultAddress(uid);
        return ResultGenerator.genSuccessResult(userDefaultAddr);

    }

    @PostMapping("/address")
    public Result addAddr(@RequestBody UserAddress userAddress, HttpServletRequest req){
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
        userAddress.setUserId(Long.valueOf(uid));
        int added = userAddressService.addUserAddress(userAddress);
        if (added > 0 ){
            return ResultGenerator.genSuccessResult("增加地址成功");
        }else{
            return ResultGenerator.genFailResult("增加地址失败");
        }
    }
}
