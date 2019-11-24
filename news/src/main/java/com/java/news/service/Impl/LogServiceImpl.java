package com.java.news.service.Impl;

import com.java.news.mapper.LogInfoMapper;
import com.java.news.model.LogInfo;
import com.java.news.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogInfoMapper logInfoMapper;

    @Override
    public void insertLog(LogInfo logInfo) {
        logInfoMapper.insertLog(logInfo);
    }

    @Override
    public List<LogInfo> queryLogInfo(String logId) {
        return logInfoMapper.queryLogInfo(logId);
    }

    @Override
    public int deleteLogById(String logId) {
        return logInfoMapper.deleteLogById(logId);
    }

    @Override
    public int clearLog() {
        return logInfoMapper.clearLog();
    }
}
