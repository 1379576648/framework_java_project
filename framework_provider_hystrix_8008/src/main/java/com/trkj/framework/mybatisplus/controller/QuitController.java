package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Quit;
import com.trkj.framework.mybatisplus.service.QuitService;
import com.trkj.framework.vo.FullVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 离职表 前端控制器
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
@RestController
public class QuitController {

    @Autowired
    private QuitService quitService;

    /**
     * 添加离职
     * @param quit
     * @return
     */
    @PostMapping("/insertQuit")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Object insertQuit(@RequestBody Quit quit){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",quitService.insertQuit(quit));
        return map1;
    }
    //备选方案
    public Object HystixGet(@RequestBody Quit quit){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

}

