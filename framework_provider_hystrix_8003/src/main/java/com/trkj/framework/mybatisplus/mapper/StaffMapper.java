package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface StaffMapper extends BaseMapper<Staff> {

    @Select("select count(STAFF_NAME) from STAFF ${ew.customSqlSegment}")
    long selectStaffState(@Param(Constants.WRAPPER) QueryWrapper<Staff> queryWrapper);
}
