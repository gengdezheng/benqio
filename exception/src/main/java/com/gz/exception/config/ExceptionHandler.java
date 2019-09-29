package com.gz.exception.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author:gengdz
 * @date:2019/9/29
 * @desc:异常处理
 */
@RestControllerAdvice
@Slf4j
@CrossOrigin
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public String throwException(Exception e){
        log.info("Exception异常：{}",e.getMessage());
        return e.getMessage();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public String throwRuntimeException(RuntimeException re){
        log.info("RuntimeException异常：{}",re.getMessage());
        return re.getMessage();
    }
}
