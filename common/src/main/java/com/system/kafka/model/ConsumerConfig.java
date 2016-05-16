package com.system.kafka.model;

/**
 * <ul>
 * <li>消费者配置类</li>
 * <li>User: weiwei Date:16/5/11 <li>
 * </ul>
 */
public class ConsumerConfig {
    // TODO: 16/5/14
    private String bootstrapServers;
    private String groupId;
    private String enableAutoCommit;
    private String autoCommitIntervalMs;
    private String sessionTimeoutMs;
    private String keyDeserializer = "org.apache.kafka.common.serialization.StringDeserializer";
    private String valueDeserializer = "com.system.kafka.serializer.MessageDeserializer";

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getEnableAutoCommit() {
        return enableAutoCommit;
    }

    public void setEnableAutoCommit(String enableAutoCommit) {
        this.enableAutoCommit = enableAutoCommit;
    }

    public String getAutoCommitIntervalMs() {
        return autoCommitIntervalMs;
    }

    public void setAutoCommitIntervalMs(String autoCommitIntervalMs) {
        this.autoCommitIntervalMs = autoCommitIntervalMs;
    }

    public String getSessionTimeoutMs() {
        return sessionTimeoutMs;
    }

    public void setSessionTimeoutMs(String sessionTimeoutMs) {
        this.sessionTimeoutMs = sessionTimeoutMs;
    }

    public String getKeyDeserializer() {
        return keyDeserializer;
    }

    public void setKeyDeserializer(String keyDeserializer) {
        this.keyDeserializer = keyDeserializer;
    }

    public String getValueDeserializer() {
        return valueDeserializer;
    }

    public void setValueDeserializer(String valueDeserializer) {
        this.valueDeserializer = valueDeserializer;
    }

}
