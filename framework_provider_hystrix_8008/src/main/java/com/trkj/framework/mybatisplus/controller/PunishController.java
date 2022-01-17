package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Glory;
import com.trkj.framework.entity.mybatisplus.Punish;
import com.trkj.framework.mybatisplus.service.GloryService;
import com.trkj.framework.mybatisplus.service.PunishService;
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

    /**
     * 根据惩罚id查询惩罚
     * @param workVo
     * @return
     */
    @PostMapping("/selectPunishOne")
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Object selectPunishOne(@RequestBody WorkVo workVo){
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 200);
        map1.put("info", punishService.selectPunishOne(workVo));
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
     * 添加惩罚
     * @param punish
     * @return
     */
    @PostMapping("/insertPunish")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object insertPunish(@RequestBody Punish punish){
        return punishService.insertPunish(punish);
    }

    //备选方案
    public Object HystixGet2(@RequestBody Punish punish){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 修改惩罚
     * @param punishId
     * @return
     */
    @PutMapping("/updatePunish")
    public Object updatePunish(@RequestBody Punish punishId){
        //惩罚类型
        punishId.setPunishType(punishId.getPunishType());
        //惩罚原因
        punishId.setPunishCause(punishId.getPunishCause());
        //惩罚单位
        punishId.setPunishUnit(punishId.getPunishUnit());
        //是否撤销
        punishId.setIsRevocation(punishId.getIsRevocation());
        //备注
        punishId.setPunishRemark(punishId.getPunishRemark());
        final var i = punishService.updatePunish(punishId);
        if (i==999){
            return 666;
        }else {
            return 100;
        }

    }

    /**
     * 删除惩罚
     * @param list
     * @return
     */
    @DeleteMapping("/deletePunish")
    @HystrixCommand(fallbackMethod = "HystixGet3")
    public Object deletePunish(@RequestBody ArrayList<Integer> list){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",punishService.deletePunish(list));
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

