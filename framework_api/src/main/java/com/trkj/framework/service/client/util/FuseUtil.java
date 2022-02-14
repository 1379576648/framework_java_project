package com.trkj.framework.service.client.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 13795
 * 熔断器处理
 *
 */
@Component
public class FuseUtil {

    public Map<String,Object> main(Throwable throwable){
        throwable.printStackTrace();
        Map<String, Object> objectMap = new HashMap<>(2);
            objectMap.put("state", 100);
            objectMap.put("info", "服务发生关闭");
        return objectMap;
    }

}
