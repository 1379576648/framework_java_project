package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Glory;
import com.trkj.framework.entity.mybatisplus.Punish;
import com.trkj.framework.mybatisplus.service.GloryService;
import com.trkj.framework.mybatisplus.service.PunishService;
import com.trkj.framework.util.Fuse8008Util;
import com.trkj.framework.vo.WorkVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 惩罚表 前端控制器
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
@RestController
public class PunishController {

    @Autowired
    private PunishService punishService;

    @Autowired
    private Fuse8008Util fuse8008Util;
    /**
     * 根据惩罚id查询惩罚
     * @param workVo
     * @return
     */
    @PostMapping("/selectPunishOne")
    @HystrixCommand(fallbackMethod = "hystixGet")
    public Map<String, Object> selectPunishOne(@RequestBody WorkVo workVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", punishService.selectPunishOne(workVo));
        return map1;
    }

    //备选方案
    public Map<String,Object> hystixGet(@RequestBody WorkVo workVo) {
        return fuse8008Util.main();
    }

    /**
     * 添加惩罚
     * @param punish
     * @return
     */
    @PostMapping("/insertPunish")
    @HystrixCommand(fallbackMethod = "hystixGet2")
    public Map<String, Object> insertPunish(@RequestBody Punish punish){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",punishService.insertPunish(punish));
        return map1;
    }

    //备选方案
    public Map<String,Object> hystixGet2(@RequestBody Punish punish) {
        return fuse8008Util.main();
    }

    /**
     * 修改惩罚
     * @param punishId
     * @return
     */
    @PutMapping("/updatePunish")
    @HystrixCommand(fallbackMethod = "updatePunishHystrix")
    public Map<String, Object> updatePunish(@RequestBody Punish punishId){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",punishService.updatePunish(punishId));
        return map1;

    }
    //备选方案
    public Map<String,Object> updatePunishHystrix(@RequestBody Punish punishId) {
        return fuse8008Util.main();
    }
    /**
     * 删除惩罚
     * @param list
     * @return
     */
    @DeleteMapping("/deletePunish")
    @HystrixCommand(fallbackMethod = "hystixGet3")
    public Map<String ,Object> deletePunish(@RequestBody ArrayList<Integer> list){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",punishService.deletePunish(list));
        return map1;
    }

    //备选方案
    public Map<String,Object> hystixGet3(@RequestBody ArrayList<Integer> list) {
        return fuse8008Util.main();
    }

}

