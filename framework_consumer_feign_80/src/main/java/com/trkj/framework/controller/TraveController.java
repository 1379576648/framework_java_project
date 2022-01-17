package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Travel;
import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraveController {
    @Autowired
    private AuditflowService auditflowService;

    /**
     * 根据审批类型的出差/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectTravelAll")
    public AjaxResponse selectTravelAll(@RequestBody Auditflowone auditflowone) {
        return AjaxResponse.success(auditflowService.selectTravelAll(auditflowone));
    }

    /**
     * 根据审批类型的出差/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndTravelAll")
    public AjaxResponse selectEndTravelAll(@RequestBody Auditflowone auditflowone) {
        return AjaxResponse.success(auditflowService.selectEndTravelAll(auditflowone));
    }

    /**
     * 根据审批类型的出差/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsTrave")
    public AjaxResponse selectDetailsTrave(@RequestBody TravelDetailsVo travelDetailsVo) {
        return AjaxResponse.success(auditflowService.selectDetailsTrave(travelDetailsVo));
    }

    /**
     * 根据员工名称是否有出差记录
     * @param travel
     * @return
     */
    @PostMapping("/selectEvectionExamine")
    public AjaxResponse selectEvectionExamine(@RequestBody Travel travel){
        return AjaxResponse.success(auditflowService.selectEvectionExamine(travel));
    }

    /**
     * 添加出差 三个审批人
     * @param travelVo
     * @return
     */
    @PostMapping("/submitToTravel3")
    public AjaxResponse submitToTravel3(@RequestBody TravelVo travelVo){
        return AjaxResponse.success(auditflowService.submitToTravel3(travelVo));
    }

    /**
     * 添加出差 两个审批人
     * @param travelVo
     * @return
     */
    @PostMapping("/submitToTravel2")
    public AjaxResponse submitToTravel2(@RequestBody TravelVo travelVo){
        return AjaxResponse.success(auditflowService.submitToTravel2(travelVo));
    }
}
