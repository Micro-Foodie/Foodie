package com.example.ReportManage.Mapper;

import com.example.ReportManage.DTO.Administrator;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdministratorDataMapper {
    @Select("select * from ${table}")
    List<Administrator> findAll(@Param("table") String table);

}
