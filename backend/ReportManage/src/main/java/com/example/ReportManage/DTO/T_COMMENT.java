package com.example.ReportManage.DTO;

import java.util.Date;

public class T_COMMENT {

    private Integer MsgId;
    private Integer UserId;
    private Integer PostId;
    private Date ReleaseTime;
    private String Content;
    private Integer IsBanned;

    // Getters and Setters
    public Integer getMsgId() {
        return MsgId;
    }

    public void setMsgId(Integer msgId) {
        this.MsgId = msgId;
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

    public void setReleaseTime(Date releaseTime) {
        this.ReleaseTime = releaseTime;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public Integer getIsBanned() {
        return IsBanned;
    }

    public void setIsBanned(Integer isBanned) {
        this.IsBanned = isBanned;
    }

    // Constructor, hashCode, equals, and toString methods can be added as needed
}
