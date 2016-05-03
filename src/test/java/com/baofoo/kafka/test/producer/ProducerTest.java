package com.baofoo.kafka.test.producer;

import com.baofoo.kafka.service.producer.ProducerServiceImpl;
import com.baofoo.kafka.test.model.Topics;
import com.baofoo.kafka.test.model.User;
import com.baofoo.kafka.test.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by LZQ on 14-10-20.
 *
 */
@Slf4j
public class ProducerTest extends BaseSpringTest {
    @Autowired
    private ProducerServiceImpl producerService;

    User getUser(int i){
        return new User("name"+i,String.valueOf(System.currentTimeMillis()),"withSping");
    }

    @Test
    public void testProduceAsyncMsg(){
        for (int i = 0 ;i < 10 ; i++){
            User user = getUser(i);
            log.info("user=====:{}",user);
            producerService.sendMessage(Topics.getTopicInfo(),user,String.valueOf(System.currentTimeMillis()));
            log.debug("第几条消息：{}",i);
        }

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            log.debug("消息中断：{}",e);
        }
    }
}