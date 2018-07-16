package com.rdlsmile.kafkarecord.controlleer;

import com.rdlsmile.kafkarecord.entity.MessageInfo;
import com.rdlsmile.kafkarecord.entity.TopicInfo;
import com.rdlsmile.kafkarecord.mapper.TopicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by RDL on 2018-07-16 13:58
 **/
@Controller
public class TopicController {

    private Logger LOG = LoggerFactory.getLogger(TopicController.class);

    @Autowired
    private TopicMapper topicMapper;

    @RequestMapping("/")
    public String index() {
        return "topic.html";
    }

    @RequestMapping("/getTopicInfoList")
    @ResponseBody
    public List<TopicInfo> getTopicInfoList() {
        return topicMapper.findTopicInfoList();
    }

    @RequestMapping("/getMessageInfoList")
    @ResponseBody
    public List<MessageInfo> getMessageInfoList(Long topicInfoId) {
        return topicMapper.findTop10MessageInfoByTopicInfoId(topicInfoId);
    }

}
