package com.example.ReportManage.Mapper;

import com.example.ReportManage.DTO.ReportComments;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
            "rc.UserId AS UserId, " +
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
    List<ReportComments> findReportCommentByReportId(@Param("msgReportId") int msgReportId);
    @Update("UPDATE ReportComments SET IsTrue = #{IsTrue}, AdminId = #{AdminId},Result = #{Result} WHERE msgReportId = #{msgReportId}")
    void updateIsTrueById(@Param("msgReportId") int msgReportId, @Param("IsTrue") int IsTrue,@Param("AdminId") int AdminId,@Param("Result") String Result);
}

