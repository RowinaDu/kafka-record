package com.rdlsmile.kafkarecord.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by RDL on 2018-07-13 18:24
 **/
@Component
public class TestConsumer {

    Logger LOG = LoggerFactory.getLogger("TestConsumer");

    /**
    * @Description: 监听消息内容
    * @Param: [message]
    * @return: void
    * @Author: RDL
    * @Date: 2018/7/13  18:29
    */
    @KafkaListener(topics = {"test"})
    public void consumer(String message) {
        LOG.info("test topic message : {}", message);
    }

}
