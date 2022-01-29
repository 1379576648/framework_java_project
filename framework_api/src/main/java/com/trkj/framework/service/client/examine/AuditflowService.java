package com.trkj.framework.service.client.examine;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.fallbackfactory.AuditflowClinetServiceFallbackfactory;
import com.trkj.framework.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 13795
 */
@FeignClient(value = "FRAMEWORK-ZUUL/8003/provider", fallbackFactory = AuditflowClinetServiceFallbackfactory.class)
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
     * 根据员工名称查询其状态
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectStaffState")
    Object selectStaffState(@RequestBody Staff staff);

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
     * 根据审批类型的出差/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectTravelAll")
    Object selectTravelAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的出差/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEndTravelAll")
    Object selectEndTravelAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的出差/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsTrave")
    Object selectDetailsTrave(@RequestBody TravelDetailsVo travelDetailsVo);

    /**
     * 根据审批类型的补打卡/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectCardAll")
    Object selectCardAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的补打卡/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEndCardAll")
    Object selectEndCardAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的补打卡/审批人查询已处理的详情信息
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
     * 根据审批类型的调动/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectTransferAll")
    Object selectTransferAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的调动/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEndTransferAll")
    Object selectEndTransferAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的调动/审批人查询已处理的详情信息
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

    /**
     *  点击异动查询所有部门
     * @param
     * @return
     */
    @GetMapping("/selectDeptList")
    Object selectDeptAll();

    /**
     * 根据部门编号查询其部门经理
     * @return
     */
    @PostMapping("/selectDeptPostName")
    Object selectDeptPostName(@RequestBody DeptPostVo deptPostVo);

    /**
     * 根据部门编号查询部门名称
     * @param
     * @return
     */
    @PostMapping("/selectDeptName")
    Object selectDeptName(@RequestBody Dept dept);

    /**
     * 查询人事经理及总裁（总经理）
     * @return
     */
    @PostMapping("/selectpresident")
    Object selectpresident();

    /**
     * 添加转正 3个审批人
     * @param workerVo
     * @return
     */
    @PostMapping("/SubmitPositive3")
    Object SubmitPositive3(WorkerVo workerVo);

    /**
     * 添加转正 2个审批人
     * @param workerVo
     * @return
     */
    @PostMapping("/SubmitPositive2")
    Object SubmitPositive2(WorkerVo workerVo);

    /**
     * 添加转正 1个审批人
     * @param workerVo
     * @return
     */
    @PostMapping("/SubmitPositive1")
    Object SubmitPositive1(WorkerVo workerVo);

    /**
     * 根据员工名称是否有转正记录
     * @param workerVo
     * @return
     */
    @PostMapping("/selectexaminerecord")
    Object selectexaminerecord(WorkerVo workerVo);

    /**
     * 根据员工名称是否有异动记录
     * @param transferVo
     * @return
     */
    @PostMapping("/selectTransferRecord")
    Object selectTransferRecord(Transfer8003Vo transferVo);

    /**
     * 添加调动 3个审批人
     * @param transferVo
     * @return
     */
    @PostMapping("/SubmitTransfer3")
    Object SubmitTransfer3(Transfer8003Vo transferVo);

    /**
     * 添加调动 2个审批人
     * @param transferVo
     * @return
     */
    @PostMapping("/SubmitTransfer2")
    Object SubmitTransfer2(Transfer8003Vo transferVo);

    /**
     * 添加调动 1个审批人
     * @param transferVo
     * @return
     */
    @PostMapping("/SubmitTransfer1")
    Object SubmitTransfer1(Transfer8003Vo transferVo);

    /**
     * 添加调动 1个审批人
     * @param staff
     * @return
     */
    @PostMapping("/selectDeptPost")
    Object selectDeptPost(Staff staff);

    /**
     * 根据员工名称是否有调薪记录
     * @param salaryVo
     * @return
     */
    @PostMapping("/selectSalaryRecord")
    Object selectSalaryRecord(SalaryVo salaryVo);

    /**
     * 查询基本工资
     * @param fixedwagf
     * @return
     */
    @PostMapping("/selectPay")
    Object selectPay(Fixedwagf fixedwagf);

    /**
     * 添加调薪 3个审批人
     * @param salaryVo
     * @return
     */
    @PostMapping("/SubmitSalary3")
    Object SubmitSalary3(SalaryVo salaryVo);

    /**
     * 添加调薪 2个审批人
     * @param salaryVo
     * @return
     */
    @PostMapping("/SubmitSalary2")
    Object SubmitSalary2(SalaryVo salaryVo);

    /**
     * 添加调薪 1个审批人
     * @param salaryVo
     * @return
     */
    @PostMapping("/SubmitSalary1")
    Object SubmitSalary1(SalaryVo salaryVo);

    /**
     * 根据员工名称是否有离职记录
     * @param quitDetailsVo
     * @return
     */
    @PostMapping("/selectDimissionRecord")
    Object selectDimissionRecord(QuitDetailsVo quitDetailsVo);

    /**
     * 添加调薪 3个审批人
     * @param quitVo
     * @return
     */
    @PostMapping("/submitToLeave3")
    Object submitToLeave3(QuitVo quitVo);

    /**
     * 添加调薪 2个审批人
     * @param quitVo
     * @return
     */
    @PostMapping("/submitToLeave2")
    Object submitToLeave2(QuitVo quitVo);

    /**
     * 添加调薪 1个审批人
     * @param quitVo
     * @return
     */
    @PostMapping("/submitToLeave1")
    Object submitToLeave1(QuitVo quitVo);

    /**
     * 根据员工名称是否有加班记录
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/selectOvertimeExamine")
    Object selectOvertimeExamine(OvertimeaskVo overtimeaskVo);

    /**
     * 添加加班 3个审批人
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime3")
    Object submitToOvertime3(OvertimeaskVo overtimeaskVo);

    /**
     * 添加加班 2个审批人
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime2")
    Object submitToOvertime2(OvertimeaskVo overtimeaskVo);

    /**
     * 添加加班 1个审批人
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime1")
    Object submitToOvertime1(OvertimeaskVo overtimeaskVo);

    /**
     * 根据员工名称是否有补打卡记录
     * @param cardDetailsVo
     * @return
     */
    @PostMapping("/selectCardExamine")
    Object selectCardExamine(CardDetailsVo cardDetailsVo);

    /**
     * 添加补打卡 3个审批人
     * @param cardVo
     * @return
     */
    @PostMapping("/submitToCard3")
    Object submitToCard3(CardVo cardVo);

    /**
     * 添加补打卡 2个审批人
     * @param cardVo
     * @return
     */
    @PostMapping("/submitToCard2")
    Object submitToCard2(CardVo cardVo);

    /**
     * 添加补打卡 1个审批人
     * @param cardVo
     * @return
     */
    @PostMapping("/submitToCard1")
    Object submitToCard1(CardVo cardVo);

    /**
     * 根据员工名称是否有出差记录
     * @param travelDetailsVo
     * @return
     */
    @PostMapping("/selectEvectionExamine")
    Object selectEvectionExamine(TravelDetailsVo travelDetailsVo);

    /**
     * 添加出差 3个审批人
     * @param travelVo
     * @return
     */
    @PostMapping("/submitToTravel3")
    Object submitToTravel3(TravelVo travelVo);

    /**
     * 添加出差 2个审批人
     * @param travelVo
     * @return
     */
    @PostMapping("/submitToTravel2")
    Object submitToTravel2(TravelVo travelVo);

    /**
     * 添加出差 1个审批人
     * @param travelVo
     * @return
     */
    @PostMapping("/submitToTravel1")
    Object submitToTravel1(TravelVo travelVo);

    /**
     * 根据员工名称是否有出差记录
     * @param leaveDetailsVo
     * @return
     */
    @PostMapping("/selectLeaveExamine")
    Object selectLeaveExamine(LeaveDetailsVo leaveDetailsVo);

    /**
     * 添加请假 3个审批人
     * @param leaveVo
     * @return
     */
    @PostMapping("/submitToAskForLeave3")
    Object submitToAskForLeave3(LeaveVo leaveVo);

    /**
     * 添加请假 2个审批人
     * @param leaveVo
     * @return
     */
    @PostMapping("/submitToAskForLeave2")
    Object submitToAskForLeave2(LeaveVo leaveVo);

    /**
     * 添加请假 1个审批人
     * @param leaveVo
     * @return
     */
    @PostMapping("/submitToAskForLeave1")
    Object submitToAskForLeave1(LeaveVo leaveVo);

    /**
     * 查询我的转正审批申请 待处理
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectMyWorker")
    Object selectMyWorker(Auditflowone auditflowone);

    /**
     * 查询我的转正审批申请 已处理
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectMyEndWorker")
    Object selectMyEndWorker(Auditflowone auditflowone);

    /**
     * 根据员工编号查询部门职位
     * @param staff
     * @return
     */
    @PostMapping("/inquirePosition")
    Object inquirePosition(Staff staff);

    @PostMapping("/revocation")
    Object revocation(@RequestBody Auditflow auditflow);

}
