package com.geekaca.news.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tb_link
 */
public class Link implements Serializable {
    /**
     * 内部链接表主键id
     */
    private Integer linkId;

    /**
     * 内部链接类别 0-内部链接 1-推荐 2-个人网站
     */
    private Integer linkType;

    /**
     * 网站名称
     */
    private String linkName;

    /**
     * 网站链接
     */
    private String linkUrl;

    /**
     * 网站描述
     */
    private String linkDescription;

    /**
     * 用于列表排序
     */
    private Integer linkRank;

    /**
     * 是否删除 0-未删除 1-已删除
     */
    private Integer isDeleted;

    /**
     * 添加时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 内部链接表主键id
     */
    public Integer getLinkId() {
        return linkId;
    }

    /**
     * 内部链接表主键id
     */
    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    /**
     * 内部链接类别 0-内部链接 1-推荐 2-个人网站
     */
    public Integer getLinkType() {
        return linkType;
    }

    /**
     * 内部链接类别 0-内部链接 1-推荐 2-个人网站
     */
    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    /**
     * 网站名称
     */
    public String getLinkName() {
        return linkName;
    }

    /**
     * 网站名称
     */
    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    /**
     * 网站链接
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * 网站链接
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    /**
     * 网站描述
     */
    public String getLinkDescription() {
        return linkDescription;
    }

    /**
     * 网站描述
     */
    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }

    /**
     * 用于列表排序
     */
    public Integer getLinkRank() {
        return linkRank;
    }

    /**
     * 用于列表排序
     */
    public void setLinkRank(Integer linkRank) {
        this.linkRank = linkRank;
    }

    /**
     * 是否删除 0-未删除 1-已删除
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否删除 0-未删除 1-已删除
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 添加时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 添加时间
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
        Link other = (Link) that;
        return (this.getLinkId() == null ? other.getLinkId() == null : this.getLinkId().equals(other.getLinkId()))
            && (this.getLinkType() == null ? other.getLinkType() == null : this.getLinkType().equals(other.getLinkType()))
            && (this.getLinkName() == null ? other.getLinkName() == null : this.getLinkName().equals(other.getLinkName()))
            && (this.getLinkUrl() == null ? other.getLinkUrl() == null : this.getLinkUrl().equals(other.getLinkUrl()))
            && (this.getLinkDescription() == null ? other.getLinkDescription() == null : this.getLinkDescription().equals(other.getLinkDescription()))
            && (this.getLinkRank() == null ? other.getLinkRank() == null : this.getLinkRank().equals(other.getLinkRank()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLinkId() == null) ? 0 : getLinkId().hashCode());
        result = prime * result + ((getLinkType() == null) ? 0 : getLinkType().hashCode());
        result = prime * result + ((getLinkName() == null) ? 0 : getLinkName().hashCode());
        result = prime * result + ((getLinkUrl() == null) ? 0 : getLinkUrl().hashCode());
        result = prime * result + ((getLinkDescription() == null) ? 0 : getLinkDescription().hashCode());
        result = prime * result + ((getLinkRank() == null) ? 0 : getLinkRank().hashCode());
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
        sb.append(", linkId=").append(linkId);
        sb.append(", linkType=").append(linkType);
        sb.append(", linkName=").append(linkName);
        sb.append(", linkUrl=").append(linkUrl);
        sb.append(", linkDescription=").append(linkDescription);
        sb.append(", linkRank=").append(linkRank);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}