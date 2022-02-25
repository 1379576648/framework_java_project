package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.*;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AuditflowController {
    @Autowired
    private AuditflowService auditflowService =null;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 根据审批类型的加班/审批人查询待处理的审批
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectAuditflow")
    public AjaxResponse selectAuditflowoneAll(@RequestBody Auditflowone auditflowone){
        Map<String,Object> map = (Map<String, Object>)auditflowService.selectAuditflowoneAll(auditflowone);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据审批类型的加班/审批人查询已处理的审批
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEnddAuditflow")
    public AjaxResponse selectEnddAuditflow(@RequestBody Auditflowone auditflowone){
        Map<String,Object> map = (Map<String, Object>)auditflowService.selectEnddAuditflow(auditflowone); ;
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据审批类型的加班/审批人查询待处理的审批详情信息
     * @param auditflowDetailsVo
     * @return
     */
    @PostMapping("/selectDetailsAuditflow")
    public AjaxResponse selectDetailsAuditflow(@RequestBody AuditflowDetailsVo auditflowDetailsVo){
        Map<String,Object> map = (Map<String, Object>)auditflowService.selectDetailsAuditflow(auditflowDetailsVo); ;
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据员工名称查询其状态
     * @param staff
     * @return
     */
    @PostMapping("/selectStaffState")
    public AjaxResponse selectStaffState(@RequestBody Staff staff){
        Map<String,Object> map = (Map<String, Object>)auditflowService.selectStaffState(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }


    /**
     *根据审批明细表ID修改其状态 通过
     * @param auditflowdetail
     * @return
     */
    @PostMapping("/update_Approval_State")
    public AjaxResponse updateApprovalState(@RequestBody Auditflowdetail auditflowdetail) {
        Map<String,Object> map = (Map<String, Object>)auditflowService.updateApprovalState(auditflowdetail);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     *根据审批明细表ID修改其状态 驳回
     * @param auditflowdetail
     * @return
     */
    @PostMapping("/reject_Approval_State")
    public AjaxResponse rejectApprovalState(@RequestBody Auditflowdetail auditflowdetail) {
        Map<String,Object> map = (Map<String, Object>)auditflowService.rejectApprovalState(auditflowdetail);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据审批编号查询对应的审批明细表状态
     * @param auditflowdetail
     * @return
     */
    @PostMapping("/queryDetail")
    public AjaxResponse queryDetail(@RequestBody Auditflowdetail auditflowdetail){
        Map<String,Object> map = (Map<String, Object>)auditflowService.queryDetail(auditflowdetail);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据员工名称是否有加班记录
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/selectOvertimeExamine")
    public AjaxResponse selectOvertimeExamine(@RequestBody OvertimeaskVo overtimeaskVo){
        Map<String,Object> map = (Map<String, Object>)auditflowService.selectOvertimeExamine(overtimeaskVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加加班 三个审批人
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime3")
    public AjaxResponse submitToOvertime3(@RequestBody OvertimeaskVo overtimeaskVo){
        Map<String,Object> map = (Map<String, Object>)auditflowService.submitToOvertime3(overtimeaskVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加加班 两个审批人
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime2")
    public AjaxResponse submitToOvertime2(@RequestBody OvertimeaskVo overtimeaskVo){
        Map<String,Object> map = (Map<String, Object>)auditflowService.submitToOvertime2(overtimeaskVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加加班 一个审批人
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime1")
    public AjaxResponse submitToOvertime1(@RequestBody OvertimeaskVo overtimeaskVo){
        Map<String,Object> map = (Map<String, Object>)auditflowService.submitToOvertime1(overtimeaskVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据员工编号查询部门职位
     * @param staff
     * @return
     */
    @PostMapping("/inquirePosition")
    public AjaxResponse inquirePosition(@RequestBody Staff staff){
        Map<String,Object> map = (Map<String, Object>)auditflowService.inquirePosition(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 撤销审批
     * @param auditflow
     * @return
     */
    @PostMapping("/revocation")
    public AjaxResponse revocation(@RequestBody Auditflow auditflow){
        Map<String,Object> map = (Map<String, Object>)auditflowService.revocation(auditflow);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询当天的加班审批记录
     * @param auditflow
     * @return
     */
    @PostMapping("/selectTodayOverTimeExamine")
    public AjaxResponse selectTodayOverTimeExamine(@RequestBody Auditflow auditflow){
        Map<String,Object> map = (Map<String, Object>)auditflowService.selectTodayOverTimeExamine(auditflow);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询当前员工是否有正在进行中的请假
     * @param leave
     * @return
     */
    @PostMapping("/inquireUnderwayLeave")
    public AjaxResponse inquireUnderwayLeave(@RequestBody Leave leave){
        Map<String,Object> map = (Map<String, Object>)auditflowService.inquireUnderwayLeave(leave);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询当前员工是否有正在进行中的请假
     * @param overtimeask
     * @return
     */
    @PostMapping("/inquireUnderwayOverTime")
    public AjaxResponse inquireUnderwayOverTime(@RequestBody Overtimeask overtimeask){
        Map<String,Object> map = (Map<String, Object>)auditflowService.inquireUnderwayOverTime(overtimeask);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询当前员工是否有正在进行中的出差
     * @param travel
     * @return
     */
    @PostMapping("/inquireUnderwayTravel")
    public AjaxResponse inquireUnderwayTravel(@RequestBody Travel travel){
        Map<String,Object> map = (Map<String, Object>)auditflowService.inquireUnderwayTravel(travel);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
