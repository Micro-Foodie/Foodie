package com.example.user.DTO;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
public class Administrator {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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
