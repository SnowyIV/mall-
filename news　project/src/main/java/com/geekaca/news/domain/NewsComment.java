package com.geekaca.news.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tb_news_comment
 */
public class NewsComment implements Serializable {
    /**
     * 主键id
     */
    private Long commentId;

    /**
     * 关联的news主键
     */
    private Long newsId;

    /**
     * 评论者名称
     */
    private String commentator;

    /**
     * 评论人的邮箱
     */
    private String email;

    /**
     * 网址
     */
    private String websiteUrl;

    /**
     * 评论内容
     */
    private String commentBody;

    /**
     * 评论提交时间
     */
    private Date commentCreateTime;

    /**
     * 评论时的ip地址
     */
    private String commentatorIp;

    /**
     * 回复内容
     */
    private String replyBody;

    /**
     * 回复时间
     */
    private Date replyCreateTime;

    /**
     * 是否审核通过 0-未审核 1-审核通过
     */
    private Integer commentStatus;

    /**
     * 是否删除 0-未删除 1-已删除
     */
    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * 主键id
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * 关联的news主键
     */
    public Long getNewsId() {
        return newsId;
    }

    /**
     * 关联的news主键
     */
    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    /**
     * 评论者名称
     */
    public String getCommentator() {
        return commentator;
    }

    /**
     * 评论者名称
     */
    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }

    /**
     * 评论人的邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 评论人的邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 网址
     */
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    /**
     * 网址
     */
    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    /**
     * 评论内容
     */
    public String getCommentBody() {
        return commentBody;
    }

    /**
     * 评论内容
     */
    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    /**
     * 评论提交时间
     */
    public Date getCommentCreateTime() {
        return commentCreateTime;
    }

    /**
     * 评论提交时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setCommentCreateTime(Date commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    /**
     * 评论时的ip地址
     */
    public String getCommentatorIp() {
        return commentatorIp;
    }

    /**
     * 评论时的ip地址
     */
    public void setCommentatorIp(String commentatorIp) {
        this.commentatorIp = commentatorIp;
    }

    /**
     * 回复内容
     */
    public String getReplyBody() {
        return replyBody;
    }

    /**
     * 回复内容
     */
    public void setReplyBody(String replyBody) {
        this.replyBody = replyBody;
    }

    /**
     * 回复时间
     */
    public Date getReplyCreateTime() {
        return replyCreateTime;
    }

    /**
     * 回复时间
     */
    public void setReplyCreateTime(Date replyCreateTime) {
        this.replyCreateTime = replyCreateTime;
    }

    /**
     * 是否审核通过 0-未审核 1-审核通过
     */
    public Integer getCommentStatus() {
        return commentStatus;
    }

    /**
     * 是否审核通过 0-未审核 1-审核通过
     */
    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
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
        NewsComment other = (NewsComment) that;
        return (this.getCommentId() == null ? other.getCommentId() == null : this.getCommentId().equals(other.getCommentId()))
            && (this.getNewsId() == null ? other.getNewsId() == null : this.getNewsId().equals(other.getNewsId()))
            && (this.getCommentator() == null ? other.getCommentator() == null : this.getCommentator().equals(other.getCommentator()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getWebsiteUrl() == null ? other.getWebsiteUrl() == null : this.getWebsiteUrl().equals(other.getWebsiteUrl()))
            && (this.getCommentBody() == null ? other.getCommentBody() == null : this.getCommentBody().equals(other.getCommentBody()))
            && (this.getCommentCreateTime() == null ? other.getCommentCreateTime() == null : this.getCommentCreateTime().equals(other.getCommentCreateTime()))
            && (this.getCommentatorIp() == null ? other.getCommentatorIp() == null : this.getCommentatorIp().equals(other.getCommentatorIp()))
            && (this.getReplyBody() == null ? other.getReplyBody() == null : this.getReplyBody().equals(other.getReplyBody()))
            && (this.getReplyCreateTime() == null ? other.getReplyCreateTime() == null : this.getReplyCreateTime().equals(other.getReplyCreateTime()))
            && (this.getCommentStatus() == null ? other.getCommentStatus() == null : this.getCommentStatus().equals(other.getCommentStatus()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommentId() == null) ? 0 : getCommentId().hashCode());
        result = prime * result + ((getNewsId() == null) ? 0 : getNewsId().hashCode());
        result = prime * result + ((getCommentator() == null) ? 0 : getCommentator().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getWebsiteUrl() == null) ? 0 : getWebsiteUrl().hashCode());
        result = prime * result + ((getCommentBody() == null) ? 0 : getCommentBody().hashCode());
        result = prime * result + ((getCommentCreateTime() == null) ? 0 : getCommentCreateTime().hashCode());
        result = prime * result + ((getCommentatorIp() == null) ? 0 : getCommentatorIp().hashCode());
        result = prime * result + ((getReplyBody() == null) ? 0 : getReplyBody().hashCode());
        result = prime * result + ((getReplyCreateTime() == null) ? 0 : getReplyCreateTime().hashCode());
        result = prime * result + ((getCommentStatus() == null) ? 0 : getCommentStatus().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", commentId=").append(commentId);
        sb.append(", newsId=").append(newsId);
        sb.append(", commentator=").append(commentator);
        sb.append(", email=").append(email);
        sb.append(", websiteUrl=").append(websiteUrl);
        sb.append(", commentBody=").append(commentBody);
        sb.append(", commentCreateTime=").append(commentCreateTime);
        sb.append(", commentatorIp=").append(commentatorIp);
        sb.append(", replyBody=").append(replyBody);
        sb.append(", replyCreateTime=").append(replyCreateTime);
        sb.append(", commentStatus=").append(commentStatus);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}