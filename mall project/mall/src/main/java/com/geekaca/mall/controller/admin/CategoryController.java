package com.geekaca.mall.controller.admin;


import com.geekaca.mall.controller.param.BatchIdParam;
import com.geekaca.mall.controller.param.CategoryParam;
import com.geekaca.mall.domain.GoodsCategory;
import com.geekaca.mall.service.CategoryService;
import com.geekaca.mall.utils.PageResult;
import com.geekaca.mall.utils.Result;
import com.geekaca.mall.utils.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/manage-api/v1")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public Result categories(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                             @RequestParam(value = "pageSize", required = false) Integer pageSize,
                             @RequestParam("categoryLevel") Integer categoryLevel,
                             @RequestParam("parentId") Integer parentId) {
        if (pageNumber == null || pageNumber <= 0) {
            pageNumber = 1;
        }
        if (pageSize == null) {
            pageSize = 50;
        }
        CategoryParam categoryParam = new CategoryParam();
        categoryParam.setPageNumber(pageNumber);
        categoryParam.setPageSize(pageSize);
        categoryParam.setCategoryLevel(categoryLevel);
        categoryParam.setParentId(parentId);
        PageResult pageResult = categoryService.selectByLevelAndParentIds(categoryParam);
        if (pageResult.getList() != null) {
            return ResultGenerator.genSuccessResult(pageResult);
        } else {
            return ResultGenerator.genFailResult("获取类别失败");
        }
    }

    @GetMapping("/categories/{id}")
    public Result Categories(@PathVariable("id") Long id) {
        GoodsCategory category = categoryService.getCategory(id);
        if (category != null) {
            return ResultGenerator.genSuccessResult(category);
        } else {
            return ResultGenerator.genFailResult("获取失败");
        }
    }

    @PutMapping("/categories")
    public Result update(@RequestBody GoodsCategory goodsCategory) {
        int updated = categoryService.updateCategory(goodsCategory);
        if (updated > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }

    @PostMapping("/categories")
    public Result add(@RequestBody GoodsCategory goodsCategory) {
        int added = categoryService.addCategory(goodsCategory);
        if (added > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }

    @DeleteMapping("/categories")
    public Result delete(@RequestBody BatchIdParam batchIdParam) {
        int deleted = categoryService.deleteByIds(batchIdParam.getIds());
        if (deleted > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }
}