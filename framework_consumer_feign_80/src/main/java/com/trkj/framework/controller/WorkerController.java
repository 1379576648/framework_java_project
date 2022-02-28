package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.*;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WorkerController {
    @Autowired
    private AuditflowService auditflowService;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 根据审批类型的转正/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectWorkerlAll")
    @ApiOperation(value = "根据审批类型的转正/审批人查询待处理的审批", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectWorkerlAll")
    public AjaxResponse selectWorkerlAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectWorkerlAll(auditflowone);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据审批类型的转正/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndWorkerlAll")
    @ApiOperation(value = "根据审批类型的转正/审批人查询已处理的审批", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectEndWorkerlAll")
    public AjaxResponse selectEndWorkerlAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectEndWorkerlAll(auditflowone);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据审批类型的转正/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsWorker")
    @ApiOperation(value = "根据审批类型的转正/审批人查询已处理的详情信息", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectDetailsWorker\"")
    public AjaxResponse selectDetailsWorker(@RequestBody WorkerDetaIsVo workerDetaIsVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectDetailsWorker(workerDetaIsVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据部门编号查询其部门经理
     *
     * @return
     */
    @PostMapping("/selectDeptPostName")
    @ApiOperation(value = "根据部门编号查询其部门经理", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectDeptPostName\"")
    public AjaxResponse selectDeptPostName(@RequestBody DeptPostVo deptPostVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectDeptPostName(deptPostVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据部门编号查询部门名称
     *
     * @param
     * @return
     */
    @PostMapping("/selectDeptName")
    @ApiOperation(value = "根据部门编号查询部门名称", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectDeptName\"")
    public AjaxResponse selectDeptName(@RequestBody Dept selectDeptName) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectDeptName(selectDeptName);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询人事经理及总裁（总经理）
     *
     * @return
     */
    @PostMapping("/selectpresident")
    @ApiOperation(value = "查询人事经理及总裁（总经理）", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectpresident\"")
    public AjaxResponse selectpresident() {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectpresident();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询人事经理
     *
     * @return
     */
    @PostMapping("/selectStaffing")
    @ApiOperation(value = "查询人事经理", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectStaffing\"")
    public AjaxResponse selectStaffing() {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectStaffing();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加转正 三个审批人
     *
     * @param workerVo
     * @return
     */
    @PostMapping("/SubmitPositive3")
    @ApiOperation(value = "添加转正 三个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/SubmitPositive3\"")
    public AjaxResponse SubmitPositive3(@RequestBody WorkerVo workerVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.SubmitPositive3(workerVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加转正 两个审批人
     *
     * @param workerVo
     * @return
     */
    @PostMapping("/SubmitPositive2")
    @ApiOperation(value = "添加转正 两个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/SubmitPositive2\"")
    public AjaxResponse SubmitPositive2(@RequestBody WorkerVo workerVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.SubmitPositive2(workerVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加转正 两个审批人
     *
     * @param workerVo
     * @return
     */
    @PostMapping("/SubmitPositive1")
    @ApiOperation(value = "添加转正 一个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/SubmitPositive1\"")
    public AjaxResponse SubmitPositive1(@RequestBody WorkerVo workerVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.SubmitPositive1(workerVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据员工名称是否有转正记录
     *
     * @param workerVo
     * @return
     */
    @PostMapping("/selectexaminerecord")
    @ApiOperation(value = "根据员工名称是否有转正记录", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectexaminerecord\"")
    public AjaxResponse selectexaminerecord(@RequestBody WorkerVo workerVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectexaminerecord(workerVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询我的转正审批申请 待处理
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectMyWorker")
    @ApiOperation(value = "查询我的转正审批申请 待处理", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectMyWorker\"")
    public AjaxResponse selectMyWorker(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectMyWorker(auditflowone);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 查询我的转正审批申请 待处理
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectMyEndWorker")
    @ApiOperation(value = "查询我的转正审批申请 已处理", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectMyEndWorker\"")
    public AjaxResponse selectMyEndWorker(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectMyEndWorker(auditflowone);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

}
