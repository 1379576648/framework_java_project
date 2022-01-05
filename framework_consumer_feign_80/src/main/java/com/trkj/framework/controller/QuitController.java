package com.trkj.framework.controller;

import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.QuitDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuitController {
    @Autowired
    private AuditflowService auditflowService;

    /**
     * 根据审批类型的离职/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectQuitAll")
    public AjaxResponse selectQuitAll(@RequestBody Auditflowone auditflowone) {
        return AjaxResponse.success(auditflowService.selectQuitAll(auditflowone));
    }

    /**
     * 根据审批类型的离职/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndQuitAll")
    public AjaxResponse selectEndQuitAll(@RequestBody Auditflowone auditflowone) {
        return AjaxResponse.success(auditflowService.selectEndQuitAll(auditflowone));
    }

    /**
     * 根据审批类型的离职/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsQuit")
    public AjaxResponse selectDetailsQuit(@RequestBody QuitDetailsVo quitDetailsVo) {
        return AjaxResponse.success(auditflowService.selectDetailsQuit(quitDetailsVo));
    }
}
