package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.Travel;
import com.trkj.framework.entity.mybatisplus.Worker;
import com.trkj.framework.vo.WorkerVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TravelMapper extends BaseMapper<Travel> {

    @Select("select distinct  a.AUDITFLOW_STATE from AUDITFLOW a LEFT JOIN AUDITFLOWDETAIL b on a.AUDITFLOW_ID = b.AUDITFLOW_ID LEFT JOIN TRAVEL c on a.AUDITFLOW_ID = c.AUDITFLOW_ID ${ew.customSqlSegment}")
    Integer selectEvectionExamine(@Param(Constants.WRAPPER) QueryWrapper<Travel> queryWrapper);
}
