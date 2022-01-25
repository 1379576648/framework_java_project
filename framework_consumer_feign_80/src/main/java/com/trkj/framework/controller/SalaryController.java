package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalaryController {
    @Autowired
    private AuditflowService auditflowService;

    /**
     * 根据审批类型的调薪/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectSalaryAll")
    public AjaxResponse selectSalaryAll(@RequestBody Auditflowone auditflowone) {
        return AjaxResponse.success(auditflowService.selectSalaryAll(auditflowone));
    }

    /**
     * 根据审批类型的调薪/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndSalaryAll")
    public AjaxResponse selectEndSalaryAll(@RequestBody Auditflowone auditflowone) {
        return AjaxResponse.success(auditflowService.selectEndSalaryAll(auditflowone));
    }

    /**
     * 根据审批类型的调薪/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsSalary")
    public AjaxResponse selectDetailsSalary(@RequestBody SalaryDetailsVo salaryDetailsVo) {
        return AjaxResponse.success(auditflowService.selectDetailsSalary(salaryDetailsVo));
    }

    /**
     * 根据员工名称是否有调薪记录
     * @param salaryVo
     * @return
     */
    @PostMapping("/selectSalaryRecord")
    public AjaxResponse selectSalaryRecord(@RequestBody SalaryVo salaryVo){
        return AjaxResponse.success(auditflowService.selectSalaryRecord(salaryVo));
    }

    /**
     * 根据员工ID查询其基本工资
     * @param fixedwagf
     * @return
     */
    @PostMapping("/selectPay")
    public AjaxResponse selectPay(@RequestBody Fixedwagf fixedwagf){
        return AjaxResponse.success(auditflowService.selectPay(fixedwagf));
    }

    /**
     * 添加调薪 添加三个审批人
     * @param salaryVo
     * @return
     */
    @PostMapping("/SubmitSalary3")
    public AjaxResponse SubmitSalary3(@RequestBody SalaryVo salaryVo){
        return AjaxResponse.success(auditflowService.SubmitSalary3(salaryVo));
    }

    /**
     * 添加调薪 添加两个审批人
     * @param salaryVo
     * @return
     */
    @PostMapping("/SubmitSalary2")
    public AjaxResponse SubmitSalary2(@RequestBody SalaryVo salaryVo){
        return AjaxResponse.success(auditflowService.SubmitSalary2(salaryVo));
    }

    /**
     * 添加调薪 添加一个审批人
     * @param salaryVo
     * @return
     */
    @PostMapping("/SubmitSalary1")
    public AjaxResponse SubmitSalary1(@RequestBody SalaryVo salaryVo){
        return AjaxResponse.success(auditflowService.SubmitSalary1(salaryVo));
    }
}
