package com.system.kafka.clients.demo.producer.multiple;

import com.system.kafka.clients.handle.ProducerHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <ul>
 * <li>消息发送线程对象</li>
 * <li>User: weiwei Date:16/5/23 <li>
 * </ul>
 */
public class MessageTrans extends Thread {

    private final Logger logger = LoggerFactory.getLogger(MessageTrans.class);

    ProducerHandler producerHandler;

    private Object message;

    public MessageTrans(ProducerHandler producerHandler, Object messageObj) {
        logger.info("init a message:{}", message);
        this.producerHandler = producerHandler;
        this.message = messageObj;
    }

    @Override
    public void run() {
        logger.debug("block a message,{}", message);
        this.sendMessage();
    }

    /**
     * 发送消息
     */
    public void sendMessage() {
        logger.debug("send a message " + message);
        try {
            producerHandler.sendMessage(message);
        } catch (Exception e) {
            logger.error("send a message,{} Exception:", message, e);
        }
    }
}
