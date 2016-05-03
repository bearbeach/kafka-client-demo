package com.baofoo.kafka.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by LZQ on 14-10-17.
 * kafka topic info
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TopicInfo {

    /**
     * 消息类型 同步、异步
     */
    private ProducerType syncFlag;
    /**
     * Topic 名称
     */
    private String topicName;
    /**
     * 消息发送后的应答方式
     */
    private RequiredAck ack;
    /**
     * 消息发送异常后是否可以重复发送（重复时可能消息重复）
     */
    private boolean retries;
    /**
     * 该topic作为队列使用
     */
    private boolean useAsQueue;
    /**
     * zookeeper 地址（例：127.0.0.1:2181）
     */
    private String zkAddress;
    /**
     * 集群地址列表（列：172.17.13.41:9092,172.17.13.42:9092）
     */
    private String brokerList;

    public TopicInfo(ProducerType syncFlag, String topicName, RequiredAck ack, boolean retries,
                     boolean useAsQueue,String zkAddress,String brokerList){
        this.syncFlag = syncFlag ;
        this.topicName = topicName ;
        this.ack = ack ;
        this.retries = retries;
        this.useAsQueue =useAsQueue;
        this.zkAddress = zkAddress;
        this.brokerList = brokerList;
    }

}
