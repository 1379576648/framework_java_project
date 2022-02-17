package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.DeptPost;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TransferController {
    @Autowired
    private AuditflowService auditflowService;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 根据审批类型的调动/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectTransferAll")
    public AjaxResponse selectTransferAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectTransferAll(auditflowone);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据审批类型的调动/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndTransferAll")
    public AjaxResponse selectEndTransferAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectEndTransferAll(auditflowone);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据审批类型的调动/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsTransfer")
    public AjaxResponse selectDetailsTransfer(@RequestBody TransferDetailsVo transferDetailsVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectDetailsTransfer(transferDetailsVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 点击异动查询所有部门
     *
     * @param
     * @return
     */
    @GetMapping("/selectDeptList")
    public AjaxResponse selectDeptAll() {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectDeptAll();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据员工名称是否有调动记录
     *
     * @param transferVo
     * @return
     */
    @PostMapping("/selectTransferRecord")
    public AjaxResponse selectTransferRecord(@RequestBody Transfer8003Vo transferVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectTransferRecord(transferVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加调动 添加三个审批人
     *
     * @param transferVo
     * @return
     */
    @PostMapping("/SubmitTransfer3")
    public AjaxResponse SubmitTransfer3(@RequestBody Transfer8003Vo transferVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.SubmitTransfer3(transferVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加调动 添加两个审批人
     *
     * @param transferVo
     * @return
     */
    @PostMapping("/SubmitTransfer2")
    public AjaxResponse SubmitTransfer2(@RequestBody Transfer8003Vo transferVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.SubmitTransfer2(transferVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加调动 添加一个审批人
     *
     * @param transferVo
     * @return
     */
    @PostMapping("/SubmitTransfer1")
    public AjaxResponse SubmitTransfer1(@RequestBody Transfer8003Vo transferVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.SubmitTransfer1(transferVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据部门名称查询该部门是否有部门经理
     *
     * @param staff
     * @return
     */
    @PostMapping("/selectDeptPost")
    public AjaxResponse selectDeptPost(@RequestBody Staff staff) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectDeptPost(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
