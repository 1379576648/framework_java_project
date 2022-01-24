package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.vo.*;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkerController {
    @Autowired
    private AuditflowService auditflowService;

    /**
     * 根据审批类型的转正/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectWorkerlAll")
    public AjaxResponse selectWorkerlAll(@RequestBody Auditflowone auditflowone) {
        return AjaxResponse.success(auditflowService.selectWorkerlAll(auditflowone));
    }

    /**
     * 根据审批类型的转正/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndWorkerlAll")
    public AjaxResponse selectEndWorkerlAll(@RequestBody Auditflowone auditflowone) {
        return AjaxResponse.success(auditflowService.selectEndWorkerlAll(auditflowone));
    }

    /**
     * 根据审批类型的转正/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsWorker")
    public AjaxResponse selectDetailsWorker(@RequestBody WorkerDetaIsVo workerDetaIsVo) {
        return AjaxResponse.success(auditflowService.selectDetailsWorker(workerDetaIsVo));
    }

    /**
     * 根据部门编号查询其部门经理
     * @return
     */
    @PostMapping("/selectDeptPostName")
    public AjaxResponse selectDeptPostName(@RequestBody DeptPostVo deptPostVo){
        return AjaxResponse.success(auditflowService.selectDeptPostName(deptPostVo));
    }

    /**
     * 根据部门编号查询部门名称
     * @param
     * @return
     */
    @PostMapping("/selectDeptName")
    public AjaxResponse selectDeptName(@RequestBody Dept selectDeptName){
        return AjaxResponse.success(auditflowService.selectDeptName(selectDeptName));
    }

    /**
     * 查询人事经理及总裁（总经理）
     * @return
     */
    @PostMapping("/selectpresident")
    public AjaxResponse selectpresident(){
        return AjaxResponse.success(auditflowService.selectpresident());
    }

    /**
     * 添加转正 三个审批人
     * @param workerVo
     * @return
     */
    @PostMapping("/SubmitPositive3")
    public AjaxResponse SubmitPositive3(@RequestBody WorkerVo workerVo){
        return AjaxResponse.success(auditflowService.SubmitPositive3(workerVo));
    }

    /**
     * 添加转正 两个审批人
     * @param workerVo
     * @return
     */
    @PostMapping("/SubmitPositive2")
    public AjaxResponse SubmitPositive2(@RequestBody WorkerVo workerVo){
        return AjaxResponse.success(auditflowService.SubmitPositive2(workerVo));
    }

    /**
     * 添加转正 两个审批人
     * @param workerVo
     * @return
     */
    @PostMapping("/SubmitPositive1")
    public AjaxResponse SubmitPositive1(@RequestBody WorkerVo workerVo){
        return AjaxResponse.success(auditflowService.SubmitPositive1(workerVo));
    }

    /**
     * 根据员工名称是否有转正记录
     * @param workerVo
     * @return
     */
    @PostMapping("/selectexaminerecord")
    public AjaxResponse selectexaminerecord(@RequestBody WorkerVo workerVo){
        return AjaxResponse.success(auditflowService.selectexaminerecord(workerVo));
    }

    /**
     * 查询我的转正审批申请 待处理
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectMyWorker")
    public AjaxResponse selectMyWorker(@RequestBody Auditflowone auditflowone){
        return AjaxResponse.success(auditflowService.selectMyWorker(auditflowone));
    }

    /**
     * 查询我的转正审批申请 待处理
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectMyEndWorker")
    public AjaxResponse selectMyEndWorker(@RequestBody Auditflowone auditflowone){
        return AjaxResponse.success(auditflowService.selectMyEndWorker(auditflowone));
    }

}
