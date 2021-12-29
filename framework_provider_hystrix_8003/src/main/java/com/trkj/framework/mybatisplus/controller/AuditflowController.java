package com.trkj.framework.mybatisplus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.mybatisplus.service.AuditflowService;
import com.trkj.framework.vo.Auditflowone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 审批主表 前端控制器
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-27
 */
@RestController
public class AuditflowController {
    @Autowired
    private AuditflowService auditflowService;

    // 根据审批类型的加班/审批人查询待处理的审批
    @PostMapping("/selectAuditflow")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Object selectAuditflowoneAll(@RequestBody Auditflowone auditflowone) {
        System.out.println("11111111111111111111111");
        System.out.println(auditflowone);
        System.out.println("11111111111111111111111");
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        map1.put("info",auditflowService.selectAuditflowoneAll(auditflowone));
        return map1;
    }
    // 备选方案
    public Object HystixGet(@RequestBody Auditflowone auditflowone){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    // 根据审批类型的加班/审批人查询已处理的审批
    @PostMapping("/selectEnddAuditflow")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object selectEnddAuditflow(@RequestBody Auditflowone auditflowone) {
        System.out.println("11111111111111111111111");
        System.out.println(auditflowone);
        System.out.println("11111111111111111111111");
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        map1.put("info",auditflowService.selectEnddAuditflow(auditflowone));
        return map1;
    }
    // 备选方案
    public Object HystixGet2(@RequestBody Auditflowone auditflowone){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    // // 根据审批类型的加班/审批人查询已处理的详情信息
    // @GetMapping("/selectDetailsAuditflow")
    // public Auditflowone selectDetailsAuditflow(int id,String name1,String name2) {
    //     HashMap<String, Object> map = new HashMap<>();
    //     map.put("id", id);
    //     map.put("name1", name1);
    //     map.put("name2", name2);
    //     List<Auditflowone> users = auditflowService.selectDetailsAuditflow(map);
    //     return null;
    // }

    // // 备选方案
    // public Object HystixGet2(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
    //     Page<Auditflowone> page = new Page<>(currentPage, pagesize);
    //     Map<String, Object> map=new HashMap<String, Object>();
    //     map.put("state",500);
    //     map.put("succeed","服务发生雪崩");
    //     return page;
    // }

}

