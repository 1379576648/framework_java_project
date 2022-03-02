package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.trkj.framework.entity.mybatisplus.MenuPower;
import com.trkj.framework.entity.mybatisplus.RoleMenuPower;
import com.trkj.framework.mybatisplus.mapper.MenuPowerMapper;
import com.trkj.framework.mybatisplus.mapper.RoleMenuPowerMapper;
import com.trkj.framework.mybatisplus.service.MenuPowerService;
import com.trkj.framework.util.MenuChildUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-06
 */
@Service
@Slf4j
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


    //父菜单
    List<Integer> getChildListList = new ArrayList<Integer>();

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
        return "成功";
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
            MenuPower menuPower = menuPowerMapper.selectOne(new QueryWrapper<MenuPower>().eq("MENU_POWER_ID", integer));
            return menuPower;
        }
    }

    /***
     * 通过实体类修改菜单数据
     * @param menuPower
     * @return
     */
    @Override
    public String menuPowerUpdate(MenuPower menuPower) {
        if (menuPowerMapper.updateById(menuPower) <= 0) {
            return "修改菜单失败";
        }
        return "成功";
    }

    /***
     *  通过菜单编号进行删除菜单数据
     * @param integer
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String menuPowerDelete(Integer integer) throws ArithmeticException {
        //查询所有的菜单
        List<MenuPower> menuPowerList = menuPowerMapper.selectList(new QueryWrapper<MenuPower>().orderByAsc("MENU_POWER_ORDER"));
        //查询需要删除菜单
        MenuPower menuPower = menuPowerMapper.selectById(integer);
        //条件 查询的菜单不为空 并且 父菜单不为0
        if (menuPower != null && !menuPower.getMenuPowerPid().equals(0L)) {
            //查询所删除的菜单的父菜单
            MenuPower menuPower1 = menuPowerMapper.selectById(menuPower.getMenuPowerPid());
            //查询父菜单下面的子菜单
            List<MenuPower> menuPowerList1 = menuPowerMapper.selectList(new QueryWrapper<MenuPower>().eq("MENU_POWER_PID", menuPower1.getMenuPowerId()));
            //去除当前需要删除的菜单
            for (int i = 0; i < menuPowerList1.size(); i++) {
                if (menuPowerList1.get(i).getMenuPowerId().equals(integer)) {
                    menuPowerList1.remove(menuPowerList1.get(i));
                }
            }
            //条件 如果父菜单下面没有子菜单
            if (menuPowerList1.size() <= 0) {
                //修改父菜单为没有子菜单
                menuPower1.setMenuPowerLeaf(1L);
                if (menuPowerMapper.updateById(menuPower1) <= 0) {
                    throw new ArithmeticException("删除菜单失败");
                }
            }
        }
            /* 获取根节点下的所有子节点 使用getChild方法*/
            List<MenuPower> childList = getChild.getChild(integer, menuPowerList);
            log.debug("{}"+childList);
            childListList = new ArrayList<>();
            List<Integer> powerList = getChild(childList);
            log.debug("{}"+powerList);
            if (menuPowerMapper.deleteById(integer) <= 0) {
                throw new ArithmeticException("删除菜单失败");
            }
            for (Integer integer1 : powerList) {
                if (menuPowerMapper.deleteById(integer1) <= 0) {
                    throw new ArithmeticException("删除菜单失败");
                }
            }
        return "成功";
    }


    /***
     * 通实体类添加菜单
     * @param menuPower
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String menuPowerAdd(MenuPower menuPower) throws ArithmeticException {
        getChildListList = new ArrayList<>();
        //通过菜单编号查询父菜单的列表
        List<MenuPower> menuPowerList = menuPowerMapper.selectList(new QueryWrapper<MenuPower>().eq("MENU_POWER_PID", menuPower.getMenuPowerPid()).orderByDesc("MENU_POWER_ORDER"));
        if (menuPowerList.size() <= 0) {
            //设置菜单的序号
            menuPower.setMenuPowerOrder(1L);
        } else {
            //设置菜单的序号
            menuPower.setMenuPowerOrder(menuPowerList.get(0).getMenuPowerOrder() + 1);
        }
        //新建一个实体类
        MenuPower menuPower1 = new MenuPower();
        //设置菜单为有叶子
        menuPower1.setMenuPowerLeaf(0L);
        //设置菜单编号
        menuPower1.setMenuPowerId(Math.toIntExact(menuPower.getMenuPowerPid()));
        //修改父菜单为有叶子
        if (menuPowerMapper.updateById(menuPower1) <= 0) {
            throw new ArithmeticException("新增菜单失败");
        }
        //查询所有的菜单
        List<MenuPower> menuPowerList1 = menuPowerMapper.selectList(new QueryWrapper<MenuPower>().orderByAsc("MENU_POWER_ORDER"));
        List<Integer> list = parentMenuId(menuPowerList1, Integer.parseInt(menuPower.getMenuPowerPid().toString()));
        log.debug("{}"+list.toString());
        for (Integer integer : list) {
            //修改角色菜单表数据为半选状态
            RoleMenuPower roleMenuPower = new RoleMenuPower();
            roleMenuPower.setIsChoice(1L);
            roleMenuPowerMapper.update(roleMenuPower, new QueryWrapper<RoleMenuPower>().eq("MENU_POWER_ID", integer));
        }
        //设置是否有叶子
        menuPower.setMenuPowerLeaf(1L);
        if (menuPowerMapper.insert(menuPower) <= 0) {
            throw new ArithmeticException("新增菜单失败");
        }
        return "成功";
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

    //梯归找出所有的的父菜单
    public List<Integer> parentMenuId(List<MenuPower> menuPowers, Integer integer) {
        for (int i = 0; i < menuPowers.size(); i++) {
            if (menuPowers.get(i).getMenuPowerId().equals(integer)) {
                log.debug("111111111111111111111111111111111111");
                getChildListList.add(menuPowers.get(i).getMenuPowerId());
                log.debug("{}"+menuPowers.get(i).getMenuPowerId());
                log.debug("{}"+Integer.parseInt(menuPowers.get(i).getMenuPowerPid().toString()));
                log.debug("111111111111111111111111111111111111");
                parentMenuId(menuPowers, Integer.parseInt(menuPowers.get(i).getMenuPowerPid().toString()));
            }
        }
        return getChildListList;
    }
}
