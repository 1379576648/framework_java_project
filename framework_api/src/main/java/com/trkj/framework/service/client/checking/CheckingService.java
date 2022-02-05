package com.trkj.framework.service.client.checking;

import com.trkj.framework.entity.mybatisplus.*;
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
     * 根据员工名称查询加班记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectOverTimeRecordAll")
    Object selectOverTimeRecordAll(@RequestBody Overtimeask overtimeask);

    /**
     * 删除打卡记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteClock")
    Object deleteClock(@RequestBody ClockRecord cardRecord);

    /**
     * 删除加班记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteOverTime")
    Object deleteOverTime(@RequestBody Overtimeask overtimeask);

    /**
     * 根据员工名称查询加班记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectLeaveRecordAll")
    Object selectLeaveRecordAll(@RequestBody Leave leave);

    /**
     * 删除加班记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteLeave")
    Object deleteLeave(@RequestBody Leave leave);

    /**
     * 根据员工名称查询加班记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEvectionRecordAll")
    Object selectEvectionRecordAll(@RequestBody Travel travel);

    /**
     * 删除加班记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteEvection")
    Object deleteEvection(@RequestBody Travel travel);

    /**
     * 根据员工名称查询补打卡记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectReissueCardRecordAll")
    Object selectReissueCardRecordAll(@RequestBody Card card);

    /**
     * 删除补打卡记录
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteCard")
    Object deleteCard(@RequestBody Card card);
}
