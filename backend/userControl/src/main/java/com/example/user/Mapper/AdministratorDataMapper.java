package com.example.user.Mapper;

import com.example.user.DTO.Administrator;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdministratorDataMapper {
    @Select("select * from ${taxble}")
    List<Administrator> findAll(@Param("table") String table);

}
