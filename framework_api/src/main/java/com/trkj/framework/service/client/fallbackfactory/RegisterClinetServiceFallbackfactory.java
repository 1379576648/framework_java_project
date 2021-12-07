package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.service.client.register.RegisterClinetService;
import com.trkj.framework.vo.AjaxResponse;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//降级~
@Component
public class RegisterClinetServiceFallbackfactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new RegisterClinetService() {
            @Override
            public AjaxResponse register(Map<String, Object> map) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }
        };
    }
}
