package com.baofoo.kafka.test.consumer;

import com.baofoo.kafka.service.consumer.process.BusinessProcessInterface;
import com.baofoo.kafka.test.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by LZQ on 14/10/24.
 *
 */
@Slf4j
@Service
public class SayHelloProcess implements BusinessProcessInterface<User> {
    @Override
    public void doBusiness(User user) {
        log.debug("say hello :{},{},{}",user.getUserName(),user.getPassWord(),user.getWithSpring());
    }
}
