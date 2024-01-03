package com.example.user.Service;

import com.example.user.DTO.Administrator;
import com.example.user.DTO.T_USER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.user.Mapper.UserDataMapper;

import java.util.List;
@Service
public class userRepository {
    @Autowired
    private UserDataMapper UserDataMapper;

    public List<T_USER> findAll(){
        return UserDataMapper.findAll("T_USER");
    }
    public List<T_USER> findEmail(String Email){
        return UserDataMapper.findArticleById(Email);
    }

    public List<T_USER> findID(int UserId){
        return UserDataMapper.findUserById(UserId);
    }

    public List<T_USER> registerUser(int UserId){
        return UserDataMapper.findUserById(UserId);
    }

}
