package com.trkj.framework.service.client.examine;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.fallbackfactory.AuditflowClinetServiceFallbackfactory;
import com.trkj.framework.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author 13795
 */
@FeignClient(value = "FRAMEWORK-ZUUL/8003/provider", fallbackFactory = AuditflowClinetServiceFallbackfactory.class)
public interface AuditflowService {
    // 全部改成map
    /**
     * 根据审批类型的加班/审批人查询待处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectAuditflow")
    Map<String,Object> selectAuditflowoneAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的加班/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEnddAuditflow")
    Map<String,Object> selectEnddAuditflow(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的加班/审批人查询待处理的审批详情信息
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectDetailsAuditflow")
    Map<String,Object> selectDetailsAuditflow(@RequestBody AuditflowDetailsVo auditflowDetailsVo);

    /**
     * 根据员工名称查询其状态
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectStaffState")
    Map<String,Object> selectStaffState(@RequestBody Staff staff);

    /**
     * 根据审批明细表修改其状态 通过
     * @param
     * @param
     * @return
     */
    @PostMapping("/update_Approval_State")
    Map<String,Object> updateApprovalState(@RequestBody Auditflowdetail auditflowdetail);

    /**
     * 根据审批明细表修改其状态 驳回
     * @param
     * @param
     * @return
     */
    @PostMapping("/reject_Approval_State")
    Map<String,Object> rejectApprovalState(@RequestBody Auditflowdetail auditflowdetail);

    /**
     * 根据审批编号查询对应的审批明细表状态
     * @param auditflowdetail
     * @return
     */
    @PostMapping("/queryDetail")
    Map<String,Object> queryDetail(@RequestBody Auditflowdetail auditflowdetail);

    /**
     * 根据审批类型的请假/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectLeaveAll")
    Map<String,Object> selectLeaveAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的请假/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEndLeaveAll")
    Map<String,Object> selectEndLeaveAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的请假/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsLeaves")
    Map<String,Object> selectDetailsLeaves(@RequestBody LeaveDetailsVo leaveDetailsVo);

    /**
     * 根据审批类型的出差/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectTravelAll")
    Map<String,Object> selectTravelAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的出差/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEndTravelAll")
    Map<String,Object> selectEndTravelAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的出差/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsTrave")
    Map<String,Object> selectDetailsTrave(@RequestBody TravelDetailsVo travelDetailsVo);

    /**
     * 根据审批类型的补打卡/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectCardAll")
    Map<String,Object> selectCardAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的补打卡/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEndCardAll")
    Map<String,Object> selectEndCardAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的补打卡/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsCards")
    Map<String,Object> selectDetailsCards(@RequestBody CardDetailsVo cardDetailsVo);

    /**
     * 根据审批类型的离职/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectQuitAll")
    Map<String,Object> selectQuitAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的离职/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEndQuitAll")
    Map<String,Object> selectEndQuitAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的离职/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsQuit")
    Map<String,Object> selectDetailsQuit(@RequestBody QuitDetailsVo quitDetailsVo);

    /**
     * 根据审批类型的调薪/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectSalaryAll")
    Map<String,Object> selectSalaryAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的调薪/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEndSalaryAll")
    Map<String,Object> selectEndSalaryAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的调薪/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsSalary")
    Map<String,Object> selectDetailsSalary(@RequestBody SalaryDetailsVo salaryDetailsVo);

    /**
     * 根据审批类型的调动/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectTransferAll")
    Map<String,Object> selectTransferAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的调动/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEndTransferAll")
    Map<String,Object> selectEndTransferAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的调动/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsTransfer")
    Map<String,Object> selectDetailsTransfer(@RequestBody TransferDetailsVo transferDetailsVo);

    /**
     * 根据审批类型的转正/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectWorkerlAll")
    Map<String,Object> selectWorkerlAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的转正/审批人查询已处理的审批
     * @param
     * @param
     * @return
     */
    @PostMapping("/selectEndWorkerlAll")
    Map<String,Object> selectEndWorkerlAll(@RequestBody Auditflowone auditflowone);

    /**
     * 根据审批类型的转正/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsWorker")
    Map<String,Object> selectDetailsWorker(@RequestBody WorkerDetaIsVo workerDetaIsVo);

    /**
     *  点击异动查询所有部门
     * @param
     * @return
     */
    @GetMapping("/selectDeptList")
    Map<String,Object> selectDeptAll();

