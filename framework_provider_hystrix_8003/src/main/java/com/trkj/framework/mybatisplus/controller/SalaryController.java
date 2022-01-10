package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.mybatisplus.service.SalaryService;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.QuitDetailsVo;
import com.trkj.framework.vo.SalaryDetailsVo;
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
}
