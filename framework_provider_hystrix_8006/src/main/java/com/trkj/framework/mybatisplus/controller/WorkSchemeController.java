package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Salary;
import com.trkj.framework.entity.mybatisplus.WorkScheme;
import com.trkj.framework.mybatisplus.service.WorkSchemeService;
import com.trkj.framework.vo.WorkSchemeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WorkSchemeController {

    @Autowired
    private WorkSchemeService workSchemeService;

    /**
     * 查询加班方案
     * @param workSchemeVo
     * @return
     */
    @PostMapping("/selectWorkScheme")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Object selectWorkScheme(@RequestBody WorkSchemeVo workSchemeVo){
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state",200);
        map1.put("info",workSchemeService.selectWorkScheme(workSchemeVo));
        return map1;
    }

    //备选方案
    public Object HystixGet(@RequestBody WorkSchemeVo workSchemeVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 添加加班方案
     * @param workScheme
     * @return
     */
    @PostMapping("/insertWorkScheme")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object insertWorkScheme(@RequestBody WorkScheme workScheme){
        return workSchemeService.insertWorkScheme(workScheme);
    }

    //备选方案
    public Object HystixGet2(@RequestBody WorkScheme workScheme){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }
}
