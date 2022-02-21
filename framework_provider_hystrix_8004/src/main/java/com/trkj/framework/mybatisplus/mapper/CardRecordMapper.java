package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Worker;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author 112729
 */
@Mapper
public interface CardRecordMapper extends BaseMapper<ClockRecord> {

    @Select("select CHECK_STATE as checkState,count(1) as stateNumber from CLOCK_RECORD  ${ew.customSqlSegment} GROUP BY CHECK_STATE")
    List<ClockRecord> selectCountState(@Param(Constants.WRAPPER) QueryWrapper<ClockRecord> queryWrapper);
}
