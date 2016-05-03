package com.baofoo.kafka.test.consumer;

import com.baofoo.kafka.service.nospring.ConsumerNoSpringService;
import com.baofoo.kafka.test.model.Topics;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * Created by LZQ on 14/10/24.
 *
 */
@Slf4j
public class ConsumerMsgNoSpring {

    public static void consumer() throws IllegalAccessException, InstantiationException {
        ConsumerNoSpringService.consumerMessages(Topics.getTopicInfo(), SayHelloProcess.class, UUID.randomUUID().toString());
        log.info("noSpring消费启动");
    }

}