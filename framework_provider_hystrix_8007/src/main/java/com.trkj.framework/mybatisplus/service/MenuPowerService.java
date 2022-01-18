package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.entity.mybatisplus.MenuPower;
import io.swagger.models.auth.In;

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

    /***
     * 通过父类编号查询菜单名称
     * @param integer
     * @return
     */
    Object menuPowerInPid(Integer integer);


    /***
     * 通过实体类修改菜单数据
     * @param menuPower
     * @return
     */
    String menuPowerUpdate(MenuPower menuPower);


    /***
     * 通过菜单编号进行删除菜单数据
     * @param integer
     * @return
     */
    String menuPowerDelete(Integer integer);


    /***
     * 通过实体类进行添加
     * @param menuPower
     * @return
     */
    String menuPowerAdd(MenuPower menuPower);
}
