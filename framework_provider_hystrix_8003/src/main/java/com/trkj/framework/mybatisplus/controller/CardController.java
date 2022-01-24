package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Card;
import com.trkj.framework.mybatisplus.service.CardService;
import com.trkj.framework.mybatisplus.service.LeaveService;
import com.trkj.framework.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 补打卡 --前端控制器
 *
 * @author 里予
 * @since 2022-1-2
 */
@RestController
public class CardController {
    @Autowired
    private CardService cardService;

    /**
     * 根据审批类型的补打卡/审批人查询待处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectCardAll")
    @HystrixCommand(fallbackMethod = "HystixGet1")
    public Object selectCardAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", cardService.selectCardAll(auditflowone));
        return map1;
    }

    public Object HystixGet1(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据审批类型的补打卡/审批人查询已处理的审批
     *
     * @param auditflowone
     * @return
     */
    @PostMapping("/selectEndCardAll")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object selectEndCardAll(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", cardService.selectEndCardAll(auditflowone));
        return map1;
    }

    public Object HystixGet2(@RequestBody Auditflowone auditflowone) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据审批类型的补打卡/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @PostMapping("/selectDetailsCards")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Object selectDetailsCards(@RequestBody CardDetailsVo cardDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", cardService.selectDetailsCards(cardDetailsVo));
        return map1;
    }

    public Object HystixGet3(@RequestBody CardDetailsVo cardDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 根据员工名称是否有补打卡记录
     * @param
     * @return
     */
    @PostMapping("/selectCardExamine")
    @HystrixCommand(fallbackMethod = "selectCardExamineHystixGet")
    public Object selectCardExamine(@RequestBody CardDetailsVo cardDetailsVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", cardService.selectCardExamine(cardDetailsVo));
        return map1;
    }

    public Object selectCardExamineHystixGet(@RequestBody CardDetailsVo cardDetailsVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }


    /**
     * 添加补打卡 添加三个审批人
     * @param cardVo
     * @return
     */
    @PostMapping("/submitToCard3")
    public int submitToCard3(@RequestBody CardVo cardVo){
        return  cardService.submitToCard3(cardVo);
    }

    /**
     * 添加补打卡 添加两个审批人
     * @param cardVo
     * @return
     */
    @PostMapping("/submitToCard2")
    public int submitToCard2(@RequestBody CardVo cardVo){
        return  cardService.submitToCard2(cardVo);
    }

    /**
     * 添加补打卡 添加一个审批人
     * @param cardVo
     * @return
     */
    @PostMapping("/submitToCard1")
    @HystrixCommand(fallbackMethod = "submitToCard1ExamineHystixGet")
    public Object submitToCard1(@RequestBody CardVo cardVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", cardService.submitToCard1(cardVo));
        return map1;
    }

    public Object submitToCard1ExamineHystixGet(@RequestBody CardVo cardVo) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }
}
