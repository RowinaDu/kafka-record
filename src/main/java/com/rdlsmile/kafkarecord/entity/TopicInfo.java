package com.rdlsmile.kafkarecord.entity;

import java.util.Date;

/**
 * Created by RDL on 2018-07-13 18:17
 **/
public class TopicInfo {

    private Long id;
    /*消息主题*/
    private String topicName;
    /*创建时间*/
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TopicInfo{" +
                "id=" + id +
                ", topicName='" + topicName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
