package com.benqio.dynamicdatasource.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author:gengdz
 * @date:2019/9/26
 * @desc:自定义注解结合AOP方式实现数据源切换
 */

@Aspect
@Component
public class DynamicDataSourceAspect {
    @Before("@annotation(TargetDS)")
    public void beforeSwitchDS(JoinPoint point){
        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        String dataSource = "master";
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@TargetDS注解
            if (method.isAnnotationPresent(TargetDS.class)) {
                TargetDS annotation = method.getAnnotation(TargetDS.class);
                // 取出注解中的数据源名
                dataSource = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 切换数据源
        DataSourceContextHolder.setDataSource(dataSource);
    }

    @After("@annotation(TargetDS)")
    public void afterSwitchDS(JoinPoint point) {
        DataSourceContextHolder.clearDataSource();
    }
}
