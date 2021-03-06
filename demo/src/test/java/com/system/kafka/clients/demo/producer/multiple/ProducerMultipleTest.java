package com.system.kafka.clients.demo.producer.multiple;

import com.system.kafka.clients.demo.BaseSpringTest;
import com.system.kafka.clients.demo.SayHello;
import com.system.kafka.clients.handle.ProducerHandler;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * <ul>
 * <li>生产者测试类 - 模拟多线程调用生产者</li>
 * <li>性能测试用例</li>
 * <li>场景:消息为1000bety大小</li>
 * <li>调用生产者处理类,发送消息<li>
 * <li>注意:消费者是通过spring-context.xml控制的,是默认启动的<li>
 * <li>User: weiwei Date:16/5/24 <li>
 * </ul>
 */
public class ProducerMultipleTest extends BaseSpringTest {

    private final static Logger logger = LoggerFactory.getLogger(ProducerMultipleTest.class);

    @Autowired
    ProducerHandler producerHandler;

    @Autowired()
    @Qualifier("producerHandler2")
    ProducerHandler producerHandler2;

    /**
     * 发送消息用例
     * 在spring-context.xml默认启动消费者
     */
    @Test
    public void MultipleSendMessageTest() throws Exception {
        Date start_time = new Date();
        logger.info("start time:{}", start_time);

        int numThread = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 1000; i++) {
            SayHello sayHello = new SayHello("name:" + i, "我要说话,说到够400bety,400bety到底有多长,1byte是8个字节,一个中文占二个字节,那我得说二百多字,但是格式也占了一些,不知道够了没,现在才说到一般,我要把刚才的话全部复制过去, 我要说话,说到够400bety,400bety到底有多长,1byte是8个字节,一个中文占二个字节,那我得说二百多字,但是格式也我要说话,说到够400bety,400bety到底有多长,1byte是8个字节,一个中文占二个字节,那我得说二百多字,但是格式也占了一些,不知道够了没,现在才说到一般,我要把刚才的话全部复制过去, 我要说话,说到够400bety,400bety到底有多长,1byte是8个字节,一个中文占二个字节,那我得说二百多字,但是格式也我要说话,说到够400bety,400bety到底有多长,1byte是8个字节,一个中文占二个字节,那我得说二百多字,但是格式也我要说话,说到够400bety,400bety到底有多长,1byte是8个字节," + i);
            executorService.execute(new MessageTrans(producerHandler, sayHello));
            numThread++;
        }

        logger.info("numThread starting complete:{}", numThread);
        executorService.shutdown();
        // 等待子线程结束，再继续执行下面的代码
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

        Date end_time = new Date();
        logger.info("end time:{}", end_time);
        long interval = (end_time.getTime() - start_time.getTime()) / 1000;
        logger.info("两个时间相差" + interval + "秒");//会打印出相差3秒

        // 休眠一定时间,等待消费者消费发送的消息
        Thread.sleep(100000);
    }
}
