package com.java.news.mapper;

import com.java.news.model.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Component
public interface ArticleMapper {
    List<Article> queryArticle();

    void insertArticle(Article article);

    Article detailArticle(String articleId);

    List<Article> myArticle(String userId);

    List<Article> searchByKey(String key);

    int getUnPass(String userId);

    int getAllNumber(String userId);

    List<Article> unPassList(String userId);

    void deleteArticleByUserId(List<String> userIds);

    List<Article> queryArticle_Admin(@Param("state") int state, @Param("title") String title, @Param("userName") String userName);

    int batchDeleteArticle(List<String> articleIds);

    int setArticlePass(String articleId);

    int updateArticle(@Param("articleId") String articleId,@Param("title") String title,@Param("content") String content);

    int getPassCount();
    int getUnpassCount();
    int deleteByClassId(@Param("classId") int classId);
}
