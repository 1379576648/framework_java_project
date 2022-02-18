package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import com.trkj.framework.mybatisplus.service.FixedwagfService;
import com.trkj.framework.vo.FixedwageVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FixedwagfController {

    @Autowired
    private FixedwagfService fixedwageService;

    /**
     * 查询固定工资
     * @param fixedwageVo
     * @return
     */
    @PostMapping("/selectFixedwage")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Object selectFixedwage(@RequestBody FixedwageVo fixedwageVo){
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state",200);
        map1.put("info",fixedwageService.selectFixedwage(fixedwageVo));
        return map1;
    }

    // 备选方案
    public Object HystixGet(@RequestBody FixedwageVo fixedwageVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 修改固定工资
     * @param fixedwagf
     * @return
     */
    @PutMapping("/updateFixedwage")
    public Object updateFixedwage(@RequestBody Fixedwagf fixedwagf){
        //试用期基本工资
        fixedwagf.setFixedwagePeriodmoney(fixedwagf.getFixedwagePeriodmoney());
        //正式基本工资
        fixedwagf.setFixedwageOfficialmoney(fixedwagf.getFixedwageOfficialmoney());
        //试用期固定工资
        fixedwagf.setFixedwagePeriodpostmoney(fixedwagf.getFixedwagePeriodpostmoney());
        //正式固定工资
        fixedwagf.setFixedwageOfflcialpostmoney(fixedwagf.getFixedwageOfflcialpostmoney());
        //备注
        fixedwagf.setFixedwageRemark(fixedwagf.getFixedwageRemark());
        final var i = fixedwageService.updateFixedwage(fixedwagf);
        if (i==999){
            return 666;
        }else {
            return 100;
        }
    }
}
