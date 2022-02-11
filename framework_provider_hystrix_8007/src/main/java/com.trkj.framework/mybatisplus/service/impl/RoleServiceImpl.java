package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.mybatisplus.mapper.RoleMapper;
import com.trkj.framework.mybatisplus.mapper.RoleMenuPowerMapper;
import com.trkj.framework.mybatisplus.mapper.RoleStaffMapper;
import com.trkj.framework.mybatisplus.mapper.StaffMapper;
import com.trkj.framework.mybatisplus.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-04
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleStaffMapper roleStaffMapper;

    @Autowired
    private RoleMenuPowerMapper roleMenuPowerMapper;

    @Autowired
    private StaffMapper staffMapper;

    /***
     * 分页查询所有的角色数据
     * @param role
     * @return
     */
    @Override
    public IPage<Role> selectRoleAll(Role role) {
        //创建分页
        Page<Role> page = new Page<Role>(role.getCurrenPage(), role.getPageSize());
        //创建条件构造器
        QueryWrapper<Role> queryWrapper = new QueryWrapper<Role>();
        //判断角色名称是否为空
        if (role.getRoleName() != null && !role.getRoleName().equals("")) {
            //角色名称模糊查询
            queryWrapper.like("ROLE_NAME", role.getRoleName());
        }

        //判断角色描述是否为空
        if (role.getRoleDescribe() != null && !role.getRoleDescribe().equals("")) {
            //角色描述模糊查询
            queryWrapper.like("ROLE_DESCRIBE", role.getRoleDescribe());
        }

        //判断角色状态否未空
        if (role.getRoleState() != null) {
            //类型模糊查询
            queryWrapper.like("ROLE_STATE", role.getRoleState());
        }

        //判断传入的时间是否为空
        if (role.getStartTime() != null || role.getEndTime() != null) {
            //登录时间范围查询
            queryWrapper.between("CREATED_TIME", role.getStartTime(), role.getEndTime());
        }


        //按照ID降序
        queryWrapper.orderByDesc("ROLE_ID");
        return roleMapper.selectPage(page, queryWrapper);
    }

    /***
     * 复选框删除角色数据
     * @param list
     * @return
     */
    @Override
    @Transactional
    public String checkRoleDelete(ArrayList<Integer> list) {
        String s = "成功";
        //循环传过来的集合
        for (int i = 0; i < list.size(); i++) {
            //通过角色编号查寻角色员工表的数据
            List<RoleStaff> staffList = roleStaffMapper.selectList(new QueryWrapper<RoleStaff>().eq("ROLE_ID", list.get(i)));
            if (staffList.size() != 0) {
                //通过员工编号删除角色员工表数据
                if (roleStaffMapper.delete(new QueryWrapper<RoleStaff>().eq("ROLE_ID", list.get(i))) <= 0) {
                    return "删除角色员工数据失败";
                }
            }
            //通过角色编号查询角色权限表数据
            List<RoleMenuPower> roleMenuPowers = roleMenuPowerMapper.selectList(new QueryWrapper<RoleMenuPower>().eq("ROLE_ID", list.get(i)));
            if (roleMenuPowers.size() != 0) {
                //通过角色编号删除角色权限表数据z
                if (roleMenuPowerMapper.delete(new QueryWrapper<RoleMenuPower>().eq("ROLE_ID", list.get(i))) <= 0) {
                    return "删除角色权限数据失败";
                }
            }

            //通过角色编号删除角色表数据
            if (roleMapper.deleteById(list.get(i)) >= 1) {
                s = "成功";
            } else {
                return "删除角色数据失败";
            }
        }
        return s;
    }

    /***
     * 通过前台的角色名称查询角色是否被使用
     * @param name
     * @return
     */
    @Override
    public String selectRoleRoleName(String name, String value) {
        String s = "成功";
        Role role = roleMapper.selectOne(new QueryWrapper<Role>().eq("ROLE_NAME", name));
        if (role != null) {
            if (!role.getRoleId().toString().equals(value)) {
                return "角色[" + name + "]名称已被使用";
            }
        }
        return s;
    }

    /***
     * 修改角色
     * @param role
     * @return
     */
    @Override
    @Transactional
    public String updateRole(Role role) {
        String s = "成功";
        if (roleMapper.updateById(role) <= 0) {
            return "修改角色数据失败";
        }
        //先删除角色菜单数据
        roleMenuPowerMapper.delete(new QueryWrapper<RoleMenuPower>().eq("ROLE_ID", role.getRoleId()));
        //循环菜单列表
        for (Integer id : role.getMenuList()) {
            RoleMenuPower roleMenuPower = new RoleMenuPower();
            //是否半选择
            roleMenuPower.setIsChoice(util(role.getMoietyList(),id));
            //角色编号
            roleMenuPower.setRoleId(Long.valueOf(role.getRoleId()));
            //菜单编号
            roleMenuPower.setMenuPowerId(Long.valueOf(id));
            if (roleMenuPowerMapper.insert(roleMenuPower) >= 1) {
                s = "成功";
            } else {
                return "添加角色菜单数据失败";
            }
        }
        return s;
    }

    /**
     * 分配权限
     *
     * @param role
     * @return
     */
    @Override
    @Transactional
    public String allotMenu(Role role) {
        String s = "成功";
        //先删除角色菜单数据
        roleMenuPowerMapper.delete(new QueryWrapper<RoleMenuPower>().eq("ROLE_ID", role.getRoleId()));
        //循环菜单列表
        for (Integer id : role.getMenuList()) {
            RoleMenuPower roleMenuPower = new RoleMenuPower();
            //是否半选择
            roleMenuPower.setIsChoice(util(role.getMoietyList(),id));
            //角色编号
            roleMenuPower.setRoleId(Long.valueOf(role.getRoleId()));
            //菜单编号
            roleMenuPower.setMenuPowerId(Long.valueOf(id));
            if (roleMenuPowerMapper.insert(roleMenuPower) >= 1) {
                s = "成功";
            } else {
                return "添加角色菜单数据失败";
            }
        }
        return s;
    }

    /***
     *
     * 分页查询所有的角色员工表数据
     * @param roleStaff
     * @return
     */
    @Override
    public IPage<RoleStaff> selectRoleStaff(RoleStaff roleStaff) {
        //分页插件
        Page<RoleStaff> iPage = new Page<RoleStaff>(roleStaff.getCurrenPage(), roleStaff.getPageSize());

        //条件构造器
        QueryWrapper<RoleStaff> roleStaffQueryWrapper = new QueryWrapper<RoleStaff>();
        //判断员工名称是否为空
        if (roleStaff.getStaffName() != null && !roleStaff.getStaffName().equals("")) {
            roleStaffQueryWrapper.like("b.STAFF_NAME", roleStaff.getStaffName());
        }
        //判断员工手机号码是否为空
        if (roleStaff.getStaffPhone() != null) {
            roleStaffQueryWrapper.like("b.STAFF_PHONE", roleStaff.getStaffPhone());
        }
        //判断员工状态是否为空
        if (roleStaff.getStaffState() != null) {
            roleStaffQueryWrapper.eq("b.STAFF_STATE", roleStaff.getStaffState());
        }

        //角色编号
        roleStaffQueryWrapper.eq("a.ROLE_ID", roleStaff.getRoleId());
        //逻辑删除
        roleStaffQueryWrapper.eq("b.IS_DELETED", 0);

        return roleStaffMapper.pageRoleStaff(iPage, roleStaffQueryWrapper);
    }

    /***
     * 用户取消授权
     * @param list
     * @return
     */
    @Override
    @Transactional
    public String cancelImpower(ArrayList<Integer> list) {
        String s = "成功";
        //循环传过来的集合
        for (Integer integer : list) {
            if (roleStaffMapper.deleteById(integer) >= 1) {
                s = "成功";
            } else {
                return "取消授权失败";
            }
        }
        return s;
    }


    /***
     * 查询所有的在职的所有员工
     * @param staff
     * @return
     */
    @Override
    public Object selectStaffInState(Staff staff) {
        //分页插件
        Page<Staff> iPage = new Page<Staff>(staff.getCurrenPage(), staff.getPageSize());
        //条件构造器
        QueryWrapper<Staff> queryWrapper = new QueryWrapper<Staff>();
        //判断员工名称是否为空
        if (staff.getStaffName() != null && !staff.getStaffName().equals("")) {
            queryWrapper.like("STAFF_NAME", staff.getStaffName());
        }
        //判断员工手机号码是否为空
        if (staff.getStaffPhone() != null) {
            queryWrapper.like("STAFF_PHONE", staff.getStaffPhone());
        }
        //通过角色编号查询角色员工表数据
        List<RoleStaff> staffList = roleStaffMapper.selectList(new QueryWrapper<RoleStaff>().eq("ROLE_ID", staff.getRoleId()));
        if (staffList.size() >= 1) {
            for (RoleStaff roleStaff : staffList) {
                //角色编号
                queryWrapper.ne("STAFF_ID", roleStaff.getStaffId());
            }
        }
        //状态不等于离职 2
        queryWrapper.ne("STAFF_STATE", 2).select(Staff.class, i -> !"STAFF_PASS".equals(i.getColumn()));
        return staffMapper.selectPage(iPage, queryWrapper);
    }

    /***
     * 角色分配员工
     * @param roleStaff
     * @return
     */
    @Override
    @Transactional
    public String allotStaff(RoleStaff roleStaff) {
        String s = "成功";
        for (Integer integer : roleStaff.getList()) {
            RoleStaff roleStaff1 = new RoleStaff();
            //角色编号
            roleStaff1.setRoleId(roleStaff.getRoleId());
            //员工编号
            roleStaff1.setStaffId(Long.valueOf(integer));
            if (roleStaffMapper.insert(roleStaff1) >= 1) {
                s = "成功";
            } else {
                return "授权失败";
            }
        }
        return s;
    }


    /***
     * 添加角色
     * @param role
     * @return
     */
    @Override
    @Transactional
    public String addRole(Role role) {
        String s = "成功";
        if (roleMapper.insert(role) <= 0) {
            return "添加角色数据失败";
        }
        //循环菜单列表
        for (Integer id : role.getMenuList()) {
            RoleMenuPower roleMenuPower = new RoleMenuPower();
            //是否半选择
            roleMenuPower.setIsChoice(util(role.getMoietyList(),id));
            //角色编号
            roleMenuPower.setRoleId(Long.valueOf(role.getRoleId()));
            //菜单编号
            roleMenuPower.setMenuPowerId(Long.valueOf(id));
            if (roleMenuPowerMapper.insert(roleMenuPower) >= 1) {
                s = "成功";
            } else {
                return "添加角色菜单数据失败";
            }
        }
        return s;
    }

    public Long util(ArrayList<Integer> list, Integer index) {
        Long id = 0L;
        for (Integer integer : list) {
            System.out.println(integer+":"+index);
            if (integer.equals(index)) {
                return 1L;
            }
        }
        return id;
    }


}
