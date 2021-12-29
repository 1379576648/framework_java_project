package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.Auditflowone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuditflowController {
    @Autowired
    private AuditflowService auditflowService =null;

    // 根据审批类型的加班/审批人查询待处理的审批
    @PostMapping("/selectAuditflow")
    public AjaxResponse selectAuditflowoneAll(@RequestBody Auditflowone auditflowone){
        return AjaxResponse.success(auditflowService.selectAuditflowoneAll(auditflowone)) ;
    }

    // 根据审批类型的加班/审批人查询待处理的审批
    @PostMapping("/selectEnddAuditflow")
    public AjaxResponse selectEnddAuditflow(@RequestBody Auditflowone auditflowone){
        return AjaxResponse.success(auditflowService.selectEnddAuditflow(auditflowone)) ;
    }
}
