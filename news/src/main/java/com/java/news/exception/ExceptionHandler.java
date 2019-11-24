//package com.java.news.exception;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
///**
// * @author:gengdz
// * @date:2019/9/29
// * @desc:异常处理
// */
//
//@RestControllerAdvice
//@Slf4j
//public class ExceptionHandler {
//
//
//    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
//    public String throwRuntimeException(RuntimeException re){
//        log.info("RuntimeException异常：{}",re+"");
//        return JSON.toJSONString(re+"".split(":")[0]);
//    }
//
//
//    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
//    public String throwIllegalArgumentException(RuntimeException re){
//        log.info("IllegalArgumentException异常：{}",re+"");
//        return JSON.toJSONString(re+"".split(":")[0]);
//    }
//
//    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
//    public String throwNullPointerException(NullPointerException re){
//        log.info("NullPointerException异常：{}",re+"");
//        return JSON.toJSONString(re);
//    }
//}
