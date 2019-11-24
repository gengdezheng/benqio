package com.java.news.service.Impl;

import com.java.news.mapper.AdminMapper;
import com.java.news.model.User;
import com.java.news.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;


    @Override
    public int addAdmin(String adminName, String adminPass, String phone) {
        return adminMapper.addAdmin(adminName,adminPass,phone);
    }
}
