package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.mybatisplus.service.StaffService;
import com.trkj.framework.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author suki
 * @since 2022-01-04
 */
@RestController
public class StaffController {
    @Autowired
    private StaffService staffService;

    /**
     * 查询员工花名册
     * @param staffVo
     * @return
     */
    @PostMapping("/selectStaff")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Object selectStaff(@RequestBody StaffVo staffVo){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        map1.put("info",staffService.selectStaff(staffVo));
        return map1;
    }

    // 备选方案
    public Object HystixGet(@RequestBody StaffVo staffVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

}

