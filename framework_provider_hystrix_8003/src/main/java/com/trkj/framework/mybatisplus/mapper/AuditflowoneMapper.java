package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.vo.AuditflowDetailsVo;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.LeaveDetailsVo;
import com.trkj.framework.vo.TravelDetailsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuditflowoneMapper extends BaseMapper<Auditflowone> {
    @Select("select a.CREATED_TIME,a.AUDITFLOW_ID,b.AUDITFLOWDETAIL_ID,a.AUDITFLOW_TYPE,a.STAFF_NAME as STAFF_NAME1,b.AUDITFLOWDETAI_STATE,b.STAFF_NAME as STAFF_NAME2,b.UPDATED_TIME from AUDITFLOW a LEFT OUTER join AUDITFLOWDETAIL b on a.AUDITFLOW_ID=b.AUDITFLOW_ID ${ew.customSqlSegment}")
    IPage<Auditflowone> selectAuditflowoneAll(Page<Auditflowone> page, @Param(Constants.WRAPPER) QueryWrapper<Auditflowone> queryWrapper);

    @Select("select a.CREATED_TIME,a.AUDITFLOW_ID,a.AUDITFLOW_TYPE,a.STAFF_NAME as STAFF_NAME1,a.AUDITFLOW_STATE,b.STAFF_NAME as STAFF_NAME2,b.UPDATED_TIME from AUDITFLOW a LEFT OUTER join AUDITFLOWDETAIL b on a.AUDITFLOW_ID=b.AUDITFLOW_ID ${ew.customSqlSegment}")
    IPage<Auditflowone> selectEnddAuditflow(Page<Auditflowone> page,@Param(Constants.WRAPPER) QueryWrapper<Auditflowone> queryWrapper);

    @Select("select a.AUDITFLOW_ID,a.AUDITFLOW_TITLE,o.STAFF_NAME as STAFF_NAME1,b.AUDITFLOWDETAI_STATE,a.AUDITFLOW_STATE,b.STAFF_NAME as STAFF_NAME2,b.AUDITFLOWDETAI_REMARKS,b.AUDITFLOWDETAI_DATE,o.OVERTIMEASK_TYPE,o.OVERTIMEASK_MATTER,o.OVERTIMEASK_REMARKS,o.OVERTIMEASK_S_DATE,o.OVERTIMEASK_E_DATE,o.OVERTIMEASK_TOTAL_DATE from AUDITFLOW a LEFT JOIN AUDITFLOWDETAIL b on a.AUDITFLOW_ID=b.AUDITFLOW_ID LEFT JOIN OVERTIMEASK o on a.AUDITFLOW_ID=b.AUDITFLOW_ID ${ew.customSqlSegment}")
    List<AuditflowDetailsVo> selectDetailsAuditflow(@Param(Constants.WRAPPER) QueryWrapper<AuditflowDetailsVo> queryWrapper);

    @Select("select  a.AUDITFLOW_ID, a.AUDITFLOW_TITLE,l.STAFF_NAME as STAFF_NAME1,b.AUDITFLOWDETAI_STATE,a.AUDITFLOW_STATE,b.STAFF_NAME as STAFF_NAME2,b.AUDITFLOWDETAI_REMARKS,b.AUDITFLOWDETAI_DATE,l.LEAVE_TYPE,l.LEAVE_MATTER,l.LEAVE_REMARKS,l.LEAVE_S_DATE,l.LEAVE_E_DATE,l.LEAVE_TOTAL_DATE from AUDITFLOW a LEFT JOIN AUDITFLOWDETAIL b on a.AUDITFLOW_ID=b.AUDITFLOW_ID LEFT JOIN LEAVE l on a.AUDITFLOW_ID=b.AUDITFLOW_ID ${ew.customSqlSegment}")
    List<LeaveDetailsVo> selectDetailsLeaves(@Param(Constants.WRAPPER) QueryWrapper<LeaveDetailsVo> queryWrapper);

    @Select("select  a.AUDITFLOW_ID, a.AUDITFLOW_TITLE,t.STAFF_NAME as STAFF_NAME1,b.AUDITFLOWDETAI_STATE,a.AUDITFLOW_STATE,b.STAFF_NAME as STAFF_NAME2,b.AUDITFLOWDETAI_REMARKS,b.AUDITFLOWDETAI_DATE,t.TRAVEL_PLACE,t.TRAVEL_MATTER,t.TRAVEL_S_DATE,t.TRAVEL_E_DATE,t.TRAVEL_TOTAL_DATE from AUDITFLOW a LEFT JOIN AUDITFLOWDETAIL b on a.AUDITFLOW_ID=b.AUDITFLOW_ID LEFT JOIN TRAVEL t on a.AUDITFLOW_ID=b.AUDITFLOW_ID ${ew.customSqlSegment}")
    List<TravelDetailsVo> selectDetailsTrave(@Param(Constants.WRAPPER) QueryWrapper<TravelDetailsVo> queryWrapper);
}
