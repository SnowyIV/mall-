package com.geekaca.mall.controller.param;

import lombok.Data;

import java.io.Serializable;

@Data
public class IndexConfigsParam implements Serializable {
    private Integer pageNO;
    private Integer pageSize;
    private Integer start;
    private Integer configType;
}
