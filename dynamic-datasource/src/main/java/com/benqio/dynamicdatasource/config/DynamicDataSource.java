package com.benqio.dynamicdatasource.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author:gengdz
 * @date:2019/9/26
 * @desc:当前的数据源
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        log.info("数据源："+DataSourceContextHolder.getDataSource());
        return DataSourceContextHolder.getDataSource();
    }
}
