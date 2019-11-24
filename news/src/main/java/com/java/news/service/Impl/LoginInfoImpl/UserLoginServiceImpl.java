package com.java.news.service.Impl.LoginInfoImpl;

import com.java.news.Constant;
import com.java.news.annotation.SystemRecord;
import com.java.news.mapper.AdminMapper;
import com.java.news.mapper.UserMapper;
import com.java.news.model.LoginInfo;
import com.java.news.model.User;
import com.java.news.service.ArticleService;
import com.java.news.service.LoginService;
import com.java.news.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author:gengdz
 * @date:2019/11/3
 * @desc:
 */

@Service
@Slf4j
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    HttpSession session;

    @Autowired
    ArticleService articleService;

    public static String ADMIN ="";

    public int login(String userName, String userPassword) {
        List<User> list = userMapper.userLogin(userName, userPassword);

        if (list.isEmpty() || list.size() == 0 || list == null)
            return Constant.LOGIN_ERROR;
        else {
            session.setAttribute("user", list.get(0));
            session.setAttribute("unPass",articleService.getUnPass());
            session.setAttribute("allNumber",articleService.getAllNumber());
            return Constant.LOGIN_SUCCESS;
        }

    }

    @Override
    public int adminLogin(String adminName, String adminPass) {
        if(adminMapper.adminLogin(adminName,adminPass)>0){
            ADMIN = adminName;
            log.info("管理员{}登录",ADMIN);
            return Constant.LOGIN_SUCCESS;
        }
        return Constant.LOGIN_ERROR;
    }


}
