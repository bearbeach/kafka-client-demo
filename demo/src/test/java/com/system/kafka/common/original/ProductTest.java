package com.system.kafka.common.original;

import com.system.kafka.common.model.User;
import com.system.kafka.factory.ProductBuild;
import com.system.kafka.model.ProductConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * <ul>
 * <li>原生态生产者测试类</li>
 * <li>保留原生态生产者测试,方便排查是否是代码原因导致的发送失败<li>
 * <li>User: weiwei Date:16/5/11 <li>
 * </ul>
 */
public class ProductTest {

    private static final Logger logger = LoggerFactory.getLogger(ProductTest.class);

    @Test
    public void productTest() {
        ProductConfig productProperteis = new ProductConfig();
        productProperteis.setBootstrapServers("10.0.21.56:9092,10.0.21.57:9092");
        productProperteis.setAcks("all");
        productProperteis.setRetries("0");
        productProperteis.setBatchSize("16384");
        productProperteis.setBufferMemory("33554432");
        productProperteis.setLingerMs("1");
        Properties props = new ProductBuild().getProperty(productProperteis);

        Producer<String, User> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 2; i++) {
            User user = new User(i, "name_" + i);
            producer.send(new ProducerRecord<String, User>("my-topic", user));
        }

        // 关闭生产者通道
        producer.close();
    }
}
