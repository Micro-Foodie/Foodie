package com.example.user.DTO;

import lombok.Data;

@Data
public class T_USER {
    public Integer USERID; 
    public String USERNAME;
    public String PASSWORD;
    public String AVATAR;
    public String PROFESSIONAL;
    public String SIGNATURE;
    public String EMAIL;
    public String TEL;
    public Integer FOLLOWERNUM;
    public Integer THEMEID;
    public Integer POINTS;
    public Integer LEVELS;
    public Integer FOLLOWNUM;

    public Integer getuserId() {
        return USERID;
    }
    public Integer getfollowerNum() {
        return FOLLOWERNUM;
    }
    public Integer getthemeId() {
        return THEMEID;
    }
    public Integer getlevels() {
        return LEVELS;
    }
    public Integer getfollowNum() {
        return FOLLOWNUM;
    }

    public String getEmail() {
        return EMAIL;
    }

    public String getPassword() {
        return PASSWORD;
    }

    public String getAvatar() {
        return AVATAR;
    }

    public String getProfessional() {
        return PROFESSIONAL;
    }

    public String getSignature() {
        return SIGNATURE;
    }

    public String getTel() {
        return TEL;
    }

    public T_USER() {
        PROFESSIONAL = "NONE";
        AVATAR = "images/avatars/default.jpg";
        FOLLOWNUM = 0;
        THEMEID = 1;  // 默认主题
        POINTS = 0;
        LEVELS = 0;
    }

}
