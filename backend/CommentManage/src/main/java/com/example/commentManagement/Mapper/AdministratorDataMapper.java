package com.example.commentManagement.Mapper;

import com.example.commentManagement.DTO.Administrator;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdministratorDataMapper {
    @Select("select * from ${table}")
    List<Administrator> findAll(@Param("table") String table);

}