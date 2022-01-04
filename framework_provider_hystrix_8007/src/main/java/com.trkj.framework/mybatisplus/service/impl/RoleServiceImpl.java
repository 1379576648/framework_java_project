package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.framework.entity.mybatisplus.Notice;
import com.trkj.framework.entity.mybatisplus.Role;
import com.trkj.framework.entity.mybatisplus.RoleStaff;
import com.trkj.framework.mybatisplus.mapper.RoleMapper;
import com.trkj.framework.mybatisplus.mapper.RoleStaffMapper;
import com.trkj.framework.mybatisplus.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        //逻辑删除查询
        queryWrapper.eq("IS_DELETED", 0);

        //按照ID降序
        queryWrapper.orderByDesc("ROLE_ID");
        return roleMapper.selectRoleAll(page, queryWrapper);
    }

    /***
     * 复选框删除角色数据
     * @param list
     * @return
     */
    @Override
    public String checkRoleDelete(ArrayList<Integer> list) {
        String s = "成功";
        //循环传过来的集合
        for (int i = 0; i < list.size(); i++) {
            //通过角色编号查寻角色员工表的数据
            List<RoleStaff> staffList = roleStaffMapper.selectList(new QueryWrapper<RoleStaff>().eq("ROLE_ID", list.get(i)).eq("IS_DELETED", 0));
            if (staffList.size()!=0) {
                if (roleStaffMapper.deleteRoleStaff(new QueryWrapper<RoleStaff>().eq("ROLE_ID", list.get(i)).eq("IS_DELETED", 0)) <=0) {
                    return "删除角色员工表数据失败";
                }
            }
            //通过编号删除角色表数据
            if (roleMapper.deleteById(list.get(i)) >= 1) {
                s = "成功";
            } else {
                return "删除角色表数据失败";
            }
        }
        return s;
    }
}
