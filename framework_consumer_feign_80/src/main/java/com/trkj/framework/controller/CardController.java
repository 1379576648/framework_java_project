package com.trkj.framework.controller;

import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.CardDetailsVo;
import com.trkj.framework.vo.LeaveDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 112729
 */
@RestController
public class CardController {
    @Autowired
    private AuditflowService auditflowService;

    /**
     * 根据审批类型的补打卡/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectCardAll")
    public AjaxResponse selectCardAll(@RequestBody Auditflowone auditflowone) {
        return AjaxResponse.success(auditflowService.selectCardAll(auditflowone));
    }

    /**
     * 根据审批类型的补打卡/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndCardAll")
    public AjaxResponse selectEndCardAll(@RequestBody Auditflowone auditflowone) {
        return AjaxResponse.success(auditflowService.selectEndCardAll(auditflowone));
    }

    /**
     * 根据审批类型的补打卡/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsCards")
    public AjaxResponse selectDetailsCards(@RequestBody CardDetailsVo cardDetailsVo) {
        return AjaxResponse.success(auditflowService.selectDetailsCards(cardDetailsVo));
    }
}
