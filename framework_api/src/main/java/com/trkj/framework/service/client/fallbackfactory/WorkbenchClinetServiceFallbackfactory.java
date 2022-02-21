package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.service.client.util.FuseUtil;
import com.trkj.framework.service.client.workbench.WorkbenchClinetService;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 13795
 */
@Component
public class WorkbenchClinetServiceFallbackfactory implements FallbackFactory {
    @Autowired
    private FuseUtil fuseUtil;
    @Override
    public Object create(Throwable throwable) {
        return new WorkbenchClinetService() {
            @Override
            public Map<String, Object> selectNoticeStaffId(Integer integer) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String, Object> updateNoticeOrId(Integer integer1, Integer integer2) {
                return fuseUtil.main(throwable);
            }
        };
    }
}
