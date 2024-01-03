package com.example.ProfessionManage.Controller;

import com.example.ProfessionManage.Service.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/Profession")
public class ReportCommentController {

    @Autowired
    private ProfessionRepository ProfessionRepository;
    @GetMapping("/ProfessionToDeal") // 列出未被处理的专业认证
    public ResponseEntity<?> getReportCommentsToDeal() {
        Map<String, Object> result = new HashMap<>();
        result = ProfessionRepository.getUnprocessedProfessions();
        return ResponseEntity.ok(result);
    }
//
    @PutMapping("/DealRequest") // 处理举报
    public ResponseEntity<?> dealMsgReport(@RequestParam int request_id, @RequestParam int response) {
        Map<String, Object> resulting = new HashMap<>();
        resulting = ProfessionRepository.findProfessionById(request_id, response);
        return ResponseEntity.ok(resulting);
    }
}

