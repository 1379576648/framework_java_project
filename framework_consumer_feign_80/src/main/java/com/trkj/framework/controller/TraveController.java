package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Travel;
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
public class TraveController {
    @Autowired
    private AuditflowService auditflowService;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /**
     * 根据审批类型的出差/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectTravelAll")
    @ApiOperation(value = "根据审批类型的出差/审批人查询待处理的审批", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectTravelAll")
    public AjaxResponse selectTravelAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectTravelAll(auditflowone);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据审批类型的出差/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndTravelAll")
    @ApiOperation(value = "根据审批类型的出差/审批人查询已处理的审批", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectEndTravelAll")
    public AjaxResponse selectEndTravelAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectEndTravelAll(auditflowone);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据审批类型的出差/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsTrave")
    @ApiOperation(value = "审批人查询已处理的详情信息", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectDetailsTrave")
    public AjaxResponse selectDetailsTrave(@RequestBody TravelDetailsVo travelDetailsVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectDetailsTrave(travelDetailsVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 根据员工名称是否有出差记录
     *
     * @param travelDetailsVo
     * @return
     */
    @PostMapping("/selectEvectionExamine")
    @ApiOperation(value = "根据员工名称是否有出差记录", notes = "审批模块", httpMethod = "POST", nickname = "查询", produces = "/selectEvectionExamine")
    public AjaxResponse selectEvectionExamine(@RequestBody TravelDetailsVo travelDetailsVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.selectEvectionExamine(travelDetailsVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加出差 三个审批人
     *
     * @param travelVo
     * @return
     */
    @PostMapping("/submitToTravel3")
    @ApiOperation(value = "添加出差 三个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/submitToTravel3")
    public AjaxResponse submitToTravel3(@RequestBody TravelVo travelVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.submitToTravel3(travelVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加出差 两个审批人
     *
     * @param travelVo
     * @return
     */
    @PostMapping("/submitToTravel2")
    @ApiOperation(value = "添加出差 两个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/submitToTravel2")
    public AjaxResponse submitToTravel2(@RequestBody TravelVo travelVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.submitToTravel2(travelVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加出差 一个审批人
     *
     * @param travelVo
     * @return
     */
    @PostMapping("/submitToTravel1")
    @ApiOperation(value = "添加出差 添加一个审批人", notes = "审批模块", httpMethod = "POST", nickname = "添加", produces = "/submitToTravel1")
    public AjaxResponse submitToTravel1(@RequestBody TravelVo travelVo) {
        Map<String, Object> map = (Map<String, Object>) auditflowService.submitToTravel1(travelVo);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
