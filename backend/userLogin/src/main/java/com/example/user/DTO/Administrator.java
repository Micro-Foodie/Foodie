package com.example.user.DTO;

import lombok.Data;

@Data
public class Administrator {
    public Integer ADMINID;
    public String ADMINNAME;
    public String PASSWORD;
    public String AVATAR;
    public String EMAIL;
    public String TEL;

    public Integer getuserId() {
        return ADMINID;
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

    public String getTel() {
        return TEL;
    }

    public Administrator() {
        AVATAR = "images/avatars/default.jpg";

    }

}
