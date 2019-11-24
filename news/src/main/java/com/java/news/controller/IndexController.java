package com.java.news.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.news.service.ArticleService;
import com.java.news.service.ClassifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author:gengdz
 * @date:2019/11/3
 * @desc:
 */
@Controller
@Api(value = "首页", description = "系统首页")
public class IndexController {
    @Autowired
    ArticleService articleService;
    @Autowired
    ClassifyService classifyService;

    @ApiOperation("加载主页及相关数据")
    @GetMapping("index")
    public String index(HttpSession session,@RequestParam(defaultValue = "1") int pageNum){

        PageHelper.startPage(pageNum,4);
        session.setAttribute("articles", new PageInfo<>(articleService.queryArticle()));
        session.setAttribute("classify",classifyService.queryClassify());
        return "index";
    }
}
