package com.java.news.controller;

import com.alibaba.fastjson.JSONObject;
import com.java.news.Constant;
import com.java.news.annotation.SystemRecord;
import com.java.news.service.ArticleService;
import com.java.news.service.UserLoginService;
import com.java.news.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@RestController
@Api(value = "用户登录",description = "登录接口")
@RequestMapping(value = "/login")
@CrossOrigin
public class LoginController {


    @Autowired
    UserLoginService userLoginService;



    @ApiOperation(value = "普通用户登录")
    @PostMapping(value = "/userLogin")
    public String userLogin(String userName , String password){
        int i=userLoginService.login(userName,password);
        if(i== Constant.LOGIN_SUCCESS){
            return Constant.LOGIN_SUCCESS+"";
        }
        return Constant.LOGIN_ERROR+"";
    }

    @ApiOperation(value = "管理员登陆")
    @RequestMapping(value = "/adminLogin")
    public int amdinLogin(String adminName , String adminPass){
        return userLoginService.adminLogin(adminName,adminPass);
    }
}
