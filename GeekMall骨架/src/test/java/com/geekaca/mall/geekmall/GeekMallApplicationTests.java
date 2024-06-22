package com.geekaca.mall.geekmall;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import com.auth0.jwt.interfaces.Claim;
import com.geekaca.mall.geekmall.common.Constants;
import com.geekaca.mall.geekmall.controller.param.AdminLoginParam;
import com.geekaca.mall.geekmall.domain.MallGoodsInfo;
import com.geekaca.mall.geekmall.mapper.MallGoodsInfoMapper;
import com.geekaca.mall.geekmall.service.AdminUserService;
import com.geekaca.mall.geekmall.service.MallOrderService;
import com.geekaca.mall.geekmall.utils.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.*;
//注解

/**
 * 展现层 view
 * 控制器  controller
 *
 * 业务逻辑层 service
 * 持久层   DAO 数据访问层  mapper
 *
 * 层 向下依赖  controller--引用--->service
 *
 * service 降低对其他层的依赖，易于测试
 */
@SpringBootTest
class GeekMallApplicationTests {
    @Autowired
    private MallGoodsInfoMapper goodsInfoMapper;
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private MallOrderService orderService;
    @Test
    public void testGoods(){
        //10003 默认是int   3.145默认是double
        MallGoodsInfo mallGoodsInfo = goodsInfoMapper.selectByPrimaryKey(10003L);
        Assertions.assertNotNull(mallGoodsInfo);
        Assertions.assertNotNull(mallGoodsInfo.getGoodsName());
    }

    @Test
    public void testJedisPool(){
        Jedis jedis = JedisPoolUtil.getJedis();
        jedis.set("uid", "sdfksdf");
        jedis.expire("uid", 50);

        String uid = jedis.get("uid");
        Assertions.assertNotNull(uid);
    }

    @Test
    public void testLogin(){
        AdminLoginParam loginParam = new AdminLoginParam();
        loginParam.setUserName("admin");

        loginParam.setPasswordMd5(MD5Util.MD5Encode("123456", "UTF-8"));
        String token = adminUserService.login(loginParam);

        //断言
        Assertions.assertNotNull(token);
    }

    @Test
    public void testToken(){
        String token = JwtUtil.createToken("8", "guest");
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim uid = stringClaimMap.get("id");
        Assertions.assertNotNull(uid);
        Assertions.assertEquals("8", uid.asString());
        System.out.println(token);
        System.out.println(uid.asString());

    }

    @Test
    public void testList(){
        List<String> list = new ArrayList<>();
        list.add("test");
        list.add("test");
        list.forEach(s-> System.out.println(s));
        System.out.println("================");
        Set<String> set = new HashSet<>();
        set.add("Tom");
        set.add("Tom");
        set.forEach(s -> System.out.println(s));
    }

    @Test
    public void testSnow(){
        //测试雪花算法
        //worker 工作者   datacenter：工作站
        for (int i = 0; i < 20; i++) {
            long l = IdUtil.getSnowflake(1, 20).nextId();
            System.out.println(l);
        }
    }

    @Test
    public void testOrder(){

        Map params = new HashMap(8);
        params.put("userId", 8);
        params.put("orderStatus", 1);
        params.put("page", 1);
        params.put("limit", Constants.ORDER_SEARCH_PAGE_LIMIT);
        PageQueryUtil pu = new PageQueryUtil(params);
        PageResult myOrders = orderService.getMyOrders(pu);
        Assert.notNull(myOrders);
    }
}
