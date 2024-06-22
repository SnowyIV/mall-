package com.geekaca.mall.controller.param;

import lombok.Data;

@Data
public class CategoryParam {
    private Integer pageNumber;
    private Integer pageSize;
    private Integer categoryLevel;
    private Integer parentId;
}
