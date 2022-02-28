package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Role;
import com.trkj.framework.entity.mybatisplus.RoleStaff;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.service.client.system.SystemClinetService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author 13795
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private SystemClinetService systemClinetService=null;
    @Autowired
    private CarryTokenUtil carryTokenUtil;

    /***
     * 分页查询所有的角色数据
     * @param role
     * @return
     */
    @PostMapping("/selectRoleAll")
    @ApiOperation(value = "分页查询所有的角色数据",notes = "系统模块",httpMethod = "POST",nickname="查询",produces = "/selectRoleAll")
    public AjaxResponse selectRoleAll(@RequestBody Role role){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.selectRoleAll(role);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 多选或者单选删除角色数据
     * @param list
     * @return
     */
    @DeleteMapping("/checkRoleDelete")
    @ApiOperation(value = "多选或者单选删除角色数据",notes = "系统模块",httpMethod = "DELETE",nickname="删除",produces = "/checkRoleDelete")
    public AjaxResponse checkRoleDelete(@RequestBody ArrayList<Integer> list){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.checkRoleDelete(list);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @PostMapping("/addRole")
    @ApiOperation(value = "添加角色",notes = "系统模块",httpMethod = "POST",nickname="添加",produces = "/addRole")
    public AjaxResponse addRole(@RequestBody Role role){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.addRole(role);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 通过前台的角色名称查询角色是否被使用
     * @param name
     * @return
     */
    @GetMapping("/selectRoleRoleName/{name}/{value}")
    @ApiOperation(value = "通过前台的角色名称查询角色是否被使用",notes = "系统模块",httpMethod = "GET",nickname="查询",produces = "/selectRoleRoleName/{name}/{value}")
    public AjaxResponse selectRoleRoleName(@PathVariable(name="name") String name,@PathVariable(name = "value") String value){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.selectRoleRoleName(name,value);

        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 修改角色
     * @param role
     * @return
     */
    @PutMapping("/updateRole")
    @ApiOperation(value = "修改角色",notes = "系统模块",httpMethod = "PUT",nickname="修改",produces = "/updateRole")
    public AjaxResponse updateRole(@RequestBody Role role){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.updateRole(role);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 分配权限
     * @param role
     * @return
     */
    @PutMapping("/allotMenu")
    @ApiOperation(value = "分配权限",notes = "系统模块",httpMethod = "PUT",nickname="修改",produces = "/allotMenu")
    public AjaxResponse allotMenu(@RequestBody Role role){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.allotMenu(role);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 分页查询所有的角色员工表数据
     * @param roleStaff
     * @return
     */
    @PostMapping("/selectRoleStaff")
    @ApiOperation(value = "分页查询所有的角色员工表数据",notes = "系统模块",httpMethod = "POST",nickname="查询",produces = "/selectRoleStaff")
    public AjaxResponse selectRoleStaff(@RequestBody RoleStaff roleStaff){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.selectRoleStaff(roleStaff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 用户取消授权
     * @param list
     * @return
     */
    @DeleteMapping("/cancelImpower")
    @ApiOperation(value = "用户取消授权",notes = "系统模块",httpMethod = "DELETE",nickname="删除",produces = "/cancelImpower")
    public AjaxResponse cancelImpower(@RequestBody ArrayList<Integer> list){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.cancelImpower(list);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 查询所有在职的员工
     * @param staff
     * @return
     */
    @PostMapping("/selectStaffInState")
    @ApiOperation(value = "查询所有在职的员工",notes = "系统模块",httpMethod = "POST",nickname="查询",produces = "/selectStaffInState")
    public AjaxResponse selectStaffInState(@RequestBody Staff staff){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.selectStaffInState(staff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 角色分配给用户
     * @param roleStaff
     * @return
     */
    @PostMapping("/allotStaff")
    @ApiOperation(value = "角色分配给用户",notes = "系统模块",httpMethod = "POST",nickname="添加",produces = "/allotStaff")
    public AjaxResponse allotStaff(@RequestBody RoleStaff roleStaff){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.allotStaff(roleStaff);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 查询所有的职位
     * @return
     */
    @GetMapping("/selectDeptPostAll")
    @ApiOperation(value = "查询所有的职位",notes = "系统模块",httpMethod = "GET",nickname="查询",produces = "/selectDeptPostAll")
    public AjaxResponse selectDeptPostAll(){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.selectDeptPostAll();
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}
