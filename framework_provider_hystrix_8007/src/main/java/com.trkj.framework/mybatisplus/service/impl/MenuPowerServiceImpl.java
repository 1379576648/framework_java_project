package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.trkj.framework.entity.mybatisplus.MenuPower;
import com.trkj.framework.entity.mybatisplus.RoleMenuPower;
import com.trkj.framework.mybatisplus.mapper.MenuPowerMapper;
import com.trkj.framework.mybatisplus.mapper.RoleMenuPowerMapper;
import com.trkj.framework.mybatisplus.service.MenuPowerService;
import com.trkj.framework.util.MenuChildUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    private MenuChildUtil getChild;

    //子菜单
    List<Integer> childListList = new ArrayList<Integer>();

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
        List<MenuPower> list = menuPowerMapper.selectList(new QueryWrapper<MenuPower>()
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
            nav.setChildren(childList);
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
        List<RoleMenuPower> roleMenuPowers = roleMenuPowerMapper.selectList(new QueryWrapper<RoleMenuPower>().eq("ROLE_ID", integer).eq("IS_CHOICE", 0));
        for (RoleMenuPower roleMenuPower : roleMenuPowers) {
            //通过id查询菜单表数据
            MenuPower menuPower = menuPowerMapper.selectOne(new QueryWrapper<MenuPower>().eq("MENU_POWER_ID", roleMenuPower.getMenuPowerId()));
            menuPowerList.add(menuPower);
        }
        return menuPowerList;
    }

    /**
     * 通过条件查询菜单
     *
     * @param menuPower
     * @return
     */
    @Override
    public Object menuPowerInCondition(MenuPower menuPower) {
        //条件构造器
        QueryWrapper<MenuPower> queryWrapper = new QueryWrapper<>();

        //判断菜单名称是否为空
        if (menuPower.getMenuPowerName() != null && !menuPower.getMenuPowerName().equals("")) {
            //菜单名称模糊查询
            queryWrapper.like("MENU_POWER_NAME", menuPower.getMenuPowerName());
        }

        //判断路由地址是否为空
        if (menuPower.getMenuPowerRoute() != null && !menuPower.getMenuPowerRoute().equals("")) {
            //路由地址模糊查询
            queryWrapper.like("MENU_POWER_ROUTE", menuPower.getMenuPowerRoute());
        }

        //判断传入的时间是否为空
        if (menuPower.getStartTime() != null || menuPower.getEndTime() != null) {
            //登录时间范围查询
            queryWrapper.between("CREATED_TIME", menuPower.getStartTime(), menuPower.getEndTime());
        }

        //通过菜单顺序排序
        queryWrapper.orderByAsc("MENU_POWER_ORDER");

        List<MenuPower> menuPowers = menuPowerMapper.selectList(queryWrapper);
        /***
         * 根节点
         */
        List<MenuPower> list1 = new ArrayList<>();
        //循环菜单列表找出根节点
        for (MenuPower menuPower1 : menuPowers) {
            //如果菜单是根节点 类型为菜单 状态为可用
            if (menuPower1.getMenuPowerPid() == 0) {
                list1.add(menuPower1);
            }
        }
        //为根菜单设置子菜单，getClild是递归调用的
        for (MenuPower nav : list1) {
            /* 获取根节点下的所有子节点 使用getChild方法*/
            List<MenuPower> childList = getChild.getChild(nav.getMenuPowerId(), menuPowers);
            //给根节点设置子节点
            nav.setChildren(childList);
        }
        return list1;
    }

    /***
     * 新增一级菜单
     * @param menuPower
     * @return
     */
    @Override
    public Object menuPowerAddSingle(MenuPower menuPower) {
        String s = "成功";
        List<MenuPower> menuPowers = menuPowerMapper.selectList(
                new QueryWrapper<MenuPower>()
                        .eq("MENU_POWER_PID", 0)
                        .orderByDesc("MENU_POWER_ORDER")
        );
        if (menuPowers.size() >= 1) {
            //排序
            menuPower.setMenuPowerOrder(menuPowers.get(0).getMenuPowerOrder() + 1);
        } else {
            menuPower.setMenuPowerOrder(1L);
        }
        //是否有叶子
        menuPower.setMenuPowerLeaf(1L);
        //父级菜单
        menuPower.setMenuPowerPid(0L);
        if (menuPowerMapper.insert(menuPower) <= 0) {
            return "新增菜单失败";
        }
        return s;
    }

    /***
     * 通过父菜单编号查询父菜单名称
     * @param integer
     * @return
     */
    @Override
    public Object menuPowerInPid(Integer integer) {
        if (integer == 0) {
            return null;
        } else {
            return menuPowerMapper.selectOne(new QueryWrapper<MenuPower>().eq("MENU_POWER_ID", integer));
        }
    }

    /***
     * 通过实体类修改菜单数据
     * @param menuPower
     * @return
     */
    @Override
    @Transactional
    public String menuPowerUpdate(MenuPower menuPower) {
        String s = "成功";
        if (menuPowerMapper.updateById(menuPower) <= 0) {
            return "修改菜单数据失败";
        }
        return s;
    }

    /***
     *  通过菜单编号进行删除菜单数据
     * @param integer
     * @return
     */
    @Override
    public String menuPowerDelete(Integer integer) {
        String s = "成功";
        //查询所有的菜单
        List<MenuPower> menuPowerList = menuPowerMapper.selectList(new QueryWrapper<MenuPower>().orderByAsc("MENU_POWER_ORDER"));
        /* 获取根节点下的所有子节点 使用getChild方法*/
        List<MenuPower> childList = getChild.getChild(integer, menuPowerList);
        childListList = new ArrayList<>();
        List<Integer> powerList = getChild(childList);
        if (menuPowerMapper.deleteById(integer) <= 0) {
            return "删除菜单数据失败";
        }
        for (Integer integer1 : powerList) {
            if (menuPowerMapper.deleteById(integer1) <= 0) {
                return "删除菜单数据失败";
            }
        }
        return s;
    }


    /***
     * 通实体类添加菜单
     * @param menuPower
     * @return
     */
    @Override
    @Transactional
    public String menuPowerAdd(MenuPower menuPower) {
        String s="成功";
        //通过菜单编号查询父菜单的列表
        List<MenuPower> menuPowerList = menuPowerMapper.selectList(new QueryWrapper<MenuPower>().eq("MENU_POWER_PID",menuPower.getMenuPowerPid()).orderByDesc("MENU_POWER_ORDER"));
        if (menuPowerList.size()<=0){
            //设置菜单的序号
            menuPower.setMenuPowerOrder(1L);
        }else{
            //设置菜单的序号
            menuPower.setMenuPowerOrder(menuPowerList.get(0).getMenuPowerOrder()+1);
        }
        //新建一个实体类
        MenuPower menuPower1 = new MenuPower();
        //设置菜单为有叶子
        menuPower1.setMenuPowerLeaf(0L);
        //设置菜单编号
        menuPower1.setMenuPowerId(Math.toIntExact(menuPower.getMenuPowerPid()));
        //修改父菜单为有叶子
        if (menuPowerMapper.updateById(menuPower1)<=0){
            return "修改父菜单数据失败";
        }
        //修改角色菜单表数据为半选状态
        RoleMenuPower roleMenuPower = new RoleMenuPower();
        roleMenuPower.setIsChoice(1L);
        roleMenuPowerMapper.update(roleMenuPower,new QueryWrapper<RoleMenuPower>().eq("MENU_POWER_ID",menuPower.getMenuPowerPid()));
        //设置是否有叶子
        menuPower.setMenuPowerLeaf(1L);
        if (menuPowerMapper.insert(menuPower)<=0){
            return "添加菜单数据失败";
        }
        return s;
    }


    //梯归循环菜单
    public List<Integer> getChild(List<MenuPower> allMenu) {
        for (MenuPower menuPower : allMenu) {
            if (menuPower.getChildren().size() <= 0) {
                childListList.add(menuPower.getMenuPowerId());
            } else {
                childListList.add(menuPower.getMenuPowerId());
                getChild(menuPower.getChildren());
            }
        }
        return childListList;
    }
}
