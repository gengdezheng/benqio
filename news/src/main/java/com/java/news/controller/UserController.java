package com.java.news.controller;

import com.alibaba.fastjson.JSON;
import com.java.news.Constant;
import com.java.news.annotation.SystemRecord;
import com.java.news.config.CheckLogin;
import com.java.news.model.User;
import com.java.news.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author:gengdz
 * @date:2019/11/3
 * @desc:
 */
@Controller
@Api(value = "用户功能列表", description = "用户前端功能列表")
@Slf4j
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    HttpSession session;

    @ApiOperation(value = "登录跳转页")
    @GetMapping("/login")
    public String loginInPage() {
        return "login";
    }


    @GetMapping("/logout")
    @ApiOperation(value = "退出系统")
    public String loginOutPage() {
        session.removeAttribute("user");
        return "index";
    }

    @PostMapping("/islogin")
    @ApiOperation(value = "判断是否登录")
    @ResponseBody
    public String userInfo() {
        if (CheckLogin.getUser(session)) {
            return JSON.toJSONString(Constant.LOGINED);
        }
        return JSON.toJSONString(Constant.UNLOGIN);
    }

    @ApiOperation(value = "个人信息跳转页")
    @GetMapping("/goUserInfo")
    public String goUserInfo() {
        return "userInfo";
    }

    @PostMapping("/updateInfo")
    @SystemRecord(description = "修改个人信息")
    @ApiOperation("修改个人信息")
    @ResponseBody
    public String updateInfo(User user) {
        userService.updateInfo(user);
        return JSON.toJSONString(Constant.UPDATE_SUCCESS);
    }

    @GetMapping("/goRegist")
    public String goRegist() {
        return "regist";
    }

    @PostMapping("/insertUser")
    @ApiOperation("用户注册")
    @ResponseBody
    public String registUser(@RequestParam(value = "headfile", required = false) MultipartFile headfile,
                             @RequestParam("userName") String userName,
                             @RequestParam("password") String password,
                             @RequestParam("phoneNumber") String phoneNumber,
                             @RequestParam("birthday") String birthday) {

        User user = new User();
        user.setHeadfile(headfile);
        user.setUserName(userName);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setBirthday(birthday);
        userService.insertUser(user);
        return JSON.toJSONString(Constant.REGIST_SUCCESS);
    }
}
