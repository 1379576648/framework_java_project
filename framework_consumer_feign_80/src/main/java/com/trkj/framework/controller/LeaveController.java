package com.trkj.framework.controller;

import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.Auditflowone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaveController {
    @Autowired
    private AuditflowService auditflowService;

    /**
     * 根据审批类型的请假/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectLeaveAll")
    public AjaxResponse selectLeaveAll(@RequestBody Auditflowone auditflowone) {
        return AjaxResponse.success(auditflowService.selectLeaveAll(auditflowone));
    }
}
