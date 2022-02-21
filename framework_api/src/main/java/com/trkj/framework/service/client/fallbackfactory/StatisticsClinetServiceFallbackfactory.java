package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.service.client.statistics.StatisticsClinetService;
import com.trkj.framework.service.client.util.FuseUtil;
import com.trkj.framework.vo.AjaxResponse;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author TanWei
 */
@Component
public class StatisticsClinetServiceFallbackfactory implements FallbackFactory {

    @Autowired
    private FuseUtil fuseUtil;
    @Override
    public Object create(Throwable throwable) {
        return new StatisticsClinetService() {
            @Override
            public Map<String,Object> querySex() {
              return   fuseUtil.main(throwable);
            }
        };
    }
}
