package com.example.commentManagement.Service;

import com.example.commentManagement.DTO.ReportComments;
import com.example.commentManagement.DTO.T_COMMENT;
import com.example.commentManagement.Mapper.ReportCommentMapper;
import com.example.commentManagement.Mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ReportCommentRepository {

    @Autowired
    private ReportCommentMapper ReportCommentMapper;
    @Autowired
    private CommentMapper CommentMapper;
    public List<ReportComments> findAll(){
        return ReportCommentMapper.findAll("msgReportId");
    }
    // 处理举报的方法
    public Map<String, Object> reportComment(int UserId, int MsgId, String Reason) {
        Map<String, Object> result = new HashMap<>();
        int affectedRows = ReportCommentMapper.insertReportComment(UserId, MsgId, Reason);

        if (affectedRows>0) {
            result.put("code", 200);
            result.put("msg", "成功");
        } else {
            result.put("code", 400);
            result.put("msg", "举报者或被举报留言不存在");
        }

        return result;
    }
    public Map<String, Object> findUnprocessedReportComments(){
        List<ReportComments> reportComments = ReportCommentMapper.findUnprocessedReportComments();
        Map<String, Object> result = new HashMap<>();

        if (!reportComments.isEmpty()) {
            result.put("code", 200);
            result.put("msg", "成功");
            result.put("data", reportComments);
        } else {
            result.put("code", 400);
            result.put("msg", "当前没有新的举报信息");
        }

        return result;
    }
    public Map<String, Object> findReportCommentByReportId(int msgReportId, int adminId, int isTrue,String setResult) {
        Map<String, Object> response = new HashMap<>();
        List<ReportComments> reportCommentOpt = ReportCommentMapper.findReportCommentByReportId(msgReportId);

        if (reportCommentOpt.isEmpty()) {
            response.put("code", 400);
            response.put("msg", "该举报信息不存在");
            return response;
        }

        ReportComments reportComment = reportCommentOpt.get(0);
        List<T_COMMENT> commentOpt = CommentMapper.findCommentByCommentId(reportComment.getMSGID());
        T_COMMENT t_comment=commentOpt.get(0);

        if (commentOpt.isEmpty()) {
            response.put("code", 400);
            response.put("msg", "举报的留言不存在");
            return response;
        }

        switch (isTrue) {
            case 1:
                reportComment.setISTRUE(1);
                reportComment.setADMINID(adminId);
                reportComment.setRESULT(setResult);
                t_comment.setIsBanned(1);
                response.put("msg", "举报已通过");
                break;
            case 2:
                reportComment.setISTRUE(2);
                reportComment.setADMINID(adminId);
                reportComment.setRESULT(setResult);
                response.put("msg", "举报未通过");
                break;
            default:
                response.put("code", 400);
                response.put("msg", "is_true参数错误");
                return response;
        }


        response.put("code", 200);
        return response;
    }

}
