package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.mybatisplus.mapper.*;
import com.trkj.framework.mybatisplus.service.WorkerService;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.DeptPostVo;
import com.trkj.framework.vo.WorkerDetaIsVo;
import com.trkj.framework.vo.WorkerVo;
import lombok.val;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private AuditflowMapper auditflowMapper;
    @Autowired
    private AuditflowdetailMapper auditflowdetailMapper;
    @Autowired
    private WorkerMapper workerMapper;

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
        queryWrapper.eq("b.STAFF_NAME", auditflowone.getStaffName2());
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
        queryWrapper.eq("b.STAFF_NAME", auditflowone.getStaffName2());
        return auditflowoneMapper.selectEnddAuditflow(page, queryWrapper);
    }

    @Override
    public List<WorkerDetaIsVo> selectDetailsWorker(WorkerDetaIsVo workerDetaIsVo) {
        QueryWrapper<WorkerDetaIsVo> queryWrapper = new QueryWrapper<>();
        if (workerDetaIsVo.getStaffName2()!=null){
            queryWrapper.eq("b.STAFF_NAME", workerDetaIsVo.getStaffName2());
        }
        queryWrapper.eq("a.AUDITFLOW_ID", workerDetaIsVo.getAuditflowId());
        queryWrapper.eq("w.STAFF_NAME", workerDetaIsVo.getStaffName1());
        return auditflowoneMapper.selectDetailsWorker(queryWrapper);
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

    /**
     * 添加转正 添加三个审批人
     *
     * @param workerVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int SubmitPositive3(WorkerVo workerVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(workerVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(workerVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(workerVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", workerVo.getStaffName())
                    .eq("AUDITFLOW_TITLE", workerVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(workerVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2 = new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(workerVo.getStaffName2());
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3 = new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(workerVo.getStaffName3());
            final var i3 = auditflowdetailMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加转正表
            if (i1 == 1 && i2 == 1 && i3 == 1) {
                Worker worker = new Worker();
                // 转正表-审批编号
                worker.setAuditflowId(auditflow1.getAuditFlowId());
                // 转正表-员工名称
                worker.setStaffName(workerVo.getStaffName());
                // 转正表-部门名称
                worker.setDeptname(workerVo.getDeptname());
                // 转正表-转正备注
                worker.setWorkerRemarks(workerVo.getAuditflowdetaiRemarks());
                // 转正表-转正类型
                worker.setWorkerType(workerVo.getAuditflowType());
                // 转正表-转正日期
                worker.setWorkerDate(workerVo.getWorkerdate());
                final val i4 = workerMapper.insert(worker);
                if (i4 == 1) {
                    return 1111;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    /**
     * 添加转正 添加两个审批人
     *
     * @param workerVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int SubmitPositive2(WorkerVo workerVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(workerVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(workerVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(workerVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", workerVo.getStaffName())
                    .eq("AUDITFLOW_TITLE", workerVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2 = new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(workerVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail2.setAuditflowdetaiState(1);
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3 = new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(workerVo.getStaffName2());
            final var i3 = auditflowdetailMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加转正表
            if (i2 == 1 && i3 == 1) {
                Worker worker = new Worker();
                // 转正表-审批编号
                worker.setAuditflowId(auditflow1.getAuditFlowId());
                // 转正表-员工名称
                worker.setStaffName(workerVo.getStaffName());
                // 转正表-部门名称
                worker.setDeptname(workerVo.getDeptname());
                // 转正表-转正备注
                worker.setWorkerRemarks(workerVo.getAuditflowdetaiRemarks());
                // 转正表-转正类型
                worker.setWorkerType(workerVo.getAuditflowType());
                // 转正表-转正日期
                worker.setWorkerDate(workerVo.getWorkerdate());
                final val i4 = workerMapper.insert(worker);
                if (i4 == 1) {
                    return 1111;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    /**
     * 添加转正 添加一个审批人
     *
     * @param workerVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer SubmitPositive1(WorkerVo workerVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(workerVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(workerVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(workerVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", workerVo.getStaffName())
                    .eq("AUDITFLOW_TITLE", workerVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail2 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail2.setStaffName(workerVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail2.setAuditflowdetaiState(1);
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);
            Worker worker = new Worker();
            // 转正表-审批编号
            worker.setAuditflowId(auditflow1.getAuditFlowId());
            // 转正表-员工名称
            worker.setStaffName(workerVo.getStaffName());
            // 转正表-部门名称
            worker.setDeptname(workerVo.getDeptname());
            // 转正表-转正备注
            worker.setWorkerRemarks(workerVo.getAuditflowdetaiRemarks());
            // 转正表-转正类型
            worker.setWorkerType(workerVo.getAuditflowType());
            // 转正表-转正日期
            worker.setWorkerDate(workerVo.getWorkerdate());
            final val i4 = workerMapper.insert(worker);
            if (i2 == 1 && i4 == 1) {
                return 1111;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    @Override
    public List<WorkerVo> selectexaminerecord(WorkerVo workerVo) {
        QueryWrapper<WorkerVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("c.STAFF_NAME", workerVo.getStaffName());
        queryWrapper.eq("a.IS_DELETED", 0);
        queryWrapper.eq("b.IS_DELETED", 0);
        queryWrapper.eq("c.IS_DELETED", 0);
        final var i = workerMapper.selectexaminerecord(queryWrapper);
        return i;
    }

    @Override
    public IPage<Auditflowone> selectMyWorker(Auditflowone auditflowone) {
        Page<Auditflowone> page = new Page<>(auditflowone.getCurrentPage(), auditflowone.getPagesize());
        QueryWrapper<Auditflowone> queryWrapper = new QueryWrapper<>();
        if (auditflowone.getStartTime() != null || auditflowone.getEndTime() != null) {
            //根据开始日期结束日期范围查询
            queryWrapper.between("a.CREATED_TIME", auditflowone.getStartTime(), auditflowone.getEndTime());
        }
        queryWrapper.eq("a.STAFF_NAME", auditflowone.getStaffName1());
        queryWrapper.eq("b.AUDITFLOWDETAI_STATE", 1);
        queryWrapper.eq("a.AUDITFLOW_TYPE", auditflowone.getAuditflowType());
        return auditflowoneMapper.selectMyWorker(page, queryWrapper);
    }

    @Override
    public IPage<Auditflowone> selectMyEndWorker(Auditflowone auditflowone) {
        Page<Auditflowone> page = new Page<>(auditflowone.getCurrentPage(), auditflowone.getPagesize());
        QueryWrapper<Auditflowone> queryWrapper = new QueryWrapper<>();
        if (auditflowone.getStartTime() != null || auditflowone.getEndTime() != null) {
            //根据开始日期结束日期范围查询
            queryWrapper.between("a.CREATED_TIME", auditflowone.getStartTime(), auditflowone.getEndTime());
        }
        queryWrapper.eq("a.STAFF_NAME", auditflowone.getStaffName1());
        queryWrapper.eq("b.STAFF_NAME", auditflowone.getStaffName2());
        queryWrapper.ne("b.AUDITFLOWDETAI_STATE", 0);
        queryWrapper.ne("b.AUDITFLOWDETAI_STATE", 1);
        queryWrapper.eq("a.AUDITFLOW_TYPE", auditflowone.getAuditflowType());
        return auditflowoneMapper.selectMyEndWorker(page, queryWrapper);
    }
}
