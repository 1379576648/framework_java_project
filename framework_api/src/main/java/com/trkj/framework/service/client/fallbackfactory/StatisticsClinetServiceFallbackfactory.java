package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.service.client.statistics.StatisticsClinetService;
import com.trkj.framework.vo.AjaxResponse;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class StatisticsClinetServiceFallbackfactory implements FallbackFactory {

    @Override
    public Object create(Throwable cause) {
        return new StatisticsClinetService() {
            @Override
            public Object querySex() {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }
        };
    }
}
