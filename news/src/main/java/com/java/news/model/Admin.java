package com.java.news.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Setter
@Getter
public class Admin {
  private int adminId;
  private String adminName;
  private String adminPassword;
  private String phone;
  private Date createTime;
}
