package com.geekaca.news.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @TableName tb_news
 */
@Data
public class News implements Serializable {
    /**
     * 新闻表主键id
     */
    private Long newsId;

    /**
     * 新闻标题
     */
    private String newsTitle;

    /**
     * 新闻自定义路径url
     */
    private String newsSubUrl;

    /**
     * 新闻封面图
     */
    private String newsCoverImage;

    /**
     * 新闻内容
     */
    private String newsContent;

    /**
     * 新闻分类id
     */
    private Integer newsCategoryId;

    /**
     * 新闻分类(冗余字段)
     */
    private String newsCategoryName;

    /**
     * 新闻标签
     */
    private String newsTags;
    private List<String> newsTagList = new ArrayList<>();

    /**
     * 0-草稿 1-发布
     */
    private Integer newsStatus;

    /**
     * 阅读量
     */
    private Long newsViews;

    /**
     * 0-允许评论 1-不允许评论
     */
    private Integer enableComment;

    /**
     * 是否删除 0=否 1=是
     */
    private Integer isDeleted;

    /**
     * 添加时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    List<NewsComment> commentList;

    private static final long serialVersionUID = 1L;


    /**
     * 新闻表主键id
     */
    public Long getNewsId() {
        return newsId;
    }

    /**
     * 新闻表主键id
     */
    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    /**
     * 新闻标题
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * 新闻标题
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    /**
     * 新闻自定义路径url
     */
    public String getNewsSubUrl() {
        return newsSubUrl;
    }

    /**
     * 新闻自定义路径url
     */
    public void setNewsSubUrl(String newsSubUrl) {
        this.newsSubUrl = newsSubUrl;
    }

    /**
     * 新闻封面图
     */
    public String getNewsCoverImage() {
        return newsCoverImage;
    }

    /**
     * 新闻封面图
     */
    public void setNewsCoverImage(String newsCoverImage) {
        this.newsCoverImage = newsCoverImage;
    }

    /**
     * 新闻内容
     */
    public String getNewsContent() {
        return newsContent;
    }

    /**
     * 新闻内容
     */
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    /**
     * 新闻分类id
     */
    public Integer getNewsCategoryId() {
        return newsCategoryId;
    }

    /**
     * 新闻分类id
     */
    public void setNewsCategoryId(Integer newsCategoryId) {
        this.newsCategoryId = newsCategoryId;
    }

    /**
     * 新闻分类(冗余字段)
     */
    public String getNewsCategoryName() {
        return newsCategoryName;
    }

    /**
     * 新闻分类(冗余字段)
     */
    public void setNewsCategoryName(String newsCategoryName) {
        this.newsCategoryName = newsCategoryName;
    }

    /**
     * 新闻标签
     */
    public String getNewsTags() {
        return newsTags;
    }

    /**
     * 新闻标签
     */
    public void setNewsTags(String newsTags) {
        this.newsTags = newsTags;
    }

    /**
     * 0-草稿 1-发布
     */
    public Integer getNewsStatus() {
        return newsStatus;
    }

    /**
     * 0-草稿 1-发布
     */
    public void setNewsStatus(Integer newsStatus) {
        this.newsStatus = newsStatus;
    }

    /**
     * 阅读量
     */
    public Long getNewsViews() {
        return newsViews;
    }

    /**
     * 阅读量
     */
    public void setNewsViews(Long newsViews) {
        this.newsViews = newsViews;
    }

    /**
     * 0-允许评论 1-不允许评论
     */
    public Integer getEnableComment() {
        return enableComment;
    }

    /**
     * 0-允许评论 1-不允许评论
     */
    public void setEnableComment(Integer enableComment) {
        this.enableComment = enableComment;
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

    /**
     * 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        News other = (News) that;
        return (this.getNewsId() == null ? other.getNewsId() == null : this.getNewsId().equals(other.getNewsId()))
            && (this.getNewsTitle() == null ? other.getNewsTitle() == null : this.getNewsTitle().equals(other.getNewsTitle()))
            && (this.getNewsSubUrl() == null ? other.getNewsSubUrl() == null : this.getNewsSubUrl().equals(other.getNewsSubUrl()))
            && (this.getNewsCoverImage() == null ? other.getNewsCoverImage() == null : this.getNewsCoverImage().equals(other.getNewsCoverImage()))
            && (this.getNewsContent() == null ? other.getNewsContent() == null : this.getNewsContent().equals(other.getNewsContent()))
            && (this.getNewsCategoryId() == null ? other.getNewsCategoryId() == null : this.getNewsCategoryId().equals(other.getNewsCategoryId()))
            && (this.getNewsCategoryName() == null ? other.getNewsCategoryName() == null : this.getNewsCategoryName().equals(other.getNewsCategoryName()))
            && (this.getNewsTags() == null ? other.getNewsTags() == null : this.getNewsTags().equals(other.getNewsTags()))
            && (this.getNewsStatus() == null ? other.getNewsStatus() == null : this.getNewsStatus().equals(other.getNewsStatus()))
            && (this.getNewsViews() == null ? other.getNewsViews() == null : this.getNewsViews().equals(other.getNewsViews()))
            && (this.getEnableComment() == null ? other.getEnableComment() == null : this.getEnableComment().equals(other.getEnableComment()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNewsId() == null) ? 0 : getNewsId().hashCode());
        result = prime * result + ((getNewsTitle() == null) ? 0 : getNewsTitle().hashCode());
        result = prime * result + ((getNewsSubUrl() == null) ? 0 : getNewsSubUrl().hashCode());
        result = prime * result + ((getNewsCoverImage() == null) ? 0 : getNewsCoverImage().hashCode());
        result = prime * result + ((getNewsContent() == null) ? 0 : getNewsContent().hashCode());
        result = prime * result + ((getNewsCategoryId() == null) ? 0 : getNewsCategoryId().hashCode());
        result = prime * result + ((getNewsCategoryName() == null) ? 0 : getNewsCategoryName().hashCode());
        result = prime * result + ((getNewsTags() == null) ? 0 : getNewsTags().hashCode());
        result = prime * result + ((getNewsStatus() == null) ? 0 : getNewsStatus().hashCode());
        result = prime * result + ((getNewsViews() == null) ? 0 : getNewsViews().hashCode());
        result = prime * result + ((getEnableComment() == null) ? 0 : getEnableComment().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", newsId=").append(newsId);
        sb.append(", newsTitle=").append(newsTitle);
        sb.append(", newsSubUrl=").append(newsSubUrl);
        sb.append(", newsCoverImage=").append(newsCoverImage);
        sb.append(", newsContent=").append(newsContent);
        sb.append(", newsCategoryId=").append(newsCategoryId);
        sb.append(", newsCategoryName=").append(newsCategoryName);
        sb.append(", newsTags=").append(newsTags);
        sb.append(", newsStatus=").append(newsStatus);
        sb.append(", newsViews=").append(newsViews);
        sb.append(", enableComment=").append(enableComment);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}