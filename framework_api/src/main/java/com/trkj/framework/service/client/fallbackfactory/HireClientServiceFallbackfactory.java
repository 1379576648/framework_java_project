package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.service.client.hire.HireClientService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.FullVo;
import com.trkj.framework.vo.HireVo;
import com.trkj.framework.vo.WorkVo;
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
            @Override
            public Object selecthirepage(HireVo hireVo) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state",100);
                objectMap.put("info","服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            /**
             * 查询已经淘汰的员工
             */
            @Override
            public Object selectabandon(HireVo hireVo) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state",100);
                objectMap.put("info","服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            /**
             *查询工作经历
             */
            @Override
            public Object selectwork(WorkVo workVo) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
                    }

            /**
             * 查询转正
             */
            @Override
            public Object selectpost(FullVo fullVo) {
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

        };
    }
}
