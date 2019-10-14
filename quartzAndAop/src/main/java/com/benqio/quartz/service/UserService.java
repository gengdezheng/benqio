package com.benqio.quartz.service;

import com.benqio.quartz.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/10/14
 * @desc:
 */
@Component
public interface UserService {
    List<User> userLogin(String userName, String password);
    void insertByQuartz();
}
