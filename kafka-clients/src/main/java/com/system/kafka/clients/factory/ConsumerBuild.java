package com.system.kafka.clients.factory;

import com.system.kafka.clients.model.ConsumerConfig;

import java.util.Properties;

/**
 * <ul>
 * <li>消费者构建类</li>
 * <li>保证消费者构建,防止缺胳膊少腿<li>
 * <li>User: weiwei Date:16/5/11 <li>
 * </ul>
 */
public class ConsumerBuild {

    public Properties getProperty(ConsumerConfig cc) {
        Properties props = new Properties();
        props.put("bootstrap.servers", cc.getBootstrapServers());
        props.put("group.id", cc.getGroupId());
        props.put("enable.auto.commit", cc.getEnableAutoCommit());
        props.put("auto.commit.interval.ms", cc.getAutoCommitIntervalMs());
        props.put("session.timeout.ms", cc.getSessionTimeoutMs());
        props.put("key.deserializer", cc.getKeyDeserializer());
        props.put("value.deserializer", cc.getValueDeserializer());
        return props;
    }
}
