package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.entity.mybatisplus.Auditflow;
import com.trkj.framework.vo.SalaryVo;
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

    @Update("update Auditflow set AUDITFLOW_STATE=1 ${ew.customSqlSegment}")
    int rejectApprovalState2(@Param(Constants.WRAPPER) QueryWrapper<Auditflow> queryWrapper2);

    @Select("select AUDITFLOW_ID from AUDITFLOW ${ew.customSqlSegment}" )
    int selectID(QueryWrapper<Object> staff_name);

    @Select("select  a.AUDITFLOW_ID, a.AUDITFLOW_TITLE,s.STAFF_NAME as STAFF_NAME1,b.AUDITFLOWDETAI_STATE,a.AUDITFLOW_STATE,b.STAFF_NAME as STAFF_NAME2,b.AUDITFLOWDETAI_REMARKS,b.AUDITFLOWDETAI_DATE,s.FRONT_SALARY,s.AFTER_SALARY,s.SALARY_REMARKS,s.TAKE_EFFECT_DATE\n" +
            "from AUDITFLOW a \n" +
            "LEFT JOIN AUDITFLOWDETAIL b \n" +
            "on a.AUDITFLOW_ID=b.AUDITFLOW_ID\n" +
            "LEFT JOIN SALARY s\n" +
            "on a.AUDITFLOW_ID=s.AUDITFLOW_ID")
    List<SalaryVo>selectSalaryDetails(@Param(Constants.WRAPPER) QueryWrapper<SalaryVo> queryWrapper);
}
