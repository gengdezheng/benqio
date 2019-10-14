package com.benqio.quartz.service.Impl;

import com.benqio.quartz.dao.UserMapper;
import com.benqio.quartz.model.User;
import com.benqio.quartz.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author:gengdz
 * @date:2019/10/14
 * @desc:
 */
@Service
@MapperScan("com.benqio.quartz.dao")
@Slf4j
@EnableScheduling
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> userLogin(String userName, String password) {
        return userMapper.userLogin(userName,password);
    }


    @Override
    public void insertByQuartz() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUserName("zhang");
        user.setPassword("san");
        user.setRoleId(1);
        userMapper.insertByQuartz(user);
        log.info("插入成功！");
    }
}
