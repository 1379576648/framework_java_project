package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.mybatisplus.mapper.AuditflowoneMapper;
import com.trkj.framework.mybatisplus.service.LeaveService;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.LeaveDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 请假表 服务实现类
 * </p>
 *
 * @author 里予
 * @since 2022-1-2
 */
@Service
public class LeaveServicelmpl implements LeaveService {
    @Autowired
    private AuditflowoneMapper auditflowoneMapper;


    /**
     * 根据审批类型的加班/审批人查询待处理的审批
     *
     * @param
     * @return
     */
    @Override
    public IPage<Auditflowone> selectLeaveAll(Auditflowone auditflowone) {
        Page<Auditflowone> page = new Page<>(auditflowone.getCurrentPage(), auditflowone.getPagesize());
        QueryWrapper<Auditflowone> queryWrapper = new QueryWrapper<>();
        if (auditflowone.getStaffName1() != null) {
            //根据申请人名称模糊查询
            queryWrapper.like("a.STAFF_NAME", auditflowone.getStaffName1());
        }
        if (auditflowone.getStartTime() != null || auditflowone.getEndTime() != null) {
            //根据开始日期结束日期范围查询
            queryWrapper.between("a.CREATED_TIME", auditflowone.getStartTime(), auditflowone.getEndTime());
        }
        queryWrapper.eq("b.STAFF_NAME", auditflowone.getStaffName2());
        queryWrapper.eq("b.AUDITFLOWDETAI_STATE", 1);
        queryWrapper.eq("a.AUDITFLOW_TYPE", "请假");
        return auditflowoneMapper.selectAuditflowoneAll(page, queryWrapper);
    }

    /**
     * 根据审批类型的加班/审批人查询已处理的审批
     *
     * @param
     * @return
     */
    @Override
    public IPage<Auditflowone> selectEndLeaveAll(Auditflowone auditflowone) {
        Page<Auditflowone> page = new Page<>(auditflowone.getCurrentPage(), auditflowone.getPagesize());
        QueryWrapper<Auditflowone> queryWrapper = new QueryWrapper<>();
        if (auditflowone.getStaffName1() != null) {
            //用户名称模糊查询
            queryWrapper.like("a.STAFF_NAME", auditflowone.getStaffName1());
        }
        if (auditflowone.getStartTime() != null || auditflowone.getEndTime() != null) {
            //根据开始日期结束日期范围查询
            queryWrapper.between("a.CREATED_TIME", auditflowone.getStartTime(), auditflowone.getEndTime());
        }
        // eq 等于 ne 不等于
        queryWrapper.ne("b.AUDITFLOWDETAI_STATE", 1);
        queryWrapper.ne("b.AUDITFLOWDETAI_STATE", 0);
        queryWrapper.eq("a.AUDITFLOW_TYPE", "请假");
        queryWrapper.eq("b.STAFF_NAME", auditflowone.getStaffName2());
        return auditflowoneMapper.selectEnddAuditflow(page, queryWrapper);
    }

    /**
     * 根据审批类型的加班/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @Override
    public List<LeaveDetailsVo> selectDetailsLeaves(LeaveDetailsVo leaveDetailsVo) {
        QueryWrapper<LeaveDetailsVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("b.STAFF_NAME", leaveDetailsVo.getStaffName2());
        queryWrapper.eq("a.AUDITFLOW_ID", leaveDetailsVo.getAuditflowId());
        queryWrapper.eq("l.STAFF_NAME", leaveDetailsVo.getStaffName1());
        return auditflowoneMapper.selectDetailsLeaves(queryWrapper);
    }
}
