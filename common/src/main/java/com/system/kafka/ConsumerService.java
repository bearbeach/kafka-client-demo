package com.system.kafka;

import com.system.kafka.factory.ConsumerFactory;
import com.system.kafka.handle.BizHandleInterface;
import com.system.kafka.process.ConsumerForward;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <ul>
 * <li>消费者服务类</li>
 * <li>封装消费实体,对外统计提供入口<li>
 * <li>User: weiwei Date:16/5/11 <li>
 * </ul>
 */
public class ConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    /**
     * 消费者工厂,获取一条消费者通道
     */
    private ConsumerFactory consumerFactory;

    public void setConsumerFactory(ConsumerFactory consumerFactory) {
        this.consumerFactory = consumerFactory;
    }

    /**
     * 根据[topicName]获取消费者通道,"长等待"主动去broker拉取消息.
     * 获取到的消息,丢给[beanName]处理人进行处理.
     *
     * @param topicName
     * @param beanName
     */
    public void consumerMessages(final String topicName, final Class<? extends BizHandleInterface> beanName) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ConsumerForward(consumerFactory.getConsumer(topicName)).poll(topicName, beanName);
            }
        }).start();
    }
}
