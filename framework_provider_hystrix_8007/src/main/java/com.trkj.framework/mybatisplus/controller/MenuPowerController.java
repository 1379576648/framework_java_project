package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.mybatisplus.service.MenuPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-06
 */
@RestController
public class MenuPowerController {
    @Autowired
     private MenuPowerService  menuPowerService;

    /***
     * 获取所有的菜单列表
     * @return
     */
    @GetMapping("/menuPowerList")
    @HystrixCommand(fallbackMethod = "menuPowerListHystrix")
    public Object menuPowerList(){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",menuPowerService.menuPowerList());
        return  map1;
    }
    //备选方案
    public Object menuPowerListHystrix(){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /**
     * 通过角色编号查询对应的菜单列表
     * @param integer
     * @return
     */
    @GetMapping("/menuPowerListInRoleId/{id}")
    @HystrixCommand(fallbackMethod = "menuPowerListInRoleIdListHystrix")
    public Object menuPowerListInRoleId(@PathVariable(name = "id") Integer integer){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",menuPowerService.menuPowerListInRoleId(integer));
        return  map1;
    }
    //备选方案
    public Object menuPowerListInRoleIdListHystrix(@PathVariable(name = "id") Integer integer){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }
}

