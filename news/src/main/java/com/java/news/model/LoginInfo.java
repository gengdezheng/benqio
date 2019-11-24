package com.java.news.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Setter
@Getter
@ToString
public class LoginInfo {
    private int id;
    private String loginName;
    private String loginIP;
    private int loginState;
    private String reason;
    private Date time;
    private int role;
}
