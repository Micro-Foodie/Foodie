package com.example.ReportManage.Mapper;

import com.example.ReportManage.DTO.Article;
import com.example.ReportManage.DTO.T_COMMENT;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleMapper {
    @Select("SELECT * FROM Article WHERE PostId = #{PostId}")
    List<Article> findArticleById(@Param("PostId") int PostId);
    @Update("UPDATE Article SET IsBanned = #{IsBanned} WHERE PostId = #{PostId}")
    void updateArticleById(@Param("PostId") int PostId, @Param("IsBanned") int IsBanned);

}
