package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Glory;
import com.trkj.framework.mybatisplus.service.GloryService;
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

    /**
     * 根据奖励id查询奖励
     * @param workVo
     * @return
     */
    @PostMapping("/selectGloryOne")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Object selectGloryOne(@RequestBody WorkVo workVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", gloryService.selectGloryOne(workVo));
        System.out.println(workVo);
        return map1;
    }

    // 备选方案
    public Object HystixGet(@RequestBody WorkVo workVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 添加奖励
     * @param glory
     * @return
     */
    @PostMapping("/insertGlory")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object insertGlory(@RequestBody Glory glory){
        return gloryService.insertGlory(glory);
    }

    //备选方案
    public Object HystixGet2(@RequestBody Glory glory){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 修改奖励
     * @param gloryId
     * @return
     */
    @PutMapping("/updateGlory")
    public Object updateGlory(@RequestBody Glory gloryId){
        //奖励名称
        gloryId.setGloryName(gloryId.getGloryName());
        //颁发单位
        gloryId.setGloryUnitname(gloryId.getGloryUnitname());
        //奖励日期
        gloryId.setCreatedTime(gloryId.getCreatedTime());
        //备注
        gloryId.setGloryRemark(gloryId.getGloryRemark());
        final var i = gloryService.updateGlory(gloryId);
        if (i==999){
            return 666;
        }else {
            return 100;
        }

    }

    /**
     * 删除奖励
     * @param list
     * @return
     */
    @DeleteMapping("/deleteGlory")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Object deleteGlory(@RequestBody ArrayList<Integer> list){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",gloryService.deleteGlory(list));
        return map1;
    }

    //备选方案
    public Object HystixGet3(@RequestBody ArrayList<Integer> list){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 查询奖励和惩罚
     * @param punishGloryVo
     * @return
     */
    @PostMapping("/selectPunishGlory")
    @HystrixCommand(fallbackMethod = "HystixGet4")
    public Object selectPunishGlory(@RequestBody PunishGloryVo punishGloryVo){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        map1.put("info",gloryService.selectPunishGlory(punishGloryVo));
        return map1;
    }

    // 备选方案
    public Object HystixGet4(@RequestBody PunishGloryVo punishGloryVo){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

}

