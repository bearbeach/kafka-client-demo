package com.baofoo.kafka.test.producer;

import com.baofoo.kafka.test.consumer.ConsumerMsgNoSpring;
import com.baofoo.kafka.test.model.User;
import com.baofoo.kafka.service.nospring.ProducerNoSpringService;
import com.baofoo.kafka.test.model.Topics;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by LZQ on 14-10-20.
 *
 */
@Slf4j
public class ProducerNoSpringTest{

    User getUser(int i){
        return new User("name"+i,String.valueOf(System.currentTimeMillis()),"noSpring");
    }

    @Test
    public void testProduceMsgNoSpring() throws InstantiationException, IllegalAccessException {

        ConsumerMsgNoSpring.consumer();

        for (int i = 0 ;i < 10 ; i++){
            User user = getUser(i);
            log.info("user=====:{}",user);
            ProducerNoSpringService.sendMessage(Topics.getTopicInfo(), user, String.valueOf(System.currentTimeMillis()));
            log.debug("第几条消息：{}",i);
        }

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            log.debug("消息中断：{}",e);
        }
    }
}