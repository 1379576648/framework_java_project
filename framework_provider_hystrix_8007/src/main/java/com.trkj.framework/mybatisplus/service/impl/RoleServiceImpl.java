package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.jpa.MenuPowerEntity;
import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.mybatisplus.mapper.*;
import com.trkj.framework.mybatisplus.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Autowired
    private DeptPostMapper deptPostMapper;

    /***
     * 分页查询所有的角色数据
     * @param role
     * @return
     */
    @Override
    public Object selectRoleAll(Role role) {
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
        IPage<Role> roleIPage = roleMapper.selectPage(page, queryWrapper);
        return roleIPage;
    }

    /***
     * 复选框删除角色数据
     * @param list
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String checkRoleDelete(ArrayList<Integer> list) throws ArithmeticException {
        //循环传过来的集合
        for (int i = 0; i < list.size(); i++) {
            //通过角色编号查寻角色员工表的数据
            List<RoleStaff> staffList = new ArrayList<>();
            staffList = roleStaffMapper.selectList(new QueryWrapper<RoleStaff>().eq("ROLE_ID", list.get(i)));
            if (staffList.size() != 0) {
                //通过员工编号删除角色员工表数据
                if (roleStaffMapper.delete(new QueryWrapper<RoleStaff>().eq("ROLE_ID", list.get(i))) <= 0) {
                    throw new ArithmeticException("删除角色失败");
                }
            }
            //通过角色编号查询角色权限表数据
            List<RoleMenuPower> roleMenuPowers = new ArrayList<>();
            roleMenuPowers = roleMenuPowerMapper.selectList(new QueryWrapper<RoleMenuPower>().eq("ROLE_ID", list.get(i)));
            if (roleMenuPowers.size() != 0) {
                //通过角色编号删除角色权限表数据z
                if (roleMenuPowerMapper.delete(new QueryWrapper<RoleMenuPower>().eq("ROLE_ID", list.get(i))) <= 0) {
                    throw new ArithmeticException("删除角色失败");
                }
            }

            //通过角色编号删除角色表数据
            if (roleMapper.deleteById(list.get(i)) <= 0) {
                throw new ArithmeticException("删除角色失败");
            }
        }
        return "成功";
    }

    /***
     * 通过前台的角色名称查询角色是否被使用
     * @param name
     * @return
     */
    @Override
    public String selectRoleRoleName(String name, String value) {
        Role role = new Role();
        role = roleMapper.selectOne(new QueryWrapper<Role>().eq("ROLE_NAME", name));
        if (role != null) {
            if (!role.getRoleId().toString().equals(value)) {
                return "角色[" + name + "]名称已被使用";
            }
        }
        return "成功";
    }

    /***
     * 修改角色
     * @param role
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateRole(Role role) throws ArithmeticException {
        if (roleMapper.updateById(role) <= 0) {
            throw new ArithmeticException("修改角色失败");
        }
        //先删除角色菜单数据
        roleMenuPowerMapper.delete(new QueryWrapper<RoleMenuPower>().eq("ROLE_ID", role.getRoleId()));
        //循环菜单列表
        for (Integer id : role.getMenuList()) {
            RoleMenuPower roleMenuPower = new RoleMenuPower();
            //是否半选择
            roleMenuPower.setIsChoice(util(role.getMoietyList(), id));
            //角色编号
            roleMenuPower.setRoleId(Long.valueOf(role.getRoleId()));
            //菜单编号
            roleMenuPower.setMenuPowerId(Long.valueOf(id));
            if (roleMenuPowerMapper.insert(roleMenuPower) <= 0) {
                throw new ArithmeticException("修改角色失败");
            }
        }
        return "成功";
    }

    /**
     * 分配权限
     *
     * @param role
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String allotMenu(Role role) throws ArithmeticException {
        //先删除角色菜单数据
        roleMenuPowerMapper.delete(new QueryWrapper<RoleMenuPower>().eq("ROLE_ID", role.getRoleId()));
        //循环菜单列表
        for (Integer id : role.getMenuList()) {
            RoleMenuPower roleMenuPower = new RoleMenuPower();
            //是否半选择
            roleMenuPower.setIsChoice(util(role.getMoietyList(), id));
            //角色编号
            roleMenuPower.setRoleId(Long.valueOf(role.getRoleId()));
            //菜单编号
            roleMenuPower.setMenuPowerId(Long.valueOf(id));
            if (roleMenuPowerMapper.insert(roleMenuPower) <= 0) {
                throw new ArithmeticException("分配失败");
            }
        }
        return "成功";
    }

    /***
     *
     * 分页查询所有的角色员工表数据
     * @param roleStaff
     * @return
     */
    @Override
    public Object selectRoleStaff(RoleStaff roleStaff) {
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
        IPage<RoleStaff> page = roleStaffMapper.pageRoleStaff(iPage, roleStaffQueryWrapper);
        return page;
    }

    /***
     * 用户取消授权
     * @param list
     * @return
     */
    @Override
    public String cancelImpower(ArrayList<Integer> list) {
        if (roleStaffMapper.deleteBatchIds(list) <= 0) {
            return "取消失败";
        }
        return "成功";
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
            queryWrapper.like("A.STAFF_NAME", staff.getStaffName());
        }
        //判断员工名称是否为空
        if (staff.getDeptPostName() != null && !staff.getDeptPostName().equals("")) {
            queryWrapper.like("B.POST_NAME", staff.getDeptPostName());
        }
        //判断员工手机号码是否为空
        if (staff.getStaffPhone() != null) {
            queryWrapper.like("A.STAFF_PHONE", staff.getStaffPhone());
        }
        //通过角色编号查询角色员工表数据
        List<RoleStaff> staffList = roleStaffMapper.selectList(new QueryWrapper<RoleStaff>().eq("ROLE_ID", staff.getRoleId()));
        if (staffList.size() >= 1) {
            for (RoleStaff roleStaff : staffList) {
                //角色编号
                queryWrapper.ne("A.STAFF_ID", roleStaff.getStaffId());
            }
        }
        //状态不等于离职 2
        queryWrapper.ne("A.STAFF_STATE", 2).select(Staff.class, i -> !"STAFF_PASS".equals(i.getColumn()));
        //分页查询数据
        IPage<Staff> staffIPage = staffMapper.selectStaffInState(iPage, queryWrapper);
        return staffIPage;
    }

    /***
     * 角色分配员工
     * @param roleStaff
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String allotStaff(RoleStaff roleStaff) throws ArithmeticException {
        for (Integer integer : roleStaff.getList()) {
            RoleStaff roleStaff1 = new RoleStaff();
            //角色编号
            roleStaff1.setRoleId(roleStaff.getRoleId());
            //员工编号
            roleStaff1.setStaffId(Long.valueOf(integer));
            if (roleStaffMapper.insert(roleStaff1) <= 0) {
                throw new ArithmeticException("分配失败");
            }
        }
        return "成功";
    }

    /***
     * 查询所有的职位
     * @return
     */
    @Override
    public Object selectDeptPostAll() {
        //定义职位存储空间
        List<String> list = new ArrayList<>();
        //查询所有的职位
        List<DeptPost> deptPosts =deptPostMapper.selectList(null);
        for (int i = 0; i <deptPosts.size() ; i++) {
            list.add(deptPosts.get(i).getPostName());
        }
        // 去重
        List<String> stringList = list.stream().distinct().collect(Collectors.toList());
        return stringList;
    }


    /***
     * 添加角色
     * @param role
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addRole(Role role) throws ArithmeticException {
        if (roleMapper.insert(role) <= 0) {
            throw new ArithmeticException("添加角色失败");
        }
        //循环菜单列表
        for (Integer id : role.getMenuList()) {
            RoleMenuPower roleMenuPower = new RoleMenuPower();
            //是否半选择
            roleMenuPower.setIsChoice(util(role.getMoietyList(), id));
            //角色编号
            roleMenuPower.setRoleId(Long.valueOf(role.getRoleId()));
            //菜单编号
            roleMenuPower.setMenuPowerId(Long.valueOf(id));
            if (roleMenuPowerMapper.insert(roleMenuPower) <= 0) {
                throw new ArithmeticException("添加角色失败");
            }
        }
        return "成功";
    }

    public Long util(ArrayList<Integer> list, Integer index) {
        Long id = 0L;
        for (Integer integer : list) {
            if (integer.equals(index)) {
                return 1L;
            }
        }
        return id;
    }


}
