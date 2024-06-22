package com.geekaca.mall.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 配置表，保存针对首页配置信息
 * @TableName tb_newbee_mall_index_config
 */
@Data
public class IndexConfig implements Serializable {
    /**
     * 首页配置项主键id
     */
    private Long configId;
    private String configName;

    /**
     * 1-搜索框热搜 2-搜索下拉框热搜 3-(首页)热销商品 4-(首页)新品上线 5-(首页)为你推荐
     */
    private Integer configType;

    /**
     * 商品id 默认为0
     */
    private Long goodsId;

    /**
     * 点击后的跳转地址(默认不跳转)
     */
    private String redirectUrl;

    /**
     * 排序值(字段越大越靠前)
     */
    private Integer configRank;

    /**
     * 删除标识字段(0-未删除 1-已删除)
     */
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 创建者id
     */
    private Integer createUser;

    /**
     * 最新修改时间
     */
    private Date updateTime;

    /**
     * 修改者id
     */
    private Integer updateUser;

    private String goodsCoverImg;

    private Double sellingPrice;

    private String goodsName;
    private static final long serialVersionUID = 1L;

}