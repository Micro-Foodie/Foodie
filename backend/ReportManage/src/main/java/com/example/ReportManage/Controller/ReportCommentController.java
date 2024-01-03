package com.example.ReportManage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/reportCommentManage")
public class ReportCommentController {

    @Autowired
    private com.example.ReportManage.Service.ReportCommentRepository ReportCommentRepository;

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

