package com.example.user.Mapper;

import com.example.user.DTO.T_USER;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDataMapper {
    @Select("select * from ${table}")
    List<T_USER> findAll(@Param("table") String table);

}
