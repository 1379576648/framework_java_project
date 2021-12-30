package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.AuditflowDetailsVo;
import com.trkj.framework.vo.Auditflowone;
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
            public Object selectAuditflowoneAll(Auditflowone auditflowone) {
                Map<String, Object> map=new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            @Override
            public Object selectEnddAuditflow(Auditflowone auditflowone) {
                Map<String, Object> map=new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            @Override
            public Object selectDetailsAuditflow(AuditflowDetailsVo auditflowDetailsVo) {
                Map<String, Object> map=new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }
        };
    }
}
