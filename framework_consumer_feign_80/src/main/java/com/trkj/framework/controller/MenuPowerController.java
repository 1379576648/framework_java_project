package com.trkj.framework.controller;


import com.trkj.framework.entity.mybatisplus.MenuPower;
import com.trkj.framework.service.client.system.SystemClinetService;
import com.trkj.framework.vo.AjaxResponse;
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
@RequestMapping("/menuPower")
public class MenuPowerController {
    @Autowired
    private SystemClinetService systemClinetService = null;
    /***
     * 获取所有的菜单列表
     * @return
     */
    @RequestMapping(value ="/menuPowerList",method = RequestMethod.GET)
    public AjaxResponse menuPowerList() {
        return AjaxResponse.success(systemClinetService.menuPowerList());
    }

    /***
     * 通过角色编号查询对应的菜单列表
     * @param id
     * @return
     */
    @RequestMapping(value ="/menuPowerListInRoleId/{id}",method = RequestMethod.GET)
    public AjaxResponse menuPowerListInRoleId(@PathVariable(name = "id") Integer id ){
        return AjaxResponse.success(systemClinetService.menuPowerListInRoleId(id));
    }

    /***
     * 通过条件查询菜单
     * @param menuPower
     * @return
     */
    @RequestMapping(value ="/menuPowerInCondition",method = RequestMethod.POST)
    public AjaxResponse menuPowerInCondition(@RequestBody MenuPower menuPower){
        return AjaxResponse.success(systemClinetService.menuPowerInCondition(menuPower));
    }

    /***
     * 新增一级菜单
     * @param menuPower
     * @return
     */
    @RequestMapping(value ="/menuPowerAddSingle",method = RequestMethod.POST)
    public AjaxResponse menuPowerAddSingle(@RequestBody MenuPower menuPower){
        return AjaxResponse.success(systemClinetService.menuPowerAddSingle(menuPower));
    }
}

