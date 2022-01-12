package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Auditflow;
import com.trkj.framework.entity.mybatisplus.Auditflowdetail;
import com.trkj.framework.entity.mybatisplus.Quit;
import com.trkj.framework.entity.mybatisplus.Salary;
import com.trkj.framework.mybatisplus.mapper.AuditflowMapper;
import com.trkj.framework.mybatisplus.mapper.AuditflowdetailMapper;
import com.trkj.framework.mybatisplus.mapper.AuditflowoneMapper;
import com.trkj.framework.mybatisplus.mapper.QuitMapper;
import com.trkj.framework.mybatisplus.service.QuitService;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.QuitDetailsVo;
import com.trkj.framework.vo.QuitVo;
import com.trkj.framework.vo.SalaryVo;
import lombok.val;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 离职表 服务实现类
 * @author 里予
 * @since 2022-1-2
 */
@Service
public class QuitServicelmpl implements QuitService {
    @Autowired
    private AuditflowoneMapper auditflowoneMapper;
    @Autowired
    private QuitMapper quitMapper;
    @Autowired
    private AuditflowMapper auditflowMapper;
    @Autowired
    private AuditflowdetailMapper auditflowdetailMapper;



    @Override
    public IPage<Auditflowone> selectQuitAll(Auditflowone auditflowone) {
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
        queryWrapper.eq("a.AUDITFLOW_TYPE", "离职");
        return auditflowoneMapper.selectAuditflowoneAll(page, queryWrapper);
    }

    @Override
    public IPage<Auditflowone> selectEndQuitAll(Auditflowone auditflowone) {
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
        queryWrapper.eq("a.AUDITFLOW_TYPE", "离职");
        queryWrapper.eq("b.STAFF_NAME", "部门经理");
        return auditflowoneMapper.selectEnddAuditflow(page, queryWrapper);
    }

    @Override
    public List<QuitDetailsVo> selectDetailsQuit(QuitDetailsVo quitDetailsVo) {
        QueryWrapper<QuitDetailsVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("b.STAFF_NAME", quitDetailsVo.getStaffName2());
        queryWrapper.eq("a.AUDITFLOW_ID", quitDetailsVo.getAuditflowId());
        queryWrapper.eq("q.STAFF_NAME", quitDetailsVo.getStaffName1());
        return auditflowoneMapper.selectDetailsQuit(queryWrapper);
    }

    @Override
    public Integer selectDimissionRecord(Quit quit) {
        QueryWrapper<Quit> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("c.STAFF_NAME", quit.getStaffName());
        queryWrapper.eq("a.IS_DELETED", 0);
        queryWrapper.eq("b.IS_DELETED", 0);
        queryWrapper.eq("c.IS_DELETED", 0);
        final var i = quitMapper.selectDimissionRecord(queryWrapper);
        if (i == null) {
            return 5;
        } else {
            return i;
        }
    }

    /**
     * 添加调薪 添加三个审批人
     * @param quitVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int submitToLeave3(QuitVo quitVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditflowTitle(quitVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditflowType(quitVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(quitVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i ==1){
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", quitVo.getStaffName())
                    .eq("AUDITFLOW_TITLE",quitVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1=new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(quitVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2=new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(quitVo.getStaffName2());
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3=new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(quitVo.getStaffName3());
            final var i3 = auditflowdetailMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加调薪表
            if (i1==1 && i2== 1 && i3==1) {
                Quit quit=new Quit();
                // 离职表-审批编号
                quit.setAuditflowId(auditflow1.getAuditflowId());
                // 离职表-员工名称
                quit.setStaffName(quitVo.getStaffName());
                // 离职表-部门名称
                quit.setDeptName(quitVo.getDeptName());
                // 离职表-离职类型
                quit.setQuitType(quitVo.getQuitType());
                // 离职表-离职说明
                quit.setQuitExplain(quitVo.getQuitExplain());
                // 离职表-申请离职日期
                quit.setApplyQuitDate(quitVo.getApplyQuitDate());
                final val i4 = quitMapper.insert(quit);
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
     * 添加调薪 添加两个审批人
     * @param quitVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int submitToLeave2(QuitVo quitVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditflowTitle(quitVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditflowType(quitVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(quitVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i ==1){
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", quitVo.getStaffName())
                    .eq("AUDITFLOW_TITLE",quitVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1=new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(quitVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2=new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(quitVo.getStaffName2());
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);

            // 如果三个审批明细表添加成功，则添加调薪表
            if (i1==1 && i2== 1) {
                Quit quit=new Quit();
                // 离职表-审批编号
                quit.setAuditflowId(auditflow1.getAuditflowId());
                // 离职表-员工名称
                quit.setStaffName(quitVo.getStaffName());
                // 离职表-部门名称
                quit.setDeptName(quitVo.getDeptName());
                // 离职表-离职类型
                quit.setQuitType(quitVo.getQuitType());
                // 离职表-离职说明
                quit.setQuitExplain(quitVo.getQuitExplain());
                // 离职表-申请离职日期
                quit.setApplyQuitDate(quitVo.getApplyQuitDate());
                final val i4 = quitMapper.insert(quit);
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
