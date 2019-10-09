package com.benqio.kafka.task;

import com.alibaba.fastjson.JSON;
import com.benqio.kafka.KafkaTopics;
import com.benqio.kafka.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(1)
public class TestConsumer implements CommandLineRunner {

    @KafkaListener(topics = {KafkaTopics.TEST})
    public  void listen( ConsumerRecord<?, ?> record) {
        //  log.info("接收消息为:" + record.value());
        Message message= JSON.parseObject(record.value()+"",Message.class);
        System.out.println(message.toString()+"");
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
