package com.trkj.framework.service.client.examine;

import com.trkj.framework.entity.mybatisplus.Auditflowdetail;
import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.service.client.fallbackfactory.AuditflowClinetServiceFallbackfactory;
import com.trkj.framework.service.client.fallbackfactory.RegisterClinetServiceFallbackfactory;
import com.trkj.framework.vo.*;
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
     * 根据审批类型的加班/审批人查询已处理的审批
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

    /**
     * 根据审批类型的请假/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEndLeaveAll")
    Object selectEndLeaveAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的请假/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsLeaves")
    Object selectDetailsLeaves(@RequestBody LeaveDetailsVo leaveDetailsVo);

    /**
     * 根据审批类型的请假/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectTravelAll")
    Object selectTravelAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的请假/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEndTravelAll")
    Object selectEndTravelAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的请假/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsTrave")
    Object selectDetailsTrave(@RequestBody TravelDetailsVo travelDetailsVo);

    /**
     * 根据审批类型的请假/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectCardAll")
    Object selectCardAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的请假/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEndCardAll")
    Object selectEndCardAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的请假/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsCards")
    Object selectDetailsCards(@RequestBody CardDetailsVo cardDetailsVo);

    /**
     * 根据审批类型的离职/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectQuitAll")
    Object selectQuitAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的离职/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEndQuitAll")
    Object selectEndQuitAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的离职/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsQuit")
    Object selectDetailsQuit(@RequestBody QuitDetailsVo quitDetailsVo);

    /**
     * 根据审批类型的调薪/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectSalaryAll")
    Object selectSalaryAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的调薪/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEndSalaryAll")
    Object selectEndSalaryAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的调薪/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsSalary")
    Object selectDetailsSalary(@RequestBody SalaryDetailsVo salaryDetailsVo);

    /**
     * 根据审批类型的调薪/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectTransferAll")
    Object selectTransferAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的调薪/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEndTransferAll")
    Object selectEndTransferAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的调薪/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsTransfer")
    Object selectDetailsTransfer(@RequestBody TransferDetailsVo transferDetailsVo);

    /**
     * 根据审批类型的转正/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectWorkerlAll")
    Object selectWorkerlAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的转正/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEndWorkerlAll")
    Object selectEndWorkerlAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的转正/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsWorker")
    Object selectDetailsWorker(@RequestBody WorkerDetaIsVo workerDetaIsVo);
}
