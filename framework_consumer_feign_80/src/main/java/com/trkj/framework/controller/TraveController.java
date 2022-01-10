package com.trkj.framework.controller;

import com.trkj.framework.service.client.examine.AuditflowService;
import com.trkj.framework.vo.AjaxResponse;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.TravelDetailsVo;
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
}
