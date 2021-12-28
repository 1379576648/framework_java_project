package com.trkj.framework.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatis.Auditflow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.framework.vo.Auditflowone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
