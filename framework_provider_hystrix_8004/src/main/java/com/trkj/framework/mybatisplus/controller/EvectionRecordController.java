package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Leave;
import com.trkj.framework.entity.mybatisplus.Travel;
import com.trkj.framework.mybatisplus.service.EvectionRecordService;
import com.trkj.framework.util.Fuse8004Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 出差记录 前端控制器
 *
 * @author 112729
 */
@RestController
public class EvectionRecordController {
    @Autowired
    private EvectionRecordService evectionRecordService;
    @Autowired
    private Fuse8004Util fuse8004Util;
    
    
    /**
     * 根据员工名称查询出差记录
     *
     * @param travel
     * @return
     */
    @PostMapping("/selectEvectionRecordAll")
    @HystrixCommand(fallbackMethod = "selectEvectionRecordAllHystixGet")
    public Map<String, Object> selectEvectionRecordAll(@RequestBody Travel travel) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", evectionRecordService.selectEvectionRecordAll(travel));
        return map1;
    }

    public Map<String, Object> selectEvectionRecordAllHystixGet(@RequestBody Travel travel) {
        return fuse8004Util.main();
    }

    /**
     * 删除出差记录
     *
     * @param travel
     * @return
     */
    @PostMapping("/deleteEvection")
    @HystrixCommand(fallbackMethod = "deleteEvectionHystixGet")
    public Map<String, Object> deleteEvection(@RequestBody Travel travel) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", evectionRecordService.deleteEvection(travel));
        return map1;
    }

    public Map<String, Object> deleteEvectionHystixGet(@RequestBody Travel travel) {
        return fuse8004Util.main();
    }

    /**
     * 开始请假
     *
     * @param travel
     * @return
     */
    @PostMapping("/updateBeginTravel")
    @HystrixCommand(fallbackMethod = "updateBeginTravelHystixGet")
    public Map<String, Object> updateBeginTravel(@RequestBody Travel travel) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", evectionRecordService.updateBeginTravel(travel));
        return map1;
    }

    public Map<String, Object> updateBeginTravelHystixGet(@RequestBody Travel travel) {
        return fuse8004Util.main();
    }

    /**
     * 结束请假
     *
     * @param travel
     * @return
     */
    @PostMapping("/updateEndTravel")
    @HystrixCommand(fallbackMethod = "updateEndTravelHystixGet")
    public Map<String, Object> updateEndTravel(@RequestBody Travel travel) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", evectionRecordService.updateEndTravel(travel));
        return map1;
    }

    public Map<String, Object> updateEndTravelHystixGet(@RequestBody Travel travel) {
        return fuse8004Util.main();
    }

}
