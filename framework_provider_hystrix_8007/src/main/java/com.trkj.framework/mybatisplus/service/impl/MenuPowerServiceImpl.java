package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.trkj.framework.entity.mybatisplus.MenuPower;
import com.trkj.framework.entity.mybatisplus.RoleMenuPower;
import com.trkj.framework.mybatisplus.mapper.MenuPowerMapper;
import com.trkj.framework.mybatisplus.mapper.RoleMenuPowerMapper;
import com.trkj.framework.mybatisplus.service.MenuPowerService;
import com.trkj.framework.util.MenuChild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-06
 */
@Service
public class MenuPowerServiceImpl implements MenuPowerService {

    @Autowired
    private MenuPowerMapper menuPowerMapper;
    @Autowired
    private RoleMenuPowerMapper roleMenuPowerMapper;

    /***
     * 获取菜单子菜单类
     */
    @Autowired
    private MenuChild getChild;

    /**
     * 获取数据库级联菜单列表
     *
     * @return
     */
    @Override
    public Object menuPowerList() {
        /**
         * 数据库获取菜单
         */
        List<MenuPower> list = list = menuPowerMapper.selectList(new QueryWrapper<MenuPower>()
                //菜单状态 启用
                .eq("MENU_POWER_STATE", 0)
                //通过菜单排序 顺序
                .orderByAsc("MENU_POWER_ORDER"));
        /***
         * 根节点
         */
        List<MenuPower> list1 = new ArrayList<>();
        //循环菜单列表找出根节点
        for (MenuPower menuPower : list) {
            //如果菜单是根节点 类型为菜单 状态为可用
            if (menuPower.getMenuPowerPid() == 0 && menuPower.getMenuPowerState() == 0) {
                list1.add(menuPower);
            }
        }
        //为根菜单设置子菜单，getClild是递归调用的
        for (MenuPower nav : list1) {
            /* 获取根节点下的所有子节点 使用getChild方法*/
            List<MenuPower> childList = getChild.getChild(nav.getMenuPowerId(), list);
            //给根节点设置子节点
            nav.setList(childList);
        }
        return list1;
    }

    /***
     * 通过角色编号查询对应的菜单列表
     * @param integer
     * @return
     */
    @Override
    public Object menuPowerListInRoleId(Integer integer) {
        //定义员工数组用来存菜单列表
        List<MenuPower> menuPowerList = new ArrayList<>();
        //通过角色编号查询角色菜单表列表
        List<RoleMenuPower> roleMenuPowers = roleMenuPowerMapper.selectList(new QueryWrapper<RoleMenuPower>().eq("ROLE_ID", integer));
        for (RoleMenuPower roleMenuPower : roleMenuPowers) {
            //通过id查询菜单表数据
            MenuPower menuPower = menuPowerMapper.selectOne(new QueryWrapper<MenuPower>().eq("MENU_POWER_ID", roleMenuPower.getMenuPowerId()));
            menuPowerList.add(menuPower);
        }
        return menuPowerList;
    }


}
