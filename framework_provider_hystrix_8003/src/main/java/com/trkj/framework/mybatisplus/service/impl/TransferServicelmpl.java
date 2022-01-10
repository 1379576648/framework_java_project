package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.mybatisplus.mapper.AuditflowoneMapper;
import com.trkj.framework.mybatisplus.mapper.DeptMapper;
import com.trkj.framework.mybatisplus.service.TransferService;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.TransferDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransferServicelmpl implements TransferService {
    @Autowired
    private AuditflowoneMapper auditflowoneMapper;
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public IPage<Auditflowone> selectTransferAll(Auditflowone auditflowone) {
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
        queryWrapper.eq("a.AUDITFLOW_TYPE", "调动");
        return auditflowoneMapper.selectAuditflowoneAll(page, queryWrapper);
    }

    @Override
    public IPage<Auditflowone> selectEndTransferAll(Auditflowone auditflowone) {
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
        queryWrapper.eq("a.AUDITFLOW_TYPE", "调动");
        queryWrapper.eq("b.STAFF_NAME", "部门经理");
        return auditflowoneMapper.selectEnddAuditflow(page, queryWrapper);
    }

    @Override
    public List<TransferDetailsVo> selectDetailsTransfer(TransferDetailsVo transferDetailsVo) {
        QueryWrapper<TransferDetailsVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("b.STAFF_NAME", transferDetailsVo.getStaffName2());
        queryWrapper.eq("a.AUDITFLOW_ID", transferDetailsVo.getAuditflowId());
        queryWrapper.eq("t.STAFF_NAME", transferDetailsVo.getStaffName1());
        return auditflowoneMapper.selectDetailsTransfer(queryWrapper);
    }

    /**
     * 查询所有被启用的部门数据
     * @return
     */
    @Override
    public List<Dept> selectDeptAll() {
        //条件构造器
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        //逻辑删除 未删除
        queryWrapper.eq("IS_DELETED", 0);
        //是否禁用 启用
        queryWrapper.eq("DEPT_STATE", 0);
        return deptMapper.selectList(queryWrapper);
    }
}
