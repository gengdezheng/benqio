package com.java.news.service;

import com.java.news.model.LogInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Component
public interface LogService {
    void insertLog(LogInfo logInfo);
    List<LogInfo> queryLogInfo(String logId);
    int deleteLogById(String logId);
    int clearLog();
}
