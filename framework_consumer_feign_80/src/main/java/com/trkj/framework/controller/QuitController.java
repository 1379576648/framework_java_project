package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Quit;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.vo.*;
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

    /**
     * 根据员工名称是否有离职记录
     * @param quitDetailsVo
     * @return
     */
    @PostMapping("/selectDimissionRecord")
    public AjaxResponse selectDimissionRecord(@RequestBody QuitDetailsVo quitDetailsVo){
        return AjaxResponse.success(auditflowService.selectDimissionRecord(quitDetailsVo));
    }

    /**
     * 添加离职 三个审批人
     * @param quitVo
     * @return
     */
    @PostMapping("/submitToLeave3")
    public AjaxResponse submitToLeave3(@RequestBody QuitVo quitVo){
        return AjaxResponse.success(auditflowService.submitToLeave3(quitVo));
    }

    /**
     * 添加离职 两个审批人
     * @param quitVo
     * @return
     */
    @PostMapping("/submitToLeave2")
    public AjaxResponse submitToLeave2(@RequestBody QuitVo quitVo){
        return AjaxResponse.success(auditflowService.submitToLeave2(quitVo));
    }

    /**
     * 添加离职 一个审批人
     * @param quitVo
     * @return
     */
    @PostMapping("/submitToLeave1")
    public AjaxResponse submitToLeave1(@RequestBody QuitVo quitVo){
        return AjaxResponse.success(auditflowService.submitToLeave1(quitVo));
    }

}
