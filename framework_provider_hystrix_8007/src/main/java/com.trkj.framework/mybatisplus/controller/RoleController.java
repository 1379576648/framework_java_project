package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.entity.mybatisplus.Role;
import com.trkj.framework.entity.mybatisplus.RoleStaff;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.mybatisplus.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     *
     * @param role
     * @return
     */
    @PostMapping("/selectRoleAll")
    @HystrixCommand(fallbackMethod = "selectRoleAllHystrix")
    public Object selectRoleAll(@RequestBody Role role) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", roleService.selectRoleAll(role));
        return map1;
    }

    //备选方案
    public Object selectRoleAllHystrix(@RequestBody Role role) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /***
     * 多选或者单选删除角色数据
     * @param list
     * @return
     */
    @DeleteMapping("/checkRoleDelete")
    @HystrixCommand(fallbackMethod = "checkRoleDeleteHystrix")
    public Object checkRoleDelete(@RequestBody ArrayList<Integer> list) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", roleService.checkRoleDelete(list));
        return map1;
    }

    //备选方案
    public Object checkRoleDeleteHystrix(@RequestBody ArrayList<Integer> list) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /***
     * 添加角色
     * @param role
     * @return
     */
    @PostMapping("/addRole")
    @HystrixCommand(fallbackMethod = "addRoleHystrix")
    public Object addRole(@RequestBody Role role) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", roleService.addRole(role));
        return map1;
    }

    //备选方案
    public Object addRoleHystrix(@RequestBody Role role) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /***
     *通过前台的角色名称查询角色是否被使用
     * @param name
     * @param value
     * @return
     */
    @GetMapping("/selectRoleRoleName/{name}/{value}")
    @HystrixCommand(fallbackMethod = "selectRoleRoleNameHystrix")
    public Object selectRoleRoleName(@PathVariable(name = "name") String name, @PathVariable(name = "value") String value) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", roleService.selectRoleRoleName(name, value));
        return map1;
    }


    //备选方案
    public Object selectRoleRoleNameHystrix(@PathVariable(name = "name") String name, @PathVariable(name = "value") String value) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /***
     * 修改角色
     * @param role
     * @return
     */
    @PutMapping("/updateRole")
    @HystrixCommand(fallbackMethod = "updateRoleHystrix")
    public Object updateRole(@RequestBody Role role) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", roleService.updateRole(role));
        return map1;
    }

    //备选方案
    public Object updateRoleHystrix(@RequestBody Role role) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    @PutMapping("/allotMenu")
    @HystrixCommand(fallbackMethod = "allotMenuHystrix")
    public Object allotMenu(@RequestBody Role role) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", roleService.allotMenu(role));
        return map1;
    }

    //备选方案
    public Object allotMenuHystrix(@RequestBody Role role) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /***
     * 分页查询所有的角色员工表数据
     * @param roleStaff
     * @return
     */
    @PostMapping("/selectRoleStaff")
    @HystrixCommand(fallbackMethod = "selectRoleStaffHystrix")
    public Object selectRoleStaff(@RequestBody RoleStaff roleStaff) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", roleService.selectRoleStaff(roleStaff));
        return map1;
    }

    //备选方案
    public Object selectRoleStaffHystrix(@RequestBody RoleStaff roleStaff) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /**
     * 用户取消授权
     *
     * @param list
     * @return
     */
    @DeleteMapping("/cancelImpower")
    @HystrixCommand(fallbackMethod = "cancelImpowerHystrix")
    public Object cancelImpower(@RequestBody ArrayList<Integer> list) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", roleService.cancelImpower(list));
        return map1;
    }

    //备选方案
    public Object cancelImpowerHystrix(@RequestBody ArrayList<Integer> list) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }

    /***
     * 查询所有在职的员工
     * @param staff
     * @return
     */
    @PostMapping("/selectStaffInState")
    @HystrixCommand(fallbackMethod = "selectStaffInStateHystrix")
    public Object selectStaffInState(@RequestBody Staff staff) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", roleService.selectStaffInState(staff));
        return map1;
    }

    //备选方案
    public Object selectStaffInStateHystrix(@RequestBody Staff staff) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }


    /**
     * 角色分配给用户
     * @param roleStaff
     * @return
     */
    @PostMapping("/allotStaff")
    @HystrixCommand(fallbackMethod = "allotStaffHystrix")
    public Object allotStaff(@RequestBody RoleStaff roleStaff) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", roleService.allotStaff(roleStaff));
        return map1;
    }

    //备选方案
    @HystrixCommand(fallbackMethod = "allotStaffHystrix")
    public Object allotStaffHystrix(@RequestBody RoleStaff roleStaff) {
        Map<String, Object> map1 = new HashMap<>(2);
        map1.put("state", 300);
        map1.put("info", "服务发生雪崩");
        return map1;
    }
}

