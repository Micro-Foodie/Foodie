package com.example.commentManagement.Mapper;

import com.example.commentManagement.DTO.ReportComments;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReportCommentMapper {
    @Select("select * from ${table}")
    List<ReportComments> findAll(@Param("table") String table);
    @Insert("INSERT INTO ReportComments (UserId, MsgId, Reason, Time, IsTrue) VALUES (#{UserId}, #{MsgId}, #{Reason}, SYSDATE, 0)")
    int insertReportComment(@Param("UserId") int UserId, @Param("MsgId") int MsgId, @Param("Reason") String Reason);
    //找到未处理的
    @Select("SELECT " +
            "rc.UserId AS id, " +
            "rc.Time AS time, " +
            "rc.MsgId AS msgId, " +
            "rc.Reason AS reason, " +
            "rc.MsgReportId AS msgReportId, " +
            "rc.Result AS Result, " +
            "rc.IsTrue AS IsTrue " +
            "FROM ReportComments rc " +
            "JOIN T_COMMENT c ON rc.MsgId = c.MsgId " +
            "WHERE rc.IsTrue = 0 AND c.IsBanned = 0")
    List<ReportComments> findUnprocessedReportComments();
    //处理举报
    @Select("SELECT * FROM ReportComments WHERE msgReportId = #{msgReportId}")
    List<ReportComments> findReportCommentByReportId(@Param("reportId") int msgReportId);
}
