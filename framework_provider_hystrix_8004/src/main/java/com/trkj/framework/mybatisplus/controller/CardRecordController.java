package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.mybatisplus.service.CardRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * 打卡记录 前端控制器
 */
@RestController
public class CardRecordController {
    @Autowired
    private CardRecordService cardRecordService;

    /**
     * 根据员工名称查询打卡记录
     * @param cardRecord
     * @return
     */
    @PostMapping("/selectCardRecordAll")
    @HystrixCommand(fallbackMethod = "selectCardRecordAllHystixGet")
    public Object selectCardRecordAll(@RequestBody ClockRecord cardRecord) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", cardRecordService.selectCardRecordAll(cardRecord));
        return map1;
    }
    public Object selectCardRecordAllHystixGet(@RequestBody ClockRecord cardRecord) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 删除打卡记录
     * @param cardRecord
     * @return
     */
    @PostMapping("/deleteClock")
    @HystrixCommand(fallbackMethod = "deleteClockHystixGet")
    public Object deleteClock(@RequestBody ClockRecord cardRecord) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", cardRecordService.deleteClock(cardRecord));
        return map1;
    }
    public Object deleteClockHystixGet(@RequestBody ClockRecord cardRecord) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }
}
