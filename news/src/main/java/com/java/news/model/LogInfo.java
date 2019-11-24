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
public class LogInfo {
    private String logId;
    private String logUrl;
    private String logParam;
    private String logClassName;
    private Date logTime;
    private String userName;
    private String descr;
}
