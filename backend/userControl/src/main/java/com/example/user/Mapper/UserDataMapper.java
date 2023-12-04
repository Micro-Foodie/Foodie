package com.example.user.Mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import com.example.user.DTO.User;
import java.util.List;

@Component
public interface UserDataMapper {
    @Select("select * from ${table}")
    List<User> findAll(@Param("table") String table);

}
