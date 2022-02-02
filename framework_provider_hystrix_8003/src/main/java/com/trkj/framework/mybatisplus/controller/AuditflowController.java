package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Auditflow;
import com.trkj.framework.entity.mybatisplus.Auditflowdetail;
import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.mybatisplus.service.AuditflowService;
import com.trkj.framework.vo.*;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 加班 前端控制器
 *
 * @author 劉祁
 * @since 2021-12-27
 */
@RestController
public class AuditflowController {
    @Autowired
    private AuditflowService auditflowService;

    /**
     * 根据审批类型的加班/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectAuditflow")
    @HystrixCommand(fallbackMethod = "HystixGet1")
    public Object selectAuditflowoneAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", auditflowService.selectAuditflowoneAll(auditflowone));
        return map1;
    }

    public Object HystixGet1(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据审批类型的加班/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEnddAuditflow")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object selectEnddAuditflow(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", auditflowService.selectEnddAuditflow(auditflowone));
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
     * @param auditflowDetailsVo
     * @return
     */
    @PostMapping("/selectDetailsAuditflow")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Object selectDetailsAuditflow(@RequestBody AuditflowDetailsVo auditflowDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.selectDetailsAuditflow(auditflowDetailsVo));
        return map1;
    }

    public Object HystixGet3(@RequestBody AuditflowDetailsVo auditflowDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据员工名称查询其状态
     * @param staff
     * @return
     */
    @PostMapping("/selectStaffState")
    public Object selectStaffState(@RequestBody Staff staff){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.selectStaffState(staff));
        return map1;
    }

    /**
     * 根据审批明细表ID修改其状态 通过
     *
     * @param
     * @return
     */
    @PostMapping("/update_Approval_State")
    public int updateApprovalState(@RequestBody Auditflowdetail auditflowdetail1) {
        auditflowdetail1.setAuditflowdetaiState(2);
        auditflowdetail1.setAuditflowdetaiDate(new Date());
        auditflowdetail1.setAuditflowdetaiRemarks(auditflowdetail1.getAuditflowdetaiRemarks());
        final var i = auditflowService.updateApprovalState(auditflowdetail1);
        if (i==1){
            return 666;
        }else {
            return 999;
        }
    }

    /**
     * 根据审批明细表ID修改其状态 驳回
     * @param auditflowdetail1
     * @return
     */
    @PostMapping("/reject_Approval_State")
    public int rejectApprovalState(@RequestBody Auditflowdetail auditflowdetail1) {
        auditflowdetail1.setAuditflowdetaiState(3);
        auditflowdetail1.setAuditflowdetaiDate(new Date());
        auditflowdetail1.setAuditflowdetaiRemarks(auditflowdetail1.getAuditflowdetaiRemarks());
        final var i = auditflowService.rejectApprovalState(auditflowdetail1);
        if (i==1){
            return 666;
        }else {
            return 999;
        }
    }

    /**
     * 根据审批编号查询对应的审批明细表编号
     *
     * @param auditflowdetail
     * @return
     */
    @PostMapping("/queryDetail")
    @HystrixCommand(fallbackMethod = "HystixGet5")
    public Object queryDetail(@RequestBody Auditflowdetail auditflowdetail) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.queryDetail(auditflowdetail));
        return map1;
    }

    public Object HystixGet5(@RequestBody Auditflowdetail auditflowdetail) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据员工名称是否有加班记录
     * @param
     * @return
     */
    @PostMapping("/selectOvertimeExamine")
    @HystrixCommand(fallbackMethod = "selectOvertimeExamineHystixGet")
    public Object selectOvertimeExamine(@RequestBody OvertimeaskVo overtimeaskVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.selectOvertimeExamine(overtimeaskVo));
        return map1;
    }
    public Object selectOvertimeExamineHystixGet(@RequestBody OvertimeaskVo overtimeaskVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 添加加班 添加三个审批人
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime3")
    public int submitToOvertime3(@RequestBody OvertimeaskVo overtimeaskVo){
        return  auditflowService.submitToOvertime3(overtimeaskVo);
    }

    /**
     * 添加加班 添加两个审批人
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime2")
    public int submitToOvertime2(@RequestBody OvertimeaskVo overtimeaskVo){
        return  auditflowService.submitToOvertime2(overtimeaskVo);
    }

    /**
     * 添加加班 添加一个审批人
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime1")
    @HystrixCommand(fallbackMethod = "submitToOvertime1ExamineHystixGet")
    public Object submitToOvertime1(@RequestBody OvertimeaskVo overtimeaskVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.submitToOvertime1(overtimeaskVo));
        return map1;
    }

    public Object submitToOvertime1ExamineHystixGet(@RequestBody OvertimeaskVo overtimeaskVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }


    /**
     * 根据员工编号查询部门职位
     * @param staff
     * @return
     */
    @PostMapping("/inquirePosition")
    @HystrixCommand(fallbackMethod = "inquirePositionExamineHystixGet")
    public Object inquirePosition(@RequestBody Staff staff){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.inquirePosition(staff));
        return map1;
    }
    public Object inquirePositionExamineHystixGet(@RequestBody Staff staff) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 撤销审批
     * @param
     * @return
     */
    @PostMapping("/revocation")
    @HystrixCommand(fallbackMethod = "submitToOvertime1ExamineHystixGet")
    public Object revocation(@RequestBody Auditflow auditflow){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.revocation(auditflow));
        return map1;
    }
    public Object submitToOvertime1ExamineHystixGet(@RequestBody Auditflow auditflow) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 查询调薪审批数据详情
     * @param salaryVo
     * @return
     */
    @PostMapping("/selectSalaryDetails")
    public Object selectSalaryDetails(@RequestBody SalaryVo salaryVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.selectSalaryDetails(salaryVo));
        return map1;
    }

    /**
     * 查询当天的加班审批记录
     * @param auditflow
     * @return
     */
    @PostMapping("/selectTodayOverTimeExamine")
    public Object selectTodayOverTimeExamine(@RequestBody Auditflow auditflow){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.selectTodayOverTimeExamine(auditflow));
        return map1;
    }
}

