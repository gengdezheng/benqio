package com.java.news.service;

import com.java.news.model.Article;
import com.java.news.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Component
public interface AdminService {

    int addAdmin(String adminName , String adminPass , String phone);
}
