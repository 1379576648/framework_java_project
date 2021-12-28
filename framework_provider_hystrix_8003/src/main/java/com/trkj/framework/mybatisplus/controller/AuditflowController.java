package com.trkj.framework.mybatisplus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.mybatisplus.service.AuditflowService;
import com.trkj.framework.vo.Auditflowone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
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
    @GetMapping("/selectAuditflow")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Object queryemp(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        Page<Auditflowone> page = new Page<>(currentPage, pagesize);
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("state",200);
        map.put("succeed",auditflowService.selectPageVo(page));
        return map;
    }
    // 备选方案
    public Object HystixGet(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<Auditflowone> page = new Page<>(currentPage, pagesize);
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("state",500);
        map.put("succeed","服务发生雪崩");
        return page;
    }

    // 根据审批类型的加班/审批人查询已处理的审批
    @GetMapping("/selectEndAuditflow")
    @HystrixCommand(fallbackMethod = "HystixGet1")
    public Object queryemp1(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        Page<Auditflowone> page = new Page<>(currentPage, pagesize);
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("state",200);
        map.put("succeed",auditflowService.selectPageVo1(page));
        return map;
    }
    // 备选方案
    public Object HystixGet1(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<Auditflowone> page = new Page<>(currentPage, pagesize);
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("state",500);
        map.put("succeed","服务发生雪崩");
        return page;
    }
}

