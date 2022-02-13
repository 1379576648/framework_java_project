package com.trkj.framework.mybatisplus.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Overtimeask;
import com.trkj.framework.mybatisplus.service.OverTimeService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 加班记录 前端控制器
 */
@RestController
public class OverTimeController {
    @Autowired
    private OverTimeService overTimeService;

    /**
     * 根据员工名称查询加班记录
     *
     * @param overtimeask
     * @return
     */
    @PostMapping("/selectOverTimeRecordAll")
    @HystrixCommand(fallbackMethod = "selectOverTimeRecordAllHystixGet")
    public Object selectOverTimeRecordAll(@RequestBody Overtimeask overtimeask) {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(date);
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", overTimeService.selectOverTimeRecordAll(overtimeask));
        return map1;
    }

    public Object selectOverTimeRecordAllHystixGet(@RequestBody Overtimeask overtimeask) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 删除加班记录
     *
     * @param overtimeask
     * @return
     */
    @PostMapping("/deleteOverTime")
    @HystrixCommand(fallbackMethod = "deleteOverTimeHystixGet")
    public Object deleteOverTime(@RequestBody Overtimeask overtimeask) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", overTimeService.deleteOverTime(overtimeask));
        return map1;
    }

    public Object deleteOverTimeHystixGet(@RequestBody Overtimeask overtimeask) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 开始加班
     *
     * @param overtimeask
     * @return
     */
    @PostMapping("/updateBeginOverTime")
    @HystrixCommand(fallbackMethod = "updateBeginOverTimeHystixGet")
    public Object updateBeginOverTime(@RequestBody Overtimeask overtimeask) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", overTimeService.updateBeginOverTime(overtimeask));
        return map1;
    }

    public Object updateBeginOverTimeHystixGet(@RequestBody Overtimeask overtimeask) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 结束加班
     *
     * @param overtimeask
     * @return
     */
    @PostMapping("/updateEndOverTime")
    @HystrixCommand(fallbackMethod = "updateEndOverTimeHystixGet")
    public Object updateEndOverTime(@RequestBody Overtimeask overtimeask) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        map1.put("info", overTimeService.updateEndOverTime(overtimeask));
        return map1;
    }

    public Object updateEndOverTimeHystixGet(@RequestBody Overtimeask overtimeask) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }
}
