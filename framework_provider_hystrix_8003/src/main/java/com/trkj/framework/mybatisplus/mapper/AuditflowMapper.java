package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.entity.mybatisplus.Auditflow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 审批主表 Mapper 接口
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-27
 */
@Mapper
public interface AuditflowMapper extends BaseMapper<Auditflow> {

    @Update("update Auditflow set AUDITFLOW_STATE=2 ${ew.customSqlSegment}")
    int rejectApprovalState(@Param(Constants.WRAPPER) QueryWrapper<Auditflow> queryWrapper2);

    @Update("update Auditflow set AUDITFLOW_STATE=1 ${ew.customSqlSegment}")
    int rejectApprovalState2(@Param(Constants.WRAPPER) QueryWrapper<Auditflow> queryWrapper2);

    @Select("select AUDITFLOW_ID from AUDITFLOW ${ew.customSqlSegment}" )
    int selectID(QueryWrapper<Object> staff_name);
}
