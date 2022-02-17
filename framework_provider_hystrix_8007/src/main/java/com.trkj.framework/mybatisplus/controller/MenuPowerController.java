package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.MenuPower;
import com.trkj.framework.mybatisplus.service.MenuPowerService;
import com.trkj.framework.util.Fuse8007Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private MenuPowerService menuPowerService;

    @Autowired
    private Fuse8007Util fuse8007Util;
    /***
     * 获取所有的菜单列表
     * @return
     */
    @GetMapping("/menuPowerList")
    @HystrixCommand(fallbackMethod = "menuPowerListHystrix")
    public Map<String,Object> menuPowerList() {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", menuPowerService.menuPowerList());
        return map1;
    }

    //备选方案
    public Map<String,Object> menuPowerListHystrix() {
        return fuse8007Util.main();
    }

    /**
     * 通过角色编号查询对应的菜单列表
     *
     * @param integer
     * @return
     */
    @GetMapping("/menuPowerListInRoleId/{id}")
    @HystrixCommand(fallbackMethod = "menuPowerListInRoleIdListHystrix")
    public Map<String,Object> menuPowerListInRoleId(@PathVariable(name = "id") Integer integer) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", menuPowerService.menuPowerListInRoleId(integer));
        return map1;
    }

    //备选方案
    public Map<String,Object> menuPowerListInRoleIdListHystrix(@PathVariable(name = "id") Integer integer) {
        return fuse8007Util.main();
    }


    /***
     * 通过条件查询菜单
     * @param menuPower
     * @return
     */
    @PostMapping("/menuPowerInCondition")
    @HystrixCommand(fallbackMethod = "menuPowerInConditionHystrix")
    public Map<String,Object> menuPowerInCondition(@RequestBody MenuPower menuPower) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", menuPowerService.menuPowerInCondition(menuPower));
        return map1;
    }

    //备选方案
    public Map<String,Object> menuPowerInConditionHystrix(@RequestBody MenuPower menuPower) {
        return fuse8007Util.main();
    }

    /***
     * 新增一级菜单
     * @param menuPower
     * @return
     */
    @PostMapping("/menuPowerAddSingle")
    @HystrixCommand(fallbackMethod = "menuPowerAddSingleHystrix")
    public Map<String,Object> menuPowerAddSingle(@RequestBody MenuPower menuPower) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", menuPowerService.menuPowerAddSingle(menuPower));
        return map1;
    }


    //备选方案
    public Map<String,Object> menuPowerAddSingleHystrix(@RequestBody MenuPower menuPower) {
        return fuse8007Util.main();
    }


    /***
     * 通过父菜单编号获取菜单名称
     * @param integer
     * @return
     */
    @GetMapping("/menuPowerInPid/{id}")
    @HystrixCommand(fallbackMethod = "menuPowerInPidHystrix")
    public Map<String,Object> menuPowerInPid(@PathVariable("id") Integer integer) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", menuPowerService.menuPowerInPid(integer));
        return map1;
    }


    //备选方案
    public Map<String,Object> menuPowerInPidHystrix(@PathVariable("id") Integer integer) {
        return fuse8007Util.main();
    }

    /***
     * 通过实体类修改菜单数据
     * @param menuPower
     * @return
     */
    @PostMapping("/menuPowerUpdate")
    @HystrixCommand(fallbackMethod = "menuPowerUpdateHystrix")
    public Map<String,Object> menuPowerUpdate(@RequestBody MenuPower menuPower) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", menuPowerService.menuPowerUpdate(menuPower));
        return map1;
    }

    //备选方案
    public Map<String,Object> menuPowerUpdateHystrix(@RequestBody MenuPower menuPower) {
        return fuse8007Util.main();
    }

    /***
     * 通过菜单编号删除数据
     * @param integer
     * @return
     */
    @DeleteMapping("/menuPowerDelete/{id}")
    @HystrixCommand(fallbackMethod = "menuPowerDeleteHystrix")
    public Map<String,Object> menuPowerDelete(@PathVariable("id") Integer integer){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        try {
            map1.put("info", menuPowerService.menuPowerDelete(integer));
        }catch (ArithmeticException e){
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    //备选
    public Map<String,Object> menuPowerDeleteHystrix(@PathVariable("id") Integer integer){
        return fuse8007Util.main();
    }


    /***
     * 通过实体类数据进行添加
     * @param menuPower
     * @return
     */
    @PostMapping("/menuPowerAdd")
    @HystrixCommand(fallbackMethod = "menuPowerAddHystrix")
    public  Object menuPowerAdd(@RequestBody MenuPower menuPower){
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        try {
            map1.put("info", menuPowerService.menuPowerAdd(menuPower));
        }catch (ArithmeticException e){
            map1.put("info", e.getMessage());
        }
        return map1;
    }


    //备选
    public Map<String,Object> menuPowerAddHystrix(@RequestBody MenuPower menuPower){
        return fuse8007Util.main();
    }

}

