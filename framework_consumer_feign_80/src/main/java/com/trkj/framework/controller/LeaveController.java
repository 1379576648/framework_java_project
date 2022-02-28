package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Card;
import com.trkj.framework.entity.mybatisplus.Leave;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.*;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "根据审批类型的请假/审批人查询待处理的审批", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectLeaveAll")
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
    @ApiOperation(value = "根据审批类型的请假/审批人查询已处理的审批", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectEndLeaveAll")
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
    @ApiOperation(value = "根据审批类型的请假/审批人查询已处理的详情信息", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectDetailsLeaves")
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
    @ApiOperation(value = "根据员工名称是否有请假记录", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectLeaveExamine")
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
    @ApiOperation(value = "添加请假 三个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/submitToAskForLeave3")
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
    @ApiOperation(value = "添加请假 两个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/submitToAskForLeave2")
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
    @ApiOperation(value = "添加请假 一个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/submitToAskForLeave1")
    public AjaxResponse submitToAskForLeave1(@RequestBody LeaveVo leaveVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.submitToAskForLeave1(leaveVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
