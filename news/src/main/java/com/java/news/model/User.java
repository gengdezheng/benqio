package com.java.news.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Setter
@Getter
public class User {
    private int id;
    private String userId;
    private String userName;
    private String password;
    private String phoneNumber;
    private String birthday;
    private Date registTime;
    private Date updateTime;
    private String headImg;
    private MultipartFile headfile;
}
