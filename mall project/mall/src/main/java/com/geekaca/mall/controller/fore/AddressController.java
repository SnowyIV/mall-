package com.geekaca.mall.controller.fore;

import com.auth0.jwt.interfaces.Claim;
import com.geekaca.mall.domain.UserAddress;
import com.geekaca.mall.exceptions.UserNotLoginException;
import com.geekaca.mall.service.AddressService;
import com.geekaca.mall.utils.JwtUtil;
import com.geekaca.mall.utils.Result;
import com.geekaca.mall.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;

import static com.geekaca.mall.constants.MallConstants.CODE_USER_NOT_LOGIN;

@RestController
@RequestMapping("/api/v1")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/address/default")
    public Result getDefaultAddress(HttpServletRequest req){
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
        long uid = Long.parseLong(sid);
        UserAddress userAddress = addressService.selectAddressByUserId(uid);
        if (userAddress!=null) {
            return ResultGenerator.genSuccessResult(userAddress);
        }else {
            return ResultGenerator.genFailResult("没有默认地址");
        }
    }

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
        List<UserAddress> userAddressList = addressService.getUserAddressList(uid);
        if (userAddressList != null) {
            return ResultGenerator.genSuccessResult(userAddressList);
        } else {
            return ResultGenerator.genFailResult("地址获取异常");
        }
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
        /**
         * 判断 userAddress是否设置为默认地址
         * 如果是，需要 把数据库之前的默认地址 取消
         */
        if (userAddress.getDefaultFlag()== 1) {
            addressService.updateUserDefaultAddress(uid);
        }
        int added = addressService.addUserAddress(userAddress);
        if (added > 0 ){
            return ResultGenerator.genSuccessResult("增加地址成功");
        }else{
            return ResultGenerator.genFailResult("增加地址失败");
        }
    }

    @PutMapping("/address")
    public Result updateAddAddr(@RequestBody UserAddress userAddress, HttpServletRequest req){
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
        if (userAddress.getDefaultFlag()== 1) {
            addressService.updateUserDefaultAddress(uid);
        }
        int updated = addressService.updateUserAddr(userAddress);
        if (updated > 0 ){
            return ResultGenerator.genSuccessResult("修改地址成功");
        }else{
            return ResultGenerator.genFailResult("修改地址失败");
        }
    }

    @GetMapping("/address/{addrId}")
    public Result getChooseAddress(@PathVariable("addrId") Integer addrId) {
        UserAddress chooseAddr = addressService.getChooseAddr(addrId);
        if (chooseAddr != null) {
            return ResultGenerator.genSuccessResult(chooseAddr);
        } else {
            return ResultGenerator.genFailResult("地址获取异常");
        }
    }
}
