package com.geekaca.maven;

import com.geekaca.maven.pojo.Brand;
import org.junit.Assert;
import org.junit.Test;



public class TestBrandDemo {

    @Test
    public void testAdd() {
        BrandDemo brandDemo = new BrandDemo();
        int added = brandDemo.addBrand(new Brand(null, "三星2", "三星公司", 10, "折叠屏幕", 1));
        Assert.assertTrue( added > 0);
    }

}
