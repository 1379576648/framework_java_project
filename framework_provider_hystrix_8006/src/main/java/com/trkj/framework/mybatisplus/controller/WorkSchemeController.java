package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.WorkScheme;
import com.trkj.framework.mybatisplus.service.WorkSchemeService;
import com.trkj.framework.vo.WorkSchemeVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    /**
     * 修改状态为禁用
     * @param workScheme
     * @return
     */
    @PutMapping("/updateWorkSchemeState")
    public int updateWorkSchemeState(@RequestBody WorkScheme workScheme){
        workScheme.setWorkschemeState(1);
        final var i = workSchemeService.updateWorkSchemeState(workScheme);
        if (i==999){
            return 666;
        }else {
            return 100;
        }
    }

    /**
     * 修改状态为启用
     * @param workScheme
     * @return
     */
    @PutMapping("/updateWorkSchemeStateTwo")
    public int updateWorkSchemeStateTwo(@RequestBody WorkScheme workScheme){
        workScheme.setWorkschemeState(0);
        final var i = workSchemeService.updateWorkSchemeStateTwo(workScheme);
        if (i==999){
            return 666;
        }else {
            return 100;
        }
    }

    /**
     * 删除加班方案
     * @param list
     * @return
     */
    @DeleteMapping("/deleteWorkScheme")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Object deleteWorkScheme(@RequestBody ArrayList<Integer> list){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",workSchemeService.deleteWorkScheme(list));
        return map1;
    }

    //备选方案
    public Object HystixGet3(@RequestBody ArrayList<Integer> list){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

}
