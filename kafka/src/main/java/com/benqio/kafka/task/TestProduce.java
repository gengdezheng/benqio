package com.benqio.kafka.task;

import com.alibaba.fastjson.JSON;
import com.benqio.kafka.KafkaTopics;
import com.benqio.kafka.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(2)
public class TestProduce implements CommandLineRunner {

    @Autowired
    private KafkaTemplate<String , String> kafkaTemplate;


    public void send(String topic,Message message){
        for(int i=0;i<3;i++) {
            message.setTitle("xixi"+i);
            message.setBody(i+"");
            kafkaTemplate.send(topic, JSON.toJSONString(message));
        }
            log.info("消息以发送");
    }

    @Override
    public void run(String... args) throws Exception {
        send(KafkaTopics.TEST,new Message());
    }
}
