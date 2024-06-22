package com.geekaca.mall.geekmall.controller.admin;

import com.geekaca.mall.geekmall.common.Constants;
import com.geekaca.mall.geekmall.common.ServiceResultEnum;
import com.geekaca.mall.geekmall.controller.admin.param.BatchIdParam;
import com.geekaca.mall.geekmall.controller.admin.param.GoodsAddParam;
import com.geekaca.mall.geekmall.controller.admin.param.GoodsEditParam;
import com.geekaca.mall.geekmall.controller.vo.PageVO;
import com.geekaca.mall.geekmall.domain.MallGoodsCategory;
import com.geekaca.mall.geekmall.domain.MallGoodsInfo;
import com.geekaca.mall.geekmall.service.CategoryService;
import com.geekaca.mall.geekmall.service.GeekMallGoodsService;
import com.geekaca.mall.geekmall.utils.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/manage-api/v1")
public class GoodsController {
    @Autowired
    private GeekMallGoodsService geekMallGoodsService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有
     * <p>
     * 还能够 根据商品名字模糊查询，再组合商品的上下架的状态
     * <p>
     * 结果是分页返回的
     */
    @ApiOperation(value = "商品列表", notes = "查询所有商品")
    @RequestMapping(value = "/goods/list", method = RequestMethod.GET)
    public Result list(@RequestParam(required = false) @ApiParam(value = "页码") Integer pageNumber,
                       @RequestParam(required = false) @ApiParam(value = "每页条数") Integer pageSize,
                       @RequestParam(required = false) @ApiParam(value = "商品名称") String goodsName,
                       @RequestParam(required = false) @ApiParam(value = "上架状态 0-上架 1-下架") Integer goodsSellStatus) {
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
        pageVOparams.setGoodsName(goodsName);
        pageVOparams.setGoodsSellStatus(goodsSellStatus);


        PageResult mallGoodsInfos = geekMallGoodsService.selectAllByPage(pageVOparams);

        return ResultGenerator.genSuccessResult(mallGoodsInfos);


    }

    /**
     * 详情
     */
    @GetMapping("/goods/{id}")
    @ApiOperation(value = "获取单条商品信息", notes = "根据id查询")
    public Result info(@PathVariable("id") Long id) {
        Map goodsInfo = new HashMap(8);
        //根据id查找商品信息
        MallGoodsInfo goods = geekMallGoodsService.getGeekMallGoodsById(id);
        if (goods == null) {
            return ResultGenerator.genFailResult(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }
        goodsInfo.put("goods", goods);
        //查找三个级别的信息
        MallGoodsCategory thirdCategory;
        MallGoodsCategory secondCategory;
        MallGoodsCategory firstCategory;
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
    public Result update(@RequestBody @Valid GoodsEditParam goodsEditParam) {

        MallGoodsInfo mallGoodsInfo = new MallGoodsInfo();

        BeanUtil.copyProperties(goodsEditParam, mallGoodsInfo);

        Integer update = geekMallGoodsService.updateGeekMallGoods(mallGoodsInfo);

        if (update > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("更新失败");
        }
    }

    /**
     * 添加
     */
    @RequestMapping(value = "/goods", method = RequestMethod.POST)
    @ApiOperation(value = "新增商品信息", notes = "新增商品信息")
    public Result save(@RequestBody @Valid GoodsAddParam goodsAddParam) {

        MallGoodsInfo goodsInfo = new MallGoodsInfo();
        BeanUtil.copyProperties(goodsAddParam, goodsInfo);
        String result = geekMallGoodsService.addGoods(goodsInfo);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 修改销售状态
     */
    @RequestMapping(value = "/goods/status/{sellStatus}", method = RequestMethod.PUT)
    @ApiOperation(value = "批量修改销售状态", notes = "批量修改销售状态")
    public Result delete(@RequestBody BatchIdParam batchIdParam, @PathVariable("sellStatus") int sellStatus) {

        if (batchIdParam == null || batchIdParam.getIds().length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (sellStatus != Constants.SELL_STATUS_UP && sellStatus != Constants.SELL_STATUS_DOWN) {
            return ResultGenerator.genFailResult("状态异常！");
        }
        if (geekMallGoodsService.updateSellStatus(batchIdParam.getIds(), sellStatus)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }
}
