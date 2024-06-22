package com.geekaca.mall.controller.param;

import lombok.Data;

@Data
public class PageParam {
    private Integer pageNO;
    private Integer pageSize;
    private Integer start;
}
