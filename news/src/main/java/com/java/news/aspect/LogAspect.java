package com.java.news.aspect;

import com.alibaba.fastjson.JSON;
import com.java.news.Constant;
import com.java.news.annotation.SystemRecord;
import com.java.news.model.LogInfo;
import com.java.news.model.LoginInfo;
import com.java.news.model.User;
import com.java.news.service.Impl.LogServiceImpl;
import com.java.news.service.Impl.LoginInfoImpl.UserLoginServiceImpl;
import com.java.news.service.LogService;
import com.java.news.service.LoginService;
import com.java.news.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Component
@EnableAspectJAutoProxy
@Aspect
@Slf4j
public class LogAspect {


    @Autowired
    LoginService loginService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpSession session;
    @Autowired
    LogService logService;


    @Pointcut("execution(public * com.java.news.service.Impl.LoginInfoImpl.UserLoginServiceImpl.login(..))")
    public void pt_login() {
    }
    @Pointcut("execution(public * com.java.news.service.Impl.LoginInfoImpl.UserLoginServiceImpl.adminLogin(..))")
    public void pt_login_a() {
    }

    @Pointcut("@annotation(com.java.news.annotation.SystemRecord)")
    public void pt_log() {
    }

    @AfterReturning(value = "pt_login()", returning = "r")
    public void insertIntoLoginInfo(JoinPoint jp, int r) {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setLoginName(jp.getArgs()[0] + "");
        loginInfo.setLoginIP(request.getRemoteAddr());
        if (r == 0) {
            loginInfo.setLoginState(Constant.LOGIN_SUCCESS);
            loginInfo.setReason("");
        } else {
            loginInfo.setLoginState(Constant.LOGIN_ERROR);
            loginInfo.setReason(Constant.LOGIN_REASON_IS_ERROR);
        }
        loginInfo.setRole(Constant.USER_ROLE);
        loginService.insert(loginInfo);
    }


    @AfterReturning(value = "pt_login_a()", returning = "r")
    public void insertIntoLoginInfo_a(JoinPoint jp, int r) {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setLoginName(jp.getArgs()[0] + "");
        loginInfo.setLoginIP(request.getRemoteAddr());
        if (r == 0) {
            loginInfo.setLoginState(Constant.LOGIN_SUCCESS);
            loginInfo.setReason("");
        } else {
            loginInfo.setLoginState(Constant.LOGIN_ERROR);
            loginInfo.setReason(Constant.LOGIN_REASON_IS_ERROR);
        }
        loginInfo.setRole(Constant.ADMIN_ROLE);
        loginService.insert(loginInfo);
    }


    public void LogInfo(JoinPoint jp) {
        LogInfo logInfo = new LogInfo();
        logInfo.setLogId(UUID.randomUUID().toString().replace("-", ""));
        logInfo.setLogParam(JSON.toJSONString(jp.getArgs()));
        logInfo.setLogClassName(jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + "()");
        logInfo.setLogUrl(request.getRequestURI());
        if (session.getAttribute("user") != null)
            logInfo.setUserName(((User) session.getAttribute("user")).getUserName());
        else
            logInfo.setUserName(UserLoginServiceImpl.ADMIN);
        SystemRecord systemRecord = getAnnotationLog(jp);
        logInfo.setDescr(systemRecord.description());

        logService.insertLog(logInfo);
    }

    @Before(value = "pt_log()")
    public void insertIntoLog(JoinPoint jp) {
        LogInfo(jp);
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private SystemRecord getAnnotationLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null) {
            return method.getAnnotation(SystemRecord.class);
        }
        return null;
    }
}
