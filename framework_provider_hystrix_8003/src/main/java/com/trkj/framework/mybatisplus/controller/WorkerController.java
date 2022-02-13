package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.entity.mybatisplus.Worker;
import com.trkj.framework.mybatisplus.service.WorkerService;
import com.trkj.framework.vo.*;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 转正 --前端控制器
 *
 * @author 里予
 * @since 2022-1-2
 */
@RestController
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    /**
     * 根据审批类型的转正/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectWorkerlAll")
    @HystrixCommand(fallbackMethod = "HystixGet1")
    public Object selectWorkerlAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", workerService.selectWorkerlAll(auditflowone));
        return map1;
    }

    public Object HystixGet1(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据审批类型的转正/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndWorkerlAll")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object selectEndWorkerlAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", workerService.selectEndWorkerlAll(auditflowone));
        return map1;
    }

    public Object HystixGet2(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据审批类型的转正/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsWorker")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Object selectDetailsWorker(@RequestBody WorkerDetaIsVo workerDetaIsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", workerService.selectDetailsWorker(workerDetaIsVo));
        return map1;
    }

    public Object HystixGet3(@RequestBody WorkerDetaIsVo workerDetaIsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据部门编号查询其部门经理
     * @return
     */
    @PostMapping("/selectDeptPostName")
    @HystrixCommand(fallbackMethod = "selectDeptPostNameHystixGet")
    public Object selectDeptPostName(@RequestBody DeptPostVo deptPostVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", workerService.selectDeptPostName(deptPostVo));
        return map1;
    }

    public Object selectDeptPostNameHystixGet(@RequestBody DeptPostVo deptPostVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据部门编号查询部门名称
     * @param dept
     * @return
     */
    @PostMapping("/selectDeptName")
    @HystrixCommand(fallbackMethod = "selectDeptNameHystixGet")
    public Object selectDeptName(@RequestBody Dept dept){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", workerService.selectDeptName(dept));
        return map1;
    }

    public Object selectDeptNameHystixGet(@RequestBody Dept dept) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 查询总裁（总经理）
     * @return
     */
    @PostMapping("/selectpresident")
    @HystrixCommand(fallbackMethod = "selectpresidentHystixGet")
    public Object selectpresident(){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", workerService.selectpresident());
        return map1;
    }

    public Object selectpresidentHystixGet() {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 查询人事部经理
     * @return
     */
    @PostMapping("/selectStaffing")
    @HystrixCommand(fallbackMethod = "selectStaffingHystixGet")
    public Object selectStaffing(){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", workerService.selectStaffing());
        return map1;
    }
    public Object selectStaffingHystixGet() {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 添加转正 添加三个审批人
     * @param workerVo
     * @return
     */
    @PostMapping("/SubmitPositive3")
    @HystrixCommand(fallbackMethod = "SubmitPositive3ExamineHystixGet")
    public Object SubmitPositive3(@RequestBody WorkerVo workerVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", workerService.SubmitPositive3(workerVo));
        return map1;
    }
    public Object SubmitPositive3ExamineHystixGet(@RequestBody WorkerVo workerVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 添加转正 添加两个审批人
     * @param workerVo
     * @return
     */
    @PostMapping("/SubmitPositive2")
    @HystrixCommand(fallbackMethod = "SubmitPositive2ExamineHystixGet")
    public Object SubmitPositive2(@RequestBody WorkerVo workerVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", workerService.SubmitPositive2(workerVo));
        return map1;
    }
    public Object SubmitPositive2ExamineHystixGet(@RequestBody WorkerVo workerVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 添加转正 添加一个审批人
     * @param workerVo
     * @return
     */
    @PostMapping("/SubmitPositive1")
    @HystrixCommand(fallbackMethod = "SubmitPositive1ExamineHystixGet")
    public Object SubmitPositive1(@RequestBody WorkerVo workerVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", workerService.SubmitPositive1(workerVo));
        return map1;
    }

    public Object SubmitPositive1ExamineHystixGet(@RequestBody WorkerVo workerVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据员工名称是否有转正记录
     * @param workerVo
     * @return
     */
    @PostMapping("/selectexaminerecord")
    @HystrixCommand(fallbackMethod = "selectexaminerecordExamineHystixGet")
    public Object selectexaminerecord(@RequestBody WorkerVo workerVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", workerService.selectexaminerecord(workerVo));
        return map1;
    }

    public Object selectexaminerecordExamineHystixGet(@RequestBody WorkerVo workerVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }
    /**
     * 查询我的审批申请 待处理
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectMyWorker")
    @HystrixCommand(fallbackMethod = "selectMyWorkerExamineHystixGet")
    public Object selectMyWorker(@RequestBody Auditflowone auditflowone){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", workerService.selectMyWorker(auditflowone));
        return map1;
    }

    public Object selectMyWorkerExamineHystixGet(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 查询我的审批申请 已处理
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectMyEndWorker")
    @HystrixCommand(fallbackMethod = "selectMyEndWorkerExamineHystixGet")
    public Object selectMyEndWorker(@RequestBody Auditflowone auditflowone){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", workerService.selectMyEndWorker(auditflowone));
        return map1;
    }

    public Object selectMyEndWorkerExamineHystixGet(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

}
