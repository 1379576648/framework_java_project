package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Role;
import com.trkj.framework.entity.mybatisplus.RoleStaff;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.service.client.system.SystemClinetService;
import com.trkj.framework.vo.AjaxResponse;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author 13795
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private SystemClinetService systemClinetService=null;

    /***
     * 分页查询所有的角色数据
     * @param role
     * @return
     */
    @PostMapping("/selectRoleAll")
    public AjaxResponse selectRoleAll(@RequestBody Role role){
        return AjaxResponse.success(systemClinetService.selectRoleAll(role));
    }

    /***
     * 多选或者单选删除角色数据
     * @param list
     * @return
     */
    @DeleteMapping("/checkRoleDelete")
    public AjaxResponse checkRoleDelete(@RequestBody ArrayList<Integer> list){
        return AjaxResponse.success(systemClinetService.checkRoleDelete(list));
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @PostMapping("/addRole")
    public AjaxResponse addRole(@RequestBody Role role){
        return AjaxResponse.success(systemClinetService.addRole(role));
    }

    /***
     * 通过前台的角色名称查询角色是否被使用
     * @param name
     * @return
     */
    @GetMapping("/selectRoleRoleName/{name}/{value}")
    public AjaxResponse selectRoleRoleName(@PathVariable(name="name") String name,@PathVariable(name = "value") String value){
        return AjaxResponse.success(systemClinetService.selectRoleRoleName(name,value));
    }

    /***
     * 修改角色
     * @param role
     * @return
     */
    @PutMapping("/updateRole")
    public AjaxResponse updateRole(@RequestBody Role role){
        return AjaxResponse.success(systemClinetService.updateRole(role));
    }

    /***
     * 分配权限
     * @param role
     * @return
     */
    @PutMapping("/allotMenu")
    public AjaxResponse allotMenu(@RequestBody Role role){
        return AjaxResponse.success(systemClinetService.allotMenu(role));
    }

    /***
     * 分页查询所有的角色员工表数据
     * @param roleStaff
     * @return
     */
    @PostMapping("/selectRoleStaff")
    public AjaxResponse selectRoleStaff(@RequestBody RoleStaff roleStaff){
        return AjaxResponse.success(systemClinetService.selectRoleStaff(roleStaff));
    }

    /***
     * 用户取消授权
     * @param list
     * @return
     */
    @DeleteMapping("/cancelImpower")
    public AjaxResponse cancelImpower(@RequestBody ArrayList<Integer> list){
        return AjaxResponse.success(systemClinetService.cancelImpower(list));
    }

    /***
     * 查询所有在职的员工
     * @param staff
     * @return
     */
    @PostMapping("/selectStaffInState")
    public AjaxResponse selectStaffInState(@RequestBody Staff staff){
        return AjaxResponse.success(systemClinetService.selectStaffInState(staff));
    }

    /***
     * 角色分配给用户
     * @param roleStaff
     * @return
     */
    @PostMapping("/allotStaff")
    public AjaxResponse allotStaff(@RequestBody RoleStaff roleStaff){
        return AjaxResponse.success(systemClinetService.allotStaff(roleStaff));
    }

}
