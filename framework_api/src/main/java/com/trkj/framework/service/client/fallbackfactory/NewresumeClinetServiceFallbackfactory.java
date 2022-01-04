package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.service.client.recruitment.NewresumeClinetService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.ResumeVo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//降级~
@Component
public class NewresumeClinetServiceFallbackfactory implements FallbackFactory {

    @Override
    public Object create(Throwable throwable) {
        return new NewresumeClinetService() {
            @Override
            public Object queryResume(ResumeVo resumeVo) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }

            @Override
            public Object queryAll(int currenPage, int pagesize) {
                Map<String, Object> objectMap = new HashMap<>(2);
                objectMap.put("state", 100);
                objectMap.put("info", "服务发生关闭");
                return AjaxResponse.success(objectMap);
            }
        };
    }
}
