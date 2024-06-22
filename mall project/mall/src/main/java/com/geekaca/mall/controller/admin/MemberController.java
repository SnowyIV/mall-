package com.geekaca.mall.controller.admin;

import com.geekaca.mall.controller.param.BatchIdParam;
import com.geekaca.mall.controller.param.PageParam;
import com.geekaca.mall.service.UserService;
import com.geekaca.mall.utils.PageResult;
import com.geekaca.mall.utils.Result;
import com.geekaca.mall.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/manage-api/v1")
public class MemberController {

    @Autowired
    private UserService userService;
    /**
     * 查询所有会员
     */
    @ApiOperation(value = "会员列表", notes = "查询所有会员")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Result list(@RequestParam(required = false) @ApiParam(value = "页码") Integer pageNumber,
                       @RequestParam(required = false) @ApiParam(value = "每页条数") Integer pageSize) {
        if (pageNumber == null || pageNumber <= 0) {
            pageNumber = 1;
        }
        if (pageSize == null || pageSize < 0) {
            pageSize = 10;
        }
        PageParam pageParam = new PageParam();
        pageParam.setPageNO(pageNumber);
        pageParam.setPageSize(pageSize);
        PageResult memberInfos = userService.selectAllMember(pageParam);
        return ResultGenerator.genSuccessResult(memberInfos);
    }

    @RequestMapping(value = "/users/{lockedFlag}", method = RequestMethod.PUT)
    @ApiOperation(value = "批量修改销售状态", notes = "批量修改销售状态")
    public Result updateUserLock(@RequestBody BatchIdParam batchIdParam, @PathVariable("lockedFlag") int lockedFlag) {
        int updated = userService.updateUserLock(batchIdParam.getIds(), lockedFlag);
        if (updated > 0) {
            return ResultGenerator.genSuccessResult("修改成功");
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }
}
