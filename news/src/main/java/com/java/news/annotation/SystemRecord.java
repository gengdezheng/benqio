package com.java.news.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author:gengdz
 * @date:2019/11/4
 * @desc:记录操作日志自定义注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface SystemRecord {
    String description() default "";
}
