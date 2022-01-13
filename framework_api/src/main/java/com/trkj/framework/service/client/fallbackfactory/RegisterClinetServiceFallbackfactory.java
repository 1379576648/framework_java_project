package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.service.client.register.RegisterClinetService;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 13795
 */
//降级~
@Component
public class RegisterClinetServiceFallbackfactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new RegisterClinetService() {
            @Override
             public Object register(Map<String, Object> map) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object login(Map<String, Object> map) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }
        };
    }
}
