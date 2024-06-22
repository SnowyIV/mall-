package com.geekaca.mall.controller.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
@Data
public class UserParam {
    @ApiModelProperty("登录名")
    @NotEmpty(message = "登陆名不能为空")
    private String loginName;

    @ApiModelProperty("用户密码")
    @NotEmpty(message = "密码不能为空")
    private String passwordMd5;


}
