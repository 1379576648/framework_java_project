package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.mybatisplus.mapper.*;
import com.trkj.framework.mybatisplus.service.Transfer8003Service;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.Transfer8003Vo;
import com.trkj.framework.vo.TransferDetailsVo;
import com.trkj.framework.vo.TransferVo;
import lombok.val;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransferServicelmpl implements Transfer8003Service {
    @Autowired
    private AuditflowoneMapper auditflowoneMapper;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private TransferMapper transferMapper;
    @Autowired
    private AuditflowMapper auditflowMapper;
    @Autowired
    private AuditflowdetailMapper auditflowdetailMapper;
    @Autowired
    private DeptPostMapper deptPostMapper;
    @Autowired
    private StaffMapper staffMapper;

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
        queryWrapper.eq("b.STAFF_NAME", auditflowone.getStaffName2());
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
        queryWrapper.eq("b.STAFF_NAME", auditflowone.getStaffName2());
        return auditflowoneMapper.selectEnddAuditflow(page, queryWrapper);
    }

    @Override
    public List<TransferDetailsVo> selectDetailsTransfer(TransferDetailsVo transferDetailsVo) {
        QueryWrapper<TransferDetailsVo> queryWrapper = new QueryWrapper<>();
        if (transferDetailsVo.getStaffName2()!=null){
            queryWrapper.eq("b.STAFF_NAME", transferDetailsVo.getStaffName2());
        }
        queryWrapper.eq("a.AUDITFLOW_ID", transferDetailsVo.getAuditflowId());
        queryWrapper.eq("t.STAFF_NAME", transferDetailsVo.getStaffName1());
        return auditflowoneMapper.selectDetailsTransfer(queryWrapper);
    }

    /**
     * 查询所有被启用的部门数据
     *
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

    @Override
    public List<Transfer8003Vo> selectTransferRecord(Transfer8003Vo transferVo) {
        QueryWrapper<Transfer8003Vo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("c.STAFF_NAME", transferVo.getStaffName());
        queryWrapper.eq("a.IS_DELETED", 0);
        queryWrapper.eq("b.IS_DELETED", 0);
        queryWrapper.eq("c.IS_DELETED", 0);
        final var i = transferMapper.selectTransferRecord(queryWrapper);
        return i;
    }

    /**
     * 添加调动 添加三个审批人
     *
     * @param transferVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int SubmitTransfer3(Transfer8003Vo transferVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(transferVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(transferVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(transferVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", transferVo.getStaffName())
                    .eq("AUDITFLOW_TITLE", transferVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(transferVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2 = new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(transferVo.getStaffName2());
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3 = new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(transferVo.getStaffName3());
            final var i3 = auditflowdetailMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加转正表
            if (i1 == 1 && i2 == 1 && i3 == 1) {
                Transfer transfer = new Transfer();
                // 调动表-审批编号
                transfer.setAuditflowId(auditflow1.getAuditFlowId());
                // 调动表-员工名称
                transfer.setStaffName(transferVo.getStaffName());
                // 调动表-调动类型
                transfer.setTransferType(transferVo.getAuditflowType());
                // 调动表-原部门名称
                transfer.setCreatedDeptName(transferVo.getCreateddeptname());
                // 调动表-变动后部门名称
                transfer.setUpdatedDeptName(transferVo.getUpdatedeptname());
                // 调动表-调动日期
                transfer.setTakeEffectDate(transferVo.getTakeeffectdate());
                // 调动表-调动备注
                transfer.setTransferRemark(transferVo.getTransferremark());
                final val i4 = transferMapper.insert(transfer);
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
     * 添加调动 添加两个审批人
     *
     * @param transferVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int SubmitTransfer2(Transfer8003Vo transferVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(transferVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(transferVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(transferVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", transferVo.getStaffName())
                    .eq("AUDITFLOW_TITLE", transferVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(transferVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2 = new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(transferVo.getStaffName2());
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);
            // 如果三个审批明细表添加成功，则添加转正表
            if (i1 == 1 && i2 == 1) {
                Transfer transfer = new Transfer();
                // 调动表-审批编号
                transfer.setAuditflowId(auditflow1.getAuditFlowId());
                // 调动表-员工名称
                transfer.setStaffName(transferVo.getStaffName());
                // 调动表-调动类型
                transfer.setTransferType(transferVo.getAuditflowType());
                // 调动表-原部门名称
                transfer.setCreatedDeptName(transferVo.getCreateddeptname());
                // 调动表-变动后部门名称
                transfer.setUpdatedDeptName(transferVo.getUpdatedeptname());
                // 调动表-调动日期
                transfer.setTakeEffectDate(transferVo.getTakeeffectdate());
                // 调动表-调动备注
                transfer.setTransferRemark(transferVo.getTransferremark());
                final val i4 = transferMapper.insert(transfer);
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
     * 添加调动 添加一个审批人
     *
     * @param transferVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer SubmitTransfer1(Transfer8003Vo transferVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(transferVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(transferVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(transferVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", transferVo.getStaffName())
                    .eq("AUDITFLOW_TITLE", transferVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(transferVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);
            // 如果三个审批明细表添加成功，则添加转正表
            Transfer transfer = new Transfer();
            // 调动表-审批编号
            transfer.setAuditflowId(auditflow1.getAuditFlowId());
            // 调动表-员工名称
            transfer.setStaffName(transferVo.getStaffName());
            // 调动表-调动类型
            transfer.setTransferType(transferVo.getAuditflowType());
            // 调动表-原部门名称
            transfer.setCreatedDeptName(transferVo.getCreateddeptname());
            // 调动表-变动后部门名称
            transfer.setUpdatedDeptName(transferVo.getUpdatedeptname());
            // 调动表-调动日期
            transfer.setTakeEffectDate(transferVo.getTakeeffectdate());
            // 调动表-调动备注
            transfer.setTransferRemark(transferVo.getTransferremark());
            final val i4 = transferMapper.insert(transfer);
            if (i1 == 1 && i4 == 1) {
                return 1111;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Staff>selectDeptPost(Staff staff){
        // 先根据部门名称去查询部门编号
        QueryWrapper<Dept> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("DEPT_NAME",staff.getDeptName());
        final var depts = deptMapper.selectList(queryWrapper);
        // 取部门编号
        final var deptId = depts.get(0).getDeptId();
        // 再根据部门编号去查询部门职位
        QueryWrapper<DeptPost>queryWrapper1=new QueryWrapper<>();
        queryWrapper1.eq("DEPT_ID",deptId);
        queryWrapper1.like("POST_NAME","经理");
        final var deptPosts = deptPostMapper.selectList(queryWrapper1);
        // 再根据查询到的部门职位数据（部门职位编号）去员工表查询是否有员工是该职位
        QueryWrapper<Staff> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("DEPT_POST_ID",deptPosts.get(0).getDeptPostId());
        final var staff1 = staffMapper.selectList(queryWrapper2);
        return staff1;
    }

}
