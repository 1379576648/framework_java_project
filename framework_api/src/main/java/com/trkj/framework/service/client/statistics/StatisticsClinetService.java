package com.trkj.framework.service.client.statistics;


import com.trkj.framework.service.client.fallbackfactory.StatisticsClinetServiceFallbackfactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * @author TanWei
 */

@FeignClient(value = "FRAMEWORK-ZUUL/8011/provider" , fallbackFactory = StatisticsClinetServiceFallbackfactory.class)
public interface StatisticsClinetService {
    /**
     * 员工性别查询
     * @return
     */
    @GetMapping("/selectStaffSex")
    Object querySex();
}
