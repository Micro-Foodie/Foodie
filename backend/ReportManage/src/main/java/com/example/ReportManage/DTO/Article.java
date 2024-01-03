package com.example.ReportManage.DTO;

import java.util.Date;

public class Article {

    private Integer AuthorId;
    private Integer UserId;
    private Integer PostId;
    private Date ReleaseTime;
    private String Tag;
    private String Title;
    private String Picture;
    private Integer Views;
    private Integer IsBanned;
    private Integer FavouriteNum;
    private Integer LikeNum;
    private Integer IsTop;
    private String ShareLink;



    // Getters and Setters

    public Integer getIsBanned() {
        return IsBanned;
    }

    public void setPostIsBanned(Integer IsBanned) {
        this.IsBanned = IsBanned;
    }
    public Integer getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(Integer AuthorId) {
        this.AuthorId = AuthorId;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        this.UserId = userId;
    }

    public Integer getPostId() {
        return PostId;
    }

    public void setPostId(Integer postId) {
        this.PostId = postId;
    }

    public Date getReleaseTime() {
        return ReleaseTime;
    }

    public void setReleaseTime(Date ReleaseTime) {
        this.ReleaseTime = ReleaseTime;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String Tag) {
        this.Tag = Tag;
    }

    public Integer getViews() {
        return Views;
    }

    public void setViews(Integer Views) {
        this.Views = Views;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    // Constructor, hashCode, equals, and toString methods can be added as needed
}
