package com.example.user.Service;

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

}
