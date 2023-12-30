package com.example.commentManagement.Controller;

import com.example.commentManagement.Service.ReportCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.commentManagement.DTO.ReportComments;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/reportCommentManage")
public class ReportCommentController {

    @Autowired
    private ReportCommentRepository ReportCommentRepository;

    @PostMapping("/PostReport") // 提交举报
    public ResponseEntity<?> reportArticle(@RequestParam int userId, @RequestParam int articleId, @RequestParam String reason) {
        Map<String, Object> result = ReportCommentRepository.reportComment(userId, articleId, reason);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/ReportCommentToDeal") // 列出未被处理的被举报的留言
    public ResponseEntity<?> getReportCommentsToDeal() {
        Map<String, Object> result = new HashMap<>();
        result = ReportCommentRepository.findUnprocessedReportComments();
        return ResponseEntity.ok(result);
    }
//
    @PutMapping("/dealMsgReport") // 处理举报
    public ResponseEntity<?> dealMsgReport(@RequestParam int reportId, @RequestParam int adminId, @RequestParam int isTrue, @RequestParam String result) {
        Map<String, Object> resulting = new HashMap<>();
        resulting = ReportCommentRepository.findReportCommentByReportId(reportId,adminId,isTrue,result);
        return ResponseEntity.ok(resulting);
    }
}

