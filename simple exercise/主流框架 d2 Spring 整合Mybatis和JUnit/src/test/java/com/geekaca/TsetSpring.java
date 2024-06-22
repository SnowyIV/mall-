package com.geekaca;

import com.geekaca.config.SpringConfig;
import com.geekaca.domain.Brand;
import com.geekaca.service.BrandService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes = SpringConfig.class)
public class TsetSpring {
    @Autowired
    private BrandService brandService;

    /**
     * 单元测试
     */
    @Test
    public void testAdd(){
        //断言    判断实际的返回值和预期的结果是否一致
        int added = brandService.addBrand(new Brand(null, "IDEA", " IntelliJ", 1, "最好用的IDE", 1));
        Assert.assertEquals(1, added);

    }
}
