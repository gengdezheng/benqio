package com.benqio.dynamicdatasource.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:gengdz
 * @date:2019/9/26
 * @desc:自定义目标数据源注解
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TargetDS {
    String value() default "master";
}
