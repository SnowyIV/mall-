package com.geekaca.mall.controller.fore;

import com.geekaca.mall.controller.vo.HotGoodsInfoVO;
import com.geekaca.mall.controller.vo.IndexInfoVO;
import com.geekaca.mall.controller.vo.NewGoodsVO;
import com.geekaca.mall.controller.vo.RecommendGoodsesVO;
import com.geekaca.mall.domain.Carousel;
import com.geekaca.mall.domain.GoodsInfo;
import com.geekaca.mall.service.CarouselService;
import com.geekaca.mall.service.GoodsService;
import com.geekaca.mall.service.IndexConfigService;
import com.geekaca.mall.utils.Result;
import com.geekaca.mall.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class IndexConfigController {
    @Autowired
    private CarouselService carouselService;
    @Autowired
    private IndexConfigService indexConfigService;
    @Autowired
    private GoodsService goodsService;
    //轮播图及商品板块
    @GetMapping("/index-infos")
    public Result IndexInfo(){
        IndexInfoVO indexInfoVO = new IndexInfoVO();
        //轮播图
        List<Carousel> carouselList = carouselService.getAll();
        indexInfoVO.setCarousels(carouselList);
        List<HotGoodsInfoVO> hotGoodsList = indexConfigService.getHotGoodsList();
        indexInfoVO.setHotGoodses(hotGoodsList);
        //indexInfoVO.setHotGoodses();
        List<NewGoodsVO> newGoodsList = indexConfigService.getNewGoodsList();
        indexInfoVO.setNewGoodses(newGoodsList);
        List<RecommendGoodsesVO> recommendGoodsesList = indexConfigService.getRecommendGoodsesList();
        indexInfoVO.setRecommendGoodses(recommendGoodsesList);
      return   ResultGenerator.genSuccessResult(indexInfoVO);
    }

    @RequestMapping("/goods/detail/{id}")
    public Result getDetail(@PathVariable("id") Long id){
        GoodsInfo detail = goodsService.getDetailById(id);
        return   ResultGenerator.genSuccessResult(detail);
    }
}
