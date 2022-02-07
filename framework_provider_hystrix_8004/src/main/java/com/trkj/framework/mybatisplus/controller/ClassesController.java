package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Classes;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.mybatisplus.service.CardRecordService;
import com.trkj.framework.mybatisplus.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 班次方案 前端控制器
 * @author 112729
 */
@RestController
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    /**
     * 查询所有班次方案
     * @param classes
     * @return
     */
    @PostMapping("/selectClassesAll")
    @HystrixCommand(fallbackMethod = "selectClassesAllHystixGet")
    public Object selectClassesAll(@RequestBody Classes classes) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", classesService.selectClassesAll(classes));
        return map1;
    }
    public Object selectClassesAllHystixGet(@RequestBody Classes classes) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 添加班次方案
     * @param classes
     * @return
     */
    @PostMapping("/submitFormClasses")
    @HystrixCommand(fallbackMethod = "submitFormClassesHystixGet")
    public Object submitFormClasses(@RequestBody Classes classes) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", classesService.submitFormClasses(classes));
        return map1;
    }
    public Object submitFormClassesHystixGet(@RequestBody Classes classes) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 查询班次方案
     * @param classes
     * @return
     */
    @PostMapping("/inquireClasses")
    @HystrixCommand(fallbackMethod = "inquireClassesHystixGet")
    public Object inquireClassesName(@RequestBody Classes classes) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", classesService.inquireClasses(classes));
        return map1;
    }
    public Object inquireClassesHystixGet(@RequestBody Classes classes) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 删除班次方案
     * @param classes
     * @return
     */
    @PostMapping("/deleteClasses")
    @HystrixCommand(fallbackMethod = "deleteClassesHystixGet")
    public Object deleteClasses(@RequestBody Classes classes) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", classesService.deleteClasses(classes));
        return map1;
    }
    public Object deleteClassesHystixGet(@RequestBody Classes classes) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }
}
