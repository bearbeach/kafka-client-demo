package com.system.kafka.test.model;

import com.system.kafka.model.TopicInfo;
import com.system.kafka.model.ProducerType;
import com.system.kafka.model.RequiredAck;

/**
 * Created by LZQ on 14/10/24.
 *
 */
public class Topics {

    public static TopicInfo getTopicInfo(){


        return new TopicInfo(
                ProducerType.SYNC,
                "testNoSpring",
                RequiredAck.LEADER_ACK,
                true,
                true,
                "127.0.0.1:2181",
                "127.0.0.1:9092"
//                "192.168.1.253:2181",
//                "192.168.1.253:9092",
        );

    }
}
