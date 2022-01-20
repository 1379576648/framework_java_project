package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.Card;
import com.trkj.framework.entity.mybatisplus.Leave;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LeaveMapper extends BaseMapper<Leave> {

    @Select("select distinct  a.AUDITFLOW_STATE from AUDITFLOW a LEFT JOIN AUDITFLOWDETAIL b on a.AUDITFLOW_ID = b.AUDITFLOW_ID LEFT JOIN LEAVE c on a.AUDITFLOW_ID = c.AUDITFLOW_ID ${ew.customSqlSegment}")
    Integer selectLeaveExamine(@Param(Constants.WRAPPER) QueryWrapper<Leave> queryWrapper);
}
