package com.trkj.framework.mybatisplus.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.Role;
import com.trkj.framework.entity.mybatisplus.RoleStaff;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.mybatisplus.service.RoleService;
import com.trkj.framework.util.Fuse8007Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.sql.SQLException;
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
    
    @Autowired
    private Fuse8007Util fuse8007Util;

    /**
     * 分页查询所有的角色数据
     *
     * @param role
     * @return
     */
    @PostMapping("/selectRoleAll")
    @HystrixCommand(fallbackMethod = "selectRoleAllHystrix")
    public Map<String,Object> selectRoleAll(@RequestBody Role role) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", roleService.selectRoleAll(role));
        return map1;
    }

    //备选方案
    public Map<String,Object> selectRoleAllHystrix(@RequestBody Role role) {
        return fuse8007Util.main();
    }

    /***
     * 多选或者单选删除角色数据
     * @param list
     * @return
     */
    @DeleteMapping("/checkRoleDelete")
    @HystrixCommand(fallbackMethod = "checkRoleDeleteHystrix")
    public Map<String,Object> checkRoleDelete(@RequestBody ArrayList<Integer> list) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        try {
            map1.put("info", roleService.checkRoleDelete(list));
        }catch (ArithmeticException e){
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    //备选方案
    public Map<String,Object> checkRoleDeleteHystrix(@RequestBody ArrayList<Integer> list) {
        return fuse8007Util.main();
    }

    /***
     * 添加角色
     * @param role
     * @return
     */
    @PostMapping("/addRole")
    @HystrixCommand(fallbackMethod = "addRoleHystrix")
    public Map<String,Object> addRole(@RequestBody Role role) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        try {
            map1.put("info", roleService.addRole(role));
        } catch (ArithmeticException e) {
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    //备选方案
    public Map<String,Object> addRoleHystrix(@RequestBody Role role) {
        return fuse8007Util.main();
    }

    /***
     *通过前台的角色名称查询角色是否被使用
     * @param name
     * @param value
     * @return
     */
    @GetMapping("/selectRoleRoleName/{name}/{value}")
    @HystrixCommand(fallbackMethod = "selectRoleRoleNameHystrix")
    public Map<String,Object> selectRoleRoleName(@PathVariable(name = "name") String name, @PathVariable(name = "value") String value) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", roleService.selectRoleRoleName(name, value));
        return map1;
    }


    //备选方案
    public Map<String,Object> selectRoleRoleNameHystrix(@PathVariable(name = "name") String name, @PathVariable(name = "value") String value) {
        return fuse8007Util.main();
    }

    /***
     * 修改角色
     * @param role
     * @return
     */
    @PutMapping("/updateRole")
    @HystrixCommand(fallbackMethod = "updateRoleHystrix")
    public Map<String,Object> updateRole(@RequestBody Role role) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        try {
            map1.put("info", roleService.updateRole(role));
        }catch (ArithmeticException e){
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    //备选方案
    public Map<String,Object> updateRoleHystrix(@RequestBody Role role) {
        return fuse8007Util.main();
    }

    @PutMapping("/allotMenu")
    @HystrixCommand(fallbackMethod = "allotMenuHystrix")
    public Map<String,Object> allotMenu(@RequestBody Role role) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        try {
            map1.put("info", roleService.allotMenu(role));
        }catch (ArithmeticException e){
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    //备选方案
    public Map<String,Object> allotMenuHystrix(@RequestBody Role role) {
        return fuse8007Util.main();
    }

    /***
     * 分页查询所有的角色员工表数据
     * @param roleStaff
     * @return
     */
    @PostMapping("/selectRoleStaff")
    @HystrixCommand(fallbackMethod = "selectRoleStaffHystrix")
    public Map<String,Object> selectRoleStaff(@RequestBody RoleStaff roleStaff) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", roleService.selectRoleStaff(roleStaff));
        return map1;
    }

    //备选方案
    public Map<String,Object> selectRoleStaffHystrix(@RequestBody RoleStaff roleStaff) {
        return fuse8007Util.main();
    }

    /**
     * 用户取消授权
     *
     * @param list
     * @return
     */
    @DeleteMapping("/cancelImpower")
    @HystrixCommand(fallbackMethod = "cancelImpowerHystrix")
    public Map<String,Object> cancelImpower(@RequestBody ArrayList<Integer> list) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", roleService.cancelImpower(list));
        return map1;
    }

    //备选方案
    public Map<String,Object> cancelImpowerHystrix(@RequestBody ArrayList<Integer> list) {
        return fuse8007Util.main();
    }

    /***
     * 查询所有在职的员工
     * @param staff
     * @return
     */
    @PostMapping("/selectStaffInState")
    @HystrixCommand(fallbackMethod = "selectStaffInStateHystrix")
    public Map<String,Object> selectStaffInState(@RequestBody Staff staff) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", roleService.selectStaffInState(staff));
        return map1;
    }

    //备选方案
    public Map<String,Object> selectStaffInStateHystrix(@RequestBody Staff staff) {
        return fuse8007Util.main();
    }


    /**
     * 角色分配给用户
     * @param roleStaff
     * @return
     */
    @PostMapping("/allotStaff")
    @HystrixCommand(fallbackMethod = "allotStaffHystrix")
    public Map<String,Object> allotStaff(@RequestBody RoleStaff roleStaff) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        try {
            map1.put("info", roleService.allotStaff(roleStaff));
        }catch (ArithmeticException e){
            map1.put("info", e.getMessage());
        }
        return map1;
    }

    //备选方案
    @HystrixCommand(fallbackMethod = "allotStaffHystrix")
    public Map<String,Object> allotStaffHystrix(@RequestBody RoleStaff roleStaff) {
        return fuse8007Util.main();
    }
}

