package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.entity.mybatisplus.Role;
import com.trkj.framework.entity.mybatisplus.RoleStaff;
import com.trkj.framework.entity.mybatisplus.Staff;
import io.swagger.models.auth.In;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-04
 */
public interface RoleService  {

    /***
     * 分页查询所有的角色数据
     * @param role
     * @return
     */
    Object selectRoleAll(Role role);

    /***
     * 多选删除
     * @param list
     * @return
     */
    String checkRoleDelete(ArrayList<Integer> list) throws ArithmeticException;


    /***
     * 添加角色
     * @param role
     * @return
     */
    String addRole(Role role) throws ArithmeticException;

    /***
     * 通过前台的角色名称判断角色是否被使用
     * @param name
     * @param value
     * @return
     */
    String selectRoleRoleName(String name,String value);


    /***
     * 修改角色
     * @param role
     * @return
     */
    String updateRole(Role role) throws ArithmeticException;


    /***
     * 分配权限
     * @param role
     * @return
     */
    String allotMenu(Role role) throws ArithmeticException;

    /***
     * 分页查询所有的角色员工表数据
     * @param roleStaff
     * @return
     */
    Object selectRoleStaff (RoleStaff roleStaff);


    /***
     * 多个取消授权或者单个取消授权
     * @param list
     * @return
     */
    String cancelImpower(ArrayList<Integer> list);


    /***
     * 查询所有的在职的所有员工
     * @param staff
     * @return
     */
    Object selectStaffInState(Staff staff);

    /***
     * 角色分配员工
     * @param roleStaff
     * @return
     */
    String allotStaff(RoleStaff roleStaff) throws ArithmeticException;
}
