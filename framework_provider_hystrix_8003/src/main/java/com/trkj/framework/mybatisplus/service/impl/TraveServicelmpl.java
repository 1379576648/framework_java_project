package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.mybatisplus.mapper.AuditflowoneMapper;
import com.trkj.framework.mybatisplus.service.TraveService;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.LeaveDetailsVo;
import com.trkj.framework.vo.TravelDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraveServicelmpl implements TraveService {
    @Autowired
    private AuditflowoneMapper auditflowoneMapper;

    /**
     * 根据审批类型的出差/审批人查询待处理的审批
     *
     * @param
     * @return
     */
    @Override
    public IPage<Auditflowone> selectTravelAll(Auditflowone auditflowone) {
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
        queryWrapper.eq("a.AUDITFLOW_TYPE", "出差");
        return auditflowoneMapper.selectAuditflowoneAll(page, queryWrapper);
    }

    /**
     * 根据审批类型的出差/审批人查询已处理的审批
     *
     * @param
     * @return
     */
    @Override
    public IPage<Auditflowone> selectEndTravelAll(Auditflowone auditflowone) {
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
        queryWrapper.eq("a.AUDITFLOW_TYPE", "出差");
        queryWrapper.eq("b.STAFF_NAME", auditflowone.getStaffName2());
        return auditflowoneMapper.selectEnddAuditflow(page, queryWrapper);
    }

    /**
     * 根据审批类型的出差/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @Override
    public List<TravelDetailsVo> selectDetailsTrave(TravelDetailsVo travelDetailsVo) {
        QueryWrapper<TravelDetailsVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("b.STAFF_NAME", travelDetailsVo.getStaffName2());
        queryWrapper.eq("a.AUDITFLOW_ID", travelDetailsVo.getAuditflowId());
        queryWrapper.eq("t.STAFF_NAME", travelDetailsVo.getStaffName1());
        return auditflowoneMapper.selectDetailsTrave(queryWrapper);
    }
}
