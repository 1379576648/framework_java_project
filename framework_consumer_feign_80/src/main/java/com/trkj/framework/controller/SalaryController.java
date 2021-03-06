package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SalaryController {
    @Autowired
    private AuditflowService auditflowService;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 根据审批类型的调薪/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectSalaryAll")
    @ApiOperation(value = "根据审批类型的调薪/审批人查询待处理的审批", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectSalaryAll")
    public AjaxResponse selectSalaryAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectSalaryAll(auditflowone);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据审批类型的调薪/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndSalaryAll")
    @ApiOperation(value = "根据审批类型的调薪/审批人查询已处理的审批", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectEndSalaryAll")
    public AjaxResponse selectEndSalaryAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectEndSalaryAll(auditflowone);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据审批类型的调薪/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsSalary")
    @ApiOperation(value = "根据审批类型的调薪/审批人查询已处理的详情信息", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectDetailsSalary")
    public AjaxResponse selectDetailsSalary(@RequestBody SalaryDetailsVo salaryDetailsVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectDetailsSalary(salaryDetailsVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据员工名称是否有调薪记录
     *
     * @param salaryVo
     * @return
     */
    @PostMapping("/selectSalaryRecord")
    @ApiOperation(value = "根据员工名称是否有调薪记录", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectSalaryRecord")
    public AjaxResponse selectSalaryRecord(@RequestBody SalaryVo salaryVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectSalaryRecord(salaryVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据员工ID查询其基本工资
     *
     * @param fixedwagf
     * @return
     */
    @PostMapping("/selectPay")
    @ApiOperation(value = "根据员工ID查询其基本工资", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectPay")
    public AjaxResponse selectPay(@RequestBody Fixedwagf fixedwagf) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectPay(fixedwagf);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加调薪 添加三个审批人
     *
     * @param salaryVo
     * @return
     */
    @PostMapping("/SubmitSalary3")
    @ApiOperation(value = "添加调薪 添加三个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/SubmitSalary3")
    public AjaxResponse SubmitSalary3(@RequestBody SalaryVo salaryVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.SubmitSalary3(salaryVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加调薪 添加两个审批人
     *
     * @param salaryVo
     * @return
     */
    @PostMapping("/SubmitSalary2")
    @ApiOperation(value = "添加调薪 添加两个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/SubmitSalary2")
    public AjaxResponse SubmitSalary2(@RequestBody SalaryVo salaryVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.SubmitSalary2(salaryVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加调薪 添加一个审批人
     *
     * @param salaryVo
     * @return
     */
    @PostMapping("/SubmitSalary1")
    @ApiOperation(value = "添加调薪 添加一个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/SubmitSalary1")
    public AjaxResponse SubmitSalary1(@RequestBody SalaryVo salaryVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.SubmitSalary1(salaryVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
