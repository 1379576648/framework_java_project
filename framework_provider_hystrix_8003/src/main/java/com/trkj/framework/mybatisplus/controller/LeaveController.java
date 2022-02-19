package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Card;
import com.trkj.framework.entity.mybatisplus.Leave;
import com.trkj.framework.mybatisplus.service.LeaveService;
import com.trkj.framework.util.Fuse8003Util;
import com.trkj.framework.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 请假 --前端控制器
 *
 * @author 里予
 * @since 2022-1-2
 */
@RestController
public class LeaveController {
    @Autowired
    private LeaveService leaveService;
    @Autowired
    private Fuse8003Util fuse8003Util;

    /**
     * 根据审批类型的请假/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectLeaveAll")
    @HystrixCommand(fallbackMethod = "HystixGet1")
    public Map<String, Object> selectLeaveAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", leaveService.selectLeaveAll(auditflowone));
        return map1;
    }

    public Map<String, Object> HystixGet1(@RequestBody Auditflowone auditflowone) {
        return fuse8003Util.main();
    }

    /**
     * 根据审批类型的请假/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndLeaveAll")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Map<String, Object> selectEndLeaveAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", leaveService.selectEndLeaveAll(auditflowone));
        return map1;
    }

    public Map<String, Object> HystixGet2(@RequestBody Auditflowone auditflowone) {
        return fuse8003Util.main();
    }

    /**
     * 根据审批类型的加班/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsLeaves")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Map<String, Object> selectDetailsLeaves(@RequestBody LeaveDetailsVo leaveDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", leaveService.selectDetailsLeaves(leaveDetailsVo));
        return map1;
    }

    public Map<String, Object> HystixGet3(@RequestBody LeaveDetailsVo leaveDetailsVo) {
        return fuse8003Util.main();
    }

    /**
     * 根据员工名称及请假类型是否有请假记录
     *
     * @param
     * @return
     */
    @PostMapping("/selectLeaveExamine")
    @HystrixCommand(fallbackMethod = "selectLeaveExamineHystixGet")
    public Map<String, Object> selectLeaveExamine(@RequestBody LeaveDetailsVo leaveDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", leaveService.selectLeaveExamine(leaveDetailsVo));
        return map1;
    }

    public Map<String, Object> selectLeaveExamineHystixGet(@RequestBody LeaveDetailsVo leaveDetailsVo) {
        return fuse8003Util.main();
    }

    /**
     * 添加请假 添加三个审批人
     *
     * @param leaveVo
     * @return
     */
    @PostMapping("/submitToAskForLeave3")
    @HystrixCommand(fallbackMethod = "submitToAskForLeave3ExamineHystixGet")
    public Map<String, Object> submitToAskForLeave3(@RequestBody LeaveVo leaveVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        try {
            map1.put("info", leaveService.submitToAskForLeave3(leaveVo));
        } catch (ArithmeticException e) {
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    public Map<String, Object> submitToAskForLeave3ExamineHystixGet(@RequestBody LeaveVo leaveVo) {
        return fuse8003Util.main();
    }

    /**
     * 添加请假 添加两个审批人
     *
     * @param leaveVo
     * @return
     */
    @PostMapping("/submitToAskForLeave2")
    @HystrixCommand(fallbackMethod = "submitToAskForLeave2ExamineHystixGet")
    public Map<String, Object> submitToAskForLeave2(@RequestBody LeaveVo leaveVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        try {
            map1.put("info", leaveService.submitToAskForLeave2(leaveVo));
        } catch (ArithmeticException e) {
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    public Map<String, Object> submitToAskForLeave2ExamineHystixGet(@RequestBody LeaveVo leaveVo) {
        return fuse8003Util.main();
    }

    /**
     * 添加请假 添加一个审批人
     *
     * @param leaveVo
     * @return
     */
    @PostMapping("/submitToAskForLeave1")
    @HystrixCommand(fallbackMethod = "submitToAskForLeave1ExamineHystixGet")
    public Map<String, Object> submitToAskForLeave1(@RequestBody LeaveVo leaveVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        try {
            map1.put("info", leaveService.submitToAskForLeave1(leaveVo));
        } catch (ArithmeticException e) {
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    public Map<String, Object> submitToAskForLeave1ExamineHystixGet(@RequestBody LeaveVo leaveVo) {
        return fuse8003Util.main();
    }

}
