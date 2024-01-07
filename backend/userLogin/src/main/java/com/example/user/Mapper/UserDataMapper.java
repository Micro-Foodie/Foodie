package com.example.user.Mapper;

import com.example.user.DTO.T_USER;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDataMapper {
    @Select("select * from ${table}")
    List<T_USER> findAll(@Param("table") String table);
    @Select("SELECT * FROM T_USER WHERE Email = #{Email}")
    List<T_USER> findArticleById(@Param("Email") String Email);

    @Select("SELECT * FROM T_USER WHERE UserId = #{UserId}")
    List<T_USER> findUserById(@Param("UserId") int UserId);
    @Insert("INSERT INTO T_USER (UserName, Email, PassWord, PROFESSIONAL, AVATAR, FOLLOWNUM, THEMEID, POINTS, LEVELS) " +
            "VALUES (#{UserName}, #{Email}, #{PassWord}, 'NONE', 'images/avatars/default.jpg', 0, 1, 0, 0)")
    int registerUser(@Param("UserName") String UserName, @Param("Email") String Email, @Param("PassWord") String PassWord);


}
