package com.example.ReportManage.Mapper;

import com.example.ReportManage.DTO.T_COMMENT;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentMapper {
    @Select("SELECT * FROM T_COMMENT WHERE MsgId = #{MsgId}")
    List<T_COMMENT> findCommentByCommentId(@Param("MsgId") int MsgId);
    @Update("UPDATE T_COMMENT SET IsBanned = #{IsBanned} WHERE MsgId = #{MsgId}")
    void updateCommentById(@Param("IsBanned") int IsBanned, @Param("MsgId") int MsgId);

}
