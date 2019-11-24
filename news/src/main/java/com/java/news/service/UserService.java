package com.java.news.service;

import com.java.news.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Component
public interface UserService {
     void insertUser(User user);
     void updateInfo(User user);
     int  getCount();
     List<User> queryUser(String userId,String userName,String phoneNumber);
     int batchDeleteUser(List<String> ids);
}
