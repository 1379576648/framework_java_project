package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.mybatisplus.service.RegisterLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 登录日志表 前端控制器
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-28
 */
@RestController
public class RegisterLogController {
    @Autowired
    private RegisterLogService registerLogService;

    /***
     * 登录日志分页查询
     * @param registerLog
     * @return
     */
    @PostMapping("/selectRegisterLogAll")
    @HystrixCommand(fallbackMethod = "selectRegisterLogAllHystrix")
    public Object selectRegisterLogAll(@RequestBody  RegisterLog registerLog){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",registerLogService.selectRegisterLogAll(registerLog));
        return  map1;
    }
    //备选方案
    public Object selectRegisterLogAllHystrix(@RequestBody RegisterLog registerLog){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }
}

