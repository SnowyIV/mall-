package com.geekaca.mall.geekmall.controller.front;

import com.geekaca.mall.geekmall.common.Constants;
import com.geekaca.mall.geekmall.controller.vo.*;
import com.geekaca.mall.geekmall.service.HomePageService;
import com.geekaca.mall.geekmall.service.MallCarouselService;
import com.geekaca.mall.geekmall.utils.Result;
import com.geekaca.mall.geekmall.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;


/**
 * 首页
 * api 为了表明这是接口的地址
 * v1 是版本号
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class MallIIndexController {
    @Autowired
    private MallCarouselService mallCarouselService;
    @Autowired
    private HomePageService homePageService;

    @RequestMapping("/index-infos")
    public Result<IndexInfoVO> indexInfo(){
        IndexInfoVO indexInfoVO = new IndexInfoVO();

        /**
         * 1, 轮播图
         * 2， 热销商品查询
         * 3，最新商品查询
         * 4，推荐商品查询
         */
        List<MallIndexCarouselVO> mallcarousels = mallCarouselService.getCarouselsForIndex(Constants.INDEX_CAROUSEL_NUMBER);
        indexInfoVO.setCarousels(mallcarousels);
        //热门商品
        List<HotGoodsesVO> allHotGoodses = homePageService.getAllHotGoodses();
        indexInfoVO.setHotGoodses(Collections.emptyList());
        //最新推荐
        List<RecommendGoodsesVO> allRecommendGoodses = homePageService.getAllRecommendGoodses();
        indexInfoVO.setRecommendGoodses(allRecommendGoodses);
        //查询新品
        List<NewGoodsVO> allNewGoods = homePageService.getAllNewGoods();
        indexInfoVO.setNewGoodses(allNewGoods);
        return ResultGenerator.genSuccessResult(indexInfoVO);
    }
    @ApiOperation(value = "获取首页新品上线", notes = "")
    @RequestMapping(value = "/getNewsGoodsList", method = RequestMethod.GET)
    public Result getNewsGoodsList(){
        List<NewGoodsVO> allNewGoods = homePageService.getAllNewGoods();
        Result result = ResultGenerator.genSuccessResult();
        result.setData(allNewGoods);
        return result;
    }

    @ApiOperation(value = "获取首页热门商品", notes = "")
    @RequestMapping(value = "/getHotGoodsesList", method = RequestMethod.GET)
    public Result getHotGoodsesList(){
        List<HotGoodsesVO> HotGoodses = homePageService.getAllHotGoodses();
        Result result = ResultGenerator.genSuccessResult();
        result.setData(HotGoodses);
        return result;
    }

    @ApiOperation(value = "获取首页最新推荐", notes = "")
    @RequestMapping(value = "/getRecommendGoodsesList", method = RequestMethod.GET)
    public Result getRecommendGoodsesList(){
        List<RecommendGoodsesVO> RecommendGoodses = homePageService.getAllRecommendGoodses();
        Result result = ResultGenerator.genSuccessResult();
        result.setData(RecommendGoodses);
        return result;
    }


}
