package com.example.user.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.user.Mapper.AdministratorDataMapper;
import com.example.user.DTO.Administrator;
import java.util.List;
@Service
public class administratorRepository {
    @Autowired
    private AdministratorDataMapper AdministratorDataMapper;

    public List<Administrator> findAll(){
        return AdministratorDataMapper.findAll("ADMINISTRATOR");
    }

}
