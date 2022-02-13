package com.trkj.framework.service.client.system;

import com.trkj.framework.entity.mybatisplus.*;

import com.trkj.framework.service.client.fallbackfactory.SystemClinetServiceFallbackfactory;
import com.trkj.framework.vo.AjaxResponse;
import org.aspectj.apache.bcel.generic.IINC;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author 13795
 */
@FeignClient(value = "FRAMEWORK-ZUUL/8007/provider", fallbackFactory = SystemClinetServiceFallbackfactory.class)
public interface SystemClinetService {

    /***
     *  登录日志分页查询
     * @param registerLog
     * @return
     */
    @PostMapping("/selectRegisterLogAll")
    public Map<String,Object> selectRegisterLogAll(@RequestBody  RegisterLog registerLog);

    /***
     * 登录日志复选删除
     * @param list
     * @return
     */
    @DeleteMapping("/checkRegisterLogDelete")
    public Map<String,Object> checkDelete(@RequestBody ArrayList<Integer> list);

    /***
     * 登录日志清空数据
     * @param registerLog
     * @return
     */
    @DeleteMapping("/emptyRegisterLogList")
    public Map<String,Object> emptyList(@RequestBody RegisterLog registerLog);

    /***
     *分页查询所有公告数据
     * @param notice
     * @return
     */
    @PostMapping("/selectNoticeAll")
    public Map<String,Object> selectNoticeAll(@RequestBody Notice notice);

    /***
     * 公告复选删除
     * @param list
     * @return
     */
    @DeleteMapping("/checkNoticeDelete")
    public Map<String,Object> checkNoticeDelete(@RequestBody ArrayList<Integer> list);

    /***
     * 查询所有的部门列表
     * @return
     */
    @GetMapping("/selectDeptList")
    public  Object selectDeptList();

    /***
     * 新增公告
     * @param notice
     * @return
     */
    @PostMapping("/insertNotice")
    public Map<String,Object> insertNotice(@RequestBody Notice notice);


    /***
     * 查询当前公告绑定的部门
     * @param id
     * @return
     */
    @GetMapping("/selectPossessDeptList")
    public Map<String,Object> selectPossessDeptList(@RequestParam("id") Integer id);


    /***
     * 修改公告
     * @param notice
     * @return
     */
    @PutMapping("/updateNotice")
    public Map<String,Object> updateNotice(@RequestBody Notice notice);


    /***
     * 已看公告人员
     * @param id
     * @return
     */
    @GetMapping("/peropleNoticeViewed")
    public Map<String,Object> peropleNoticeViewed (@RequestParam("id") Integer id);

    /***
     * 未看公告人员
     * @param id
     * @return
     */
    @GetMapping("/unseenNoticePerson")
    public Map<String,Object> unseenNoticePerson (@RequestParam("id") Integer id);

    /**
     * 分页查询所有的角色数据
     * @param role
     * @return
     */
    @PostMapping("/selectRoleAll")
    public  Object selectRoleAll(@RequestBody Role role);


    /***
     * 多选或者单选删除角色数据
     * @param list
     * @return
     */
    @DeleteMapping("/checkRoleDelete")
    public Map<String,Object> checkRoleDelete(@RequestBody ArrayList<Integer> list);

    /***
     * 查询所有的菜单列表
     * @return
     */
    @GetMapping("/menuPowerList")
    public Map<String,Object> menuPowerList();

    /***
     * 添加角色
     * @param role
     * @return
     */
    @PostMapping("/addRole")
    public Map<String,Object> addRole(@RequestBody Role role);

    /***
     * 通过前台的角色名称查询角色是否被使用
     * @param name
     * @return
     */
    @GetMapping("/selectRoleRoleName/{name}/{value}")
    public Map<String,Object> selectRoleRoleName(@PathVariable(name = "name") String name,@PathVariable(name = "value") String value);


    /****
     * 通过角色编号查询对应的菜单列表
     * @param integer
     * @return
     */
    @GetMapping("/menuPowerListInRoleId/{id}")
    public Map<String,Object> menuPowerListInRoleId(@PathVariable(name = "id") Integer integer);

    /**
     * 修改角色
     * @param role
     * @return
     */
    @PutMapping("/updateRole")
    public Map<String,Object> updateRole(@RequestBody Role role);

    /**
     *分配权限
     * @param role
     * @return
     */
    @PutMapping("/allotMenu")
    public Map<String,Object> allotMenu(@RequestBody Role role);

    /****
     * 分页查询所有的角色员工表数据
     * @param roleStaff
     * @return
     */
    @PostMapping("/selectRoleStaff")
    public Map<String,Object> selectRoleStaff(@RequestBody RoleStaff roleStaff);


    /***
     * 用户取消授权
     * @param list
     * @return
     */
    @DeleteMapping("/cancelImpower")
    public Map<String,Object> cancelImpower(@RequestBody ArrayList<Integer> list);

    /***
     * 查询所有在职的员工
     * @param staff
     * @return
     */
    @PostMapping("/selectStaffInState")
    public Map<String,Object> selectStaffInState(@RequestBody Staff staff);

    /***
     * 角色给用户
     * @param roleStaff
     * @return
     */
    @PostMapping("/allotStaff")
    public Map<String,Object> allotStaff(@RequestBody RoleStaff roleStaff);

    /***
     * 通过条件查询菜单
     * @param menuPower
     * @return
     */
    @PostMapping("/menuPowerInCondition")
    public Map<String,Object> menuPowerInCondition(@RequestBody MenuPower menuPower);


    /***
     * 新增一级菜单
     * @param menuPower
     * @return
     */
    @PostMapping("/menuPowerAddSingle")
    public  Object menuPowerAddSingle(@RequestBody MenuPower menuPower);

    /***
     * 通过父菜单获取菜单名称
     * @param integer
     * @return
     */
    @GetMapping("/menuPowerInPid/{id}")
    public  Object menuPowerInPid(@PathVariable("id") Integer  integer);


    /***
     * 通过实体类修改菜单数据
     * @param menuPower
     * @return
     */
    @PostMapping("/menuPowerUpdate")
    public Map<String,Object> menuPowerUpdate(@RequestBody MenuPower menuPower);

    /***
     * 通过菜单编号进行删除数据
     * @param id
     * @return
     */
    @DeleteMapping("/menuPowerDelete/{id}")
    public Map<String,Object> menuPowerDelete(@PathVariable("id") Integer id);


    /***
     * 通过实体类数据新增菜单
     * @param menuPower
     * @return
     */
    @PostMapping("/menuPowerAdd")
    public Map<String,Object> menuPowerAdd(@RequestBody MenuPower menuPower);
}
