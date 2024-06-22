package com.geekaca.mall.controller.fore;

import cn.hutool.crypto.digest.DigestUtil;
import com.auth0.jwt.interfaces.Claim;
import com.geekaca.mall.controller.param.UserParam;
import com.geekaca.mall.domain.User;
import com.geekaca.mall.service.UserService;
import com.geekaca.mall.utils.JwtUtil;
import com.geekaca.mall.utils.Result;
import com.geekaca.mall.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 参数  ：loginName,password ,password2
     *
     * @return
     */
    @PostMapping("/user/register")
    public Result userReg(@RequestBody UserParam userParam) {
        log.info("userParam:{}", userParam);
        String md5Pass = DigestUtil.md5Hex(userParam.getPasswordMD5());
        userParam.setPasswordMD5(md5Pass);
        int isRegisterOk = userService.userRegister(userParam.getLoginName(), userParam.getPasswordMD5());


        if (isRegisterOk > 0) {
            return ResultGenerator.genSuccessResult("注册成功");
        } else {
            return ResultGenerator.genFailResult("注册失败");
        }
    }

    /**
     * 登陆成功后
     * 给前端返回token
     *
     * @param userParam
     * @return
     */
    @PostMapping("/user/login")
    public Result userLogin(@RequestBody UserParam userParam) {
        User user = userService.login(userParam);
        Result result = ResultGenerator.genSuccessResult();
        if (user != null) {
            String token = JwtUtil.createToken(String.valueOf(user.getUserId()), user.getLoginName());
            result.setData(token);
            return result;
        }
        return ResultGenerator.genFailResult("登陆失败");
    }

    @GetMapping("/user/info")
    @ApiOperation(value = "获取用户信息", notes = "")
    public Result getInfo(HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim idClaim = stringClaimMap.get("id");
        String uid = idClaim.asString();
        long uidLong = Long.parseLong(uid);
        User userInfo = userService.getUserById(uidLong);
        return ResultGenerator.genSuccessResult(userInfo);
    }

    @PutMapping("/user/info")
    @ApiOperation(value = "修改用户信息", notes = "")
    public Result updateInfo(@RequestBody @ApiParam("用户信息") User userUpdateInfo, HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim idClaim = stringClaimMap.get("id");
        String uid = idClaim.asString();
        long uidLong = Long.parseLong(uid);
        userUpdateInfo.setUserId(uidLong);
        int flag = userService.updateUserInfo(userUpdateInfo);
        if (flag > 0) {
            //返回成功
            return ResultGenerator.genSuccessResult();
        } else {
            //返回失败
            return ResultGenerator.genFailResult("修改失败");
        }
    }
}
