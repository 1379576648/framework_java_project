package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.entity.mybatisplus.Role;
import com.trkj.framework.mybatisplus.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-04
 */
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;
    /**
     * 分页查询所有的角色数据
     * @param role
     * @return
     */
    @PostMapping("/selectRoleAll")
    @HystrixCommand(fallbackMethod = "selectRoleAllHystrix")
    public Object selectRoleAll(@RequestBody Role role){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",roleService.selectRoleAll(role));
        return  map1;
    }
    //备选方案
    public Object selectRoleAllHystrix(@RequestBody Role role){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }

    /***
     * 多选或者单选删除角色数据
     * @param list
     * @return
     */
    @DeleteMapping("/checkRoleDelete")
    @HystrixCommand(fallbackMethod = "checkRoleDeleteHystrix")
    public Object checkRoleDelete(@RequestBody ArrayList<Integer> list){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",roleService.checkRoleDelete(list));
        return map1;
    }
    //备选方案
    public Object checkRoleDeleteHystrix(@RequestBody ArrayList<Integer> list){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }
}

