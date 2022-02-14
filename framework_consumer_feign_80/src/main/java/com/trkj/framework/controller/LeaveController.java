package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Card;
import com.trkj.framework.entity.mybatisplus.Leave;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LeaveController {
    @Autowired
    private AuditflowService auditflowService;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 根据审批类型的请假/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectLeaveAll")
    public AjaxResponse selectLeaveAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectLeaveAll(auditflowone);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据审批类型的请假/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndLeaveAll")
    public AjaxResponse selectEndLeaveAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectEndLeaveAll(auditflowone);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据审批类型的请假/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsLeaves")
    public AjaxResponse selectDetailsLeaves(@RequestBody LeaveDetailsVo leaveDetailsVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectDetailsLeaves(leaveDetailsVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据员工名称是否有请假记录
     *
     * @param leaveDetailsVo
     * @return
     */
    @PostMapping("/selectLeaveExamine")
    public AjaxResponse selectCardExamine(@RequestBody LeaveDetailsVo leaveDetailsVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectLeaveExamine(leaveDetailsVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加请假 三个审批人
     *
     * @param leaveVo
     * @return
     */
    @PostMapping("/submitToAskForLeave3")
    public AjaxResponse submitToAskForLeave3(@RequestBody LeaveVo leaveVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.submitToAskForLeave3(leaveVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加请假 两个审批人
     *
     * @param leaveVo
     * @return
     */
    @PostMapping("/submitToAskForLeave2")
    public AjaxResponse submitToAskForLeave2(@RequestBody LeaveVo leaveVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.submitToAskForLeave2(leaveVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加请假 一个审批人
     *
     * @param leaveVo
     * @return
     */
    @PostMapping("/submitToAskForLeave1")
    public AjaxResponse submitToAskForLeave1(@RequestBody LeaveVo leaveVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.submitToAskForLeave1(leaveVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
