package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.vo.AjaxResponse;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

//降级~
@Component
public class AuditflowClinetServiceFallbackfactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new AuditflowService(){
            @Override
            public Object queryemp(int currentPage, int pagesize) {
                Map<String, Object> map=new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            @Override
            public Object queryemp1(int currentPage, int pagesize) {
                Map<String, Object> map=new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }
        };
    }
}
