package com.system.kafka.utils;

import com.system.kafka.handle.BizHandleInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <ul>
 * <li>消费者处理控制类</li>
 * <li>控制管理消费者处理类<li>
 * <li>User: weiwei Date:16/5/11 <li>
 * </ul>
 */
public class BizClassUtils {

    private static final Logger loger = LoggerFactory.getLogger(BizClassUtils.class);

    /**
     * 处理类map
     */
    public static Map<String, BizHandleInterface> mapObj = new HashMap<>();

    /**
     * 获取相应的处理类
     *
     * @param c
     * @return
     */
    public static BizHandleInterface get(Class c) {
        try {
            if (null == mapObj.get(c.getName()))
                mapObj.put(c.getName(), (BizHandleInterface) c.newInstance());
            return mapObj.get(c.getName());
        } catch (InstantiationException e) {
            loger.error("Initialization handle InstantiationException,{}", e);
        } catch (IllegalAccessException e) {
            loger.error("Initialization handle IllegalAccessException,{}", e);
        }
        return null;
    }
}
