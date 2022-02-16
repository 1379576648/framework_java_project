package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.service.client.util.FuseUtil;
import com.trkj.framework.vo.*;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//降级~
@Component
public class AuditflowClinetServiceFallbackfactory implements FallbackFactory {
    @Autowired
    private FuseUtil fuseUtil;
    @Override
    public Object create(Throwable throwable) {
        return new AuditflowService() {
            @Override
            public Map<String,Object> selectAuditflowoneAll(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectEnddAuditflow(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectDetailsAuditflow(AuditflowDetailsVo auditflowDetailsVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectStaffState(Staff staff) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> updateApprovalState(Auditflowdetail auditflowdetail) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> rejectApprovalState(Auditflowdetail auditflowdetail) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> queryDetail(Auditflowdetail auditflowdetail) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectLeaveAll(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectEndLeaveAll(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectDetailsLeaves(LeaveDetailsVo leaveDetailsVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectTravelAll(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectEndTravelAll(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectDetailsTrave(TravelDetailsVo travelDetailsVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectCardAll(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectEndCardAll(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectDetailsCards(CardDetailsVo cardDetailsVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectQuitAll(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectEndQuitAll(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectDetailsQuit(QuitDetailsVo quitDetailsVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectSalaryAll(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectEndSalaryAll(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectDetailsSalary(SalaryDetailsVo salaryDetailsVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectTransferAll(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectEndTransferAll(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectDetailsTransfer(TransferDetailsVo transferDetailsVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectWorkerlAll(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectEndWorkerlAll(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectDetailsWorker(WorkerDetaIsVo workerDetaIsVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectDeptAll() {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectDeptPostName(DeptPostVo deptPostVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectDeptName(Dept dept) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectpresident() {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectStaffing() {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> SubmitPositive3(WorkerVo workerVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> SubmitPositive2(WorkerVo workerVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> SubmitPositive1(WorkerVo workerVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectexaminerecord(WorkerVo workerVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectTransferRecord(Transfer8003Vo transferVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> SubmitTransfer3(Transfer8003Vo transferVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> SubmitTransfer2(Transfer8003Vo transferVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> SubmitTransfer1(Transfer8003Vo transferVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectDeptPost(Staff staff) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectSalaryRecord(SalaryVo salaryVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectPay(Fixedwagf fixedwagf) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> SubmitSalary3(SalaryVo salaryVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> SubmitSalary2(SalaryVo salaryVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> SubmitSalary1(SalaryVo salaryVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectDimissionRecord(QuitDetailsVo quitDetailsVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> submitToLeave3(QuitVo quitVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> submitToLeave2(QuitVo quitVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> submitToLeave1(QuitVo quitVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectOvertimeExamine(OvertimeaskVo overtimeaskVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> submitToOvertime3(OvertimeaskVo overtimeaskVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> submitToOvertime2(OvertimeaskVo overtimeaskVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> submitToOvertime1(OvertimeaskVo overtimeaskVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectCardExamine(CardDetailsVo cardDetailsVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> submitToCard3(CardVo cardVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> submitToCard2(CardVo cardVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> submitToCard1(CardVo cardVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectEvectionExamine(TravelDetailsVo travelDetailsVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> submitToTravel3(TravelVo travelVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> submitToTravel2(TravelVo travelVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> submitToTravel1(TravelVo travelVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectLeaveExamine(LeaveDetailsVo leaveDetailsVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> submitToAskForLeave3(LeaveVo leaveVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> submitToAskForLeave2(LeaveVo leaveVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> submitToAskForLeave1(LeaveVo leaveVo) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectMyWorker(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectMyEndWorker(Auditflowone auditflowone) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> inquirePosition(Staff staff) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> revocation(Auditflow auditflow) {
                return fuseUtil.main(throwable);
            }

            @Override
            public Map<String,Object> selectTodayOverTimeExamine(Auditflow auditflow) {
                return fuseUtil.main(throwable);
            }
        };
    }
}
