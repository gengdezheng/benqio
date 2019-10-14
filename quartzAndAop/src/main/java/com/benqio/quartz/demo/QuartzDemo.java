package com.benqio.quartz.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author:gengdz
 * date:2019/10/12
 * desc:
 */
@Component
@Slf4j


public class QuartzDemo implements CommandLineRunner {
    /**
     *cron表达式： 秒 分 时 日 月 星期
     *          / 表示增量
     *          * 表示任意值
     *          ？ 只用于日，星期
     */

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 每5秒执行一次
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void printTimeByQuartz_Second(){
        Date date = new Date();
        log.info("每秒执行{}",simpleDateFormat.format(date));
    }

    /**
     * 每1分钟执行一次
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void printTimeByQuartz_Min(){
        Date date = new Date();
        log.info("每分执行{}",simpleDateFormat.format(date));
    }

    @Override
    public void run(String... args) {
       // printTimeByQuartz_MIn();
    }
}
