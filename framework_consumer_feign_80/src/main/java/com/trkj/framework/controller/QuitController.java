package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Quit;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class QuitController {
    @Autowired
    private AuditflowService auditflowService;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 根据审批类型的离职/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectQuitAll")
    @ApiOperation(value = "根据审批类型的离职/审批人查询待处理的审批", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectQuitAll")
    public AjaxResponse selectQuitAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectQuitAll(auditflowone);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据审批类型的离职/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndQuitAll")
    @ApiOperation(value = "根据审批类型的离职/审批人查询已处理的审批", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectEndQuitAll")
    public AjaxResponse selectEndQuitAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectEndQuitAll(auditflowone);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据审批类型的离职/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsQuit")
    @ApiOperation(value = "根据审批类型的离职/审批人查询已处理的详情信息", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectDetailsQuit")
    public AjaxResponse selectDetailsQuit(@RequestBody QuitDetailsVo quitDetailsVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectDetailsQuit(quitDetailsVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据员工名称是否有离职记录
     *
     * @param quitDetailsVo
     * @return
     */
    @PostMapping("/selectDimissionRecord")
    @ApiOperation(value = "根据员工名称是否有离职记录", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectDimissionRecord")
    public AjaxResponse selectDimissionRecord(@RequestBody QuitDetailsVo quitDetailsVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectDimissionRecord(quitDetailsVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加离职 三个审批人
     *
     * @param quitVo
     * @return
     */
    @PostMapping("/submitToLeave3")
    @ApiOperation(value = "添加离职 三个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/submitToLeave3")
    public AjaxResponse submitToLeave3(@RequestBody QuitVo quitVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.submitToLeave3(quitVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加离职 两个审批人
     *
     * @param quitVo
     * @return
     */
    @PostMapping("/submitToLeave2")
    @ApiOperation(value = "添加离职 两个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/submitToLeave2")
    public AjaxResponse submitToLeave2(@RequestBody QuitVo quitVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.submitToLeave2(quitVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加离职 一个审批人
     *
     * @param quitVo
     * @return
     */
    @PostMapping("/submitToLeave1")
    @ApiOperation(value = "添加离职 一个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/submitToLeave1")
    public AjaxResponse submitToLeave1(@RequestBody QuitVo quitVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.submitToLeave1(quitVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

}
