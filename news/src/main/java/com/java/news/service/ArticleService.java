package com.java.news.service;

import com.java.news.model.Article;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Component
public interface ArticleService {
    List<Article> queryArticle();

    void publishArticle(Article article);

    Article detailArticle(String articleId);

    List<Article> myArticle(String userId);

    List<Article> searchByKey(String key);

    int getUnPass();

    int getAllNumber();

    List<Article> unPassList();

    void deleteArticleByUserId(List<String> userIds);

    List<Article> queryArticle_Admin(int classId, String title,  String userName);

    int batchDeleteArticle(List<String> articleIds);

    int setArticlePass(String articleId);

    int updateArticle(String articleId,String title,String content);

    int getPassCount();
    int getUnpassCount();

    int deleteByClassId(int classId);
}
