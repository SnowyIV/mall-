package com.geekaca;

import com.geekaca.config.SpringConfig;
import com.geekaca.domain.Brand;
import com.geekaca.service.BrandService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class APP {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BrandService brandService = ctx.getBean(BrandService.class);
        List<Brand> brandList = brandService.selectAll();
        brandList.forEach(brd -> System.out.println(brd));
    }
}
