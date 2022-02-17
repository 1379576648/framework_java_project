package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.OperatLog;
import com.trkj.framework.entity.mybatisplus.OperatLog;
import com.trkj.framework.mybatisplus.service.OperatLogService;
import com.trkj.framework.mybatisplus.service.OperatLogService;
import com.trkj.framework.util.Fuse8007Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 13795
 */
@RestController
public class OperatLogController {
    @Autowired
    private OperatLogService operatLogService;

    @Autowired
    private Fuse8007Util fuse8007Util;
    /***
     * 登录日志分页查询
     * @param operatLog
     * @return
     */
    @PostMapping("/selectOperatLogAll")
    @HystrixCommand(fallbackMethod = "selectOperatLogAllHystrix")
    public Map<String,Object> selectOperatLogAll(@RequestBody OperatLog operatLog){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",operatLogService.selectOperatLogAll(operatLog));
        return  map1;
    }
    //备选方案
    public Map<String,Object> selectOperatLogAllHystrix(@RequestBody OperatLog operatLog){
        return fuse8007Util.main();
    }

    /**
     * 多选删除
     * @param list
     * @return
     */
    @DeleteMapping("/checkOperatLogDelete")
    @HystrixCommand(fallbackMethod = "checkOperatLogDeleteHystrix")
    public Map<String,Object> checkOperatLogDelete(@RequestBody ArrayList<Integer> list){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",operatLogService.checkDelete(list));
        return map1;
    }

    /***
     * 备选方案
     * @param list
     * @return
     */
    public Map<String,Object> checkOperatLogDeleteHystrix(@RequestBody ArrayList<Integer> list){
        return fuse8007Util.main();
    }

    /***
     * 清空数据
     * @return
     */
    @DeleteMapping("/emptyOperatLogList")
    @HystrixCommand(fallbackMethod = "emptyOperatLogListHystrix")
    public Map<String,Object> emptyOperatLogList(@RequestBody OperatLog operatLog){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",operatLogService.emptyList(operatLog));
        return map1;
    }

    /**
     * 备选方案
     * @return
     */
    public Map<String,Object> emptyOperatLogListHystrix(@RequestBody OperatLog operatLog){
        return fuse8007Util.main();
    }
}
