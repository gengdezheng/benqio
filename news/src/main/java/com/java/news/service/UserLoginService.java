package com.java.news.service;

import org.springframework.stereotype.Component;

/**
 * @author:gengdz
 * @date:2019/11/3
 * @desc:登录接口
 */

@Component
public interface UserLoginService {
    int login(String userName , String userPassword);
    int adminLogin(String adminName , String adminPass);
}
