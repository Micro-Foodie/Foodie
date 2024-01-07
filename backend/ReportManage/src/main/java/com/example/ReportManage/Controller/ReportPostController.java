package com.example.ReportManage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/reportPostManage")
public class ReportPostController {

    @Autowired
    private com.example.ReportManage.Service.ReportPostRepository ReportPostRepository;

    @GetMapping("/ReportPostToDeal") // 列出未被处理的被举报的留言
    public ResponseEntity<?> getReportCommentsToDeal() {
        Map<String, Object> result = new HashMap<>();
        result = ReportPostRepository.findUnprocessedReportPosts();
        return ResponseEntity.ok(result);
    }
//
    @PutMapping("/DealReport") // 处理举报
    public ResponseEntity<?> dealMsgReport(@RequestParam int reportId, @RequestParam int adminId, @RequestParam int is_true, @RequestParam String result) {
        Map<String, Object> resulting = new HashMap<>();
        resulting = ReportPostRepository.DealReportPost(reportId,adminId,is_true,result);
        return ResponseEntity.ok(resulting);
    }
}

