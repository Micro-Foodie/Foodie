package com.example.user.Mapper;

import com.example.user.DTO.Administrator;
import com.example.user.DTO.T_USER;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdministratorDataMapper {
    @Select("select * from ${table}")
    List<Administrator> findAll(@Param("table") String table);
    @Select("SELECT * FROM Administrator WHERE Email = #{Email}")
    List<Administrator> findArticleById(@Param("Email") String Email);
    @Select("SELECT * FROM Administrator WHERE AdminId = #{AdminId}")
    List<Administrator> findAdminById(@Param("AdminId") int AdminId);

}
