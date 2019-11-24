package com.java.news.service;

import com.java.news.model.LoginInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:登录日志管理接口
 */
@Component
public interface LoginService {
    void insert(LoginInfo loginInfo);

    List<LoginInfo> queryLoginInfo(int state, int role, String loginName);

    int clearLoginInfo();

    int deleteLoginInfoByTime(int id);
}
