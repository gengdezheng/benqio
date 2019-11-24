package com.java.news.service.Impl;

import com.java.news.Constant;
import com.java.news.mapper.ArticleMapper;
import com.java.news.model.Article;
import com.java.news.model.User;
import com.java.news.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    @Value("${Img.path}")
    String path;

    String userId="";

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    HttpSession session;


    @Override
    public List<Article> queryArticle() {

        return articleMapper.queryArticle();
    }

    @Override
    public void publishArticle(Article article) {

        String fileName = "";
        article.setArticleId(UUID.randomUUID().toString().replace("-", ""));
        article.setState(Constant.NEED_CHECK);
        article.setUserId(((User) session.getAttribute("user")).getUserId());
        File uploadDirectory;
        //这里可以支持多文件上传
        if (article.getFile() != null && article.getFile().length >= 1) {
            try {
                for (MultipartFile file : article.getFile()) {
                    fileName += file.getOriginalFilename() + "::";
                    uploadDirectory = new File(path+"/"+file.getOriginalFilename());
                    file.transferTo(uploadDirectory);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        article.setImgs(fileName);
        articleMapper.insertArticle(article);
    }

    @Override
    public Article detailArticle(String articleId) {
        return articleMapper.detailArticle(articleId);
    }

    @Override
    public List<Article> myArticle(String userId) {
        return articleMapper.myArticle(userId);
    }

    @Override
    public List<Article> searchByKey(String key) {
        return articleMapper.searchByKey(key);
    }

    @Override
    public int getUnPass() {
        userId= ((User)session.getAttribute("user")).getUserId();
        return articleMapper.getUnPass(userId);
    }

    @Override
    public int getAllNumber() {
         userId= ((User)session.getAttribute("user")).getUserId();
        return articleMapper.getAllNumber(userId);
    }

    @Override
    public List<Article> unPassList() {
        userId= ((User)session.getAttribute("user")).getUserId();
        return articleMapper.unPassList(userId);
    }

    @Override
    public void deleteArticleByUserId(List<String> userIds) {
        articleMapper.deleteArticleByUserId(userIds);
    }

    @Override
    public List<Article> queryArticle_Admin(int classId, String title, String userName) {
        return articleMapper.queryArticle_Admin(classId,title,userName);
    }

    @Override
    public int batchDeleteArticle(List<String> articleIds) {
        return articleMapper.batchDeleteArticle(articleIds);
    }

    @Override
    public int setArticlePass(String articleId) {
        return articleMapper.setArticlePass(articleId);
    }

    @Override
    public int updateArticle(String articleId, String title, String content) {
        return articleMapper.updateArticle(articleId,title,content);
    }

    @Override
    public int getPassCount() {
        return articleMapper.getPassCount();
    }

    @Override
    public int getUnpassCount() {
        return articleMapper.getUnpassCount();
    }

    @Override
    public int deleteByClassId(int classId) {
        return articleMapper.deleteByClassId(classId);
    }

}
