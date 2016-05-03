package com.system.kafka.test.consumer;

import com.system.kafka.service.consumer.ConsumerServiceImpl;
import com.system.kafka.test.BaseSpringTest;
import com.system.kafka.test.model.Topics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * Created by LZQ on 14/10/24.
 *
 */
@Slf4j
@Service
public class ConsumerMessage extends BaseSpringTest {

    @Autowired
    private ConsumerServiceImpl consumerService;

    @PostConstruct
    public void consumer(){
        consumerService.consumerMessages(Topics.getTopicInfo(),SayHelloProcess.class, UUID.randomUUID().toString());
        log.info("消费启动");
    }

}