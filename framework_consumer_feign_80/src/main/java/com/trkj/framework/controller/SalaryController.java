package com.trkj.framework.controller;

import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.SalaryDetailsVo;
import com.trkj.framework.vo.TravelDetailsVo;
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
}
