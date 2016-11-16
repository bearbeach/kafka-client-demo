package com.system.kafka.clients.demo.producer.origin;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * <ul>
 * <li>****类</li>
 * <li>说明简介<li>
 * <li>User: weiwei Date:16/5/26 <li>
 * </ul>
 */
public class ConsumerManualTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis());
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.0.21.56:9092");
        props.put("group.id", "myself");
        props.put("session.timeout.ms", "30000");
        props.put("enable.auto.commit", "false");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("test"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            System.out.println("restart....");
            for (TopicPartition partition : records.partitions()) {
                List<ConsumerRecord<String, String>> partitionRecords = records.records(partition);
                for (ConsumerRecord<String, String> record : partitionRecords) {
                    System.out.println(record.offset() + ": " + record.value());
                    long lastOffset = record.offset();
                    try {
                        consumer.commitSync(Collections.singletonMap(partition, new OffsetAndMetadata(lastOffset + 1)));
                    } catch (Exception e) {
                        System.out.println("e===" + e);
                        break;
                    }

                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("" + (System.currentTimeMillis() - startTime));
                }
            }
            System.out.println("end....than next");
        }

    }

}
