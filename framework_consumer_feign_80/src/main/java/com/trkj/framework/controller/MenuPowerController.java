package com.trkj.framework.controller;


import com.trkj.framework.entity.mybatisplus.MenuPower;
import com.trkj.framework.service.client.system.SystemClinetService;
import com.trkj.framework.util.CarryTokenUtil;
import com.trkj.framework.vo.AjaxResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
@RequestMapping("/menuPower")
public class MenuPowerController {
    @Autowired
    private SystemClinetService systemClinetService = null;
    @Autowired
    private CarryTokenUtil carryTokenUtil;
    /***
     * 获取所有的菜单列表
     * @return
     */
    @GetMapping("/menuPowerList")
    @ApiOperation(value = "获取所有的菜单列表",notes = "系统模块",httpMethod = "GET",nickname="查询",produces = "/menuPowerList")
    public AjaxResponse menuPowerList() {
        Map<String,Object> map = (Map<String, Object>) systemClinetService.menuPowerList();

        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 通过角色编号查询对应的菜单列表
     * @param id
     * @return
     */
    @GetMapping("/menuPowerListInRoleId/{id}")
    @ApiOperation(value = "通过角色编号查询对应的菜单列表",notes = "系统模块",httpMethod = "GET",nickname="查询",produces = "/menuPowerListInRoleId/{id}")
    public AjaxResponse menuPowerListInRoleId(@PathVariable(name = "id") Integer id ){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.menuPowerListInRoleId(id);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 通过条件查询菜单
     * @param menuPower
     * @return
     */
    @PostMapping("/menuPowerInCondition")
    @ApiOperation(value = "通过条件查询菜单",notes = "系统模块",httpMethod = "POST",nickname="查询",produces = "/menuPowerInCondition")
    public AjaxResponse menuPowerInCondition(@RequestBody MenuPower menuPower){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.menuPowerInCondition(menuPower);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 新增一级菜单
     * @param menuPower
     * @return
     */
    @PostMapping("/menuPowerAddSingle")
    @ApiOperation(value = "新增一级菜单",notes = "系统模块",httpMethod = "POST",nickname="添加",produces = "/menuPowerAddSingle")
    public AjaxResponse menuPowerAddSingle(@RequestBody MenuPower menuPower){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.menuPowerAddSingle(menuPower);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 通过父菜单编号获取菜单名称
     * @param integer
     * @return
     */
    @GetMapping("/menuPowerInPid/{id}")
    @ApiOperation(value = "通过父菜单编号获取菜单名称",notes = "系统模块",httpMethod = "GET",nickname="查询",produces = "/menuPowerInPid/{id}")
    public  AjaxResponse menuPowerInPid(@PathVariable("id") Integer integer){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.menuPowerInPid(integer);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 通过实体类修改菜单数据
     * @param menuPower
     * @return
     */
    @PostMapping("/menuPowerUpdate")
    @ApiOperation(value = "通过实体类修改菜单数据",notes = "系统模块",httpMethod = "PUT",nickname="修改",produces = "/menuPowerUpdate")
    public AjaxResponse menuPowerUpdate(@RequestBody MenuPower menuPower){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.menuPowerUpdate(menuPower);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /***
     * 通过编号删除菜单数据
     * @param integer
     * @return
     */
    @DeleteMapping("/menuPowerDelete/{id}")
    @ApiOperation(value = "通过编号删除菜单数据",notes = "系统模块",httpMethod = "DELETE",nickname="删除",produces = "/menuPowerDelete/{id}")
    public AjaxResponse menuPowerDelete(@PathVariable("id") Integer integer){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.menuPowerDelete(integer);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }

    /**
     * 通过实体类的数据添加菜单
     * @param menuPower
     * @return
     */
    @PostMapping("/menuPowerAdd")
    @ApiOperation(value = "通过实体类的数据添加菜单",notes = "系统模块",httpMethod = "POST",nickname="添加",produces = "/menuPowerAdd")
    public AjaxResponse menuPowerAdd(@RequestBody MenuPower menuPower){
        Map<String,Object> map = (Map<String, Object>) systemClinetService.menuPowerAdd(menuPower);
        return AjaxResponse.success(carryTokenUtil.main(map));
    }
}

