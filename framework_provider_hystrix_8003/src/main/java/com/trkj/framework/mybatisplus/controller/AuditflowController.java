package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Auditflowdetail;
import com.trkj.framework.mybatisplus.service.AuditflowService;
import com.trkj.framework.vo.AuditflowDetailsVo;
import com.trkj.framework.vo.Auditflowone;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 加班 前端控制器
 *
 * @author 劉祁
 * @since 2021-12-27
 */
@RestController
public class AuditflowController {
    @Autowired
    private AuditflowService auditflowService;

    /**
     * 根据审批类型的加班/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectAuditflow")
    @HystrixCommand(fallbackMethod = "HystixGet1")
    public Object selectAuditflowoneAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", auditflowService.selectAuditflowoneAll(auditflowone));
        return map1;
    }

    public Object HystixGet1(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据审批类型的加班/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEnddAuditflow")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object selectEnddAuditflow(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", auditflowService.selectEnddAuditflow(auditflowone));
        return map1;
    }

    public Object HystixGet2(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据审批类型的加班/审批人查询已处理的详情信息
     *
     * @param auditflowDetailsVo
     * @return
     */
    @PostMapping("/selectDetailsAuditflow")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Object selectDetailsAuditflow(@RequestBody AuditflowDetailsVo auditflowDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.selectDetailsAuditflow(auditflowDetailsVo));
        return map1;
    }

    public Object HystixGet3(@RequestBody AuditflowDetailsVo auditflowDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据审批明细表ID修改其状态 通过
     *
     * @param
     * @return
     */
    @PostMapping("/update_Approval_State")
    public int updateApprovalState(@RequestBody Auditflowdetail auditflowdetail1) {
        auditflowdetail1.setAuditflowdetaiState(2);
        auditflowdetail1.setAuditflowdetaiRemarks(auditflowdetail1.getAuditflowdetaiRemarks());
        final var i = auditflowService.updateApprovalState(auditflowdetail1);
        if (i==1){
            return 666;
        }else {
            return 999;
        }
    }

    /**
     * 根据审批明细表ID修改其状态 驳回
     * @param auditflowdetail1
     * @return
     */
    @PostMapping("/reject_Approval_State")
    public int rejectApprovalState(@RequestBody Auditflowdetail auditflowdetail1) {
        auditflowdetail1.setAuditflowdetaiState(3);
        auditflowdetail1.setAuditflowdetaiRemarks(auditflowdetail1.getAuditflowdetaiRemarks());
        final var i = auditflowService.rejectApprovalState(auditflowdetail1);
        if (i==1){
            return 666;
        }else {
            return 999;
        }
    }

    /**
     * 根据审批编号查询对应的审批明细表编号
     *
     * @param auditflowdetail
     * @return
     */
    @PostMapping("/queryDetail")
    @HystrixCommand(fallbackMethod = "HystixGet5")
    public Object queryDetail(@RequestBody Auditflowdetail auditflowdetail) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", auditflowService.queryDetail(auditflowdetail));
        return map1;
    }

    public Object HystixGet5(@RequestBody Auditflowdetail auditflowdetail) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }
}

