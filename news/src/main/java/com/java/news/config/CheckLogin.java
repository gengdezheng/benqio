package com.java.news.config;

import com.java.news.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @author:gengdz
 * @date:2019/11/4
 * @desc:检查登录方法
 */
@Component
public  class CheckLogin {


    public static boolean getUser( HttpSession session){
        if(session.getAttribute("user")!=null){
            return true;
        }
        return false;
    }

}
