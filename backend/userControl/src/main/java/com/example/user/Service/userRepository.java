package com.example.user.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.user.Mapper.UserDataMapper;
import com.example.user.DTO.User;
import java.util.List;
@Service
public class userRepository {
    @Autowired
    private UserDataMapper UserDataMapper;

    public List<User> findAll(){
        return UserDataMapper.findAll("User");
    }

}
