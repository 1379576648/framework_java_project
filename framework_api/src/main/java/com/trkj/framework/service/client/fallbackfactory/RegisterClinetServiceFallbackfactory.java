package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.service.client.register.RegisterClinetService;
import com.trkj.framework.service.client.util.FuseUtil;
import com.trkj.framework.vo.AjaxResponse;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 13795
 */
//降级~
@Component
public class RegisterClinetServiceFallbackfactory implements FallbackFactory {
    @Autowired
    private FuseUtil fuseUtil;
    @Override
    public Object create(Throwable throwable) {
        return new RegisterClinetService() {

            @Override
             public Map<String,Object> register(Map<String, Object> map) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> login(Map<String, Object> map) {
                return fuseUtil.main(throwable);
            }
        };
    }
}
