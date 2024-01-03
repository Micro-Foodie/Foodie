package com.example.ProfessionManage.Mapper;

import com.example.ProfessionManage.DTO.T_COMMENT;
import com.example.ProfessionManage.DTO.T_USER;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDataMapper {
    @Select("select * from ${table}")
    List<T_USER> findAll(@Param("table") String table);
    @Select("SELECT * FROM T_USER WHERE UserId = #{UserId}")
    List<T_USER> findUserByUserId(@Param("UserId") int UserId);

    @Update("UPDATE T_USER SET Professional = #{Professional} WHERE UserId = #{UserId}")
    void updateProfessionalById(@Param("Professional") String Professional, @Param("UserId") int UserId);

}
