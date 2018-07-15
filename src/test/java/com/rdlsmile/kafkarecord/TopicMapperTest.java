package com.rdlsmile.kafkarecord;

import com.rdlsmile.kafkarecord.entity.MessageInfo;
import com.rdlsmile.kafkarecord.entity.TopicInfo;
import com.rdlsmile.kafkarecord.mapper.TopicMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by RDL on 2018-07-14 18:31
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicMapperTest {

    @Autowired
    private TopicMapper topicMapper;

    @Before
    public void setup(){

    }

    @Test
    public void addTopicInfoTest() {
        topicMapper.addTopicInfo(2L,"TEST", new Date());
    }

    @Test
    public void addMessageInfoTest() {
        topicMapper.addMessageInfo(3L,1L, "TEST", new Date());
    }

    @Test
    public void findTopicInfoByIdTest() {
       TopicInfo topicInfo = topicMapper.findTopicInfoById(1L);
        System.out.println(topicInfo);
        Assert.assertEquals("TEST", topicInfo.getTopicName());
    }


    @Test
    public void findTopicInfoByTopicNameTest() {
       TopicInfo topicInfo =  topicMapper.findTopicInfoByTopicName("TEST");
        System.out.println(topicInfo);
    }

    @Test
    public void findMessageInfoByTopicInfoIdTest() {
        List<MessageInfo> messageInfos = topicMapper.findMessageInfoByTopicInfoId(1L);
        System.out.println(messageInfos);
    }


}
