package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.mybatisplus.mapper.AuditflowMapper;
import com.trkj.framework.mybatisplus.mapper.AuditflowdetailMapper;
import com.trkj.framework.mybatisplus.mapper.AuditflowoneMapper;
import com.trkj.framework.mybatisplus.mapper.OvertimeaskMapper;
import com.trkj.framework.mybatisplus.service.AuditflowService;
import com.trkj.framework.vo.AuditflowDetailsVo;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.OvertimeaskVo;
import com.trkj.framework.vo.WorkerVo;
import lombok.val;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 审批主表 服务实现类
 * </p>
 *
 * @author 里予
 * @since 2021-12-27
 */
@Service
public class AuditflowServiceImpl implements AuditflowService {
    @Autowired
    private AuditflowMapper auditflowMapper;
    @Autowired
    private AuditflowdetailMapper auditflowdetailMapper;
    @Autowired
    private AuditflowoneMapper auditflowoneMapper;
    @Autowired
    private OvertimeaskMapper ovimeaskMapper;


    /**
     * 根据审批类型的加班/审批人查询待处理的审批
     *
     * @param
     * @return
     */
    @Override
    public IPage<Auditflowone> selectAuditflowoneAll(Auditflowone auditflowone) {
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
        queryWrapper.eq("a.AUDITFLOW_TYPE", "加班");
        return auditflowoneMapper.selectAuditflowoneAll(page, queryWrapper);
    }

    /**
     * 根据审批类型的加班/审批人查询已处理的审批
     *
     * @param
     * @return
     */
    @Override
    public IPage<Auditflowone> selectEnddAuditflow(Auditflowone auditflowone) {
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
        queryWrapper.eq("a.AUDITFLOW_TYPE", "加班");
        queryWrapper.eq("b.STAFF_NAME", auditflowone.getStaffName2());
        return auditflowoneMapper.selectEnddAuditflow(page, queryWrapper);
    }

    /**
     * 根据审批类型的加班/审批人查询已处理的详情信息
     *
     * @param auditflowDetailsVo
     * @return
     */
    @Override
    public List<AuditflowDetailsVo> selectDetailsAuditflow(AuditflowDetailsVo auditflowDetailsVo) {
        QueryWrapper<AuditflowDetailsVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("b.STAFF_NAME", auditflowDetailsVo.getStaffName2());
        queryWrapper.eq("a.AUDITFLOW_ID", auditflowDetailsVo.getAuditflowId());
        queryWrapper.eq("o.STAFF_NAME", auditflowDetailsVo.getStaffName1());
        return auditflowoneMapper.selectDetailsAuditflow(queryWrapper);
    }

    /**
     * 根据审批明细表ID修改其状态 通过
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateApprovalState(Auditflowdetail auditflowdetail) {
        // 获取下一个审批人
        final var auditflowdetailId2 = auditflowdetail.getAuditflowdetailId2();
        System.out.println(auditflowdetailId2);
        // 获取审批主表编号
        final var auditflowId = auditflowdetail.getAuditflowId();
        // 如果下一个审批人不为空
        if (auditflowdetailId2 != null) {
            final var i = auditflowdetailMapper.updateById(auditflowdetail);
            QueryWrapper<Auditflowdetail> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("auditflowdetail_Id", auditflowdetailId2);
            final var i1 = auditflowdetailMapper.updateApprovalState(queryWrapper1);
            return i1;
            // 如果为空，则代表是最后一个审批人
        } else if (auditflowdetailId2 == null) {
            final var i = auditflowdetailMapper.updateById(auditflowdetail);
            QueryWrapper<Auditflow> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("auditflow_Id", auditflowId);
            final var i2 = auditflowMapper.rejectApprovalState2(queryWrapper);
            return i2;
        } else {
            return 999;
        }
    }

    /**
     * 根据审批明细表ID修改其状态 驳回
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int rejectApprovalState(Auditflowdetail auditflowdetail) {
        // 获取第二个审批人
        final var auditflowdetailId2 = auditflowdetail.getAuditflowdetailId2();
        // 获取第三个审批人
        final var auditflowdetailId3 = auditflowdetail.getAuditflowdetailId3();
        // 获取审批主表编号
        final var auditflowId = auditflowdetail.getAuditflowId();
        // 如果第二个审批人不为空 并且 第三个审批人也不为空
        if (auditflowdetailId2 != null && auditflowdetailId3 != null) {
            // 驳回第一个审批明细记录
            final var i = auditflowdetailMapper.updateById(auditflowdetail);
            if (i == 1) {
                QueryWrapper<Auditflowdetail> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("auditflowdetail_Id", auditflowdetailId2);
                final var i1 = auditflowdetailMapper.rejectApprovalState(queryWrapper);
                if (i1 == 1) {
                    QueryWrapper<Auditflowdetail> queryWrapper1 = new QueryWrapper<>();
                    queryWrapper1.eq("auditflowdetail_Id", auditflowdetailId3);
                    final var i2 = auditflowdetailMapper.rejectApprovalState2(queryWrapper1);
                    if (i2 == 1) {
                        QueryWrapper<Auditflow> queryWrapper2 = new QueryWrapper<>();
                        queryWrapper2.eq("auditflow_Id", auditflowId);
                        final var i3 = auditflowMapper.rejectApprovalState(queryWrapper2);
                        return i3;
                    } else {
                        return 999;
                    }
                } else {
                    return 999;
                }
            } else {
                return 999;
            }
            // 如果第二个审批人和第三个审批人都为空
        } else if (auditflowdetailId2 == null && auditflowdetailId3 == null) {
            // 驳回第一个审批明细记录
            final var i = auditflowdetailMapper.updateById(auditflowdetail);
            QueryWrapper<Auditflow> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("auditflow_Id", auditflowId);
            final var i1 = auditflowMapper.rejectApprovalState(queryWrapper2);
            return i1;
        } else if (auditflowdetailId2 == null || auditflowdetailId3 == null) {
            // 驳回第一个审批明细记录
            final var i = auditflowdetailMapper.updateById(auditflowdetail);
            if (i == 1) {
                QueryWrapper<Auditflowdetail> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("auditflowdetail_Id", auditflowdetailId2);
                final var i1 = auditflowdetailMapper.rejectApprovalState(queryWrapper);
                if (i1 == 1) {
                    QueryWrapper<Auditflow> queryWrapper2 = new QueryWrapper<>();
                    queryWrapper2.eq("auditflow_Id", auditflowId);
                    final var i3 = auditflowMapper.rejectApprovalState(queryWrapper2);
                    return i3;
                } else {
                    return 999;
                }
            } else {
                return 999;
            }
        }else {
            return 999;
        }
    }

    /**
     * 根据审批编号查询对应的审批明细表编号 部门经理
     *
     * @param auditflowdetail
     * @return
     */
    @Override
    public List<Auditflowdetail> queryDetail(Auditflowdetail auditflowdetail) {
        QueryWrapper<Auditflowdetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("AUDITFLOW_ID", auditflowdetail.getAuditflowId());
        queryWrapper.ne("AUDITFLOWDETAI_STATE", 2);
        queryWrapper.ne("AUDITFLOWDETAI_STATE", 3);
        return auditflowdetailMapper.selectListAuditflow(queryWrapper);
    }

