package com.trkj.framework.service.client.checking;

import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Overtimeask;
import com.trkj.framework.service.client.fallbackfactory.CheckingServiceFallbackfactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "FRAMEWORK-ZUUL/8004/provider", fallbackFactory = CheckingServiceFallbackfactory.class)
public interface CheckingService {

    /**
     * 根据员工名称查询打卡记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectCardRecordAll")
    Object selectCardRecordAll(@RequestBody ClockRecord cardRecord);

    /**
     * 根据员工名称查询打卡记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectOverTimeRecordAll")
    Object selectOverTimeRecordAll(@RequestBody Overtimeask overtimeask);
}
