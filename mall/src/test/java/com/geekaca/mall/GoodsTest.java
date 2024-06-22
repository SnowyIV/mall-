package com.geekaca.mall;

import com.geekaca.mall.domain.GoodsInfo;
import com.geekaca.mall.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class GoodsTest {
    @Autowired
    private GoodsService goodsService;

//    @Test
//    public void testInsertGoods(GoodsInfo record) {
//        // 测试插入商品的方法
//        // 这里需要传入一个GoodsInfo对象作为参数
//        // 假设record是准备插入的商品信息
//        GoodsInfo record1 = new GoodsInfo();
//        record1.setGoodsId(Long.valueOf("22250"));
//        record1.setGoodsName("测试商品2");
//        record1.setGoodsIntro("这是一个测试商品2");
//        record1.setGoodsCoverImg("test_cover_img2.jpg");
//        record1.setGoodsCarousel("test_carousel2.jpg");
//        record1.setOriginalPrice(100);
//        record1.setSellingPrice(80);
//        record1.setStockNum(100);
//        record1.setTag("测试");
//        record1.setGoodsSellStatus(1);
//        record1.setGoodsCategoryId(Long.valueOf("10000"));
//        record1.setCreateUser(0);
//        record1.setCreateTime(null);
//        record1.setUpdateUser(0);
//        record1.setGoodsDetailContent("这是测试商品2的详情");
//        goodsService.insert(record);
//        System.out.println("商品插入完成");
//    }
}
