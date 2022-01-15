package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Auditflowdetail;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.vo.*;
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

}
