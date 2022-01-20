package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Card;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.vo.*;
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

    /**
     * 根据员工名称是否有补打卡记录
     * @param card
     * @return
     */
    @PostMapping("/selectCardExamine")
    public AjaxResponse selectCardExamine(@RequestBody Card card){
        return AjaxResponse.success(auditflowService.selectCardExamine(card));
    }

    /**
     * 添加补打卡 三个审批人
     * @param cardVo
     * @return
     */
    @PostMapping("/submitToCard3")
    public AjaxResponse submitToCard3(@RequestBody CardVo cardVo){
        return AjaxResponse.success(auditflowService.submitToCard3(cardVo));
    }

    /**
     * 添加补打卡 两个审批人
     * @param cardVo
     * @return
     */
    @PostMapping("/submitToCard2")
    public AjaxResponse submitToCard2(@RequestBody CardVo cardVo){
        return AjaxResponse.success(auditflowService.submitToCard2(cardVo));
    }

}
