package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.NoticeStaff;
import com.trkj.framework.entity.mybatisplus.RoleStaff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    /***
     * 逻辑删除角色员工表数据
     * @param queryWrapper
     * @return
     */
    @Delete("delete from ROLE_STAFF ${ew.customSqlSegment}")
    int deleteRoleStaff(@Param(Constants.WRAPPER) QueryWrapper<RoleStaff> queryWrapper);
}
