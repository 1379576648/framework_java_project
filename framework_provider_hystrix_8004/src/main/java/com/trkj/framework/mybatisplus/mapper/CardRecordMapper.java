package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CardRecordMapper extends BaseMapper<ClockRecord> {
    @Select("select * from CLOCK_RECORD ${ew.customSqlSegment}")
    IPage<ClockRecord> selectCardRecordAll(Page<ClockRecord> page, @Param(Constants.WRAPPER) QueryWrapper<ClockRecord> queryWrapper);
}
