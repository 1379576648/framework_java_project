package com.trkj.framework.controller;

import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
    @Autowired
    private AuditflowService auditflowService;

    /**
     * 根据审批类型的调动/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectTransferAll")
    public AjaxResponse selectTransferAll(@RequestBody Auditflowone auditflowone) {
        return AjaxResponse.success(auditflowService.selectTransferAll(auditflowone));
    }

    /**
     * 根据审批类型的调动/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndTransferAll")
    public AjaxResponse selectEndTransferAll(@RequestBody Auditflowone auditflowone) {
        return AjaxResponse.success(auditflowService.selectEndTransferAll(auditflowone));
    }

    /**
     * 根据审批类型的调动/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsTransfer")
    public AjaxResponse selectDetailsTransfer(@RequestBody TransferDetailsVo transferDetailsVo) {
        return AjaxResponse.success(auditflowService.selectDetailsTransfer(transferDetailsVo));
    }

    /**
     *  点击异动查询所有部门
     * @param
     * @return
     */
    @GetMapping("/selectDeptList")
    public AjaxResponse selectDeptAll(){
        return AjaxResponse.success(auditflowService.selectDeptAll());
    }

    /**
     * 根据员工名称是否有调动记录
     * @param transferVo
     * @return
     */
    @PostMapping("/selectTransferRecord")
    public AjaxResponse selectTransferRecord(@RequestBody Transfer8003Vo transferVo){
        return AjaxResponse.success(auditflowService.selectTransferRecord(transferVo));
    }

    /**
     * 添加调动 添加三个审批人
     * @param transferVo
     * @return
     */
    @PostMapping("/SubmitTransfer3")
    public AjaxResponse SubmitTransfer3(@RequestBody Transfer8003Vo transferVo){
        return AjaxResponse.success(auditflowService.SubmitTransfer3(transferVo));
    }

    /**
     * 添加调动 添加两个审批人
     * @param transferVo
     * @return
     */
    @PostMapping("/SubmitTransfer2")
    public AjaxResponse SubmitTransfer2(@RequestBody Transfer8003Vo transferVo){
        return AjaxResponse.success(auditflowService.SubmitTransfer2(transferVo));
    }

    /**
     * 添加调动 添加一个审批人
     * @param transferVo
     * @return
     */
    @PostMapping("/SubmitTransfer1")
    public AjaxResponse SubmitTransfer1(@RequestBody Transfer8003Vo transferVo){
        return AjaxResponse.success(auditflowService.SubmitTransfer1(transferVo));
    }
}
