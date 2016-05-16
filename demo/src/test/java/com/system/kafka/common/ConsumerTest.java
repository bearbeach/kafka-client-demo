package com.system.kafka.common;

import com.system.kafka.ConsumerService;
import com.system.kafka.factory.ConsumerFactory;
import com.system.kafka.common.handle.Receiver;
import com.system.kafka.model.ConsumerConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <ul>
 * <li>消费者测试类</li>
 * <li>非Srping注解模式测试消费者进行消息消费<li>
 * <li>User: weiwei Date:16/5/11 <li>
 * </ul>
 */
public class ConsumerTest {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerTest.class);
    /**
     * 消费者服务类
     */
    private ConsumerService consumerService;

    /**
     * 主题
     */
    private String topicName = "my-topic";

    @Test
    public void consumerTest() throws InterruptedException {
        ConsumerConfig cc = new ConsumerConfig();
        cc.setBootstrapServers("10.0.21.56:9092,10.0.21.57:9092");
        cc.setGroupId("test");
        cc.setEnableAutoCommit("true");
        cc.setAutoCommitIntervalMs("1000");
        cc.setSessionTimeoutMs("30000");
        ConsumerFactory consumerFactory = new ConsumerFactory(cc);
        consumerService = new ConsumerService();
        consumerService.setConsumerFactory(consumerFactory);

        consumerService.consumerMessages(topicName, Receiver.class);

        // 休眠,等待消费
        Thread.sleep(200000);
    }
}
