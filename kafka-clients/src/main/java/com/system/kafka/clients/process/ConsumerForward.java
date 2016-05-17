package com.system.kafka.clients.process;

import com.alibaba.fastjson.JSON;
import com.system.kafka.clients.utils.BizClassUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * <ul>
 * <li>消费者转发</li>
 * <li>接收到消息后,转发到各个业务处理类<li>
 * <li>User: weiwei Date:16/5/11 <li>
 * </ul>
 */
public class ConsumerForward {

    private final static Logger logger = LoggerFactory.getLogger(ConsumerForward.class);

    /**
     * 消费者通道对象
     */
    private KafkaConsumer consumer;

    public ConsumerForward(KafkaConsumer consumer) {
        this.consumer = consumer;
    }

    public <T> void poll(String topicName, Class c, Class<T> clas) {

        // 订阅一个主题
        consumer.subscribe(Arrays.asList(topicName));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                try {
                    BizClassUtils.get(c).doBiz(JSON.parseObject(record.value(), clas));
                } catch (Exception e) {
                    logger.error("a message errors:{}", e);
                }
            }
        }
    }
}
