package com.example.ProfessionManage.DTO;

import java.util.Date;

public class PROFESSION {
    private Date ApplyTime;
    private Integer UserId;
    private String Illustrate;
    private String Evidence;
    private Integer IsAccepted;
    private Integer RequestId;

    // Getters and setters

    public Date getApplyTime() {
        return ApplyTime;
    }

    public void setApplyTime(Date ApplyTime) {
        this.ApplyTime = ApplyTime;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer USERID) {
        this.UserId = USERID;
    }

    public String getIllustrate() {
        return Illustrate;
    }

    public void setIllustrate(String Illustrate) {
        this.Illustrate = Illustrate;
    }

    public Integer getRequestId() {
        return RequestId;
    }

    public void setRequestId(Integer RequestId) {
        this.RequestId = RequestId;
    }

    public String getEvidence() {
        return Evidence;
    }

    public void setEvidence(String Evidence) {
        this.Evidence = Evidence;
    }

    public Integer getIsAccepted() {
        return IsAccepted;
    }

    public void setIsAccepted(Integer IsAccepted) {
        this.IsAccepted = IsAccepted;
    }



}
