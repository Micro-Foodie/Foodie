package com.example.ReportManage.Mapper;

import com.example.ReportManage.DTO.REPORTPOST;
import com.example.ReportManage.DTO.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReportPostMapper {
    //找没处理的
    @Select("SELECT " +
            "rc.UserId AS UserId, " +
            "rc.Time AS Time, " +
            "rc.PostId AS PostId, " +
            "rc.Reason AS Reason, " +
            "rc.PostReportId AS PostReportId " +
            "FROM REPORTPOST rc " +
            "JOIN Article a ON rc.PostId = a.PostId " +
            "WHERE rc.IsTrue = 0 AND a.IsBanned = 0")
    List<REPORTPOST> findUnprocessedPostReport();
    //处理举报
    @Select("SELECT* FROM REPORTPOST rc WHERE rc.PostReportId = #{PostReportId}")
    List<REPORTPOST> findByReportId(@Param("PostReportId") int PostReportId);
    //处理举报

    @Update("UPDATE REPORTPOST SET IsTrue = #{IsTrue}, AdminId = #{AdminId},Result = #{Result} WHERE PostReportId = #{PostReportId}")
    void updateIsAcceptedById(@Param("PostReportId") int PostReportId, @Param("IsTrue") int IsTrue,@Param("AdminId") int AdminId,@Param("Result") String Result);
}
