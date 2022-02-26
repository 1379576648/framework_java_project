package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Card;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 112729
 */
@RestController
public class CardController {
    @Autowired
    private AuditflowService auditflowService;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 根据审批类型的补打卡/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectCardAll")
    @ApiOperation(value = "查询待处理的补打卡审批", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectCardAll")
    public AjaxResponse selectCardAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectCardAll(auditflowone);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据审批类型的补打卡/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndCardAll")
    @ApiOperation(value = "查询已处理的补打卡审批", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectEndCardAll")
    public AjaxResponse selectEndCardAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectEndCardAll(auditflowone);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据审批类型的补打卡/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsCards")
    @ApiOperation(value = "查询已处理的补打卡审批详情信息", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectDetailsCards")
    public AjaxResponse selectDetailsCards(@RequestBody CardDetailsVo cardDetailsVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectDetailsCards(cardDetailsVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据员工名称是否有补打卡记录
     *
     * @param cardDetailsVo
     * @return
     */
    @PostMapping("/selectCardExamine")
    @ApiOperation(value = "根据员工名称是否有补打卡记录", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectCardExamine")
    public AjaxResponse selectCardExamine(@RequestBody CardDetailsVo cardDetailsVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectCardExamine(cardDetailsVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加补打卡 三个审批人
     *
     * @param cardVo
     * @return
     */
    @PostMapping("/submitToCard3")
    @ApiOperation(value = "添加补打卡 三个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/submitToCard3")
    public AjaxResponse submitToCard3(@RequestBody CardVo cardVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.submitToCard3(cardVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加补打卡 两个审批人
     *
     * @param cardVo
     * @return
     */
    @PostMapping("/submitToCard2")
    @ApiOperation(value = "添加补打卡 两个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/submitToCard2")
    public AjaxResponse submitToCard2(@RequestBody CardVo cardVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.submitToCard2(cardVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加补打卡 一个审批人
     *
     * @param cardVo
     * @return
     */
    @PostMapping("/submitToCard1")
    @ApiOperation(value = "添加补打卡 一个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/submitToCard1")
    public AjaxResponse submitToCard1(@RequestBody CardVo cardVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.submitToCard1(cardVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
