package com.geekaca.mall.geekmall.controller.admin;

import com.geekaca.mall.geekmall.domain.MallGoodsInfo;
import com.geekaca.mall.geekmall.service.CategoryService;
import com.geekaca.mall.geekmall.service.GeekMallGoodsService;
import com.geekaca.mall.geekmall.utils.PageQueryUtil;
import com.geekaca.mall.geekmall.utils.PageResult;
import com.geekaca.mall.geekmall.utils.Result;
import com.geekaca.mall.geekmall.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/manage-api/v1")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Resource
    private GeekMallGoodsService geekMallGoodsService;

    /**
     * 获取商品分类
     *
     * @param pageNumber    第几页
     * @param pageSize      每页显示记录条数
     * @param categoryLevel 类别的等级
     * @param parentId      父亲类别id
     * @return
     */
    @ApiOperation(value = "商品分类列表", notes = "根据级别和上级分类id查询")
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public Result listCategory(@RequestParam(required = false) @ApiParam(value = "页码") Integer pageNumber,
                               @RequestParam(required = false) @ApiParam(value = "每页条数") Integer pageSize,
                               @RequestParam(required = false) @ApiParam(value = "分类级别") Integer categoryLevel,
                               @RequestParam(required = false) @ApiParam(value = "上级分类的id") Long parentId) {
        Map map = new HashMap();
        map.put("page", pageNumber);
        map.put("limit", pageSize);
        map.put("categoryLevel", categoryLevel);
        map.put("parentId", parentId);
        PageQueryUtil pageQueryUtil = new PageQueryUtil(map);
        PageResult categoryPage = categoryService.getCategoryPage(pageQueryUtil);
        return ResultGenerator.genSuccessResult(categoryPage);
    }


}
