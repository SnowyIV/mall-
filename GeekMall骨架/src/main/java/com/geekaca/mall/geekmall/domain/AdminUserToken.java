  
package com.geekaca.mall.geekmall.domain;

import lombok.Data;

import java.util.Date;

/**
 * 载体，传递 token和userid
 */
@Data
public class AdminUserToken {
    private Long adminUserId;

    private String token;

    private Date updateTime;

    private Date expireTime;
}