    /**
     * 根据部门编号查询其部门经理
     * @return
     */
    @PostMapping("/selectDeptPostName")
    Map<String,Object> selectDeptPostName(@RequestBody DeptPostVo deptPostVo);

    /**
     * 根据部门编号查询部门名称
     * @param
     * @return
     */
    @PostMapping("/selectDeptName")
    Map<String,Object> selectDeptName(@RequestBody Dept dept);

    /**
     * 查询人事经理及总裁（总经理）
     * @return
     */
    @PostMapping("/selectpresident")
    Map<String,Object> selectpresident();

    /**
     * 查询人事经理及总裁（总经理）
     * @return
     */
    @PostMapping("/selectStaffing")
    Map<String,Object> selectStaffing();

    /**
     * 添加转正 3个审批人
     * @param workerVo
     * @return
     */
    @PostMapping("/SubmitPositive3")
    Map<String,Object> SubmitPositive3(WorkerVo workerVo);

    /**
     * 添加转正 2个审批人
     * @param workerVo
     * @return
     */
    @PostMapping("/SubmitPositive2")
    Map<String,Object> SubmitPositive2(WorkerVo workerVo);

    /**
     * 添加转正 1个审批人
     * @param workerVo
     * @return
     */
    @PostMapping("/SubmitPositive1")
    Map<String,Object> SubmitPositive1(WorkerVo workerVo);

    /**
     * 根据员工名称是否有转正记录
     * @param workerVo
     * @return
     */
    @PostMapping("/selectexaminerecord")
    Map<String,Object> selectexaminerecord(WorkerVo workerVo);

    /**
     * 根据员工名称是否有异动记录
     * @param transferVo
     * @return
     */
    @PostMapping("/selectTransferRecord")
    Map<String,Object> selectTransferRecord(Transfer8003Vo transferVo);

    /**
     * 添加调动 3个审批人
     * @param transferVo
     * @return
     */
    @PostMapping("/SubmitTransfer3")
    Map<String,Object> SubmitTransfer3(Transfer8003Vo transferVo);

    /**
     * 添加调动 2个审批人
     * @param transferVo
     * @return
     */
    @PostMapping("/SubmitTransfer2")
    Map<String,Object> SubmitTransfer2(Transfer8003Vo transferVo);

    /**
     * 添加调动 1个审批人
     * @param transferVo
     * @return
     */
    @PostMapping("/SubmitTransfer1")
    Map<String,Object> SubmitTransfer1(Transfer8003Vo transferVo);

    /**
     * 添加调动 1个审批人
     * @param staff
     * @return
     */
    @PostMapping("/selectDeptPost")
    Map<String,Object> selectDeptPost(Staff staff);

    /**
     * 根据员工名称是否有调薪记录
     * @param salaryVo
     * @return
     */
    @PostMapping("/selectSalaryRecord")
    Map<String,Object> selectSalaryRecord(SalaryVo salaryVo);

    /**
     * 查询基本工资
     * @param fixedwagf
     * @return
     */
    @PostMapping("/selectPay")
    Map<String,Object> selectPay(Fixedwagf fixedwagf);

    /**
     * 添加调薪 3个审批人
     * @param salaryVo
     * @return
     */
    @PostMapping("/SubmitSalary3")
    Map<String,Object> SubmitSalary3(SalaryVo salaryVo);

    /**
     * 添加调薪 2个审批人
     * @param salaryVo
     * @return
     */
    @PostMapping("/SubmitSalary2")
    Map<String,Object> SubmitSalary2(SalaryVo salaryVo);

    /**
     * 添加调薪 1个审批人
     * @param salaryVo
     * @return
     */
    @PostMapping("/SubmitSalary1")
    Map<String,Object> SubmitSalary1(SalaryVo salaryVo);

    /**
     * 根据员工名称是否有离职记录
     * @param quitDetailsVo
     * @return
     */
    @PostMapping("/selectDimissionRecord")
    Map<String,Object> selectDimissionRecord(QuitDetailsVo quitDetailsVo);

    /**
     * 添加调薪 3个审批人
     * @param quitVo
     * @return
     */
    @PostMapping("/submitToLeave3")
    Map<String,Object> submitToLeave3(QuitVo quitVo);

    /**
     * 添加调薪 2个审批人
     * @param quitVo
     * @return
     */
    @PostMapping("/submitToLeave2")
    Map<String,Object> submitToLeave2(QuitVo quitVo);

