package com.benqio.quartz;

import com.benqio.quartz.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuartzApplicationTests {

    @Autowired
    UserService userService;
    @Test
    public void contextLoads() {
        //AOP切入
        System.out.println(userService.userLogin("geng","123")!=null);

     //   userService.insertByQuartz();
    }

}
