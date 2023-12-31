package com.example.ProfessionManage.Mapper;

import com.example.ProfessionManage.DTO.T_COMMENT;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentMapper {
    @Select("SELECT * FROM T_COMMENT WHERE MsgId = #{MsgId}")
    List<T_COMMENT> findCommentByCommentId(@Param("MsgId") int MsgId);

}
