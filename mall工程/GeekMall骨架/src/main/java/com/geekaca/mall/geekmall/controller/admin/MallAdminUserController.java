package com.geekaca.mall.geekmall.controller.admin;

import com.geekaca.mall.geekmall.config.annotation.TokenToAdminUser;
import com.geekaca.mall.geekmall.controller.admin.param.BatchIdParam;
import com.geekaca.mall.geekmall.domain.AdminUserToken;
import com.geekaca.mall.geekmall.service.MallUserService;
import com.geekaca.mall.geekmall.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.geekaca.mall.geekmall.utils.Result;

@RestController
@Api(value = "v1", tags = "8-6.后台管理系统注册用户模块接口")
@RequestMapping("/manage-api/v1")
@Slf4j
public class MallAdminUserController {
    @Autowired
    private MallUserService mallUserService;
    /**
     * 用户禁用与解除禁用(0-未锁定 1-已锁定)
     */
    @RequestMapping(value = "/users/{lockStatus}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改用户状态", notes = "批量修改，用户禁用与解除禁用(0-未锁定 1-已锁定)")
    public Result lockUser(@RequestBody BatchIdParam batchIdParam, @PathVariable int lockStatus, @TokenToAdminUser AdminUserToken adminUser) {
        log.info("adminUser:{}", adminUser.toString());
        if (batchIdParam==null||batchIdParam.getIds().length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (lockStatus != 0 && lockStatus != 1) {
            return ResultGenerator.genFailResult("操作非法！");
        }
        if (mallUserService.lockUsers(batchIdParam.getIds(), lockStatus)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("禁用失败");
        }
    }
}
