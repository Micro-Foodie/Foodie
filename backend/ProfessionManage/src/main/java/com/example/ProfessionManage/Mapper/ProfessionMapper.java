package com.example.ProfessionManage.Mapper;

import com.example.ProfessionManage.DTO.PROFESSION;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProfessionMapper {
    @Select("select * from ${table}")
    List<PROFESSION> findAll(@Param("table") String table);
    @Insert("INSERT INTO ReportComments (UserId, MsgId, Reason, Time, IsTrue) VALUES (#{UserId}, #{MsgId}, #{Reason}, SYSDATE, 0)")
    int insertReportComment(@Param("UserId") int UserId, @Param("MsgId") int MsgId, @Param("Reason") String Reason);
    //找到未处理的
    @Select("SELECT " +
            "rc.UserId AS UserId, " +
            "rc.ApplyTime AS ApplyTime, " +
            "rc.Illustrate AS illustrate, " +
            "rc.Evidence AS evidence, " +
            "rc.IsAccepted AS IsAccepted, " +
            "rc.RequestId AS requestId " +
            "FROM PROFESSION rc " +
            "WHERE rc.IsAccepted = 0")
    List<PROFESSION> findUnprocessedProfessions();
    //处理举报
    @Select("SELECT " +
            "rc.UserId AS UserId, " +
            "rc.ApplyTime AS ApplyTime, " +
            "rc.Illustrate AS illustrate, " +
            "rc.Evidence AS evidence, " +
            "rc.IsAccepted AS IsAccepted, " +
            "rc.RequestId AS requestId " +
            "FROM PROFESSION rc " +
            "WHERE rc.RequestId = #{requestId}")
    List<PROFESSION> findByRequestId(@Param("requestId") int requestId);
    //处理举报

    @Update("UPDATE PROFESSION SET isAccepted = #{isAccepted} WHERE UserId = #{UserId}")
    void updateIsAcceptedById(@Param("UserId") int UserId, @Param("isAccepted") int isAccepted);

}
