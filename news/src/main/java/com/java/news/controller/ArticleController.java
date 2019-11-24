package com.java.news.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.news.annotation.SystemRecord;
import com.java.news.model.Article;
import com.java.news.model.User;
import com.java.news.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author:gengdz
 * @date:2019/11/4
 * @desc:
 */
@Controller
@RequestMapping("article")
@Api(value = "新闻功能列表", description = "新闻功能列表")
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @Autowired
    HttpSession session;

    @ApiOperation("发布新闻跳转页")
    @GetMapping("/goArticlePage")
    public String goArticlePage() {
        return "writeArticle";
    }

    @ApiOperation(value = "发布新闻")
    @PostMapping("/insertArticle")
    @ResponseBody
    public String insertArticle(@RequestParam(value = "file", required = false) MultipartFile[] file,
                                @RequestParam("title") String title,
                                @RequestParam("content") String content,
                                @RequestParam("classId") int classId) {
        Article article = new Article();
        if (file != null) {
            article.setFile(file);
        }
        article.setTitle(title);
        article.setContent(content);
        article.setClassId(classId);
        articleService.publishArticle(article);
        return JSON.toJSONString("OK");
    }

    @GetMapping("look")
    @ApiOperation("查看新闻详细")
    public String detail(String articleId, Model model) {
        session.setAttribute("detail", articleService.detailArticle(articleId));
        return "detail";
    }

    @GetMapping("lookToday")
    @ApiOperation("查看今日新闻")
    public String today(@RequestParam(defaultValue = "1") int pageNum) {
        List<Article> list = articleService.queryArticle();
        List<Article> today = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        list.forEach(a -> {
            if (simpleDateFormat.format(a.getTime()).equals(simpleDateFormat.format(new Date()))) {
                today.add(a);
            }
        });
        PageHelper.startPage(pageNum, 4);
        session.setAttribute("today", new PageInfo<>(today));
        return "today";
    }


    @ApiOperation("查看个人历史记录")
    @GetMapping("histry")
    @SystemRecord(description = "查看发布记录")
    public String myHistry() {
        String userId = ((User) session.getAttribute("user")).getUserId();
        session.setAttribute("histry", articleService.myArticle(userId));
        return "histry";
    }

    @GetMapping("searchByKey")
    @ApiOperation("根据关键字查询新闻")
    public String searchByKey(String key) {
        session.setAttribute("search", articleService.searchByKey(key));
        return "search";
    }

    @ApiOperation("待审核列表")
    @GetMapping("/goUnPass")
    public String goUnPass(Model model) {
        model.addAttribute("unPassList", articleService.unPassList());
        return "unPass";
    }
}
