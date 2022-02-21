package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Fixedwagf;
import com.trkj.framework.mybatisplus.service.FixedwagfService;
import com.trkj.framework.util.Fuse8006Util;
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

    @Autowired
    private Fuse8006Util fuse8006Util;
    /**
     * 查询固定工资
     * @param fixedwageVo
     * @return
     */
    @PostMapping("/selectFixedwage")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Map<String,Object> selectFixedwage(@RequestBody FixedwageVo fixedwageVo){
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state",200);
        map1.put("info",fixedwageService.selectFixedwage(fixedwageVo));
        return map1;
    }

    // 备选方案
    public Map<String,Object> HystixGet(@RequestBody FixedwageVo fixedwageVo){
        return fuse8006Util.main();
    }

    /**
     * 修改固定工资
     * @param fixedwagf
     * @return
     */
    @PutMapping("/updateFixedwage")
    @HystrixCommand(fallbackMethod = "updateFixedwageHystix")
    public Object updateFixedwage(@RequestBody Fixedwagf fixedwagf){
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state",200);
        map1.put("info",fixedwageService.updateFixedwage(fixedwagf));
        return map1;
    }
    // 备选方案
    public Map<String,Object> updateFixedwageHystix(@RequestBody Fixedwagf fixedwagf){
        return fuse8006Util.main();
    }
}
