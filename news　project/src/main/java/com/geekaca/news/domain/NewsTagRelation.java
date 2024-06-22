package com.geekaca.news.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tb_news_tag_relation
 */
public class NewsTagRelation implements Serializable {
    /**
     * 关系表id
     */
    private Long relationId;

    /**
     * 新闻id
     */
    private Long newsId;

    /**
     * 标签id
     */
    private Integer tagId;

    /**
     * 添加时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 关系表id
     */
    public Long getRelationId() {
        return relationId;
    }

    /**
     * 关系表id
     */
    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    /**
     * 新闻id
     */
    public Long getNewsId() {
        return newsId;
    }

    /**
     * 新闻id
     */
    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    /**
     * 标签id
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * 标签id
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
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
        NewsTagRelation other = (NewsTagRelation) that;
        return (this.getRelationId() == null ? other.getRelationId() == null : this.getRelationId().equals(other.getRelationId()))
            && (this.getNewsId() == null ? other.getNewsId() == null : this.getNewsId().equals(other.getNewsId()))
            && (this.getTagId() == null ? other.getTagId() == null : this.getTagId().equals(other.getTagId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRelationId() == null) ? 0 : getRelationId().hashCode());
        result = prime * result + ((getNewsId() == null) ? 0 : getNewsId().hashCode());
        result = prime * result + ((getTagId() == null) ? 0 : getTagId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", relationId=").append(relationId);
        sb.append(", newsId=").append(newsId);
        sb.append(", tagId=").append(tagId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}