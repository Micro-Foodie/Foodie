package com.example.ReportManage.Service;

import com.example.ReportManage.DTO.REPORTPOST;
import com.example.ReportManage.DTO.Article;
import com.example.ReportManage.DTO.T_COMMENT;
import com.example.ReportManage.Mapper.ArticleMapper;
import com.example.ReportManage.Mapper.ReportPostMapper;
import com.example.ReportManage.Mapper.ReportCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportPostRepository {

    @Autowired
    private ReportPostMapper ReportPostMapper;
    @Autowired
    private ArticleMapper ArticleMapper;

    // 处理举报的方法

    public Map<String, Object> findUnprocessedReportPosts(){
        List<REPORTPOST> REPORTPOST = ReportPostMapper.findUnprocessedPostReport();
        Map<String, Object> result = new HashMap<>();

        if (!REPORTPOST.isEmpty()) {
            result.put("code", 200);
            result.put("msg", "成功");
            result.put("data", REPORTPOST);
        } else {
            result.put("code", 400);
            result.put("msg", "当前没有新的举报信息");
        }

        return result;
    }
    public Map<String, Object> DealReportPost(int report_id, int adminId, int is_true, String result) {
        Map<String, Object> response = new HashMap<>();
        List<REPORTPOST> reportPostOpt = ReportPostMapper.findByReportId(report_id);

        if (reportPostOpt.isEmpty()) {
            response.put("code", 400);
            response.put("msg", "该举报信息不存在");
            return response;
        }

        REPORTPOST reportPost = reportPostOpt.get(0);
        List<Article> ArticleOpt = ArticleMapper.findArticleById(reportPost.getPostId());
        if (ArticleOpt.isEmpty()) {
            response.put("code", 400);
            response.put("msg", "举报的留言不存在");
            return response;
        }
        Article Article=ArticleOpt.get(0);

        switch (is_true) {
            case 1:
                ArticleMapper.updateArticleById(reportPost.getPostId(),1);
                ReportPostMapper.updateIsAcceptedById(reportPost.getPostReportId(),1,adminId,result);
                response.put("msg", "举报已通过");
                break;
            case 2:
                ReportPostMapper.updateIsAcceptedById(reportPost.getPostReportId(),2,adminId,result);
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
