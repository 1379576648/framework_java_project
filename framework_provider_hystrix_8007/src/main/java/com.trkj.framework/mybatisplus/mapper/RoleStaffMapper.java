package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.NoticeStaff;
import com.trkj.framework.entity.mybatisplus.RoleStaff;
import com.trkj.framework.vo.StaffVo;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 * 角色员工表 Mapper 接口
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-04
 */
@Mapper
public interface RoleStaffMapper extends BaseMapper<RoleStaff> {

    /**
     * 通过角色编号多表查询角色员工表
     * @param page
     * @param queryWrapper
     * @return
     */
    public IPage<RoleStaff> pageRoleStaff(Page<RoleStaff> page, @Param(Constants.WRAPPER) QueryWrapper<RoleStaff> queryWrapper);

}
