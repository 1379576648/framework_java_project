package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Overtimeask;
import com.trkj.framework.vo.Auditflowone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OverTimeMapper extends BaseMapper<Overtimeask> {
    @Select("select * from OVERTIMEASK ${ew.customSqlSegment}")
    IPage<Overtimeask> selectOverTimeRecordAll(Page<Overtimeask> page, @Param(Constants.WRAPPER) QueryWrapper<Overtimeask> queryWrapper);
}
