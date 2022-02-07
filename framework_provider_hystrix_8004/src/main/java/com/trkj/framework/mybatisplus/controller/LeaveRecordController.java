package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Leave;
import com.trkj.framework.mybatisplus.service.CardRecordService;
import com.trkj.framework.mybatisplus.service.LeaveRecordService;
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
 * @author 112729
 */
@RestController
public class LeaveRecordController {
    @Autowired
    private LeaveRecordService leaveRecordService;

    /**
     * 根据员工名称查询请假记录
     * @param
     * @return
     */
    @PostMapping("/selectLeaveRecordAll")
    @HystrixCommand(fallbackMethod = "selectLeaveRecordAllHystixGet")
    public Object selectLeaveRecordAll(@RequestBody Leave leave) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", leaveRecordService.selectLeaveRecordAll(leave));
        return map1;
    }
    public Object selectLeaveRecordAllHystixGet(@RequestBody Leave leave) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 删除请假记录
     * @param leave
     * @return
     */
    @PostMapping("/deleteLeave")
    @HystrixCommand(fallbackMethod = "deleteLeaveHystixGet")
    public Object deleteLeave(@RequestBody Leave leave) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", leaveRecordService.deleteLeave(leave));
        return map1;
    }
    public Object deleteLeaveHystixGet(@RequestBody Leave leave) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    @RequestMapping("/xlsx_two")
    public String xlsx_two(@RequestBody(required = false) List<Leave> list) throws ParseException {
        int sum = list.size();
        for(int i=0; i<sum; i++){
            leaveRecordService.save(list.get(i));
        }
        return "Success";
    }
}
