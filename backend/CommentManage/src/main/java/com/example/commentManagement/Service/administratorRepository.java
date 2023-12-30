package com.example.commentManagement.Service;

import com.example.commentManagement.DTO.Administrator;
import com.example.commentManagement.Mapper.AdministratorDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class administratorRepository {
    @Autowired
    private AdministratorDataMapper AdministratorDataMapper;

    public List<Administrator> findAll(){
        return AdministratorDataMapper.findAll("ADMINISTRATOR");
    }

}
