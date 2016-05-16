package com.system.kafka.model;

/**
 * <ul>
 * <li>生产者配置类</li>
 * <li>User: weiwei Date:16/5/11 <li>
 * </ul>
 */
public class ProductConfig {

    // TODO: 16/5/14
    /**
     *
     */
    String bootstrapServers;

    /**
     *
     */
    String acks;

    /**
     *
     */
    String retries;
    String batchSize;
    String lingerMs;
    String bufferMemory;
    String keySerializer = "org.apache.kafka.common.serialization.StringSerializer";
    String valueSerializer = "com.system.kafka.serializer.MessageSerializer";

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getAcks() {
        return acks;
    }

    public void setAcks(String acks) {
        this.acks = acks;
    }

    public String getRetries() {
        return retries;
    }

    public void setRetries(String retries) {
        this.retries = retries;
    }

    public String getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(String batchSize) {
        this.batchSize = batchSize;
    }

    public String getLingerMs() {
        return lingerMs;
    }

    public void setLingerMs(String lingerMs) {
        this.lingerMs = lingerMs;
    }

    public String getBufferMemory() {
        return bufferMemory;
    }

    public void setBufferMemory(String bufferMemory) {
        this.bufferMemory = bufferMemory;
    }

    public String getKeySerializer() {
        return keySerializer;
    }

    public void setKeySerializer(String keySerializer) {
        this.keySerializer = keySerializer;
    }

    public String getValueSerializer() {
        return valueSerializer;
    }

    public void setValueSerializer(String valueSerializer) {
        this.valueSerializer = valueSerializer;
    }
}
