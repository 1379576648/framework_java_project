package com.trkj.framework.service.client.examine;

import com.trkj.framework.entity.mybatisplus.Auditflowdetail;
import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.service.client.fallbackfactory.AuditflowClinetServiceFallbackfactory;
import com.trkj.framework.service.client.fallbackfactory.RegisterClinetServiceFallbackfactory;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.AuditflowDetailsVo;
import com.trkj.framework.vo.Auditflowone;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "REGISTER-8003/provider", fallbackFactory = AuditflowClinetServiceFallbackfactory.class)
public interface AuditflowService {

    /**
     * 根据审批类型的加班/审批人查询待处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectAuditflow")
    Object selectAuditflowoneAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的加班/审批人查询待处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEnddAuditflow")
    Object selectEnddAuditflow(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的加班/审批人查询待处理的审批详情信息
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectDetailsAuditflow")
    Object selectDetailsAuditflow(@RequestBody AuditflowDetailsVo auditflowDetailsVo);

    /**
     * 根据审批明细表修改其状态 通过
     * @param
     * @param
     * @return
     */
    @PostMapping("/update_Approval_State")
    Object updateApprovalState(@RequestBody Auditflowdetail auditflowdetail);

    /**
     * 根据审批明细表修改其状态 驳回
     * @param
     * @param
     * @return
     */
    @PostMapping("/reject_Approval_State")
    Object rejectApprovalState(@RequestBody Auditflowdetail auditflowdetail);

    /**
     * 根据审批编号查询对应的审批明细表状态
     * @param auditflowdetail
     * @return
     */
    @PostMapping("/queryDetail")
    Object queryDetail(@RequestBody Auditflowdetail auditflowdetail);

    /**
     * 根据审批类型的请假/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectLeaveAll")
    Object selectLeaveAll(@RequestBody Auditflowone auditflowone);
}
