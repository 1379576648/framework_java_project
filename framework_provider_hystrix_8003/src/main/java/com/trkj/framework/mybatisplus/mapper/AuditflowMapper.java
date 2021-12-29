package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.entity.mybatisplus.Auditflow;
import com.trkj.framework.vo.Auditflowone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
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

    @Select("select a.CREATED_TIME,a.AUDITFLOW_ID,a.AUDITFLOW_TYPE,a.STAFF_NAME as STAFF_NAME1,a.AUDITFLOW_STATE,b.STAFF_NAME as STAFF_NAME2,b.UPDATED_TIME " +
            "from AUDITFLOW a LEFT OUTER join AUDITFLOWDETAIL b " +
            "on a.AUDITFLOW_ID=b.AUDITFLOW_ID " +
            "where b.STAFF_NAME='部门经理' and b.AUDITFLOWDETAI_STATE=1  and a.AUDITFLOW_TYPE = '加班' ")
    IPage<Auditflowone> one(Page<Auditflowone> page);

    @Select("select a.CREATED_TIME,a.AUDITFLOW_ID,a.AUDITFLOW_TYPE,a.STAFF_NAME as STAFF_NAME1,a.AUDITFLOW_STATE,b.STAFF_NAME as STAFF_NAME2,b.UPDATED_TIME " +
            "from AUDITFLOW a LEFT OUTER join AUDITFLOWDETAIL b " +
            "on a.AUDITFLOW_ID=b.AUDITFLOW_ID " +
            "where b.STAFF_NAME='部门经理' and b.AUDITFLOWDETAI_STATE<>1 and b.AUDITFLOWDETAI_STATE<>0 and a.AUDITFLOW_TYPE='加班' ")
    IPage<Auditflowone> two(Page<Auditflowone> page);

    @Select("select a.AUDITFLOW_TITLE,o.STAFF_NAME as STAFF_NAME1,b.AUDITFLOWDETAI_STATE,b.STAFF_NAME as STAFF_NAME2,b.AUDITFLOWDETAI_REMARKS,b.AUDITFLOWDETAI_DATE,o.OVERTIMEASK_TYPE,o.OVERTIMEASK_MATTER,o.OVERTIMEASK_REMARKS,o.OVERTIMEASK_S_DATE,o.OVERTIMEASK_E_DATE,o.OVERTIMEASK_TOTAL_DATE " +
            "from AUDITFLOW a LEFT JOIN AUDITFLOWDETAIL b on a.AUDITFLOW_ID=b.AUDITFLOW_ID\n" +
            "LEFT JOIN OVERTIMEASK o on a.AUDITFLOW_ID=b.AUDITFLOW_ID " +
            "where a.AUDITFLOW_ID=? " +
            "and o.STAFF_NAME=? " +
            "and b.STAFF_NAME=?")
    List<Auditflowone> selectDetailsAuditflow(HashMap<String, Object> map);
}
