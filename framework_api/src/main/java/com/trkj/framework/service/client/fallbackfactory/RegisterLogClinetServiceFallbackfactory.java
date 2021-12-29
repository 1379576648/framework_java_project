package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.service.client.system.RegisterLogClinetService;
import com.trkj.framework.vo.AjaxResponse;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 13795
 */
//降级~
@Component
public class RegisterLogClinetServiceFallbackfactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new RegisterLogClinetService() {
            @Override
            public AjaxResponse selectRegisterLogAll( @RequestBody  RegisterLog registerLog) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object checkDelete(@RequestBody  ArrayList<Integer> list) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object emptyList() {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }
        };
    }
}
