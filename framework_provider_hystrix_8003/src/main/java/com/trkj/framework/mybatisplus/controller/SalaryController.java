package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import com.trkj.framework.mybatisplus.service.SalaryService;
import com.trkj.framework.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * 调薪 --前端控制器
 *
 * @author 里予
 * @since 2022-1-2
 */
@RestController
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    /**
     * 根据审批类型的调薪/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectSalaryAll")
    @HystrixCommand(fallbackMethod = "HystixGet1")
    public Object selectSalaryAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", salaryService.selectSalaryAll(auditflowone));
        return map1;
    }

    public Object HystixGet1(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据审批类型的调薪/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndSalaryAll")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object selectEndSalaryAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", salaryService.selectEndSalaryAll(auditflowone));
        return map1;
    }

    public Object HystixGet2(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据审批类型的调薪/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsSalary")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Object selectDetailsSalary(@RequestBody SalaryDetailsVo salaryDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", salaryService.selectDetailsSalary(salaryDetailsVo));
        return map1;
    }

    public Object HystixGet3(@RequestBody SalaryDetailsVo salaryDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据员工名称是否有调薪记录
     * @param salaryVo
     * @return
     */
    @PostMapping("/selectSalaryRecord")
    public Integer selectTransferRecord(@RequestBody SalaryVo salaryVo){
        return salaryService.selectSalaryRecord(salaryVo);
    }

    /**
     * 根据员工ID查询其基本工资
     * @param fixedwagf
     * @return
     */
    @PostMapping("/selectPay")
    public Integer selectPay(@RequestBody Fixedwagf fixedwagf){
        return salaryService.selectPay(fixedwagf);
    }

    /**
     * 添加调薪 添加三个审批人
     * @param salaryVo
     * @return
     */
    @PostMapping("/SubmitSalary3")
    public int SubmitSalary3(@RequestBody SalaryVo salaryVo){
        return  salaryService.SubmitSalary3(salaryVo);
    }

    /**
     * 添加调薪 添加两个审批人
     * @param salaryVo
     * @return
     */
    @PostMapping("/SubmitSalary2")
    public int SubmitSalary2(@RequestBody SalaryVo salaryVo){
        return  salaryService.SubmitSalary2(salaryVo);
    }

}
