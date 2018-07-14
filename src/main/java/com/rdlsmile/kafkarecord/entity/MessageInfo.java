package com.rdlsmile.kafkarecord.entity;

import java.util.Date;

/**
 * Created by RDL on 2018-07-13 18:18
 **/
public class MessageInfo {

    private Long id;
    /*消息主题id*/
    private Long topicInfoId;
    /*消息体*/
    private String message;
    /*接收时间*/
    private Date receiveTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTopicInfoId() {
        return topicInfoId;
    }

    public void setTopicInfoId(Long topicInfoId) {
        this.topicInfoId = topicInfoId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    @Override
    public String toString() {
        return "MessageInfo{" +
                "id=" + id +
                ", topicInfoId=" + topicInfoId +
                ", message='" + message + '\'' +
                ", receiveTime=" + receiveTime +
                '}';
    }
}
