package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import com.trkj.framework.mybatisplus.service.SalaryService;
import com.trkj.framework.util.Fuse8003Util;
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
    @Autowired
    private Fuse8003Util fuse8003Util;

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
        return fuse8003Util.main();
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
        return fuse8003Util.main();
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
        return fuse8003Util.main();
    }

    /**
     * 根据员工名称是否有调薪记录
     *
     * @param salaryVo
     * @return
     */
    @PostMapping("/selectSalaryRecord")
    @HystrixCommand(fallbackMethod = "selectSalaryRecordHystixGet")
    public Object selectTransferRecord(@RequestBody SalaryVo salaryVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", salaryService.selectSalaryRecord(salaryVo));
        return map1;
    }

    public Object selectSalaryRecordHystixGet(@RequestBody SalaryVo salaryVo) {
        return fuse8003Util.main();
    }

    /**
     * 根据员工ID查询其基本工资
     *
     * @param fixedwagf
     * @return
     */
    @PostMapping("/selectPay")
    @HystrixCommand(fallbackMethod = "selectPayHystixGet")
    public Object selectPay(@RequestBody Fixedwagf fixedwagf) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", salaryService.selectPay(fixedwagf));
        return map1;
    }

    public Object selectPayHystixGet(@RequestBody Fixedwagf fixedwagf) {
        return fuse8003Util.main();
    }


    /**
     * 添加调薪 添加三个审批人
     *
     * @param salaryVo
     * @return
     */
    @PostMapping("/SubmitSalary3")
    @HystrixCommand(fallbackMethod = "SubmitSalary3ExamineHystixGet")
    public Object SubmitSalary3(@RequestBody SalaryVo salaryVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", salaryService.SubmitSalary3(salaryVo));
        return map1;
    }

    public Object SubmitSalary3ExamineHystixGet(@RequestBody SalaryVo salaryVo) {
        return fuse8003Util.main();
    }

    /**
     * 添加调薪 添加两个审批人
     *
     * @param salaryVo
     * @return
     */
    @PostMapping("/SubmitSalary2")
    @HystrixCommand(fallbackMethod = "SubmitSalary2ExamineHystixGet")
    public Object SubmitSalary2(@RequestBody SalaryVo salaryVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", salaryService.SubmitSalary2(salaryVo));
        return map1;
    }

    public Object SubmitSalary2ExamineHystixGet(@RequestBody SalaryVo salaryVo) {
        return fuse8003Util.main();
    }

    /**
     * 添加调薪 添加一个审批人
     *
     * @param salaryVo
     * @return
     */
    @PostMapping("/SubmitSalary1")
    @HystrixCommand(fallbackMethod = "SubmitSalary1ExamineHystixGet")
    public Object submitToCard1(@RequestBody SalaryVo salaryVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", salaryService.SubmitSalary1(salaryVo));
        return map1;
    }

    public Object SubmitSalary1ExamineHystixGet(@RequestBody SalaryVo salaryVo) {
        return fuse8003Util.main();
    }
}
