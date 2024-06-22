package com.geekaca.mall.geekmall.controller.front;

import com.auth0.jwt.interfaces.Claim;
import com.geekaca.mall.geekmall.common.ServiceResultEnum;
import com.geekaca.mall.geekmall.config.annotation.TokenToMallUser;
import com.geekaca.mall.geekmall.controller.param.MallUserLoginParam;
import com.geekaca.mall.geekmall.controller.param.MallUserRegisterParam;
import com.geekaca.mall.geekmall.controller.param.MallUserUpdateParam;
import com.geekaca.mall.geekmall.domain.MallUser;
import com.geekaca.mall.geekmall.exceptions.BusinessException;
import com.geekaca.mall.geekmall.service.MallUserService;
import com.geekaca.mall.geekmall.utils.JwtUtil;
import com.geekaca.mall.geekmall.utils.Result;
import com.geekaca.mall.geekmall.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class MallUserController {
    @Autowired
    private MallUserService mallUserService;

    @PostMapping("/user/register")
    @ApiOperation(value = "用户注册", notes = "")
    public Result register(@RequestBody @Valid MallUserRegisterParam mallUserRegisterParam) {
        boolean isRegOk = mallUserService.register(mallUserRegisterParam);

        log.info("register api,loginName={},loginResult={}", mallUserRegisterParam.getLoginName(), isRegOk);

        //注册成功
        if (isRegOk) {
            return ResultGenerator.genSuccessResult();
        }
        //注册失败
        return ResultGenerator.genFailResult("注册失败");
    }

    @PostMapping("/user/login")
    public Result login(@RequestBody @Valid MallUserLoginParam userLoginParam) {
        String loginResult = mallUserService.login(userLoginParam);
        if (loginResult != null && !"".equals(loginResult.trim())) {
            Result result = ResultGenerator.genSuccessResult();
            result.setData(loginResult);
            return result;
        }
        return ResultGenerator.genFailResult("登陆失败");
    }

    @PostMapping("/user/logout")
    @ApiOperation(value = "登出接口", notes = "清除token")
    public Result<String> logout(HttpServletRequest request) {
        String token = request.getParameter("token");
        if (token == null){
            return ResultGenerator.genSuccessResult();
        }
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim idClaim = stringClaimMap.get("id");
        String uid = idClaim.asString();
        long uidLong = Long.parseLong(uid);
        Boolean logoutResult = mallUserService.logout(uidLong);

        log.info("logout api,loginMallUser={}", uidLong);

        //登出成功
        if (logoutResult) {
            return ResultGenerator.genSuccessResult();
        }
        //登出失败
        return ResultGenerator.genFailResult("logout error");
    }

    @PutMapping("/user/info")
    @ApiOperation(value = "修改用户信息", notes = "")
    public Result updateInfo(@RequestBody @ApiParam("用户信息") MallUserUpdateParam mallUserUpdateParam, HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim idClaim = stringClaimMap.get("id");
        String uid = idClaim.asString();
        long uidLong = Long.parseLong(uid);
        boolean flag = mallUserService.updateUserInfo(mallUserUpdateParam, uidLong);
        if (flag) {
            //返回成功
            Result result = ResultGenerator.genSuccessResult();
            return result;
        } else {
            //返回失败
            Result result = ResultGenerator.genFailResult("修改失败");
            return result;
        }
    }

    @GetMapping("/user/info")
    @ApiOperation(value = "获取用户信息", notes = "")
    public Result getInfo(HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim idClaim = stringClaimMap.get("id");
        String uid = idClaim.asString();
        long uidLong = Long.parseLong(uid);
        MallUser userInfo = mallUserService.getUserById(uidLong);
        Result result = ResultGenerator.genSuccessResult(userInfo);
        return result;
    }
}
