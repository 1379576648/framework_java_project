package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Auditflow;
import com.trkj.framework.entity.mybatisplus.Auditflowdetail;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.vo.*;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuditflowController {
    @Autowired
    private AuditflowService auditflowService =null;

    /**
     * 根据审批类型的加班/审批人查询待处理的审批
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectAuditflow")
    public AjaxResponse selectAuditflowoneAll(@RequestBody Auditflowone auditflowone){
        return AjaxResponse.success(auditflowService.selectAuditflowoneAll(auditflowone)) ;
    }

    /**
     * 根据审批类型的加班/审批人查询已处理的审批
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEnddAuditflow")
    public AjaxResponse selectEnddAuditflow(@RequestBody Auditflowone auditflowone){
        return AjaxResponse.success(auditflowService.selectEnddAuditflow(auditflowone)) ;
    }

    /**
     * 根据审批类型的加班/审批人查询待处理的审批详情信息
     * @param auditflowDetailsVo
     * @return
     */
    @PostMapping("/selectDetailsAuditflow")
    public AjaxResponse selectDetailsAuditflow(@RequestBody AuditflowDetailsVo auditflowDetailsVo){
        return AjaxResponse.success(auditflowService.selectDetailsAuditflow(auditflowDetailsVo)) ;
    }

    /**
     * 根据员工名称查询其状态
     * @param staff
     * @return
     */
    @PostMapping("/selectStaffState")
    public AjaxResponse selectStaffState(@RequestBody Staff staff){
        return AjaxResponse.success(auditflowService.selectStaffState(staff)) ;
    }


    /**
     *根据审批明细表ID修改其状态 通过
     * @param auditflowdetail
     * @return
     */
    @PostMapping("/update_Approval_State")
    public AjaxResponse updateApprovalState(@RequestBody Auditflowdetail auditflowdetail) {
        return  AjaxResponse.success(auditflowService.updateApprovalState(auditflowdetail));
    }

    /**
     *根据审批明细表ID修改其状态 驳回
     * @param auditflowdetail
     * @return
     */
    @PostMapping("/reject_Approval_State")
    public AjaxResponse rejectApprovalState(@RequestBody Auditflowdetail auditflowdetail) {
        return  AjaxResponse.success(auditflowService.rejectApprovalState(auditflowdetail));
    }

    /**
     * 根据审批编号查询对应的审批明细表状态
     * @param auditflowdetail
     * @return
     */
    @PostMapping("/queryDetail")
    public AjaxResponse queryDetail(@RequestBody Auditflowdetail auditflowdetail){
        return  AjaxResponse.success(auditflowService.queryDetail(auditflowdetail));
    }

    /**
     * 根据员工名称是否有加班记录
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/selectOvertimeExamine")
    public AjaxResponse selectOvertimeExamine(@RequestBody OvertimeaskVo overtimeaskVo){
        return AjaxResponse.success(auditflowService.selectOvertimeExamine(overtimeaskVo));
    }

    /**
     * 添加加班 三个审批人
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime3")
    public AjaxResponse submitToOvertime3(@RequestBody OvertimeaskVo overtimeaskVo){
        return AjaxResponse.success(auditflowService.submitToOvertime3(overtimeaskVo));
    }

    /**
     * 添加加班 两个审批人
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime2")
    public AjaxResponse submitToOvertime2(@RequestBody OvertimeaskVo overtimeaskVo){
        return AjaxResponse.success(auditflowService.submitToOvertime2(overtimeaskVo));
    }

    /**
     * 添加加班 一个审批人
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime1")
    public AjaxResponse submitToOvertime1(@RequestBody OvertimeaskVo overtimeaskVo){
        return AjaxResponse.success(auditflowService.submitToOvertime1(overtimeaskVo));
    }

    /**
     * 根据员工编号查询部门职位
     * @param staff
     * @return
     */
    @PostMapping("/inquirePosition")
    public AjaxResponse inquirePosition(@RequestBody Staff staff){
        return AjaxResponse.success(auditflowService.inquirePosition(staff));
    }

    /**
     * 撤销审批
     * @param auditflow
     * @return
     */
    @PostMapping("/revocation")
    public AjaxResponse revocation(@RequestBody Auditflow auditflow){
        return AjaxResponse.success(auditflowService.revocation(auditflow));
    }

    /**
     * 查询当天的加班审批记录
     * @param auditflow
     * @return
     */
    @PostMapping("/selectTodayOverTimeExamine")
    public AjaxResponse selectTodayOverTimeExamine(@RequestBody Auditflow auditflow){
        return AjaxResponse.success(auditflowService.selectTodayOverTimeExamine(auditflow));
    }
}
