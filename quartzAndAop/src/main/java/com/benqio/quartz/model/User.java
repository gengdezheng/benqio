package com.benqio.quartz.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author:gengdz
 * @date:2019/10/14
 * @desc:
 */
@Setter
@Getter
@ToString
public class User {
    private String id;
    private String userName;
    private String password;
    private int roleId;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(){}
}
