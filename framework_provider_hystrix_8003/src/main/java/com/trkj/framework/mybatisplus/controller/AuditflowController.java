package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.mybatisplus.service.AuditflowService;
import com.trkj.framework.util.Fuse8003Util;
import com.trkj.framework.vo.*;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 加班 前端控制器
 *
 * @author
 * @since 2021-12-27
 */
@RestController
public class AuditflowController {
    @Autowired
    private AuditflowService auditflowService;
    @Autowired
    private Fuse8003Util fuse8003Util;

    /**
     * 根据审批类型的加班/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectAuditflow")
    @HystrixCommand(fallbackMethod = "HystixGet1")
    public Map<String, Object> selectAuditflowoneAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", auditflowService.selectAuditflowoneAll(auditflowone));
        return map1;
    }

    public Map<String, Object> HystixGet1(@RequestBody Auditflowone auditflowone) {
        return fuse8003Util.main();
    }

    /**
     * 根据审批类型的加班/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEnddAuditflow")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Map<String, Object> selectEnddAuditflow(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", auditflowService.selectEnddAuditflow(auditflowone));
        return map1;
    }

    public Map<String, Object> HystixGet2(@RequestBody Auditflowone auditflowone) {
        return fuse8003Util.main();
    }

    /**
     * 根据审批类型的加班/审批人查询已处理的详情信息
     *
     * @param auditflowDetailsVo
     * @return
     */
    @PostMapping("/selectDetailsAuditflow")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Map<String, Object> selectDetailsAuditflow(@RequestBody AuditflowDetailsVo auditflowDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.selectDetailsAuditflow(auditflowDetailsVo));
        return map1;
    }

    public Map<String, Object> HystixGet3(@RequestBody AuditflowDetailsVo auditflowDetailsVo) {
        return fuse8003Util.main();
    }

    /**
     * 根据员工名称查询其状态
     *
     * @param staff
     * @return
     */
    @PostMapping("/selectStaffState")
    @HystrixCommand(fallbackMethod = "selectStaffStateHystixGet")
    public Map<String, Object> selectStaffState(@RequestBody Staff staff) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.selectStaffState(staff));
        return map1;
    }

    public Map<String, Object> selectStaffStateHystixGet(@RequestBody Staff staff) {
        return fuse8003Util.main();
    }


    /**
     * 根据审批明细表ID修改其状态 通过
     *
     * @param
     * @return
     */
    @PostMapping("/update_Approval_State")
    @HystrixCommand(fallbackMethod = "update_Approval_StateHystixGet")
    public Map<String, Object> updateApprovalState(@RequestBody Auditflowdetail auditflowdetail1) {
        Map<String, Object> map1 = new HashMap<>(2);
        auditflowdetail1.setAuditflowdetaiState(2);
        auditflowdetail1.setAuditflowdetaiDate(new Date());
        auditflowdetail1.setAuditflowdetaiRemarks(auditflowdetail1.getAuditflowdetaiRemarks());
        try {
            final var i = auditflowService.updateApprovalState(auditflowdetail1);
            int i1;
            if (i == 1) {
                i1 = 666;
            } else if (i == 100) {
                i1 = 100;
            } else {
                i1 = 999;
            }
            map1.put("state", 200);
            map1.put("info", i1);
        } catch (ArithmeticException e) {
            map1.put("state", 200);
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    public Map<String, Object> update_Approval_StateHystixGet(@RequestBody Auditflowdetail auditflowdetail1) {
        return fuse8003Util.main();
    }

    /**
     * 根据审批明细表ID修改其状态 驳回
     *
     * @param auditflowdetail1
     * @return
     */
    @PostMapping("/reject_Approval_State")
    @HystrixCommand(fallbackMethod = "reject_Approval_StateHystixGet")
    public Map<String, Object> rejectApprovalState(@RequestBody Auditflowdetail auditflowdetail1) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        try {
            auditflowdetail1.setAuditflowdetaiState(3);
            auditflowdetail1.setAuditflowdetaiDate(new Date());
            auditflowdetail1.setAuditflowdetaiRemarks(auditflowdetail1.getAuditflowdetaiRemarks());
            final var i = auditflowService.rejectApprovalState(auditflowdetail1);
            int i1;
            if (i == 1) {
                i1 = 666;
            } else if (i == 100) {
                i1 = 100;
            } else {
                i1 = 999;
            }
            map1.put("info", i1);
        }catch(ArithmeticException e){
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    public Map<String, Object> reject_Approval_StateHystixGet(@RequestBody Auditflowdetail auditflowdetail1) {
        return fuse8003Util.main();
    }

    /**
     * 根据审批编号查询对应的审批明细表编号
     *
     * @param auditflowdetail
     * @return
     */
    @PostMapping("/queryDetail")
    @HystrixCommand(fallbackMethod = "HystixGet5")
    public Map<String, Object> queryDetail(@RequestBody Auditflowdetail auditflowdetail) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.queryDetail(auditflowdetail));
        return map1;
    }

    public Map<String, Object> HystixGet5(@RequestBody Auditflowdetail auditflowdetail) {
        return fuse8003Util.main();
    }

    /**
     * 根据员工名称是否有加班记录
     *
     * @param
     * @return
     */
    @PostMapping("/selectOvertimeExamine")
    @HystrixCommand(fallbackMethod = "selectOvertimeExamineHystixGet")
    public Map<String, Object> selectOvertimeExamine(@RequestBody OvertimeaskVo overtimeaskVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.selectOvertimeExamine(overtimeaskVo));
        return map1;
    }

    public Map<String, Object> selectOvertimeExamineHystixGet(@RequestBody OvertimeaskVo overtimeaskVo) {
        return fuse8003Util.main();
    }

    /**
     * 添加加班 添加三个审批人
     *
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime3")
    @HystrixCommand(fallbackMethod = "submitToOvertime3ExamineHystixGet")
    public Map<String, Object> submitToOvertime3(@RequestBody OvertimeaskVo overtimeaskVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        try {
            map1.put("info", auditflowService.submitToOvertime3(overtimeaskVo));
        }catch (ArithmeticException e){
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    public Map<String, Object> submitToOvertime3ExamineHystixGet(@RequestBody OvertimeaskVo overtimeaskVo) {
        return fuse8003Util.main();
    }

    /**
     * 添加加班 添加两个审批人
     *
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime2")
    @HystrixCommand(fallbackMethod = "submitToOvertime2ExamineHystixGet")
    public Map<String, Object> submitToOvertime2(@RequestBody OvertimeaskVo overtimeaskVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        try {
            map1.put("info", auditflowService.submitToOvertime2(overtimeaskVo));
        }catch (ArithmeticException e){
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    public Map<String, Object> submitToOvertime2ExamineHystixGet(@RequestBody OvertimeaskVo overtimeaskVo) {
        return fuse8003Util.main();
    }

    /**
     * 添加加班 添加一个审批人
     *
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime1")
    @HystrixCommand(fallbackMethod = "submitToOvertime1ExamineHystixGet")
    public Map<String, Object> submitToOvertime1(@RequestBody OvertimeaskVo overtimeaskVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        try {
            map1.put("info", auditflowService.submitToOvertime1(overtimeaskVo));
        }catch (ArithmeticException e){
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    public Map<String, Object> submitToOvertime1ExamineHystixGet(@RequestBody OvertimeaskVo overtimeaskVo) {
        return fuse8003Util.main();
    }


    /**
     * 根据员工编号查询部门职位
     *
     * @param staff
     * @return
     */
    @PostMapping("/inquirePosition")
    @HystrixCommand(fallbackMethod = "inquirePositionExamineHystixGet")
    public Map<String, Object> inquirePosition(@RequestBody Staff staff) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.inquirePosition(staff));
        return map1;
    }

    public Map<String, Object> inquirePositionExamineHystixGet(@RequestBody Staff staff) {
        return fuse8003Util.main();
    }

    /**
     * 撤销审批
     *
     * @param
     * @return
     */
    @PostMapping("/revocation")
    @HystrixCommand(fallbackMethod = "submitToOvertime1ExamineHystixGet")
    public Map<String, Object> revocation(@RequestBody Auditflow auditflow) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.revocation(auditflow));
        return map1;
    }

    public Map<String, Object> submitToOvertime1ExamineHystixGet(@RequestBody Auditflow auditflow) {
        return fuse8003Util.main();
    }

    /**
     * 查询调薪审批数据详情
     *
     * @param salaryVo
     * @return
     */
    @PostMapping("/selectSalaryDetails")
    @HystrixCommand(fallbackMethod = "selectSalaryDetailsExamineHystixGet")
    public Map<String, Object> selectSalaryDetails(@RequestBody SalaryVo salaryVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.selectSalaryDetails(salaryVo));
        return map1;
    }

    public Map<String, Object> selectSalaryDetailsExamineHystixGet(@RequestBody SalaryVo salaryVo) {
        return fuse8003Util.main();
    }

    /**
     * 查询当天的加班审批记录
     *
     * @param auditflow
     * @return
     */
    @PostMapping("/selectTodayOverTimeExamine")
    @HystrixCommand(fallbackMethod = "selectTodayOverTimeExamineExamineHystixGet")
    public Map<String, Object> selectTodayOverTimeExamine(@RequestBody Auditflow auditflow) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.selectTodayOverTimeExamine(auditflow));
        return map1;
    }

    public Map<String, Object> selectTodayOverTimeExamineExamineHystixGet(@RequestBody Auditflow auditflow) {
        return fuse8003Util.main();
    }

    /**
     * 查询当前员工是否有正在进行中的请假
     *
     * @param leave
     * @return
     */
    @PostMapping("/inquireUnderwayLeave")
    @HystrixCommand(fallbackMethod = "inquireUnderwayLeaveExamineHystixGet")
    public Map<String, Object> inquireUnderwayLeave(@RequestBody Leave leave) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.inquireUnderwayLeave(leave));
        return map1;
    }

    public Map<String, Object> inquireUnderwayLeaveExamineHystixGet(@RequestBody Leave leave) {
        return fuse8003Util.main();
    }

    /**
     * 查询当前员工是否有正在进行中的加班
     *
     * @param overtimeask
     * @return
     */
    @PostMapping("/inquireUnderwayOverTime")
    @HystrixCommand(fallbackMethod = "inquireUnderwayOverTimeExamineHystixGet")
    public Map<String, Object> inquireUnderwayOverTime(@RequestBody Overtimeask overtimeask) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.inquireUnderwayOverTime(overtimeask));
        return map1;
    }

    public Map<String, Object> inquireUnderwayOverTimeExamineHystixGet(@RequestBody Overtimeask overtimeask) {
        return fuse8003Util.main();
    }

    /**
     * 查询当前员工是否有正在进行中的出差
     *
     * @param travel
     * @return
     */
    @PostMapping("/inquireUnderwayTravel")
    @HystrixCommand(fallbackMethod = "inquireUnderwayTravelExamineHystixGet")
    public Map<String, Object> inquireUnderwayTravel(@RequestBody Travel travel) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.inquireUnderwayTravel(travel));
        return map1;
    }

    public Map<String, Object> inquireUnderwayTravelExamineHystixGet(@RequestBody Travel travel) {
        return fuse8003Util.main();
    }
}

