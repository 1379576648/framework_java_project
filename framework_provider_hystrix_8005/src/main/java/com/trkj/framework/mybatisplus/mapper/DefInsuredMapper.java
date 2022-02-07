package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.DefInsured;
import com.trkj.framework.entity.mybatisplus.RoleStaff;
import com.trkj.framework.entity.mybatisplus.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 默认参保方案表 Mapper 接口
 * </p>
 *
 * @author 劉祁
 * @since 2022-01-19
 */
@Mapper
public interface DefInsuredMapper extends BaseMapper<DefInsured> {

    /***
     * 查询员工信息
     * @param staffPage
     * @param queryWrapper
     * @return
     */
    public IPage<Staff> pageStaff(Page<Staff> staffPage,@Param(Constants.WRAPPER) QueryWrapper<Staff> queryWrapper);
}
