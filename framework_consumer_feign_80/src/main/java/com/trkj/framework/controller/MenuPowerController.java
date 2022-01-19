package com.trkj.framework.controller;


import com.trkj.framework.entity.mybatisplus.MenuPower;
import com.trkj.framework.service.client.system.SystemClinetService;
import com.trkj.framework.vo.AjaxResponse;
import io.swagger.models.auth.In;
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
    /***
     * 获取所有的菜单列表
     * @return
     */
    @GetMapping(value ="/menuPowerList")
    public AjaxResponse menuPowerList() {
        return AjaxResponse.success(systemClinetService.menuPowerList());
    }

    /***
     * 通过角色编号查询对应的菜单列表
     * @param id
     * @return
     */
    @GetMapping(value ="/menuPowerListInRoleId/{id}")
    public AjaxResponse menuPowerListInRoleId(@PathVariable(name = "id") Integer id ){
        return AjaxResponse.success(systemClinetService.menuPowerListInRoleId(id));
    }

    /***
     * 通过条件查询菜单
     * @param menuPower
     * @return
     */
    @PostMapping(value ="/menuPowerInCondition")
    public AjaxResponse menuPowerInCondition(@RequestBody MenuPower menuPower){
        return AjaxResponse.success(systemClinetService.menuPowerInCondition(menuPower));
    }

    /***
     * 新增一级菜单
     * @param menuPower
     * @return
     */
    @PostMapping(value ="/menuPowerAddSingle")
    public AjaxResponse menuPowerAddSingle(@RequestBody MenuPower menuPower){
        return AjaxResponse.success(systemClinetService.menuPowerAddSingle(menuPower));
    }

    /***
     * 通过父菜单编号获取菜单名称
     * @param integer
     * @return
     */
    @GetMapping("/menuPowerInPid/{id}")
    public  AjaxResponse menuPowerInPid(@PathVariable("id") Integer integer){
        return AjaxResponse.success(systemClinetService.menuPowerInPid(integer));
    }

    /***
     * 通过实体类修改菜单数据
     * @param menuPower
     * @return
     */
    @PostMapping("/menuPowerUpdate")
    public AjaxResponse menuPowerUpdate(@RequestBody MenuPower menuPower){
        return AjaxResponse.success(systemClinetService.menuPowerUpdate(menuPower));
    }

    /***
     * 通过编号删除菜单数据
     * @param integer
     * @return
     */
    @DeleteMapping("/menuPowerDelete/{id}")
    public AjaxResponse menuPowerDelete(@PathVariable("id") Integer integer){
        return AjaxResponse.success(systemClinetService.menuPowerDelete(integer));
    }

    /**
     * 通过实体类的数据添加菜单
     * @param menuPower
     * @return
     */
    @PostMapping("/menuPowerAdd")
    public AjaxResponse menuPowerAdd(@RequestBody MenuPower menuPower){
        return AjaxResponse.success(systemClinetService.menuPowerAdd(menuPower));
    }
}

