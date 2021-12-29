package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.service.client.hire.HireClientService;
import com.trkj.framework.vo.AjaxResponse;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import java.util.Map;
@Component
public class HireClientServiceFallbackfactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new HireClientService() {
            /**
             * 查询已录用待入职的员工
             */
            @Override
            public Object selecthirepage(int currentPage, int pagesize) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            /**
             * 查询已经淘汰的员工
             */
            @Override
            public Object selectabandon(int currentPage, int pagesize) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state",100);
                objectMap.put("info","服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object selectwork(int currentPage, int pagesize) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
                    }
                };
        }
}
