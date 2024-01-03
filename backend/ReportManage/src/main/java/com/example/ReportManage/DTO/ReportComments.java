package com.example.ReportManage.DTO;

import java.util.Date;

public class ReportComments {
    private Integer msgReportId;
    private Integer UserId;
    private Integer MsgId;
    private Integer AdminId;
    private String Reason;
    private Date Time;
    private String Result;
    private Integer IsTrue;

    // Getters and setters

    public Integer getMSGREPORTID() {
        return msgReportId;
    }

    public void setMSGREPORTID(Integer MSGREPORTID) {
        this.msgReportId = MSGREPORTID;
    }

    public Integer getUSERID() {
        return UserId;
    }

    public void setUSERID(Integer USERID) {
        this.UserId = USERID;
    }

    public Integer getMSGID() {
        return MsgId;
    }

    public void setMSGID(Integer MSGID) {
        this.MsgId = MSGID;
    }

    public Integer getADMINID() {
        return AdminId;
    }

    public void setADMINID(Integer ADMINID) {
        this.AdminId = ADMINID;
    }

    public String getREASON() {
        return Reason;
    }

    public void setREASON(String REASON) {
        this.Reason = REASON;
    }

    public Date getTIME() {
        return Time;
    }

    public void setTIME(Date TIME) {
        this.Time = TIME;
    }

    public String getRESULT() {
        return Result;
    }

    public void setRESULT(String RESULT) {
        this.Result = RESULT;
    }

    public int getISTRUE() {
        return IsTrue;
    }

    public void setISTRUE(Integer ISTRUE) {
        this.IsTrue = ISTRUE;
    }


}
