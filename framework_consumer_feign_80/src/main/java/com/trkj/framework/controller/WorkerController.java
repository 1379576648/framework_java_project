package com.trkj.framework.controller;

import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.WorkerDetaIsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkerController {
    @Autowired
    private AuditflowService auditflowService;

    /**
     * 根据审批类型的转正/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectWorkerlAll")
    public AjaxResponse selectWorkerlAll(@RequestBody Auditflowone auditflowone) {
        return AjaxResponse.success(auditflowService.selectWorkerlAll(auditflowone));
    }

    /**
     * 根据审批类型的转正/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndWorkerlAll")
    public AjaxResponse selectEndWorkerlAll(@RequestBody Auditflowone auditflowone) {
        return AjaxResponse.success(auditflowService.selectEndWorkerlAll(auditflowone));
    }

    /**
     * 根据审批类型的转正/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsWorker")
    public AjaxResponse selectDetailsWorker(@RequestBody WorkerDetaIsVo workerDetaIsVo) {
        return AjaxResponse.success(auditflowService.selectDetailsWorker(workerDetaIsVo));
    }
}
