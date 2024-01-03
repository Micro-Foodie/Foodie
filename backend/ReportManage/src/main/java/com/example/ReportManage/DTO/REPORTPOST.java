package com.example.ReportManage.DTO;

import java.util.Date;

public class REPORTPOST {

    private Integer PostReportId;
    private Integer UserId;
    private Integer PostId;
    private Date Time;
    private String Reason;
    private Integer AdminId;
    private Integer IsTrue;
    private String Result;

    // Getters and Setters

    public Integer getIsTrue() {
        return IsTrue;
    }

    public void setPostIsTrue(Integer IsTrue) {
        this.IsTrue = IsTrue;
    }
    public Integer getPostReportId() {
        return PostReportId;
    }

    public void setPostReportId(Integer PostReportId) {
        this.PostReportId = PostReportId;
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

    public Date getTime() {
        return Time;
    }

    public void setTime(Date Time) {
        this.Time = Time;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    public Integer getAdminId() {
        return AdminId;
    }

    public void setAdminId(Integer AdminId) {
        this.AdminId = AdminId;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    // Constructor, hashCode, equals, and toString methods can be added as needed
}
