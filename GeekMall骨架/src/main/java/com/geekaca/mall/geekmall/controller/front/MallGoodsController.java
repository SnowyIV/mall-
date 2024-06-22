package com.geekaca.mall.geekmall.controller.front;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.geekaca.mall.geekmall.common.NewBeeMallException;
import com.geekaca.mall.geekmall.controller.vo.FrontPageVo;
import com.geekaca.mall.geekmall.controller.vo.NewBeeMallGoodsDetailVO;
import com.geekaca.mall.geekmall.controller.vo.NewBeeMallSearchGoodsVO;
import com.geekaca.mall.geekmall.domain.Book;
import com.geekaca.mall.geekmall.domain.ListBook;
import com.geekaca.mall.geekmall.domain.MallGoodsInfo;
import com.geekaca.mall.geekmall.service.GeekMallGoodsService;
import com.geekaca.mall.geekmall.utils.PageResult;
import com.geekaca.mall.geekmall.utils.Result;
import com.geekaca.mall.geekmall.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.http.HttpClient;
import java.util.List;

/**
 * @RestController =  @Controller 控制器，接收http请求 + @ResponseBody(修饰方法)  字符串原样返回，Java对象->JSON
 */
@RestController
@RequestMapping("/api/v1")
public class MallGoodsController {
    @Resource
    private GeekMallGoodsService goodsService;
    @Resource
    private RestTemplate restTemplate;

    /**
     * goodsId 是用户提交的参数名
     * 参数较少的用GET， 新增，修改用post
     * http://localhost:28019/api/v1/goods/detail/10003
     *
     * @return
     */
    @GetMapping("/goods/detail/{goodsId}")
    public Result getGoodsDetailById(@PathVariable("goodsId") Long gid) {
        MallGoodsInfo goodsDetail = goodsService.getGoodsDetailById(gid);
        //前台接口，不要把所有信息都给出去，泄露机密
        /**
         * 保护方式
         * 1，自己手动把机密信息 清空
         * 2，定义单独的Value Object 来传递值
         */
//        goodsDetail.setOriginalPrice(0);
        NewBeeMallGoodsDetailVO goodsDetailVO = new NewBeeMallGoodsDetailVO();
        //从goodsDetail  复制 所有属性值 到 goodsDetailVO
        BeanUtils.copyProperties(goodsDetail, goodsDetailVO);
        //明确的告诉JVM ，这个对象我不用了，变成垃圾了
        goodsDetail = null;
        if (goodsDetailVO.getGoodsCarouselList() == null) {
            goodsDetailVO.setGoodsCarouselList(new String[]{});
        }
        //用一个controller接口调用另一个http服务
        /**
         * 比如在工作中，已经有一个项目（单独的SpringBoot web工程）具有功能：根据id查询用户详情
         *
         * httpClient
         */
//        String url = "http://localhost/books";
//        //向地址url发出一个http请求
//        String forObject = restTemplate.getForObject(url, String.class);
//        System.out.println(forObject);
        //todo: JSON解析

//        ResponseEntity<ListBook> forEntity = restTemplate.getForEntity(url, ListBook.class);
//        ListBook body = forEntity.getBody();
//        List<Book> books = body.getBooks();
//        books.forEach(b-> System.out.println(b));
        return ResultGenerator.genSuccessResult(goodsDetailVO);
    }


    /**
     * 前台商品搜索
     *
     * @param keyword
     * @param goodsCategoryId
     * @param orderBy
     * @param pageNumber
     * @return
     */
    @GetMapping("/search")
    @ApiOperation(value = "商品搜索接口", notes = "根据关键字和分类id进行搜索")
    public Result<PageResult<List<NewBeeMallSearchGoodsVO>>> search(@RequestParam(required = false) @ApiParam(value = "搜索关键字") String keyword,
                                                                    @RequestParam(required = false) @ApiParam(value = "分类id") Long goodsCategoryId,
                                                                    @RequestParam(required = false) @ApiParam(value = "排序关键字") String orderBy,
                                                                    @RequestParam(required = false) @ApiParam(value = "页码") Integer pageNumber
    ) {


        FrontPageVo frontPageVo = new FrontPageVo();
        //两个搜索参数都为空，直接返回异常
        if (goodsCategoryId == null && !StringUtils.hasText(keyword)) {
            NewBeeMallException.fail("非法的搜索参数");
        }
        if (pageNumber == null || pageNumber < 1) {
            pageNumber = 1;
        }
        frontPageVo.setPageNumber(pageNumber);
        frontPageVo.setKeyword(keyword);
        frontPageVo.setGoodsCategoryId(goodsCategoryId);
        frontPageVo.setOrderBy(orderBy);

        //对keyword做过滤 去掉空格
        if (StringUtils.hasText(keyword)) {
            frontPageVo.setKeyword(keyword);
        }
        if (StringUtils.hasText(orderBy)) {
            frontPageVo.setOrderBy(orderBy);
        }
        //搜索上架状态下的商品
        //params.put("goodsSellStatus", Constants.SELL_STATUS_UP);

        PageResult result = goodsService.searchFrontMallGoods(frontPageVo);
        return ResultGenerator.genSuccessResult(result);
    }

}
