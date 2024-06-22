package com.geekaca.mall;

import com.geekaca.mall.domain.GoodsInfo;
import com.geekaca.mall.mapper.GoodsInfoMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallApplicationTests {
    @Autowired
    private GoodsInfoMapper goodsInfoMapper;
    @Test
   public void testGetGoods() {
GoodsInfo goodsInfo = goodsInfoMapper.selectByPrimaryKey(10003L);
        Assertions.assertNotNull(goodsInfo);
    }

}
