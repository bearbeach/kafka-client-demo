package com.system.kafka.common.handle;

import com.system.kafka.handle.BizHandleInterface;
import com.system.kafka.common.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <ul>
 * <li>接收派发处理类</li>
 * <li>接收到获取的消息,进行响应处理.<li>
 * <li>User: weiwei Date:16/5/12 <li>
 * </ul>
 */
public class Receiver implements BizHandleInterface<User> {

    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    @Override
    public void doBiz(User obj) {
        // [你需要在这里写逻辑处理]
        logger.info("receipt a message:[{}]", obj.toString());
    }
}
