package com.java.news.mapper;

import com.java.news.model.LoginInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Component
public interface LoginInfoMapper {
    void insertLoginInfo(LoginInfo loginInfo);
    List<LoginInfo> queryLoginInfo(@Param("loginState") int loginState, @Param("role")int role, @Param("loginName")String loginName);
    int clearLoginInfo();
    int deleteLoginInfoByTime(int id);
}
