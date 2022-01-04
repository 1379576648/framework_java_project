package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-04
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    /****
     * 分页查询所有的角色记录
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("select * from ROLE ${ew.customSqlSegment}")
    IPage<Role> selectRoleAll(Page<Role> page, @Param(Constants.WRAPPER) QueryWrapper<Role> queryWrapper);
}
