package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.entity.mybatisplus.MenuPower;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-06
 */
public interface MenuPowerService  {
    /***
     * 获取数据库级联菜单列表
     * @return
     */
    Object menuPowerList();

    /***
     * 通过角色编号查询对应的菜单列表
     * @param integer
     * @return
     */
    Object menuPowerListInRoleId(Integer integer);

    /***
     * 按照条件查询菜单
     * @param menuPower
     * @return
     */
    Object menuPowerInCondition(MenuPower menuPower);

    /***
     * 新增一级菜单
     * @param menuPower
     * @return
     */
    Object menuPowerAddSingle(MenuPower menuPower);
}
