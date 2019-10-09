package com.benqio.kafka;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.TimerTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaApplicationTests {


    @Test
    public void contextLoads() {

        TimerTask tt = testTimer();
    }

    public TimerTask testTimer(){
        return new TimerTask() {
            @Override
            public void run() {
                System.out.println("123");
            }
        };
    }

}
