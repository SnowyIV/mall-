package com.geekaca.mall.controller.admin;


import cn.hutool.core.bean.BeanUtil;
import com.auth0.jwt.interfaces.Claim;
import com.geekaca.mall.constants.MallConstants;
import com.geekaca.mall.controller.param.BatchIdParam;
import com.geekaca.mall.controller.param.GoodsParam;
import com.geekaca.mall.domain.GoodsCategory;
import com.geekaca.mall.domain.GoodsInfo;
import com.geekaca.mall.exceptions.UserNotLoginException;
import com.geekaca.mall.service.CategoryService;
import com.geekaca.mall.service.GoodsService;
import com.geekaca.mall.utils.JwtUtil;
import com.geekaca.mall.utils.PageResult;
import com.geekaca.mall.utils.Result;
import com.geekaca.mall.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.HashMap;
import java.util.Map;

import static com.geekaca.mall.constants.MallConstants.CODE_USER_NOT_LOGIN;

@RestController
@RequestMapping("/manage-api/v1")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "商品列表", notes = "查询所有商品")
    @RequestMapping(value = "/goods/list", method = RequestMethod.GET)
    public Result list(@RequestParam(required = false) @ApiParam(value = "页码") Integer pageNumber,
                       @RequestParam(required = false) @ApiParam(value = "每页条数") Integer pageSize,
                       @RequestParam(required = false) @ApiParam(value = "商品名称") String goodsName,
                       @RequestParam(required = false) @ApiParam(value = "上架状态 0-上架 1-下架") Integer goodsSellStatus) {
        if (pageNumber == null || pageNumber <= 0) {
            pageNumber = 1;
        }
        if (pageSize == null || pageSize < 0) {
            pageSize = 10;
        }
        GoodsParam goodsParam = new GoodsParam(goodsName, goodsSellStatus, pageNumber, pageSize);
        PageResult pageResult = goodsService.getGoodsList(goodsParam);
        if (pageResult != null) {
            return ResultGenerator.genSuccessResult(pageResult);
        } else {
            return ResultGenerator.genFailResult("没有找到相关商品");
        }
    }

    @PostMapping("/goods")
    public Result add(@RequestBody GoodsInfo goodsInfo) {
        int added = goodsService.addGoods(goodsInfo);
        if (added > 0) {
            return ResultGenerator.genSuccessResult("增加成功");
        } else {
            return ResultGenerator.genFailResult("增加失败");
        }
    }

    /**
     * 修改销售状态
     */
    @RequestMapping(value = "/goods/status/{sellStatus}", method = RequestMethod.PUT)
    @ApiOperation(value = "批量修改销售状态", notes = "批量修改销售状态")
    public Result updateSellStatus(@RequestBody BatchIdParam batchIdParam, @PathVariable("sellStatus") int sellStatus) {
        int updated = goodsService.updateSellStatus(batchIdParam.getIds(), sellStatus);
        if (updated > 0) {
            return ResultGenerator.genSuccessResult("修改成功");
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }

    /**
     * 详情
     */
    @GetMapping("/goods/{id}")
    @ApiOperation(value = "获取单条商品信息", notes = "根据id查询")
    public Result info(@PathVariable("id") Long id) {
        Map goodsInfo = new HashMap(8);
        //根据id查找商品信息
        GoodsInfo goods = goodsService.getGoodsById(id);
        if (goods == null) {
            return ResultGenerator.genFailResult("商品不存在!");
        }
        goodsInfo.put("goods", goods);
        //查找三个级别的信息
        GoodsCategory thirdCategory;
        GoodsCategory secondCategory;
        GoodsCategory firstCategory;
        //根据id查找商品分类,三级查询
        Long goodsCategoryId = goods.getGoodsCategoryId();
        thirdCategory = categoryService.getGoodsCategoryById(goodsCategoryId);
        if (thirdCategory != null) {
            goodsInfo.put("thirdCategory", thirdCategory);
            secondCategory = categoryService.getGoodsCategoryById(thirdCategory.getParentId());
            if (secondCategory != null) {
                goodsInfo.put("secondCategory", secondCategory);
                firstCategory = categoryService.getGoodsCategoryById(secondCategory.getParentId());
                if (firstCategory != null) {
                    goodsInfo.put("firstCategory", firstCategory);
                }
            }
        }
        return ResultGenerator.genSuccessResult(goodsInfo);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/goods", method = RequestMethod.PUT)
    @ApiOperation(value = "修改商品信息", notes = "修改商品信息")
    public Result update(@RequestBody @Valid GoodsInfo goodsEditInfo, HttpServletRequest req) {
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
        int id = Integer.parseInt(sid);
        goodsEditInfo.setUpdateUser(id);
        goodsEditInfo.setGoodsCarousel(goodsEditInfo.getGoodsCoverImg());
        int update = goodsService.updateGoodsInfo(goodsEditInfo);
        if (update > 0) {
            return ResultGenerator.genSuccessResult("更新成功");
        } else {
            return ResultGenerator.genFailResult("更新失败");
        }
    }
}

