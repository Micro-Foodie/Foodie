package com.example.ReportManage.Service;

import com.example.ReportManage.DTO.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class administratorRepository {
    @Autowired
    private com.example.ReportManage.Mapper.AdministratorDataMapper AdministratorDataMapper;

    public List<Administrator> findAll(){
        return AdministratorDataMapper.findAll("ADMINISTRATOR");
    }

}
