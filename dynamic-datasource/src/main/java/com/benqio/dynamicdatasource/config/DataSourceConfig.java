package com.benqio.dynamicdatasource.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:gengdz
 * @date:2019/9/26
 * @desc:数据源配置
 */
@Configuration
public class DataSourceConfig {

    //主数据源master
    @Bean(name = "master")
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    @Primary
    public DataSource dataSourceMaster() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 辅数据源slave
     *
     * @return
     */
    @Bean(name = "slave")
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave")
    public DataSource dataSourceSlave() {
        return DataSourceBuilder.create().build();
    }

    //动态数据源，数据源之间的动态切换
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(dataSourceMaster());

        Map<Object,Object> dsMap = new HashMap<>();
        dsMap.put("master",dataSourceMaster());
        dsMap.put("slave",dataSourceSlave());

        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

    /**
     * 配置事物
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dynamicDataSource());
    }


}
