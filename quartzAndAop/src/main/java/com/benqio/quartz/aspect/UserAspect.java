package com.benqio.quartz.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author:gengdz
 * @date:2019/10/14
 * @desc:
 */
@Component
@EnableAspectJAutoProxy
@Aspect
@Slf4j
public class UserAspect {

    @Pointcut("execution(public * com.benqio.quartz.service.Impl.*.*(..))")
    public void pt(){}

    @Before("pt()")
    public void before(){
        log.info("before--------------");
    }

    /**
     * 后置通知
     * @param jp  获取目标方法参数值等关键
     * @param returnValue  返回值
     */
    @AfterReturning(value = "pt()" , returning = "returnValue")
    public void getInfo(JoinPoint jp ,Object returnValue){
        log.info(jp.getArgs()[0] + ","+jp.getArgs()[1]+","+returnValue);
    }

}
