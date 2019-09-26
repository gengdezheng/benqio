package com.benqio.dynamicdatasource.config;

import lombok.extern.slf4j.Slf4j;

/**
 * @author:gengdz
 * @date:2019/9/26
 * @desc:保存当前数据源
 */
@Slf4j
public class DataSourceContextHolder {
    private  static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDataSource(String dsType)
    {
        contextHolder.set(dsType);
        log.info("切换到数据源{}",dsType);
    }

    public static String getDataSource(){
        return contextHolder.get();
    }

    public static void clearDataSource(){
        contextHolder.remove();
    }
}
