package com.trkj.framework.service.client.fallbackfactory;

import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.service.client.util.FuseUtil;
import com.trkj.framework.vo.*;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//降级~
@Component
public class AuditflowClinetServiceFallbackfactory implements FallbackFactory {
    @Autowired
    private FuseUtil fuseUtil;
    @Override
    public Object create(Throwable throwable) {
        return new AuditflowService() {
            @Override
            public Object selectAuditflowoneAll(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectEnddAuditflow(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectDetailsAuditflow(AuditflowDetailsVo auditflowDetailsVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectStaffState(Staff staff) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object updateApprovalState(Auditflowdetail auditflowdetail) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object rejectApprovalState(Auditflowdetail auditflowdetail) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object queryDetail(Auditflowdetail auditflowdetail) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectLeaveAll(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectEndLeaveAll(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectDetailsLeaves(LeaveDetailsVo leaveDetailsVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectTravelAll(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectEndTravelAll(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectDetailsTrave(TravelDetailsVo travelDetailsVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectCardAll(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectEndCardAll(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectDetailsCards(CardDetailsVo cardDetailsVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectQuitAll(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectEndQuitAll(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectDetailsQuit(QuitDetailsVo quitDetailsVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectSalaryAll(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectEndSalaryAll(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectDetailsSalary(SalaryDetailsVo salaryDetailsVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectTransferAll(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectEndTransferAll(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectDetailsTransfer(TransferDetailsVo transferDetailsVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectWorkerlAll(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectEndWorkerlAll(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectDetailsWorker(WorkerDetaIsVo workerDetaIsVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectDeptAll() {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectDeptPostName(DeptPostVo deptPostVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectDeptName(Dept dept) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectpresident() {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object SubmitPositive3(WorkerVo workerVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object SubmitPositive2(WorkerVo workerVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object SubmitPositive1(WorkerVo workerVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectexaminerecord(WorkerVo workerVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectTransferRecord(Transfer8003Vo transferVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object SubmitTransfer3(Transfer8003Vo transferVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object SubmitTransfer2(Transfer8003Vo transferVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object SubmitTransfer1(Transfer8003Vo transferVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectDeptPost(Staff staff) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectSalaryRecord(SalaryVo salaryVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectPay(Fixedwagf fixedwagf) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object SubmitSalary3(SalaryVo salaryVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object SubmitSalary2(SalaryVo salaryVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object SubmitSalary1(SalaryVo salaryVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectDimissionRecord(QuitDetailsVo quitDetailsVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object submitToLeave3(QuitVo quitVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object submitToLeave2(QuitVo quitVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object submitToLeave1(QuitVo quitVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectOvertimeExamine(OvertimeaskVo overtimeaskVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object submitToOvertime3(OvertimeaskVo overtimeaskVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object submitToOvertime2(OvertimeaskVo overtimeaskVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object submitToOvertime1(OvertimeaskVo overtimeaskVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectCardExamine(CardDetailsVo cardDetailsVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object submitToCard3(CardVo cardVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object submitToCard2(CardVo cardVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object submitToCard1(CardVo cardVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectEvectionExamine(TravelDetailsVo travelDetailsVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object submitToTravel3(TravelVo travelVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object submitToTravel2(TravelVo travelVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object submitToTravel1(TravelVo travelVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectLeaveExamine(LeaveDetailsVo leaveDetailsVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object submitToAskForLeave3(LeaveVo leaveVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object submitToAskForLeave2(LeaveVo leaveVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object submitToAskForLeave1(LeaveVo leaveVo) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectMyWorker(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object selectMyEndWorker(Auditflowone auditflowone) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object inquirePosition(Staff staff) {
                return AjaxResponse.success(fuseUtil.main(throwable));
            }

            @Override
            public Object revocation(Auditflow auditflow) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }

            @Override
            public Object selectTodayOverTimeExamine(Auditflow auditflow) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("state", 100);
                map.put("info", "服务发生关闭");
                return AjaxResponse.success(map);
            }
        };
    }
}
