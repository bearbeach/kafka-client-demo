package com.system.kafka.service.consumer.process;

import org.springframework.stereotype.Service;

/**
 * Created by LZQ on 14/10/24.
 * 业务处理接口
 */
@Service
public interface BusinessProcessInterface<V> {

    /**
     * 业务处理
     *
     * @param args          业务处理参数
     */
    void doBusiness(V args);
}