    @Override
    public Integer selectOvertimeExamine(OvertimeaskVo overtimeaskVo) {
        QueryWrapper<OvertimeaskVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("c.STAFF_NAME", overtimeaskVo.getStaffName());
        queryWrapper.eq("a.IS_DELETED", 0);
        queryWrapper.eq("b.IS_DELETED", 0);
        queryWrapper.eq("c.IS_DELETED", 0);
        final var i = ovimeaskMapper.selectOvertimeExamine(queryWrapper);
        if (i == null) {
            return 5;
        } else {
            return i;
        }
    }

    /**
     * 添加加班 添加三个审批人
     *
     * @param overtimeaskVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int submitToOvertime3(OvertimeaskVo overtimeaskVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditflowTitle(overtimeaskVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditflowType(overtimeaskVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(overtimeaskVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", overtimeaskVo.getStaffName())
                    .eq("AUDITFLOW_TITLE", overtimeaskVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(overtimeaskVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2 = new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(overtimeaskVo.getStaffName2());
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3 = new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(overtimeaskVo.getStaffName3());
            final var i3 = auditflowdetailMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加加班表
            if (i1 == 1 && i2 == 1 && i3 == 1) {
                Overtimeask overtimeask = new Overtimeask();
                // 加班表-审批编号
                overtimeask.setAuditflowId(auditflow1.getAuditflowId());
                // 加班表-员工名称
                overtimeask.setStaffName(overtimeaskVo.getStaffName());
                // 加班表-部门名称
                overtimeask.setDeptName(overtimeaskVo.getDeptName());
                // 加班表-加班类型
                overtimeask.setOvertimeaskType(overtimeaskVo.getOvertimeaskType());
                // 加班表-加班事由
                overtimeask.setOvertimeaskMatter(overtimeaskVo.getOvertimeaskMatter());
                // 加班表-加班开始时间
                overtimeask.setOvertimeaskSDate(overtimeaskVo.getOvertimeaskSDate());
                // 加班表-加班结束时间
                overtimeask.setOvertimeaskEDate(overtimeaskVo.getOvertimeaskEDate());
                // 加班表-加班总时长
                overtimeask.setOvertimeaskTotalDate(overtimeask.getOvertimeaskTotalDate());
                final val i4 = ovimeaskMapper.insert(overtimeask);
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
     * 添加加班 添加两个审批人
     *
     * @param overtimeaskVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int submitToOvertime2(OvertimeaskVo overtimeaskVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditflowTitle(overtimeaskVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditflowType(overtimeaskVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(overtimeaskVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", overtimeaskVo.getStaffName())
                    .eq("AUDITFLOW_TITLE", overtimeaskVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(overtimeaskVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2 = new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(overtimeaskVo.getStaffName2());
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);

            // 如果三个审批明细表添加成功，则添加加班表
            if (i1 == 1 && i2 == 1) {
                Overtimeask overtimeask = new Overtimeask();
                // 加班表-审批编号
                overtimeask.setAuditflowId(auditflow1.getAuditflowId());
                // 加班表-员工名称
                overtimeask.setStaffName(overtimeaskVo.getStaffName());
                // 加班表-部门名称
                overtimeask.setDeptName(overtimeaskVo.getDeptName());
                // 加班表-加班类型
                overtimeask.setOvertimeaskType(overtimeaskVo.getOvertimeaskType());
                // 加班表-加班事由
                overtimeask.setOvertimeaskMatter(overtimeaskVo.getOvertimeaskMatter());
                // 加班表-加班开始时间
                overtimeask.setOvertimeaskSDate(overtimeaskVo.getOvertimeaskSDate());
                // 加班表-加班结束时间
                overtimeask.setOvertimeaskEDate(overtimeaskVo.getOvertimeaskEDate());
                // 加班表-加班总时长
                overtimeask.setOvertimeaskTotalDate(overtimeask.getOvertimeaskTotalDate());
                final val i4 = ovimeaskMapper.insert(overtimeask);
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
}