    /**
     * 添加调薪 1个审批人
     * @param quitVo
     * @return
     */
    @PostMapping("/submitToLeave1")
    Map<String,Object> submitToLeave1(QuitVo quitVo);

    /**
     * 根据员工名称是否有加班记录
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/selectOvertimeExamine")
    Map<String,Object> selectOvertimeExamine(OvertimeaskVo overtimeaskVo);

    /**
     * 添加加班 3个审批人
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime3")
    Map<String,Object> submitToOvertime3(OvertimeaskVo overtimeaskVo);

    /**
     * 添加加班 2个审批人
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime2")
    Map<String,Object> submitToOvertime2(OvertimeaskVo overtimeaskVo);

    /**
     * 添加加班 1个审批人
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/submitToOvertime1")
    Map<String,Object> submitToOvertime1(OvertimeaskVo overtimeaskVo);

    /**
     * 根据员工名称是否有补打卡记录
     * @param cardDetailsVo
     * @return
     */
    @PostMapping("/selectCardExamine")
    Map<String,Object> selectCardExamine(CardDetailsVo cardDetailsVo);

    /**
     * 添加补打卡 3个审批人
     * @param cardVo
     * @return
     */
    @PostMapping("/submitToCard3")
    Map<String,Object> submitToCard3(CardVo cardVo);

    /**
     * 添加补打卡 2个审批人
     * @param cardVo
     * @return
     */
    @PostMapping("/submitToCard2")
    Map<String,Object> submitToCard2(CardVo cardVo);

    /**
     * 添加补打卡 1个审批人
     * @param cardVo
     * @return
     */
    @PostMapping("/submitToCard1")
    Map<String,Object> submitToCard1(CardVo cardVo);

    /**
     * 根据员工名称是否有出差记录
     * @param travelDetailsVo
     * @return
     */
    @PostMapping("/selectEvectionExamine")
    Map<String,Object> selectEvectionExamine(TravelDetailsVo travelDetailsVo);

    /**
     * 添加出差 3个审批人
     * @param travelVo
     * @return
     */
    @PostMapping("/submitToTravel3")
    Map<String,Object> submitToTravel3(TravelVo travelVo);

    /**
     * 添加出差 2个审批人
     * @param travelVo
     * @return
     */
    @PostMapping("/submitToTravel2")
    Map<String,Object> submitToTravel2(TravelVo travelVo);

    /**
     * 添加出差 1个审批人
     * @param travelVo
     * @return
     */
    @PostMapping("/submitToTravel1")
    Map<String,Object> submitToTravel1(TravelVo travelVo);

    /**
     * 根据员工名称是否有出差记录
     * @param leaveDetailsVo
     * @return
     */
    @PostMapping("/selectLeaveExamine")
    Map<String,Object> selectLeaveExamine(LeaveDetailsVo leaveDetailsVo);

    /**
     * 添加请假 3个审批人
     * @param leaveVo
     * @return
     */
    @PostMapping("/submitToAskForLeave3")
    Map<String,Object> submitToAskForLeave3(LeaveVo leaveVo);

    /**
     * 添加请假 2个审批人
     * @param leaveVo
     * @return
     */
    @PostMapping("/submitToAskForLeave2")
    Map<String,Object> submitToAskForLeave2(LeaveVo leaveVo);

    /**
     * 添加请假 1个审批人
     * @param leaveVo
     * @return
     */
    @PostMapping("/submitToAskForLeave1")
    Map<String,Object> submitToAskForLeave1(LeaveVo leaveVo);

    /**
     * 查询我的转正审批申请 待处理
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectMyWorker")
    Map<String,Object> selectMyWorker(Auditflowone auditflowone);

    /**
     * 查询我的转正审批申请 已处理
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectMyEndWorker")
    Map<String,Object> selectMyEndWorker(Auditflowone auditflowone);

    /**
     * 根据员工编号查询部门职位
     * @param staff
     * @return
     */
    @PostMapping("/inquirePosition")
    Map<String,Object> inquirePosition(Staff staff);

    /**
     * 撤销审批
     * @param auditflow
     * @return
     */
    @PostMapping("/revocation")
    Map<String,Object> revocation(@RequestBody Auditflow auditflow);

    /**
     * 查询当天的加班审批记录
     * @param auditflow
     * @return
     */
    @PostMapping("/selectTodayOverTimeExamine")
    Map<String,Object> selectTodayOverTimeExamine(@RequestBody Auditflow auditflow);
}
