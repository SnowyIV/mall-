package com.geekaca.mall.geekmall.controller.admin;

import com.geekaca.mall.geekmall.controller.vo.PageVO;
import com.geekaca.mall.geekmall.service.GeekMallGoodsService;
import com.geekaca.mall.geekmall.service.MemberService;
import com.geekaca.mall.geekmall.utils.PageResult;
import com.geekaca.mall.geekmall.utils.Result;
import com.geekaca.mall.geekmall.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/manage-api/v1")
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * 查询所有会员
     */
    @ApiOperation(value = "会员列表", notes = "查询所有会员")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Result list(@RequestParam(required = false) @ApiParam(value = "页码") Integer pageNumber,
                       @RequestParam(required = false) @ApiParam(value = "每页条数") Integer pageSize) {
        if (pageNumber == null || pageNumber < 1 || pageSize == null || pageSize < 10) {
            return ResultGenerator.genFailResult("分页参数异常！");
        }
        log.info("test");
//        Map params = new HashMap(8);
//        params.put("page", pageNumber);
//        params.put("limit", pageSize);
//        if (StringUtils.hasText(goodsName)) {
//            params.put("goodsName", goodsName);
//        }
//        if (goodsSellStatus != null) {
//            params.put("goodsSellStatus", goodsSellStatus);
//        }

        //用自己创建的类接受前端参数
        PageVO pageVOparams = new PageVO();
        pageVOparams.setPageNumber(pageNumber);
        pageVOparams.setPageRecord(pageSize);

        PageResult mallMemberInfos = memberService.selectAllMember(pageVOparams);

        return ResultGenerator.genSuccessResult(mallMemberInfos);


    }
}
