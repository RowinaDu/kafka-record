package com.rdlsmile.kafkarecord.consumer;

import com.rdlsmile.kafkarecord.common.SnowflakeIdWorker;
import com.rdlsmile.kafkarecord.entity.TopicInfo;
import com.rdlsmile.kafkarecord.mapper.TopicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by RDL on 2018/7/15 23:35
 */
@Component
public class PayResultConsumer {

    Logger LOG = LoggerFactory.getLogger(PayResultConsumer.class);
    private final String topicName = "pay_result_topic";
    private Long topicInfoId;
    private SnowflakeIdWorker snowflakeIdWorker;
    private Boolean isInit = false;

    @Autowired
    private TopicMapper topicMapper;

    private void init() {
        snowflakeIdWorker = new SnowflakeIdWorker(0, 0);
        TopicInfo topicInfo = topicMapper.findTopicInfoByTopicName(topicName);
        if (topicInfo != null) {
            topicInfoId = topicInfo.getId();
            LOG.info("该topic存在，记录id为{}", topicInfo.getId());
        } else {
            topicInfoId = snowflakeIdWorker.nextId();
            topicMapper.addTopicInfo(topicInfoId, topicName, new Date());
            LOG.info("该topic不存在，新建记录id为{}", topicInfoId);
        }
        LOG.info("初始化完成，当前topic为{}，对应id为{}", topicName, topicInfoId);
    }

    @KafkaListener(topics = {topicName})
    public void consumer(String message) {
        if (!isInit) {
            init();
            isInit = true;
        }
        topicMapper.addMessageInfo(snowflakeIdWorker.nextId(), topicInfoId, message, new Date());
        LOG.info("接收到topicName={}的消息，消息体为{},记录成功。", topicName, message);
    }

}
