package com.java.news.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.news.Constant;
import com.java.news.annotation.SystemRecord;
import com.java.news.mapper.LogInfoMapper;
import com.java.news.model.Article;
import com.java.news.model.LogInfo;
import com.java.news.model.LoginInfo;
import com.java.news.model.User;
import com.java.news.model.index.HomePageInfo;
import com.java.news.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:gengdz
 * @date:2019/11/7
 * @desc:
 */
@RestController
@CrossOrigin
@RequestMapping("admin")
@Slf4j
@Api(value = "管理员", description = "功能列表")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    ArticleService articleService;

    @Autowired
    LoginService loginService;

    @Autowired
    LogService logService;

    @Autowired
    UserService userService;

    @Autowired
    ClassifyService classifyService;



    @ApiOperation("用户列表")
    @GetMapping("/userlist")
    public PageInfo<User> query(int pageNum,String userId, String userName, String phoneNumber) {

            PageHelper.startPage(pageNum,Constant.PAGE_SIZE);
        return new PageInfo<>(userService.queryUser(userId, userName, phoneNumber));
    }

    @GetMapping("/batchDelete")
    @ApiOperation("批量删除用户")
    @SystemRecord(description = "删除用户")
    public int batch(String ids) {
        List<String> id = new ArrayList<>();
        String idd[] = ids.split(",");
        for (int i = 0; i < idd.length; i++) {
            id.add(idd[i]);
        }
        articleService.deleteArticleByUserId(id);
        return userService.batchDeleteUser(id);
    }

    @GetMapping("/articlelist")
    @ApiOperation("新闻列表/条件查找")
    public PageInfo<Article> articleList(int pageNum,String state, String title, String userName) {
        int id = 0;
        if (state == null || state.equals(""))
            id = -1;
        else
            id = Integer.parseInt(state);
        PageHelper.startPage(pageNum,Constant.PAGE_SIZE);
        return new PageInfo<>(articleService.queryArticle_Admin(id, title, userName));
    }

    @GetMapping("/batchDeleteArticle")
    @ApiOperation("批量删除新闻")
    @SystemRecord(description = "删除新闻")
    public int batchDeleteArticle(String articleIds) {
        List<String> articleId = new ArrayList<>();
        String idd[] = articleIds.split(",");
        for (int i = 0; i < idd.length; i++) {
            articleId.add(idd[i]);
        }
        return articleService.batchDeleteArticle(articleId);
    }

    @GetMapping("/lookArticle")
    @ApiOperation("查看新闻并审核")
    public Article lookArticle(String articleId){
        return  articleService.detailArticle(articleId);
    }

    @GetMapping("/setPass")
    @ApiOperation("审核新闻通过")
    @SystemRecord(description = "新闻通过审核")
    public String setArticlePass(String articleId){
        return articleService.setArticlePass(articleId)>0?Constant.SET_PASS_SUCCESS:Constant.SET_PASS_ERROR;
    }

    @GetMapping("/updateArticle")
    @ApiOperation("修改新闻")
    @SystemRecord(description = "修改(审核)新闻")
    public int updateArticle(String articleId,String title,String content){
        log.info(articleId+","+title);
        return articleService.updateArticle(articleId,title,content);
    }

    @GetMapping("/loginlist")
    @ApiOperation("登录日志列表")
    public PageInfo<LoginInfo> queryLoginInfo(int pageNum,String state,String role,String loginName){
        int loginState = -1 ,loginRole =-1;
        if(state==null || state.equals("")){}else{loginState = Integer.parseInt(state);}
            if(role==null || role.equals("")){}else{loginRole = Integer.parseInt(role);}
            PageHelper.startPage(pageNum,Constant.PAGE_SIZE);
        return new PageInfo<>(loginService.queryLoginInfo(loginState,loginRole,loginName));
    }

    @GetMapping("/clearLoginInfo")
    @SystemRecord(description = "清空登录日志")
    @ApiOperation("清空日志")
    public String clearLoginInfo(){
        return loginService.clearLoginInfo()+"条数据被清除";
    }

    @GetMapping("/deleteLoginInfoById")
    @SystemRecord(description = "删除登录日志")
    @ApiOperation("删除登录日志")
    public String deleteLoginInfoById(int getId){

       // int id = Integer.parseInt(getId);
        return loginService.deleteLoginInfoByTime(getId)+"条数据被清除";
    }

    @GetMapping("/loglist")
    @ApiOperation("操作日志列表")
    public PageInfo<LogInfo> queryLogInfo(int pageNum,String logId){
        PageHelper.startPage(pageNum,Constant.PAGE_SIZE);
        return  new PageInfo<>(logService.queryLogInfo(logId));
    }

    @GetMapping("/logdetail")
    @ApiOperation("操作日志列表")
    public LogInfo getLogInfo(String id){
        LogInfo log=logService.queryLogInfo(id).get(0);
       return log;
    }

    @GetMapping("/deleteLogInfoById")
    @ApiOperation("删除操作日志")
    @SystemRecord(description = "删除操作日志")
    public String deleteLogInfoById(String logId){
        return  logService.deleteLogById(logId)+"条数据被删除";
    }

    @GetMapping("/clearLog")
    @ApiOperation("清楚操作日志")
    @SystemRecord(description = "清楚操作日志")
    public String clearLog(){
        return  logService.clearLog()+"条数据被删除";
    }

    @GetMapping("/index")
    @ApiOperation("系统首页")
    public HomePageInfo homePageInfo(){
        HomePageInfo homePageInfo = new HomePageInfo();
        homePageInfo.setUserCount(userService.getCount());
        homePageInfo.setPassCountForArti(articleService.getPassCount());
        homePageInfo.setUnPassCountForArti(articleService.getUnpassCount());
        homePageInfo.setClassifyList(classifyService.queryClassify());
        return homePageInfo;
    }

    @GetMapping("/deleteClassify")
    @ApiOperation("删除分类")
    @SystemRecord(description = "删除分类")
    public String deleteClassify(int id){
        return classifyService.deleteById(id)+"条分类标签被删除，关联"+articleService.deleteByClassId(id)+"新闻";
    }
    @GetMapping("/addClassify")
    @ApiOperation("添加分类")
    @SystemRecord(description = "添加分类")
    public String addClassify(String name){
        return classifyService.insert(name);
    }

    @GetMapping("/addAdmin")
    @ApiOperation("添加管理")
    @SystemRecord(description = "添加管理")
    public String adminRegist(String adminName , String adminPass , String phone){
        if(adminService.addAdmin(adminName,adminPass,phone)>0){
            return  Constant.REGIST_SUCCESS;
        }
        return Constant.REGIST_ERROR;
    }
}
