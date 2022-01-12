package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.RoleMenuPower;
import com.trkj.framework.entity.mybatisplus.RoleStaff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

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


}
