package com.java.news.service.Impl;

import com.java.news.mapper.LoginInfoMapper;
import com.java.news.model.LoginInfo;
import com.java.news.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Service

public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginInfoMapper loginInfoMapper;


    @Override
    public void insert(LoginInfo loginInfo) {
        loginInfoMapper.insertLoginInfo(loginInfo);
    }

    @Override
    public List<LoginInfo> queryLoginInfo(int state, int role, String loginName) {
        return loginInfoMapper.queryLoginInfo(state,role,loginName);
    }

    @Override
    public int clearLoginInfo() {
        return loginInfoMapper.clearLoginInfo();
    }

    @Override
    public int deleteLoginInfoByTime(int id) {
        return loginInfoMapper.deleteLoginInfoByTime(id);
    }
}
