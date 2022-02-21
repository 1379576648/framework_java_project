package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Glory;
import com.trkj.framework.mybatisplus.service.GloryService;
import com.trkj.framework.util.Fuse8008Util;
import com.trkj.framework.vo.PunishGloryVo;
import com.trkj.framework.vo.StaffVo;
import com.trkj.framework.vo.WorkVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 奖励表 前端控制器
 * </p>
 *
 * @author suki
 * @since 2022-01-08
 */
@RestController
public class GloryController {

    @Autowired
    private GloryService gloryService;

    @Autowired
    private Fuse8008Util fuse8008Util;

    /**
     * 根据奖励id查询奖励
     * @param workVo
     * @return
     */
    @PostMapping("/selectGloryOne")
    @HystrixCommand(fallbackMethod = "hystixGet")
    public Map<String, Object> selectGloryOne(@RequestBody WorkVo workVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", gloryService.selectGloryOne(workVo));
        return map1;
    }

    //备选方案
    public Map<String,Object> hystixGet(@RequestBody WorkVo workVo) {
        return fuse8008Util.main();
    }

    /**
     * 添加奖励
     * @param glory
     * @return
     */
    @PostMapping("/insertGlory")
    @HystrixCommand(fallbackMethod = "hystixGet2")
    public Map<String, Object> insertGlory(@RequestBody Glory glory){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",gloryService.insertGlory(glory));
        return map1;
    }

    //备选方案
    public Map<String,Object> hystixGet2(@RequestBody Glory glory) {
        return fuse8008Util.main();
    }

    /**
     * 修改奖励
     * @param gloryId
     * @return
     */
    @PutMapping("/updateGlory")
    @HystrixCommand(fallbackMethod = "updateGloryHystrix")
    public Map<String, Object> updateGlory(@RequestBody Glory gloryId){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",gloryService.updateGlory(gloryId));
        return map1;

    }
    //备选方案
    public Map<String,Object> updateGloryHystrix(@RequestBody Glory gloryId) {
        return fuse8008Util.main();
    }
    /**
     * 删除奖励
     * @param list
     * @return
     */
    @DeleteMapping("/deleteGlory")
    @HystrixCommand(fallbackMethod = "hystixGet3")
    public Map<String, Object> deleteGlory(@RequestBody ArrayList<Integer> list){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",gloryService.deleteGlory(list));
        return map1;
    }

    //备选方案
    public Map<String,Object> hystixGet3(@RequestBody ArrayList<Integer> list) {
        return fuse8008Util.main();
    }

    /**
     * 查询奖励和惩罚
     * @param punishGloryVo
     * @return
     */
    @PostMapping("/selectPunishGlory")
    @HystrixCommand(fallbackMethod = "hystixGet4")
    public Map<String, Object> selectPunishGlory(@RequestBody PunishGloryVo punishGloryVo){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        map1.put("info",gloryService.selectPunishGlory(punishGloryVo));
        return map1;
    }

    //备选方案
    public Map<String,Object> hystixGet4(@RequestBody PunishGloryVo punishGloryVo) {
        return fuse8008Util.main();
    }

}

