package com.baofoo.kafka.service.nospring;

import com.baofoo.kafka.model.TopicInfo;
import com.baofoo.kafka.service.factory.ProducerFactory;
import kafka.producer.KeyedMessage;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * kafka 生产者
 *
 * <ul>
 * <li>kafka消息发送，不依赖spring</li>
 * </ul>
 *
 * @author LZQ
 * @version 1.0.0 createTime: 15/6/3 上午8:54
 * @see
 * @since 1.6
 */
@Slf4j
public class ProducerNoSpringService {


    /**
     * 发送消息集合
     * @param topicInfo topic 信息
     * @param messages   待发送消息
     * @param <T>       消息类型
     */
    public static  <T> void sendMessages(TopicInfo topicInfo, List<T> messages,String traceLogId) {
        log.debug("traceLogId:{},topicInfo:{} messages to send :{}",traceLogId, topicInfo,messages);
        ProducerFactory.getProducer(topicInfo).send(new KeyedMessage(topicInfo.getTopicName(),messages));
    }

    /**
     * 发送单个消息
     * @param topicInfo topic 信息
     * @param message   待发送消息
     * @param <T>       消息类型
     */
    public static  <T> void sendMessage(TopicInfo topicInfo, T message,String traceLogId) {
        log.debug("traceLogId:{} topic message to send :{}",traceLogId,topicInfo,message);
        ProducerFactory.getProducer(topicInfo).send(new KeyedMessage(topicInfo.getTopicName(),message));
    }
}
