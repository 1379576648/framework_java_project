package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Travel;
import com.trkj.framework.mybatisplus.service.TraveService;
import com.trkj.framework.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 出差 --前端控制器
 *
 * @author 里予
 * @since 2022-1-2
 */
@RestController
public class TravelController {
    @Autowired
    private TraveService traveService;

    /**
     * 根据审批类型的出差/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectTravelAll")
    @HystrixCommand(fallbackMethod = "HystixGet1")
    public Object selectTravelAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", traveService.selectTravelAll(auditflowone));
        return map1;
    }

    public Object HystixGet1(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据审批类型的出差/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndTravelAll")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object selectEndLeaveAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", traveService.selectEndTravelAll(auditflowone));
        return map1;
    }

    public Object HystixGet2(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据审批类型的出差/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsTrave")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Object selectDetailsLeaves(@RequestBody TravelDetailsVo travelDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", traveService.selectDetailsTrave(travelDetailsVo));
        return map1;
    }

    public Object HystixGet3(@RequestBody TravelDetailsVo travelDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据员工名称是否有出差记录
     *
     * @param travelDetailsVo
     * @return
     */
    @PostMapping("/selectEvectionExamine")
    @HystrixCommand(fallbackMethod = "selectEvectionExamineExamineHystixGet")
    public Object selectEvectionExamine(@RequestBody TravelDetailsVo travelDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", traveService.selectEvectionExamine(travelDetailsVo));
        return map1;
    }

    public Object selectEvectionExamineExamineHystixGet(@RequestBody TravelDetailsVo travelDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 添加出差 添加三个审批人
     *
     * @param travelVo
     * @return
     */
    @PostMapping("/submitToTravel3")
    @HystrixCommand(fallbackMethod = "submitToTravel3ExamineHystixGet")
    public Object submitToTravel3(@RequestBody TravelVo travelVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", traveService.submitToTravel3(travelVo));
        return map1;
    }

    public Object submitToTravel3ExamineHystixGet(@RequestBody TravelVo travelVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 添加出差 添加两个审批人
     *
     * @param travelVo
     * @return
     */
    @PostMapping("/submitToTravel2")
    @HystrixCommand(fallbackMethod = "submitToTravel2ExamineHystixGet")
    public Object submitToTravel2(@RequestBody TravelVo travelVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", traveService.submitToTravel2(travelVo));
        return map1;
    }

    public Object submitToTravel2ExamineHystixGet(@RequestBody TravelVo travelVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 添加出差 添加一个审批人
     *
     * @param travelVo
     * @return
     */
    @PostMapping("/submitToTravel1")
    @HystrixCommand(fallbackMethod = "submitToTravel1ExamineHystixGet")
    public Object submitToTravel1(@RequestBody TravelVo travelVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", traveService.submitToTravel1(travelVo));
        return map1;
    }

    public Object submitToTravel1ExamineHystixGet(@RequestBody TravelVo travelVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }
}
