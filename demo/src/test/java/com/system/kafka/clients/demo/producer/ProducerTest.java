package com.system.kafka.clients.demo.producer;

import com.system.kafka.clients.demo.BaseSpringTest;
import com.system.kafka.clients.demo.SayHello;
import com.system.kafka.clients.handle.ProducerHandler;
import com.system.kafka.clients.factory.ProducerFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * <ul>
 * <li>生产者测试类</li>
 * <li>调用生产者处理类,发送消息<li>
 * <li>注意:消费者是通过spring-context.xml控制的,是默认启动的<li>
 * <li>User: weiwei Date:16/5/12 <li>
 * </ul>
 */
public class ProducerTest extends BaseSpringTest {

    private final static Logger logger = LoggerFactory.getLogger(ProducerFactory.class);

    @Autowired
    ProducerHandler producerHandler;

    @Autowired()
    @Qualifier("producerHandler2")
    ProducerHandler producerHandler2;

    /**
     * 发送消息用例
     * 在spring-context.xml默认启动消费者
     *
     * @throws InterruptedException
     */
    @Test
    public void singleSendMessageTest() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            SayHello sayHello = new SayHello("name:" + i, "say " + i);
            try {
                producerHandler.sendMessage(sayHello);
            } catch (Exception e) {
                logger.error("send a message:{},fatal,Exception:", sayHello, e);
            }
        }

        Thread.sleep(100000);
    }
}
