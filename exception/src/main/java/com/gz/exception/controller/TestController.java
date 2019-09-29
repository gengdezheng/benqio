package com.gz.exception.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author:gengdz
 * @date:2019/9/29
 * @desc:
 */
@CrossOrigin
@RestController
@RequestMapping("/exception")
public class TestController {

    @GetMapping("/chu")
    public int test(){
        int i = 5/0;
        return i;
    }
}
