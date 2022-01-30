package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Overtimeask;
import com.trkj.framework.mybatisplus.service.OverTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * 加班记录 前端控制器
 */
@RestController
public class OverTimeController {
    @Autowired
    private OverTimeService overTimeService;

    /**
     * 根据员工名称查询加班记录
     * @param overtimeask
     * @return
     */
    @PostMapping("/selectOverTimeRecordAll")
    @HystrixCommand(fallbackMethod = "selectOverTimeRecordAllHystixGet")
    public Object selectOverTimeRecordAll(@RequestBody Overtimeask overtimeask) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", overTimeService.selectOverTimeRecordAll(overtimeask));
        return map1;
    }
    public Object selectOverTimeRecordAllHystixGet(@RequestBody Overtimeask overtimeask) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }
}
