package com.system.kafka.clients.demo.producer.origin;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * <ul>
 * <li>****类</li>
 * <li>说明简介<li>
 * <li>User: weiwei Date:16/5/26 <li>
 * </ul>
 */
public class ProducerSSLTest {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.211.55.5:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);

        // 增加ssl验证
        props.put("security.protocol", "SSL");
        props.put("ssl.truststore.password", "test1234");
        props.put("ssl.truststore.location", "/Users/weiwei/Downloads/client.truststore.jks");

        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 10; i++)
            try {
                producer.send(new ProducerRecord<String, String>("test", Integer.toString(i), Integer.toString(i))).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        producer.close();
    }
}
