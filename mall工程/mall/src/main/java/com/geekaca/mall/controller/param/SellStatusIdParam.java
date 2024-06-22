package com.geekaca.mall.controller.param;

import lombok.Data;

import java.io.Serializable;

@Data
public class SellStatusIdParam implements Serializable {

    Long[] ids;
}
