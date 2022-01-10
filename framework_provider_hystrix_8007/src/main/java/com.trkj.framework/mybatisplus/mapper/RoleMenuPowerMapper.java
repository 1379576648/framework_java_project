package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.RoleMenuPower;
import com.trkj.framework.entity.mybatisplus.RoleStaff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 角色菜单权限表 Mapper 接口
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-06
 */
@Mapper
public interface RoleMenuPowerMapper extends BaseMapper<RoleMenuPower> {

    /***
     * 逻辑删除角色权限表数据
     * @param queryWrapper
     * @return
     */
    @Delete("delete from ROLE_MENU_POWER ${ew.customSqlSegment}")
    int deleteRoleMenuPower(@Param(Constants.WRAPPER) QueryWrapper<RoleMenuPower> queryWrapper);
}
