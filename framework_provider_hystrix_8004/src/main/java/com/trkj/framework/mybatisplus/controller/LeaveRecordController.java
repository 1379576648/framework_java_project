package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Leave;
import com.trkj.framework.entity.mybatisplus.Overtimeask;
import com.trkj.framework.mybatisplus.service.CardRecordService;
import com.trkj.framework.mybatisplus.service.LeaveRecordService;
import com.trkj.framework.util.Fuse8004Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请假记录 前端控制器
 *
 * @author 112729
 */
@RestController
public class LeaveRecordController {
    @Autowired
    private LeaveRecordService leaveRecordService;
    @Autowired
    private Fuse8004Util fuse8004Util;
    /**
     * 根据员工名称查询请假记录
     *
     * @param
     * @return
     */
    @PostMapping("/selectLeaveRecordAll")
    @HystrixCommand(fallbackMethod = "selectLeaveRecordAllHystixGet")
    public Map<String, Object> selectLeaveRecordAll(@RequestBody Leave leave) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", leaveRecordService.selectLeaveRecordAll(leave));
        return map1;
    }

    public Map<String, Object> selectLeaveRecordAllHystixGet(@RequestBody Leave leave) {
        return fuse8004Util.main();
    }

    /**
     * 删除请假记录
     *
     * @param leave
     * @return
     */
    @PostMapping("/deleteLeave")
    @HystrixCommand(fallbackMethod = "deleteLeaveHystixGet")
    public Map<String, Object> deleteLeave(@RequestBody Leave leave) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", leaveRecordService.deleteLeave(leave));
        return map1;
    }

    public Map<String, Object> deleteLeaveHystixGet(@RequestBody Leave leave) {
        return fuse8004Util.main();
    }

    /**
     * 开始请假
     *
     * @param leave
     * @return
     */
    @PostMapping("/updateBeginLeave")
    @HystrixCommand(fallbackMethod = "updateBeginLeaveHystixGet")
    public Map<String, Object> updateBeginLeave(@RequestBody Leave leave) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", leaveRecordService.updateBeginLeave(leave));
        return map1;
    }

    public Map<String, Object> updateBeginLeaveHystixGet(@RequestBody Leave leave) {
        return fuse8004Util.main();
    }

    /**
     * 结束请假
     *
     * @param leave
     * @return
     */
    @PostMapping("/updateEndLeave")
    @HystrixCommand(fallbackMethod = "updateEndLeaveHystixGet")
    public Map<String, Object> updateEndLeave(@RequestBody Leave leave) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", leaveRecordService.updateEndLeave(leave));
        return map1;
    }

    public Map<String, Object> updateEndLeaveHystixGet(@RequestBody Leave leave) {
        return fuse8004Util.main();
    }

}
