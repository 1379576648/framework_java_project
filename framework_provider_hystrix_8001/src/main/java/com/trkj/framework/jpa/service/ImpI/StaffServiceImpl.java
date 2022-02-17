package com.trkj.framework.jpa.service.ImpI;

import com.trkj.framework.entity.jpa.*;
import com.trkj.framework.jpa.dao.*;
import com.trkj.framework.jpa.service.StaffService;
import com.trkj.framework.util.MenuChild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

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
    @Autowired
    private DeptPostDao deptPostDao;

    @Autowired
    private RedisTemplate redisTemplate;

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
            //乐观锁
            registerLog.setRevision(1);
            registerLogDao.save(registerLog);
            redisTemplate.opsForValue().set("JpaRegisterLog:"+registerLog.toString(),registerLog);
            redisTemplate.delete(redisTemplate.keys("JpaRegisterLogPage:*"));
            redisTemplate.delete(redisTemplate.keys("JpaRegisterLogList:*"));
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
        List<RegisterLogEntity> registerLogEntities = new ArrayList<>();
        //查询缓存
        Set set  = redisTemplate.keys("JpaRegisterLogList:registerLogPhone=" + Long.decode(map.get("phone").toString()));
        Object o = redisTemplate.opsForValue().get(!set.isEmpty()?set.toArray()[0].toString():"");
        if (o == null || o.equals("")) {
            //查询数据库
            registerLogEntities = registerLogDao.selectRegisterNumber(Long.decode(map.get("phone").toString()));
            redisTemplate.opsForValue().set("JpaRegisterLogList:registerLogPhone=" + Long.decode(map.get("phone").toString()), registerLogEntities);
        } else {
            registerLogEntities = (List<RegisterLogEntity>) o;
        }
        if (registerLogEntities.size() >= 3) {
            //返回需要等待的时间
            entity.setError(30 - (date.getTime() - registerLogEntities.get(0).getCreatedTime().getTime()) / (1000 * 60));
            return entity;
        } else {
            StaffEntity staffEntity  = staffDao.findStaffByPhoneAndPass(Long.decode(map.get("phone").toString()), map.get("pass").toString());
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
            //乐观锁
            registerLog.setRevision(1);
            registerLogDao.save(registerLog);
            redisTemplate.opsForValue().set("JpaRegisterLog:"+registerLog.toString(),registerLog);
            redisTemplate.delete(redisTemplate.keys("JpaRegisterLogPage:*"));
            redisTemplate.delete(redisTemplate.keys("JpaRegisterLogList:*"));
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
        Set set  = redisTemplate.keys("JpaRoleStaffList:e.roleId=d.roleId,staffId=" + id );
        //查询缓存
        Object o = redisTemplate.opsForValue().get(!set.isEmpty()?set.toArray()[0].toString():"");
        List<RoleStaffEntity> roleStaffEntities = new ArrayList<>();
        if (o == null || o.equals("")) {
            //查询数据库
            roleStaffEntities = roleStaffDao.selectRoleStaff(id);
            redisTemplate.opsForValue().set("JpaRoleStaffList:e.roleId=d.roleId,staffId=" + id , roleStaffEntities);
        } else {
            roleStaffEntities = (List<RoleStaffEntity>) o;
        }
        //储藏所有角色下的菜单列表 没有去重
        List<MenuPowerEntity> menuPowerEntities = new ArrayList<>();
        //迭代角色列表
        for (RoleStaffEntity roleStaffEntity : roleStaffEntities) {
            //获取所有角色下的菜单编号列表
            List<RoleMenuPowerEntity> roleMenuPowerEntities = new ArrayList<>();
            //查询缓存
            Set set1 = redisTemplate.keys("JpaRoleMenuPowerList:roleId=" + roleStaffEntity.getRoleId());
            Object o1 = redisTemplate.opsForValue().get(!set1.isEmpty()?set1.toArray()[0].toString():"");
            if (o1 == null || o1.equals("")) {
                //查询数据库
                roleMenuPowerEntities = roleMenuPowerDao.selectRoleMenuPower(roleStaffEntity.getRoleId());
                redisTemplate.opsForValue().set("JpaRoleMenuPowerList:roleId=" + roleStaffEntity.getRoleId(), roleMenuPowerEntities);
            } else {
                roleMenuPowerEntities = (List<RoleMenuPowerEntity>) o1;
            }
            //迭代菜单编号列表
            for (RoleMenuPowerEntity roleMenuPowerEntity : roleMenuPowerEntities) {
                //通过菜单编号查询菜单
                MenuPowerEntity menuPower = new MenuPowerEntity();
                //查询缓存
                Set set2 = redisTemplate.keys("JpaMenuPower:*menuPowerId=" + roleMenuPowerEntity.getMenuPowerId()+",*");
                Object o2 = redisTemplate.opsForValue().get(!set2.isEmpty()?set2.toArray()[0].toString():"");
                if (o2 == null || o2.equals("")) {
                    //查询数据库
                    menuPower = menuPowerDao.selectMenuPower(roleMenuPowerEntity.getMenuPowerId());
                    redisTemplate.opsForValue().set("JpaMenuPower:"+menuPower.toString(), menuPower);
                } else {
                    menuPower = (MenuPowerEntity) o2;
                }
                //将查询的菜单列表添加到集合中
                if (menuPower != null) {
                    menuPowerEntities.add(menuPower);
                }
            }
            redisTemplate.delete(redisTemplate.keys("JpaMenuPowerPage:*"));
            redisTemplate.delete(redisTemplate.keys("JpaMenuPowerList:*"));
        }
        //储藏所有角色下的菜单列表 去重
        List<MenuPowerEntity> menuPowerEntities1 = menuPowerEntities.stream().distinct().collect(Collectors.toList());
        //排序
        menuPowerEntities1.sort(comparing(MenuPowerEntity::getMenuPowerOrder));
        //菜单根节点
        List<MenuPowerEntity> menuPowerEntities2 = new ArrayList<>();
        //循环菜单列表找出根节点
        for (MenuPowerEntity menuPower : menuPowerEntities1) {
            //如果父级菜单为0 菜单类型为菜单 状态为启用
            if (menuPower.getMenuPowerPid() == 0 && menuPower.getMenuPowerType() == 0 && menuPower.getMenuPowerState() == 0) {
                menuPowerEntities2.add(menuPower);
            }
        }
        //为根菜单设置子菜单，getClild是递归调用的
        for (MenuPowerEntity nav : menuPowerEntities2) {
            /* 获取根节点下的所有子节点 使用getChild方法*/
            List<MenuPowerEntity> childList = getChild.getChild(nav.getMenuPowerId(), menuPowerEntities1);
            //给根节点设置子节点
            nav.setChildren(childList);
        }
        return menuPowerEntities2;
    }

    /***
     * 通过员工编号查询职位名称
     * @param integer
     * @return
     */
    @Override
    public String selectPostName(Integer integer) {
        DeptPostEntity deptPost= deptPostDao.findDeptPostEntityByDeptPostId(integer);
        //判断
        if (deptPost != null) {
            return deptPost.getPostName();
        }
        return null;
    }
}
