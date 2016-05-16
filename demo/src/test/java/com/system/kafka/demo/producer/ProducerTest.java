package com.system.kafka.demo.producer;

import com.system.kafka.factory.ProducerFactory;
import com.system.kafka.demo.BaseSpringTest;
import com.system.kafka.demo.SayHello;
import com.system.kafka.demo.handler.ProducerHandler;
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
     * 单发送消息用例
     *
     * @throws InterruptedException
     */
    @Test
    public void singleSendMessageTest() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            SayHello sayHello = new SayHello("name:" + i, "say " + i);
            producerHandler.sendMessage(sayHello);
        }

        Thread.sleep(100000);
    }

    @Test
    public void multipleSendMessageTest() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            SayHello sayHello = new SayHello("name:" + i, "say " + i);
            /**
             * 发送通道1
             */
            producerHandler.sendMessage(sayHello);

            /**
             * 发送通道2
             */
            producerHandler2.sendMessage(sayHello);
        }

        Thread.sleep(100000);
    }
}
