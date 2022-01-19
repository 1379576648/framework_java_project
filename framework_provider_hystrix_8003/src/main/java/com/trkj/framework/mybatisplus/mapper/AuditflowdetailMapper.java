package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.framework.entity.mybatisplus.*;
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

    @Update("update STAFF set STAFF_STATE=1 ${ew.customSqlSegment}")
    int updateStaffState(@Param(Constants.WRAPPER) QueryWrapper<Staff> queryWrapper1);

    @Update("update WORKER set WORKER_STATE=1 ${ew.customSqlSegment}")
    int updateWorker(@Param(Constants.WRAPPER) QueryWrapper<Worker> queryWrapper1);

    @Select("select UPDATED_DEPT_NAME from TRANSFER ${ew.customSqlSegment}")
    List<Transfer> selectTransfer(@Param(Constants.WRAPPER) QueryWrapper<Transfer> queryWrapper);

    @Select("select DEPT_ID from DEPT ${ew.customSqlSegment}")
    Integer selectDeptID(@Param(Constants.WRAPPER) QueryWrapper<Dept> queryWrapper);

    @Select("select * from STAFF ${ew.customSqlSegment}")
    List<Staff> selectStaffID(@Param(Constants.WRAPPER) QueryWrapper<Staff> queryWrapper);

    @Select("select a.POST_NAME from DEPT_POST a LEFT JOIN DEPT b on a.DEPT_ID = b.DEPT_ID ${ew.customSqlSegment}")
    List<DeptPost> selectPostName(@Param(Constants.WRAPPER) QueryWrapper<DeptPost> queryWrapper);

    @Select("select a.DEPT_POST_ID from DEPT_POST a LEFT JOIN DEPT b on a.DEPT_ID = b.DEPT_ID ${ew.customSqlSegment}")
    Integer selectPostID(@Param(Constants.WRAPPER) QueryWrapper<DeptPost> queryWrapper);
}
