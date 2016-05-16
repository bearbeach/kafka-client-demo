package com.system.kafka.common.original;

import com.system.kafka.common.model.User;
import com.system.kafka.factory.ConsumerBuild;
import com.system.kafka.model.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Properties;

/**
 * <ul>
 * <li>原生态消费者类</li>
 * <li>保留原生态测试例子<li>
 * <li>User: weiwei Date:16/5/11 <li>
 * </ul>
 */
public class ConsumerTest {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerTest.class);

    @Test
    public void consumerTest() {
        ConsumerConfig consumerProperteis = new ConsumerConfig();
        consumerProperteis.setBootstrapServers("10.0.21.56:9092,10.0.21.57:9092");
        consumerProperteis.setGroupId("test");
        consumerProperteis.setEnableAutoCommit("true");
        consumerProperteis.setAutoCommitIntervalMs("1000");
        consumerProperteis.setSessionTimeoutMs("30000");
        consumerProperteis.setKeyDeserializer("org.apache.kafka.common.serialization.StringDeserializer");
        Properties props = new ConsumerBuild().getProperty(consumerProperteis);

        KafkaConsumer<String, User> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("my-topic"));
        while (true) {
            ConsumerRecords<String, User> records = consumer.poll(100);
            for (ConsumerRecord<String, User> record : records) {
                User u = record.value();
//                System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
                logger.debug("id:{},name:{}", u.getId(), u.getName());
            }
        }
    }
}
