package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.mybatisplus.mapper.AuditflowoneMapper;
import com.trkj.framework.mybatisplus.service.CardService;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.CardDetailsVo;
import com.trkj.framework.vo.LeaveDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServicelmpl implements CardService {
    @Autowired
    private AuditflowoneMapper auditflowoneMapper;

    @Override
    public IPage<Auditflowone> selectCardAll(Auditflowone auditflowone) {
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
        queryWrapper.eq("b.STAFF_NAME", "部门经理");
        queryWrapper.eq("b.AUDITFLOWDETAI_STATE", 1);
        queryWrapper.eq("a.AUDITFLOW_TYPE", "补打卡");
        return auditflowoneMapper.selectAuditflowoneAll(page, queryWrapper);
    }

    @Override
    public IPage<Auditflowone> selectEndCardAll(Auditflowone auditflowone) {
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
        queryWrapper.eq("a.AUDITFLOW_TYPE", "补打卡");
        queryWrapper.eq("b.STAFF_NAME", "部门经理");
        return auditflowoneMapper.selectEnddAuditflow(page, queryWrapper);
    }

    @Override
    public List<CardDetailsVo> selectDetailsCards(CardDetailsVo cardDetailsVo) {
        QueryWrapper<CardDetailsVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("b.STAFF_NAME", cardDetailsVo.getStaffName2());
        queryWrapper.eq("a.AUDITFLOW_ID", cardDetailsVo.getAuditflowId());
        queryWrapper.eq("c.STAFF_NAME", cardDetailsVo.getStaffName1());
        return auditflowoneMapper.selectDetailsCards(queryWrapper);
    }
}