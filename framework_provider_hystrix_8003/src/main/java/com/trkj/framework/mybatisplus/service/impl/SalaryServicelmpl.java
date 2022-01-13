package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.mybatisplus.mapper.*;
import com.trkj.framework.mybatisplus.service.SalaryService;
import com.trkj.framework.vo.*;
import lombok.val;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalaryServicelmpl implements SalaryService {
    @Autowired
    private AuditflowoneMapper auditflowoneMapper;
    @Autowired
    private SalaryMapper salaryMapper;
    @Autowired
    private FixedwagfMapper fixedwagfMapper;
    @Autowired
    private AuditflowMapper auditflowMapper;
    @Autowired
    private AuditflowdetailMapper auditflowdetailMapper;


    /**
     * 根据审批类型的调薪/审批人查询待处理的审批
     *
     * @param
     * @return
     */
    @Override
    public IPage<Auditflowone> selectSalaryAll(Auditflowone auditflowone) {
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
        queryWrapper.eq("a.AUDITFLOW_TYPE", "调薪");
        return auditflowoneMapper.selectAuditflowoneAll(page, queryWrapper);
    }

    /**
     * 根据审批类型的调薪/审批人查询已处理的审批
     *
     * @param
     * @return
     */
    @Override
    public IPage<Auditflowone> selectEndSalaryAll(Auditflowone auditflowone) {
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
        queryWrapper.eq("a.AUDITFLOW_TYPE", "调薪");
        queryWrapper.eq("b.STAFF_NAME", "部门经理");
        return auditflowoneMapper.selectEnddAuditflow(page, queryWrapper);
    }

    /**
     * 根据审批类型的调薪/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    @Override
    public List<SalaryDetailsVo> selectDetailsSalary(SalaryDetailsVo salaryDetailsVo) {
        QueryWrapper<SalaryDetailsVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("b.STAFF_NAME", salaryDetailsVo.getStaffName2());
        queryWrapper.eq("a.AUDITFLOW_ID", salaryDetailsVo.getAuditflowId());
        queryWrapper.eq("s.STAFF_NAME", salaryDetailsVo.getStaffName1());
        return auditflowoneMapper.selectDetailsSalary(queryWrapper);
    }

    @Override
    public Integer selectSalaryRecord(SalaryVo salaryVo) {
        QueryWrapper<SalaryVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("c.STAFF_NAME", salaryVo.getStaffName());
        queryWrapper.eq("a.IS_DELETED", 0);
        queryWrapper.eq("b.IS_DELETED", 0);
        queryWrapper.eq("c.IS_DELETED", 0);
        final var i = salaryMapper.selectSalaryRecord(queryWrapper);
        if (i == null) {
            return 5;
        } else {
            return i;
        }
    }

    @Override
    public Integer selectPay(Fixedwagf fixedwagf) {
        QueryWrapper<Fixedwagf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("STAFF_ID",fixedwagf.getStaffid());
        return fixedwagfMapper.selectPay(queryWrapper);
    }

    /**
     * 添加调薪 添加三个审批人
     * @param salaryVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int SubmitSalary3(SalaryVo salaryVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditflowTitle(salaryVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditflowType(salaryVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(salaryVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i ==1){
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", salaryVo.getStaffName())
                    .eq("AUDITFLOW_TITLE",salaryVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1=new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(salaryVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2=new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(salaryVo.getStaffName2());
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3=new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(salaryVo.getStaffName3());
            final var i3 = auditflowdetailMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加调薪表
            if (i1==1 && i2== 1 && i3==1) {
                Salary salary=new Salary();
                // 调薪表-审批编号
                salary.setAuditflowId(auditflow1.getAuditflowId());
                // 调薪表-员工名称
                salary.setStaffName(salaryVo.getStaffName());
                // 调薪表-部门名称
                salary.setDeptName(salaryVo.getDeptname());
                // 调薪表-调薪备注
                salary.setSalaryRemarks(salaryVo.getSalaryremarks());
                // 调薪表-调薪前基本工资
                salary.setFrontSalary(salaryVo.getFrontsalary());
                // 调薪表-调薪后基本工资
                salary.setAfterSalary(salaryVo.getAftersalary());
                // 调薪表-转正日期
                salary.setTakeEffectDate(salaryVo.getTakeEffectDate());
                final val i4 = salaryMapper.insert(salary);
                if (i4==1){
                    return 1111;
                }else {
                    return 0;
                }
            }else {
                return 0;
            }
        }else {
            return 0;
        }
    }

    /**
     * 添加调薪 添加三个审批人
     * @param salaryVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int SubmitSalary2(SalaryVo salaryVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditflowTitle(salaryVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditflowType(salaryVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(salaryVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i ==1){
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", salaryVo.getStaffName())
                    .eq("AUDITFLOW_TITLE",salaryVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1=new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(salaryVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2=new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(salaryVo.getStaffName2());
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);
            // 如果三个审批明细表添加成功，则添加调薪表
            if (i1==1 && i2==1) {
                Salary salary=new Salary();
                // 调薪表-审批编号
                salary.setAuditflowId(auditflow1.getAuditflowId());
                // 调薪表-员工名称
                salary.setStaffName(salaryVo.getStaffName());
                // 调薪表-部门名称
                salary.setDeptName(salaryVo.getDeptname());
                // 调薪表-调薪备注
                salary.setSalaryRemarks(salaryVo.getSalaryremarks());
                // 调薪表-调薪前基本工资
                salary.setFrontSalary(salaryVo.getFrontsalary());
                // 调薪表-调薪后基本工资
                salary.setAfterSalary(salaryVo.getAftersalary());
                // 调薪表-转正日期
                salary.setTakeEffectDate(salaryVo.getTakeEffectDate());
                final val i4 = salaryMapper.insert(salary);
                if (i4==1){
                    return 1111;
                }else {
                    return 0;
                }
            }else {
                return 0;
            }
        }else {
            return 0;
        }
    }
}
