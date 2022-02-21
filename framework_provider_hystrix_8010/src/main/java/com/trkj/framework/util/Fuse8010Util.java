package com.trkj.framework.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 13795
 * 熔断器处理
 *
 */
@Component
public class Fuse8010Util {

    public Map<String,Object> main(){
        Map<String, Object> objectMap = new HashMap<>(2);
        objectMap.put("state", 300);
        objectMap.put("info", "服务器异常，请稍后再试");
        return objectMap;
    }

}