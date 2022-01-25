package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Card;
import com.trkj.framework.entity.mybatisplus.Leave;
import com.trkj.framework.mybatisplus.service.LeaveService;
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

    /**
     * 根据审批类型的请假/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectLeaveAll")
    @HystrixCommand(fallbackMethod = "HystixGet1")
    public Object selectLeaveAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", leaveService.selectLeaveAll(auditflowone));
        return map1;
    }

    public Object HystixGet1(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据审批类型的请假/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndLeaveAll")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object selectEndLeaveAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", leaveService.selectEndLeaveAll(auditflowone));
        return map1;
    }

    public Object HystixGet2(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据审批类型的加班/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsLeaves")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Object selectDetailsLeaves(@RequestBody LeaveDetailsVo leaveDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", leaveService.selectDetailsLeaves(leaveDetailsVo));
        return map1;
    }

    public Object HystixGet3(@RequestBody LeaveDetailsVo leaveDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据员工名称及请假类型是否有请假记录
     * @param
     * @return
     */
    @PostMapping("/selectLeaveExamine")
    public Object selectLeaveExamine(@RequestBody LeaveDetailsVo leaveDetailsVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", leaveService.selectLeaveExamine(leaveDetailsVo));
        return map1;
    }

    /**
     * 添加请假 添加三个审批人
     * @param leaveVo
     * @return
     */
    @PostMapping("/submitToAskForLeave3")
    public int submitToAskForLeave3(@RequestBody LeaveVo leaveVo){
        return  leaveService.submitToAskForLeave3(leaveVo);
    }

    /**
     * 添加请假 添加两个审批人
     * @param leaveVo
     * @return
     */
    @PostMapping("/submitToAskForLeave2")
    public int submitToAskForLeave2(@RequestBody LeaveVo leaveVo){
        return  leaveService.submitToAskForLeave2(leaveVo);
    }

    /**
     * 添加请假 添加一个审批人
     * @param leaveVo
     * @return
     */
    @PostMapping("/submitToAskForLeave1")
    @HystrixCommand(fallbackMethod = "submitToAskForLeave1ExamineHystixGet")
    public Object submitToAskForLeave1(@RequestBody LeaveVo leaveVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", leaveService.submitToAskForLeave1(leaveVo));
        return map1;
    }

    public Object submitToAskForLeave1ExamineHystixGet(@RequestBody LeaveVo leaveVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

}
