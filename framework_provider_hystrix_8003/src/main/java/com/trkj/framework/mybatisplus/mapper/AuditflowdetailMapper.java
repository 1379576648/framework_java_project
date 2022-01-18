package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.Auditflowdetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuditflowdetailMapper extends BaseMapper<Auditflowdetail> {

    @Select("select AUDITFLOWDETAIL_ID from auditflowdetail ${ew.customSqlSegment} ORDER BY AUDITFLOWDETAIL_ID")
    List<Auditflowdetail> selectListAuditflow(@Param(Constants.WRAPPER) QueryWrapper<Auditflowdetail> queryWrapper);

    @Update("update AUDITFLOWDETAIL set AUDITFLOWDETAI_STATE=1 ${ew.customSqlSegment}")
    int updateApprovalState(@Param(Constants.WRAPPER) QueryWrapper<Auditflowdetail> queryWrapper1);

    @Update("update AUDITFLOWDETAIL set AUDITFLOWDETAI_STATE=3, AUDITFLOWDETAI_DATE=sysdate ${ew.customSqlSegment}")
    int rejectApprovalState(@Param(Constants.WRAPPER) QueryWrapper<Auditflowdetail> queryWrapper);

    @Update("update AUDITFLOWDETAIL set AUDITFLOWDETAI_STATE=3, AUDITFLOWDETAI_DATE=sysdate ${ew.customSqlSegment}")
    int rejectApprovalState2(@Param(Constants.WRAPPER) QueryWrapper<Auditflowdetail> queryWrapper);

}
