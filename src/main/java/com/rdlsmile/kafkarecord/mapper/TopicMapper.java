package com.rdlsmile.kafkarecord.mapper;

import com.rdlsmile.kafkarecord.entity.MessageInfo;
import com.rdlsmile.kafkarecord.entity.TopicInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.plugin2.message.Message;

import java.util.Date;
import java.util.List;

/**
 * Created by RDL on 2018-07-14 17:21
 **/
@Mapper
@Repository
public interface TopicMapper {

    /*根据id查询topic*/
    @Select("SELECT " +
            " id as id," +
            " topic_name as topicName," +
            " create_time as createTime " +
            " FROM topic_info WHERE id = #{id}")
    TopicInfo findTopicInfoById(@Param("id") Long id);

    /*根据topicName查询topic*/
    @Select("SELECT " +
            " id as id," +
            " topic_name as topicName," +
            " create_time as createTime " +
            " FROM topic_info WHERE topic_name = #{topicName}")
    TopicInfo findTopicInfoByTopicName(@Param("topicName") String topicName);


    /*根据topicInfoId查询消息*/
    @Select("SELECT " +
            " id as id, " +
            " topic_info_id as topicInfoId, " +
            " message as message, " +
            " receive_time as receiveTime " +
            " FROM message_info WHERE topic_info_id = #{topicInfoId}")
    List<MessageInfo> findMessageInfoByTopicInfoId(@Param("topicInfoId") Long topicInfoId);

    /*插入topicInfo*/
    @Insert("INSERT INTO topic_info (id, topic_name, create_time) VALUES (#{id}, #{topicName}, #{createTime})")
    int addTopicInfo(@Param("id") Long id, @Param("topicName") String topicName, @Param("createTime") Date createTime);

    /*插入messageInfo*/
    @Insert("INSERT INTO message_info (id, topic_info_id, message, receive_time ) " +
            " VALUES (#{id}, #{topicInfoId}, #{message}, #{receiveTime})")
    int addMessageInfo(@Param("id") Long id, @Param("topicInfoId") Long topicInfoId, @Param("message") String message,
                       @Param("receiveTime") Date receiveTime);


}
