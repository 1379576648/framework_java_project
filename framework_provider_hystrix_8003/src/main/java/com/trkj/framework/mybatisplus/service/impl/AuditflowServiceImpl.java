package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.mybatisplus.mapper.*;
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
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private FixedwagfMapper fixedwagfMapper;


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
        // 获取审批类型
        final var auditflowType = auditflowdetail.getAuditflowType();
        // 获取审批主表编号
        final var auditflowId = auditflowdetail.getAuditflowId();
        // 获取审批申请人
        final var staffName1 = auditflowdetail.getStaffName1();
        // 根据申请人名称去获取其员工信息
        QueryWrapper<Staff> queryWrapper6 = new QueryWrapper<>();
        queryWrapper6.eq("STAFF_NAME", staffName1);
        final var satffNO = auditflowdetailMapper.selectStaffID(queryWrapper6);
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
            // 修改完审批主表状态，再根据审批类型去完成对应的操作
            if (i2 == 1) {
                // 如果等于转正，则根据审批申请人去修改员工表的员工状态
                if ("转正".equals(auditflowType)) {
                    QueryWrapper<Staff> queryWrapper2 = new QueryWrapper<>();
                    queryWrapper2.eq("STAFF_NAME", staffName1);
                    final var i1 = auditflowdetailMapper.updateStaffState(queryWrapper2);
                    // 如果修改成功，则将转正表中的状态修改为同意,根据审批主表编号及审批申请人名称
                    if (i1 == 1) {
                        QueryWrapper<Worker> queryWrapper3 = new QueryWrapper<>();
                        queryWrapper3.eq("STAFF_NAME", staffName1);
                        queryWrapper3.eq("AUDITFLOW_ID", auditflowId);
                        final var i3 = auditflowdetailMapper.updateWorker(queryWrapper3);
                        return i3;
                    } else {
                        return 999;
                    }
                    // 如果等于调岗,则先根据审批主表编号去查询调动表中的记录（调岗后部门名称）
                } else if ("调动".equals(auditflowType)) {
                    QueryWrapper<Transfer> queryWrapper4 = new QueryWrapper<>();
                    queryWrapper4.eq("AUDITFLOW_ID", auditflowId);
                    final var updatedDeptName = auditflowdetailMapper.selectTransfer(queryWrapper4);
                    // 如果不等于空,则根据它去部门表中拿编号
                    if (updatedDeptName != null) {
                        QueryWrapper<Dept> queryWrapper5 = new QueryWrapper<>();
                        queryWrapper5.eq("DEPT_NAME", updatedDeptName.get(0).getUpdatedDeptName());
                        final var deptID = auditflowdetailMapper.selectDeptID(queryWrapper5);
                        // 如果不等于空，则拿编号调岗后部门编号及员工编号去修改员工表的部门编号
                        if (deptID != null) {
                            Staff staff = new Staff();
                            staff.setStaffId(satffNO.get(0).getStaffId());
                            staff.setDeptId(deptID);
                            final var i1 = staffMapper.updateById(staff);
                            // 如果成功，则根据部门编号及部门职位编号查询部门职位名称
                            if (i1 == 1) {
                                QueryWrapper<DeptPost>queryWrapper7 = new QueryWrapper<>();
                                queryWrapper7.eq("a.DEPT_ID",satffNO.get(0).getDeptId());
                                queryWrapper7.eq("a.DEPT_POST_ID",satffNO.get(0).getDeptPostId());
                                final var deptPosts = auditflowdetailMapper.selectPostName(queryWrapper7);
                                // 如果成功，在这里拿到员工调岗前原部门职位名称，则根据原部门职位名称去及变动后部门编号查询变动后部门职位编号
                                QueryWrapper<DeptPost>queryWrapper8 = new QueryWrapper<>();
                                queryWrapper8.eq("a.DEPT_ID",deptID);
                                queryWrapper8.eq("a.POST_NAME",deptPosts.get(0).getPostName());
                                final var postID = auditflowdetailMapper.selectPostID(queryWrapper8);
                                // 拿这个部门职位编号去修改员工的原部门职位编号
                                Staff staff1 = new Staff();
                                staff1.setStaffId(satffNO.get(0).getStaffId());
                                staff1.setDeptPostId(postID);
                                final var i3 = staffMapper.updateById(staff1);
                                if (i3 == 1){
                                    return 1;
                                }else {
                                    return 999;
                                }
                            }else {
                                return 999;
                            }
                        } else {
                            return 999;
                        }
                    } else {
                        return 999;
                    }
                // 如果等于调薪,则先根据审批主表编号去查询调薪表中的记录（调薪后基本工资）
                } else if ("调薪".equals(auditflowType)){
                    QueryWrapper<Salary> queryWrapper9 = new QueryWrapper<>();
                    queryWrapper9.eq("AUDITFLOW_ID", auditflowId);
                    final var afterSalary = auditflowdetailMapper.selectSalary(queryWrapper9);
                // 拿到调薪后基本工资，根据员工编号去查询固定工资表编号
                    QueryWrapper<Fixedwagf>queryWrapper10=new QueryWrapper<>();
                    queryWrapper10.eq("STAFF_ID",satffNO.get(0).getStaffId());
                    final var fixedwafID = auditflowdetailMapper.selectFixedwagfID(queryWrapper10);
                // 拿到固定工资表编号，则根据其和调薪后基本工资去修改员工工资
                    Fixedwagf fixedwagf = new Fixedwagf();
                    fixedwagf.setFixedwangerId(fixedwafID);
                    fixedwagf.setFixedwageOfficialmoney(afterSalary);
                    final var i4 = fixedwagfMapper.updateById(fixedwagf);
                    return i4;
                }else {
                    return 999;
                }
            } else {
                return 999;
            }
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
        } else {
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
