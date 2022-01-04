package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.entity.mybatisplus.Auditflow;
import com.trkj.framework.entity.mybatisplus.Auditflowdetail;
import com.trkj.framework.vo.AuditflowDetailsVo;
import com.trkj.framework.vo.Auditflowone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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
}
