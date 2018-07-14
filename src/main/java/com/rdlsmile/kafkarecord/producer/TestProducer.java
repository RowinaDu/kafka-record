package com.rdlsmile.kafkarecord.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by RDL on 2018-07-13 18:25
 **/
@Component
public class TestProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
    * @Description: 发送消息
    * @Param: []
    * @return: void
    * @Author: RDL
    * @Date: 2018/7/13  18:29
    */
    public void sendTest() {
        kafkaTemplate.send("test", "hello,kafka  " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
    }

}
