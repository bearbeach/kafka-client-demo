package com.system.kafka.serializer;

import com.system.kafka.utils.CloseUtils;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * <ul>
 * <li>消息序列化类</li>
 * <li>User: weiwei Date:16/5/11 <li>
 * </ul>
 */

public class MessageSerializer implements Serializer {

    private static final Logger logger = LoggerFactory.getLogger(MessageSerializer.class);

    @Override
    public void configure(Map configs, boolean isKey) {
        // not to do
    }

    @Override
    public byte[] serialize(String topic, Object data) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(data);
            oos.flush();
            bytes = bos.toByteArray();
        } catch (IOException ex) {
            logger.error("message serializer IOException：{}", ex);
        } finally {
            CloseUtils.CloseAll(bos, oos);
        }
        return bytes;
    }

    @Override
    public void close() {
        // noting to do
    }
}
