package com.system.kafka.clients;

import com.system.kafka.clients.factory.ProducerFactory;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <ul>
 * <li>生产者服务类</li>
 * <li>此类封装生产者发送实体,对外提供统一入口<li>
 * <li>User: weiwei Date:16/5/11 <li>
 * </ul>
 */
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    /**
     * 生产者工厂
     */
    private ProducerFactory producerFactory;

    public void setProducerFactory(ProducerFactory producerFactory) {
        this.producerFactory = producerFactory;
    }


    /**
     * 通过[topicName]从[生产者工厂]获取一条通道,然后发送[message]到broker集群
     *
     * @param topicName 主题名称
     * @param message   消息
     * @param <T>       消息类型
     */
    public <T> void sendMessage(String topicName, T message) {
        try {
            producerFactory.getProducer(topicName).send(new ProducerRecord<String, T>(topicName, message));
        } catch (Throwable throwable) {
            logger.error("send a message Exception:{}", throwable);
        }
    }
}
