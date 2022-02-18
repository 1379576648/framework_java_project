package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Auditflow;
import com.trkj.framework.entity.mybatisplus.Auditflowdetail;
import com.trkj.framework.entity.mybatisplus.Card;
import com.trkj.framework.entity.mybatisplus.Leave;
import com.trkj.framework.mybatisplus.mapper.AuditflowMapper;
import com.trkj.framework.mybatisplus.mapper.AuditflowdetailMapper;
import com.trkj.framework.mybatisplus.mapper.AuditflowoneMapper;
import com.trkj.framework.mybatisplus.mapper.LeaveMapper;
import com.trkj.framework.mybatisplus.service.LeaveService;
import com.trkj.framework.vo.*;
import lombok.val;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private LeaveMapper leaveMapper;
    @Autowired
    private AuditflowMapper auditflowMapper;
    @Autowired
    private AuditflowdetailMapper auditflowdetailMapper;

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
        if (leaveDetailsVo.getStaffName2()!=null){
            queryWrapper.eq("b.STAFF_NAME", leaveDetailsVo.getStaffName2());
        }
        queryWrapper.eq("a.AUDITFLOW_ID", leaveDetailsVo.getAuditflowId());
        queryWrapper.eq("l.STAFF_NAME", leaveDetailsVo.getStaffName1());
        return auditflowoneMapper.selectDetailsLeaves(queryWrapper);
    }

    /**
     * 根据名称及请假类型去查询是否有记录
     *
     * @param leaveDetailsVo
     * @return
     */
    @Override
    public List<LeaveDetailsVo> selectLeaveExamine(LeaveDetailsVo leaveDetailsVo) {
        QueryWrapper<LeaveDetailsVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("c.STAFF_NAME", leaveDetailsVo.getStaffName1());
        queryWrapper.eq("c.LEAVE_TYPE", leaveDetailsVo.getLeaveType());
        queryWrapper.eq("a.IS_DELETED", 0);
        queryWrapper.eq("b.IS_DELETED", 0);
        queryWrapper.eq("c.IS_DELETED", 0);
        final var i = leaveMapper.selectLeaveExamine(queryWrapper);
        return i;
    }

    /**
     * 添加请假 添加三个审批人
     *
     * @param leaveVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int submitToAskForLeave3(LeaveVo leaveVo) throws ArithmeticException{
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(leaveVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(leaveVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(leaveVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", leaveVo.getStaffName())
                    .eq("AUDITFLOW_TITLE", leaveVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(leaveVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2 = new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(leaveVo.getStaffName2());
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3 = new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(leaveVo.getStaffName3());
            final var i3 = auditflowdetailMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加请假表
            if (i1 == 1 && i2 == 1 && i3 == 1) {
                Leave leave = new Leave();
                // 请假表-审批编号
                leave.setAuditflowId(auditflow1.getAuditFlowId());
                // 请假表-员工名称
                leave.setStaffName(leaveVo.getStaffName());
                // 请假表-部门名称
                leave.setDeptname(leaveVo.getDeptname());
                // 请假表-请假类型
                leave.setLeaveType(leaveVo.getLeaveType());
                // 请假表-请假事由
                leave.setLeaveMatter(leaveVo.getLeaveMatter());
                // 请假表-请假开始时间
                leave.setLeaveSDate(leaveVo.getLeaveSDate());
                // 请假表-请假结束时间
                leave.setLeaveEDate(leaveVo.getLeaveEDate());
                // 请假表-请假时长
                leave.setLeaveTotalDate(leaveVo.getLeaveTotalDate());
                final val i4 = leaveMapper.insert(leave);
                if (i4 == 1) {
                    return 1111;
                } else {
                    throw new ArithmeticException("0");
                }
            } else {
                throw new ArithmeticException("0");
            }
        } else {
            throw new ArithmeticException("0");
        }
    }

    /**
     * 添加请假 添加两个审批人
     *
     * @param leaveVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int submitToAskForLeave2(LeaveVo leaveVo) throws ArithmeticException{
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(leaveVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(leaveVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(leaveVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", leaveVo.getStaffName())
                    .eq("AUDITFLOW_TITLE", leaveVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(leaveVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2 = new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(leaveVo.getStaffName2());
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);

            // 如果三个审批明细表添加成功，则添加请假表
            if (i1 == 1 && i2 == 1) {
                Leave leave = new Leave();
                // 请假表-审批编号
                leave.setAuditflowId(auditflow1.getAuditFlowId());
                // 请假表-员工名称
                leave.setStaffName(leaveVo.getStaffName());
                // 请假表-部门名称
                leave.setDeptname(leaveVo.getDeptname());
                // 请假表-请假类型
                leave.setLeaveType(leaveVo.getLeaveType());
                // 请假表-请假事由
                leave.setLeaveMatter(leaveVo.getLeaveMatter());
                // 请假表-请假开始时间
                leave.setLeaveSDate(leaveVo.getLeaveSDate());
                // 请假表-请假结束时间
                leave.setLeaveEDate(leaveVo.getLeaveEDate());
                // 请假表-请假时长
                leave.setLeaveTotalDate(leaveVo.getLeaveTotalDate());
                final val i4 = leaveMapper.insert(leave);
                if (i4 == 1) {
                    return 1111;
                } else {
                    throw new ArithmeticException("0");
                }
            } else {
                throw new ArithmeticException("0");
            }
        } else {
            throw new ArithmeticException("0");
        }
    }

    /**
     * 添加请假 添加一个审批人
     *
     * @param leaveVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer submitToAskForLeave1(LeaveVo leaveVo) throws ArithmeticException{
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(leaveVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(leaveVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(leaveVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", leaveVo.getStaffName())
                    .eq("AUDITFLOW_TITLE", leaveVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(leaveVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);
            // 如果三个审批明细表添加成功，则添加请假表
            Leave leave = new Leave();
            // 请假表-审批编号
            leave.setAuditflowId(auditflow1.getAuditFlowId());
            // 请假表-员工名称
            leave.setStaffName(leaveVo.getStaffName());
            // 请假表-部门名称
            leave.setDeptname(leaveVo.getDeptname());
            // 请假表-请假类型
            leave.setLeaveType(leaveVo.getLeaveType());
            // 请假表-请假事由
            leave.setLeaveMatter(leaveVo.getLeaveMatter());
            // 请假表-请假开始时间
            leave.setLeaveSDate(leaveVo.getLeaveSDate());
            // 请假表-请假结束时间
            leave.setLeaveEDate(leaveVo.getLeaveEDate());
            // 请假表-请假时长
            leave.setLeaveTotalDate(leaveVo.getLeaveTotalDate());
            final val i4 = leaveMapper.insert(leave);
            if (i1 == 1 && i4 == 1) {
                return 1111;
            } else {
                throw new ArithmeticException("0");
            }
        } else {
            throw new ArithmeticException("0");
        }
    }

}
