package com.geekaca.news.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tb_news_category
 */
public class NewsCategory implements Serializable {
    /**
     * 分类表主键
     */
    private Integer categoryId;

    /**
     * 分类的名称
     */
    private String categoryName;

    /**
     * 分类的图标
     */
    private String categoryIcon;

    /**
     * 分类的排序值 被使用的越多数值越大
     */
    private Integer categoryRank;

    /**
     * 是否删除 0=否 1=是
     */
    private Integer isDeleted;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 分类表主键
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 分类表主键
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 分类的名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 分类的名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 分类的图标
     */
    public String getCategoryIcon() {
        return categoryIcon;
    }

    /**
     * 分类的图标
     */
    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    /**
     * 分类的排序值 被使用的越多数值越大
     */
    public Integer getCategoryRank() {
        return categoryRank;
    }

    /**
     * 分类的排序值 被使用的越多数值越大
     */
    public void setCategoryRank(Integer categoryRank) {
        this.categoryRank = categoryRank;
    }

    /**
     * 是否删除 0=否 1=是
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否删除 0=否 1=是
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        NewsCategory other = (NewsCategory) that;
        return (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getCategoryName() == null ? other.getCategoryName() == null : this.getCategoryName().equals(other.getCategoryName()))
            && (this.getCategoryIcon() == null ? other.getCategoryIcon() == null : this.getCategoryIcon().equals(other.getCategoryIcon()))
            && (this.getCategoryRank() == null ? other.getCategoryRank() == null : this.getCategoryRank().equals(other.getCategoryRank()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getCategoryName() == null) ? 0 : getCategoryName().hashCode());
        result = prime * result + ((getCategoryIcon() == null) ? 0 : getCategoryIcon().hashCode());
        result = prime * result + ((getCategoryRank() == null) ? 0 : getCategoryRank().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", categoryIcon=").append(categoryIcon);
        sb.append(", categoryRank=").append(categoryRank);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}