package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.mybatisplus.service.WageTableService;
import com.trkj.framework.util.Fuse8006Util;
import com.trkj.framework.vo.WageTableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WageTableController {
    @Autowired
    private WageTableService wageTableService;
    @Autowired
    private Fuse8006Util fuse8006Util;

    /**
     * 查询工资表
     * @param staff
     * @return
     */
    @PostMapping("/selectWage")
    @HystrixCommand(fallbackMethod = "hystixGet")
    public Map<String, Object> selectWage(@RequestBody Staff staff){
        Map<String, Object> map1 = new HashMap(2);
        //状态码
        map1.put("state",200);
        map1.put("info",wageTableService.selectWage(staff));
        return map1;
    }

    //备选方案
    public  Map<String, Object> hystixGet(@RequestBody Staff staff){
        return fuse8006Util.main();
    }
}
