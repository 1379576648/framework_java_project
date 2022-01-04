package com.trkj.framework.controller;

import com.trkj.framework.entity.mybatisplus.Role;
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
}
