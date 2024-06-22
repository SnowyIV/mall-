package com.geekaca.mall.controller.fore;


import cn.hutool.crypto.digest.DigestUtil;
import com.geekaca.mall.controller.param.UserParam;
import com.geekaca.mall.domain.User;
import com.geekaca.mall.service.UserService;
import com.geekaca.mall.utils.JwtUtil;
import com.geekaca.mall.utils.Result;
import com.geekaca.mall.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    @ApiOperation(value = "注册接口", notes = "")
    public Result userReg(@RequestBody @Valid UserParam userParam) {
        log.info("userParam:{}", userParam);
        String md5Pass = DigestUtil.md5Hex(userParam.getPasswordMd5());
        userParam.setPasswordMd5(md5Pass);
        boolean isRegisterOk = userService.register(userParam.getLoginName(), userParam.getPasswordMd5());
        if (isRegisterOk) {
            return ResultGenerator.genSuccessResult("注册成功");
        } else {
            return ResultGenerator.genFailResult("注册失败");
        }
    }


    @PostMapping("/user/login")
    public Result userLogin(@RequestBody @Valid UserParam userParam ){
        User user = userService.login(userParam);
        Result result = ResultGenerator.genSuccessResult();
        if (user != null){
            String token = JwtUtil.createToken(String.valueOf(user.getUserId()), user.getLoginName());
            result.setData(token);
            return result;
        }
        return ResultGenerator.genFailResult("登陆失败");
    }
    }

