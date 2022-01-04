package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.entity.mybatisplus.Role;

import java.util.ArrayList;

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
    IPage<Role> selectRoleAll(Role role);

    /***
     * 多选删除
     * @param list
     * @return
     */
    String checkRoleDelete(ArrayList<Integer> list);
}
