package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.mybatisplus.mapper.AuditflowoneMapper;
import com.trkj.framework.mybatisplus.mapper.DeptMapper;
import com.trkj.framework.mybatisplus.mapper.StaffMapper;
import com.trkj.framework.mybatisplus.service.WorkerService;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.DeptPostVo;
import com.trkj.framework.vo.WorkerDetaIsVo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WorkerServicelmpl implements WorkerService {
    @Autowired
    private AuditflowoneMapper auditflowoneMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public IPage<Auditflowone> selectWorkerlAll(Auditflowone auditflowone) {
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
        queryWrapper.eq("a.AUDITFLOW_TYPE", "转正");
        return auditflowoneMapper.selectAuditflowoneAll(page, queryWrapper);
    }

    @Override
    public IPage<Auditflowone> selectEndWorkerlAll(Auditflowone auditflowone) {
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
        queryWrapper.eq("a.AUDITFLOW_TYPE", "转正");
        queryWrapper.eq("b.STAFF_NAME", "部门经理");
        return auditflowoneMapper.selectEnddAuditflow(page, queryWrapper);
    }

    @Override
    public List<WorkerDetaIsVo> selectDetailsWorker(WorkerDetaIsVo workerDetaIsVo) {
        QueryWrapper<WorkerDetaIsVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("b.STAFF_NAME", workerDetaIsVo.getStaffName2());
        queryWrapper.eq("a.AUDITFLOW_ID", workerDetaIsVo.getAuditflowId());
        queryWrapper.eq("w.STAFF_NAME", workerDetaIsVo.getStaffName1());
        return auditflowoneMapper.selectDetailsWorker(queryWrapper);
    }

    /**
     * 根据员工名称去查询其员工状态为2实习的员工 条件为逻辑删除为0/员工状态为2实习的
     *
     * @param staff
     * @return
     */
    @Override
    public Long selectStaffState(Staff staff) {
        QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("IS_DELETED", 0);
        queryWrapper.eq("STAFF_STATE", 2);
        queryWrapper.eq("STAFF_NAME", staff.getStaffName());
        return staffMapper.selectStaffState(queryWrapper);
    }

    @Override
    public List<DeptPostVo> selectDeptPostName(DeptPostVo deptPostVo) {
        QueryWrapper<DeptPostVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("a.DEPT_ID", deptPostVo.getDeptId());
        queryWrapper.like("d.POST_NAME", "经理");
        queryWrapper.eq("s.IS_DELETED", 0);
        queryWrapper.eq("d.IS_DELETED", 0);
        return auditflowoneMapper.selectDeptPostName(queryWrapper);
    }

    @Override
    public List<Dept> selectDeptName(Dept dept) {
        final var dept1 = deptMapper.selectById(dept);
        return Collections.singletonList(dept1);
    }

    @Override
    public List<DeptPostVo> selectpresident() {
        QueryWrapper<DeptPostVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("d.POST_NAME", "总裁").or().like("d.POST_NAME", "人事部经理");
        return deptMapper.selectpresident(queryWrapper);
    }
}
