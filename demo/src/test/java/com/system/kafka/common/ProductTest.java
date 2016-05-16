package com.system.kafka.common;

import com.system.kafka.ProductService;
import com.system.kafka.factory.ProducerFactory;
import com.system.kafka.model.ProductConfig;
import com.system.kafka.common.model.User;
import org.junit.Test;

/**
 * <ul>
 * <li>生产者测试类</li>
 * <li>非Srping注解模式测试生产者进行发送消息<li>
 * <li>User: weiwei Date:16/5/11 <li>
 * </ul>
 */
public class ProductTest {

    private ProductService productService;

    @Test
    public void sendMessageTest() throws InterruptedException {
        ProductConfig pc = new ProductConfig();
        pc.setBootstrapServers("10.0.21.56:9092,10.0.21.57:9092");
        pc.setAcks("all");
        pc.setRetries("0");
        pc.setBatchSize("16384");
        pc.setBufferMemory("33554432");
        pc.setLingerMs("1");
        pc.setKeySerializer("org.apache.kafka.common.serialization.StringSerializer");
        pc.setValueSerializer("com.system.kafka.serializer.MessageSerializer");

        ProducerFactory pf = new ProducerFactory(pc);
        productService = new ProductService();
        productService.setProducerFactory(pf);

        for (int i = 0; i < 2; i++) {
            User user = new User(i, "name_" + i);
            productService.sendMessage("my-topic", user);
        }

        // 休眠
        Thread.sleep(1000);
    }
}
