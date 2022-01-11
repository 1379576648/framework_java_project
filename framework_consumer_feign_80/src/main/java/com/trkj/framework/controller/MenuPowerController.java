package com.trkj.framework.controller;


import com.trkj.framework.service.client.system.SystemClinetService;
import com.trkj.framework.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/menuPowerList")
    public AjaxResponse menuPowerList() {
        return AjaxResponse.success(systemClinetService.menuPowerList());
    }

    /***
     * 通过角色编号查询对应的菜单列表
     * @param id
     * @return
     */
    @GetMapping("/menuPowerListInRoleId/{id}")
    public AjaxResponse menuPowerListInRoleId(@PathVariable(name = "id") Integer id ){
        return AjaxResponse.success(systemClinetService.menuPowerListInRoleId(id));
    }

}

