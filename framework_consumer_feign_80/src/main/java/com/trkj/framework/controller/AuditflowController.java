package com.trkj.framework.controller;

import com.trkj.framework.service.client.examine.AuditflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditflowController {
    @Autowired
    private AuditflowService auditflowService =null;

    // 根据审批类型的加班/审批人查询待处理的审批
    @GetMapping("/selectAuditflow")
    public Object queryemp(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        return auditflowService.queryemp(currentPage,pagesize);
    }

    // 根据审批类型的加班/审批人查询待处理的审批
    @GetMapping("/selectEndAuditflow")
    public Object queryemp1(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        return auditflowService.queryemp1(currentPage,pagesize);
    }
}
