package com.trkj.framework.jpa.service.ImpI;

import ch.qos.logback.core.joran.action.AppenderRefAction;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.framework.entity.jpa.*;
import com.trkj.framework.entity.mybatisplus.MenuPower;
import com.trkj.framework.jpa.dao.*;
import com.trkj.framework.jpa.service.StaffService;
import com.trkj.framework.util.MenuChild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 13795
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private RegisterLogDao registerLogDao;
    @Autowired
    private RoleStaffDao roleStaffDao;
    @Autowired
    private RoleMenuPowerDao roleMenuPowerDao;
    @Autowired
    private MenuPowerDao menuPowerDao;
    @Autowired
    private MenuChild getChild;

    /***
     * 通过id查询用户信息
     * @param map
     * @return
     */
    @Override
    @Transactional
    public StaffEntity staffId(Map<String, Object> map) {
        StaffEntity staffEntity = staffDao.selectId(Integer.parseInt(map.get("成功").toString()));
        if (staffEntity != null) {
            RegisterLogEntity registerLog = new RegisterLogEntity();
            //登录类型
            registerLog.setRegisterLogGenre(1);
            //登录手机号码
            registerLog.setRegisterLogPhone(staffEntity.getStaffPhone());
            //登录用户名
            registerLog.setRegisterLogPeople(staffEntity.getStaffName());
            //登录成功
            registerLog.setRegisterLogState(0);
            //创建时间
            registerLog.setCreatedTime(new Date());
            //修改时间
            registerLog.setUpdatedTime(new Date());
            //浏览器名称
            registerLog.setRegisterLogBrowser(map.get("browserName").toString());
            //IP地址
            registerLog.setRegisterLogIp(map.get("ip").toString());
            //设备类型
            registerLog.setRegisterLogType(map.get("deviceType").toString());
            //ip所在地
            registerLog.setRegisterLogIpName(map.get("ipName").toString());
            //逻辑删除
            registerLog.setIsDeleted(0);
            //乐观锁
            registerLog.setRevision(1);
            registerLogDao.save(registerLog);
        }
        return staffEntity;
    }

    /****
     * 通过手机号码以及密码进行登录
     * @param map
     * @return
     */
    @Override
    @Transactional
    public StaffEntity findStaffByPhoneAndPass(Map<String, Object> map) {
        StaffEntity entity = new StaffEntity();
        //系统当前时间
        Date date = new Date();
        List<RegisterLogEntity> registerLogEntities = registerLogDao.selectRegisterNumber(Long.decode(map.get("phone").toString()));
        if (registerLogEntities.size() >= 3) {
            //返回需要等待的时间
            entity.setError(30 - (date.getTime() - registerLogEntities.get(0).getCreatedTime().getTime()) / (1000 * 60));
            return entity;
        } else {
            StaffEntity staffEntity = staffDao.findStaffByPhoneAndPass(Long.decode(map.get("phone").toString()), map.get("pass").toString());
            RegisterLogEntity registerLog = new RegisterLogEntity();
            //登录类型
            registerLog.setRegisterLogGenre(1);
            //登录手机号码
            registerLog.setRegisterLogPhone(Long.decode(map.get("phone").toString()));
            //状态
            if (staffEntity == null) {
                //登录失败
                registerLog.setRegisterLogState(1);
            } else {
                //登录用户名
                registerLog.setRegisterLogPeople(staffEntity.getStaffName());
                //登录成功
                registerLog.setRegisterLogState(0);
            }
            //创建时间
            registerLog.setCreatedTime(new Date());
            //修改时间
            registerLog.setUpdatedTime(new Date());
            //浏览器名称
            registerLog.setRegisterLogBrowser(map.get("browserName").toString());
            //IP地址
            registerLog.setRegisterLogIp(map.get("ip").toString());
            //设备类型
            registerLog.setRegisterLogType(map.get("deviceType").toString());
            //ip所在地
            registerLog.setRegisterLogIpName(map.get("ipName").toString());
            //逻辑删除
            registerLog.setIsDeleted(0);
            //乐观锁
            registerLog.setRevision(1);
            registerLogDao.save(registerLog);
            return staffEntity;
        }
    }
    /***
     *  查询用户角色下菜单列表
     * @return
     */
    @Override
    public Object menuList(Integer id) {
        //获取用户下所有的角色列表
        List<RoleStaffEntity> roleStaffEntities = roleStaffDao.selectRoleStaff(id);
        //储藏所有角色下的菜单列表 没有去重
        List<MenuPowerEntity> menuPowerEntities = new ArrayList<>();
        //迭代角色列表
        for (RoleStaffEntity roleStaffEntity : roleStaffEntities) {
            //获取所有角色下的菜单编号列表
            List<RoleMenuPowerEntity> roleMenuPowerEntities = roleMenuPowerDao.selectRoleMenuPower(roleStaffEntity.getRoleId());
            //迭代菜单编号列表
            for (RoleMenuPowerEntity roleMenuPowerEntity : roleMenuPowerEntities) {
                //通过菜单编号查询菜单
                MenuPowerEntity menuPower = menuPowerDao.selectMenuPower(roleMenuPowerEntity.getMenuPowerId());
                //将查询的菜单列表添加到集合中
                if (menuPower != null) {
                    menuPowerEntities.add(menuPower);
                }
            }
        }

        //储藏所有角色下的菜单列表 去重
        List<MenuPowerEntity> menuPowerEntities1 = menuPowerEntities.stream().distinct().collect(Collectors.toList());
        //菜单根节点
        List<MenuPowerEntity> menuPowerEntities2 = new ArrayList<>();
        //循环菜单列表找出根节点
        for (MenuPowerEntity menuPower : menuPowerEntities1) {
            System.out.println(menuPower.toString());
            if (menuPower.getMenuPowerPid() == 0 && menuPower.getMenuPowerType() == 0) {
                menuPowerEntities2.add(menuPower);
            }
        }
        //为根菜单设置子菜单，getClild是递归调用的
        for (MenuPowerEntity nav : menuPowerEntities2) {
            /* 获取根节点下的所有子节点 使用getChild方法*/
            List<MenuPowerEntity> childList = getChild.getChild(nav.getMenuPowerId(), menuPowerEntities1);
            //给根节点设置子节点
            nav.setList(childList);
        }
        return menuPowerEntities2;
    }
}
