package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.*;
import com.trkj.framework.mybatisplus.mapper.*;
import com.trkj.framework.mybatisplus.service.AuditflowService;
import com.trkj.framework.vo.*;
import lombok.val;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static com.alibaba.druid.util.FnvHash.Constants.TO_CHAR;

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
    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private TravelMapper travelMapper;
    @Autowired
    private LeaveMapper leaveMapper;
    @Autowired
    private DeptPostMapper deptPostMapper;
    @Autowired
    private CardMapper cardMapper;
    @Autowired
    private ClockRecordMapper clockRecordMapper;




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
        if (auditflowDetailsVo.getStaffName2() != null) {
            queryWrapper.eq("b.STAFF_NAME", auditflowDetailsVo.getStaffName2());
        }
        queryWrapper.eq("a.AUDITFLOW_ID", auditflowDetailsVo.getAuditflowId());
        queryWrapper.eq("o.STAFF_NAME", auditflowDetailsVo.getStaffName1());
        return auditflowoneMapper.selectDetailsAuditflow(queryWrapper);
    }

    @Override
    public Integer selectStaffState(Staff staff) {
        QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("STAFF_NAME", staff.getStaffName());
        return auditflowoneMapper.selectStaffState(queryWrapper);
    }

    /**
     * 根据审批明细表ID修改其状态 通过
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateApprovalState(Auditflowdetail auditflowdetail) throws ArithmeticException {
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
                    // 根据审批主表编号查询转正表数据
                    QueryWrapper<Worker> worker = new QueryWrapper<>();
                    worker.eq("AUDITFLOW_ID", auditflowId);
                    final var workers = auditflowdetailMapper.selectWorker(worker);
                    QueryWrapper<Staff> queryWrapper2 = new QueryWrapper<>();
                    queryWrapper2.eq("STAFF_NAME", staffName1);
                    final var i1 = auditflowdetailMapper.updateStaffState(queryWrapper2);
                    // 如果修改成功，则将转正表中的状态修改为同意,根据审批主表编号及审批申请人名称
                    if (i1 == 1) {
                        QueryWrapper<Worker> queryWrapper3 = new QueryWrapper<>();
                        queryWrapper3.eq("STAFF_NAME", staffName1);
                        queryWrapper3.eq("AUDITFLOW_ID", auditflowId);
                        final var i3 = auditflowdetailMapper.updateWorker(queryWrapper3);
                        // 如果修改成功，则添加一条消息给申请人(员工编号、标题、内容、)
                        if (i3 == 1) {
                            News news = new News();
                            news.setStaffId(satffNO.get(0).getStaffId());
                            news.setNewsTitle(auditflowType + "审批已通过:");
                            // 转日期格式
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                            String CreatedTime = sdf.format(workers.get(0).getCreatedTime());
                            news.setNewsMatter("您于" + CreatedTime + "发起的" + auditflowType + "审批,现已通过，请核实，如有纰漏，请联系管理员");
                            final var insert = newsMapper.insert(news);
                            return insert;
                        } else {
                            throw new ArithmeticException("999");
                        }
                    } else {
                        throw new ArithmeticException("999");
                    }
                    // 如果等于调岗,则先根据审批主表编号去查询调动表中的数据
                } else if ("调动".equals(auditflowType)) {
                    QueryWrapper<Transfer> queryWrapper4 = new QueryWrapper<>();
                    queryWrapper4.eq("AUDITFLOW_ID", auditflowId);
                    final var transfers = auditflowdetailMapper.selectTransfer(queryWrapper4);
                    // 如果不等于空,则根据它去部门表中拿编号
                    if (transfers != null) {
                        QueryWrapper<Dept> queryWrapper5 = new QueryWrapper<>();
                        queryWrapper5.eq("DEPT_NAME", transfers.get(0).getUpdatedDeptName());
                        final var deptID = auditflowdetailMapper.selectDeptID(queryWrapper5);
                        // 如果不等于空，则拿编号调岗后部门编号及员工编号去修改员工表的部门编号
                        if (deptID != null) {
                            Staff staff = new Staff();
                            staff.setStaffId(satffNO.get(0).getStaffId());
                            staff.setDeptId(deptID);
                            final var i1 = staffMapper.updateById(staff);
                            // 如果成功，则根据部门编号及部门职位编号查询部门职位名称
                            if (i1 == 1) {
                                QueryWrapper<DeptPost> queryWrapper7 = new QueryWrapper<>();
                                queryWrapper7.eq("a.DEPT_ID", satffNO.get(0).getDeptId());
                                queryWrapper7.eq("a.DEPT_POST_ID", satffNO.get(0).getDeptPostId());
                                final var deptPosts = auditflowdetailMapper.selectPostName(queryWrapper7);
                                final var op = deptPosts.get(0).getPostName().matches("(.*)经理(.*)");
                                // 如果成功，在这里拿到员工调岗前原部门职位名称，则根据原部门职位名称去及变动后部门编号查询变动后部门职位编号
                                QueryWrapper<DeptPost> queryWrapper8 = new QueryWrapper<>();
                                if (op == true) {
                                    queryWrapper8.like("a.POST_NAME", "经理");
                                } else {
                                    queryWrapper8.eq("a.POST_NAME", deptPosts.get(0).getPostName());
                                }
                                queryWrapper8.eq("a.DEPT_ID", deptID);
                                final var postID = auditflowdetailMapper.selectPostID(queryWrapper8);
                                // 拿这个部门职位编号去修改员工的原部门职位编号
                                Staff staff1 = new Staff();
                                staff1.setStaffId(satffNO.get(0).getStaffId());
                                staff1.setDeptPostId(postID);
                                final var i3 = staffMapper.updateById(staff1);
                                // 修改调动表中的状态为同意 根据审批主表编号及审批申请人名称
                                QueryWrapper<Transfer> queryWrapper14 = new QueryWrapper<>();
                                queryWrapper14.eq("STAFF_NAME", staffName1);
                                queryWrapper14.eq("AUDITFLOW_ID", auditflowId);
                                final var i7 = auditflowdetailMapper.updateTransfer(queryWrapper14);
                                System.out.println(postID);
                                System.out.println(i3);
                                System.out.println(i7);
                                // 如果修改成功，则添加一条消息给申请人(员工编号、标题、内容、)
                                if (i3 == 1 && i7 == 1) {
                                    System.out.println("22222222222222222222222222222222222222");
                                    News news = new News();
                                    news.setStaffId(satffNO.get(0).getStaffId());
                                    news.setNewsTitle(auditflowType + "审批已通过:");
                                    // 转日期格式
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                    String CreatedTime = sdf.format(transfers.get(0).getCreatedTime());
                                    news.setNewsMatter("您于" + CreatedTime + "发起的" + auditflowType + "审批,现已通过，请核实，如有纰漏，请联系管理员");
                                    final var insert = newsMapper.insert(news);
                                    return insert;
                                } else {
                                    throw new ArithmeticException("999");
                                }
                            } else {
                                throw new ArithmeticException("999");
                            }
                        } else {
                            throw new ArithmeticException("999");
                        }
                    } else {
                        throw new ArithmeticException("999");
                    }
                    // 如果等于调薪,则先根据审批主表编号去查询调薪表中的记录（调薪后基本工资）
                } else if ("调薪".equals(auditflowType)) {
                    QueryWrapper<Salary> queryWrapper9 = new QueryWrapper<>();
                    queryWrapper9.eq("AUDITFLOW_ID", auditflowId);
                    final var salarys = auditflowdetailMapper.selectSalary(queryWrapper9);
                    // 拿到调薪后基本工资，根据员工编号去查询固定工资表编号
                    QueryWrapper<Fixedwagf> queryWrapper10 = new QueryWrapper<>();
                    queryWrapper10.eq("STAFF_ID", satffNO.get(0).getStaffId());
                    final var fixedwafID = auditflowdetailMapper.selectFixedwagfID(queryWrapper10);
                    // 拿到固定工资表编号，则根据其和调薪后基本工资去修改员工工资
                    Fixedwagf fixedwagf = new Fixedwagf();
                    fixedwagf.setFixedwageId(fixedwafID);
                    fixedwagf.setFixedwageOfficialmoney(salarys.get(0).getAfterSalary());
                    final var i4 = fixedwagfMapper.updateById(fixedwagf);
                    // 修改调薪表中的状态为同意 根据审批主表编号及审批申请人名称
                    QueryWrapper<Fixedwagf> queryWrapper13 = new QueryWrapper<>();
                    queryWrapper13.eq("STAFF_NAME", staffName1);
                    queryWrapper13.eq("AUDITFLOW_ID", auditflowId);
                    final var i7 = auditflowdetailMapper.updateFixedwagf(queryWrapper13);
                    // 如果修改成功，则添加一条消息给申请人(员工编号、标题、内容、)
                    if (i7 == 1) {
                        News news = new News();
                        news.setStaffId(satffNO.get(0).getStaffId());
                        news.setNewsTitle(auditflowType + "审批已通过:");
                        // 转日期格式
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        String CreatedTime = sdf.format(salarys.get(0).getCreatedTime());
                        news.setNewsMatter("您于" + CreatedTime + "发起的" + auditflowType + "审批,现已通过，请核实，如有纰漏，请联系管理员");
                        final var insert = newsMapper.insert(news);
                        return insert;
                    } else {
                        throw new ArithmeticException("999");
                    }
                    // 如果等于离职
                } else if ("离职".equals(auditflowType)) {
                    // 根据审批主表编号去查询离职表数据
                    QueryWrapper<Quit> quit = new QueryWrapper<>();
                    quit.eq("AUDITFLOW_ID", auditflowId);
                    final var quits = auditflowdetailMapper.selectQuit(quit);
                    // 根据审批人名称去修改员工表的状态（离职）
                    QueryWrapper<Staff> queryWrapper11 = new QueryWrapper<>();
                    queryWrapper11.eq("STAFF_NAME", staffName1);
                    final var i5 = auditflowdetailMapper.updateStaffState1(queryWrapper11);
                    // 如果修改成功，则将离职表中的状态修改为同意,根据审批主表编号及审批申请人名称
                    if (i5 == 1) {
                        QueryWrapper<Quit> queryWrapper12 = new QueryWrapper<>();
                        queryWrapper12.eq("STAFF_NAME", staffName1);
                        queryWrapper12.eq("AUDITFLOW_ID", auditflowId);
                        final var i6 = auditflowdetailMapper.updateQuit(queryWrapper12);
                        // 如果修改成功，则添加一条消息给申请人(员工编号、标题、内容、)
                        if (i6 == 1) {
                            News news = new News();
                            news.setStaffId(satffNO.get(0).getStaffId());
                            news.setNewsTitle(auditflowType + "审批已通过:");
                            // 转日期格式
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                            String CreatedTime = sdf.format(quits.get(0).getCreatedTime());
                            news.setNewsMatter("您于" + CreatedTime + "发起的" + auditflowType + "审批,现已通过，请核实，如有纰漏，请联系管理员");
                            final var insert = newsMapper.insert(news);
                            return insert;
                        } else {
                            throw new ArithmeticException("999");
                        }
                    } else {
                        throw new ArithmeticException("999");
                    }
                    // 如果类型等于加班
                } else if ("加班".equals(auditflowType)) {
                    // 根据审批主表编号去查询加班表数据
                    QueryWrapper<Overtimeask> overtimeask = new QueryWrapper<>();
                    overtimeask.eq("AUDITFLOW_ID", auditflowId);
                    final var overtimeasks = auditflowdetailMapper.selectOvertime(overtimeask);
                    // 修改加班表中的状态为同意
                    QueryWrapper<Overtimeask> queryWrapper13 = new QueryWrapper<>();
                    queryWrapper13.eq("STAFF_NAME", staffName1);
                    queryWrapper13.eq("AUDITFLOW_ID", auditflowId);
                    final var i8 = auditflowdetailMapper.updateOvertimeasks(queryWrapper13);
                    //  成功后发一条消息给申请人
                    News news = new News();
                    news.setStaffId(satffNO.get(0).getStaffId());
                    news.setNewsTitle(auditflowType + "审批已通过:");
                    // 转日期格式
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String CreatedTime = sdf.format(overtimeasks.get(0).getCreatedTime());
                    news.setNewsMatter("您于" + CreatedTime + "发起的" + auditflowType + "审批,现已通过，请核实，如有纰漏，请联系管理员");
                    final var insert = newsMapper.insert(news);
                    //  如果都成功
                    if (i8 == 1 && insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                    // 如果类型等于出差
                } else if ("出差".equals(auditflowType)) {
                    // 根据审批主表编号去查询出差表数据
                    QueryWrapper<Travel> travel = new QueryWrapper<>();
                    travel.eq("AUDITFLOW_ID", auditflowId);
                    final var travels = auditflowdetailMapper.selectTravel(travel);
                    // 修改出差表中的状态为同意（状态1）
                    Travel travel1 = new Travel();
                    travel1.setTravelId(travels.get(0).getTravelId());
                    travel1.setAuditflowId(auditflowId);
                    travel1.setTravelState(1);
                    final var i9 = travelMapper.updateById(travel1);
                    // 修改成功后，发给申请人一条消息
                    News news = new News();
                    news.setStaffId(satffNO.get(0).getStaffId());
                    news.setNewsTitle(auditflowType + "审批已通过:");
                    // 转日期格式
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String CreatedTime = sdf.format(travels.get(0).getCreatedTime());
                    news.setNewsMatter("您于" + CreatedTime + "发起的" + auditflowType + "审批,现已通过，请核实，如有纰漏，请联系管理员");
                    final var insert = newsMapper.insert(news);
                    //  如果都成功
                    if (i9 == 1 && insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                    // 如果类型等于请假
                } else if ("请假".equals(auditflowType)) {
                    // 根据审批主表编号去查询请假表数据
                    QueryWrapper<Leave> leave = new QueryWrapper<>();
                    leave.eq("AUDITFLOW_ID", auditflowId);
                    final var leaves = auditflowdetailMapper.selectLeave(leave);
                    // 修改请假表中的状态为同意（状态1）
                    Leave leave1 = new Leave();
                    leave1.setLeaveId(leaves.get(0).getLeaveId());
                    leave1.setAuditflowId(auditflowId);
                    leave1.setLeaveState(1);
                    final var i0 = leaveMapper.updateById(leave1);
                    // 修改成功后，发给申请人一条消息
                    News news = new News();
                    news.setStaffId(satffNO.get(0).getStaffId());
                    news.setNewsTitle(auditflowType + "审批已通过:");
                    // 转日期格式
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String CreatedTime = sdf.format(leaves.get(0).getCreatedTime());
                    news.setNewsMatter("您于" + CreatedTime + "发起的" + auditflowType + "审批,现已通过，请核实，如有纰漏，请联系管理员");
                    final var insert = newsMapper.insert(news);
                    //  如果都成功
                    if (i0 == 1 && insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("补打卡".equals(auditflowType)) {
                    // 根据审批编号去查询补打卡记录表数据
                    QueryWrapper<Card> card = new QueryWrapper<>();
                    card.eq("AUDITFLOW_ID", auditflowId);
                    final var cards = cardMapper.selectList(card);
                    // 修改补打卡中的状态为同意
                    Card card1 = new Card();
                    card1.setCardId(cards.get(0).getCardId());
                    card1.setAuditflowId(auditflowId);
                    card1.setCardState(1);
                    final var i1 = cardMapper.updateById(card1);
                    if (i1 == 1) {
                        // 修改成功后，发给申请人一条消息
                        News news = new News();
                        news.setStaffId(satffNO.get(0).getStaffId());
                        news.setNewsTitle(auditflowType + "审批已通过:");
                        // 转日期格式
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        String CreatedTime = sdf.format(cards.get(0).getCreatedTime());
                        news.setNewsMatter("您于" + CreatedTime + "发起的" + auditflowType + "审批,现已通过，请核实，如有纰漏，请联系管理员");
                        final var insert = newsMapper.insert(news);
                        // 发消息成功后，则根据补打卡表中的员工名称及创建时间去打卡记录表中的查询有无记录
                        QueryWrapper<ClockRecord> clockRecord = new QueryWrapper<>();
                        clockRecord.eq("STAFF_NAME", cards.get(0).getStaffName());
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        String CreatedTime1 = df.format(cards.get(0).getCreatedTime());
                        clockRecord.apply("TO_CHAR(CREATED_TIME,'yyyy-mm-dd' ) like {0}", CreatedTime1);
                        final var clockRecords = clockRecordMapper.selectList(clockRecord);
                        if (clockRecords.size() != 0) {
                            // 查到打卡记录表中有数据，则根据补打卡表中的补打卡类型（未签退、未签到）去修改打卡记录中的数据
                            if ("未签到".equals(cards.get(0).getCardType())) {
                                ClockRecord clockRecord1 = new ClockRecord();
                                clockRecord1.setClockRecordId(clockRecords.get(0).getClockRecordId());
                                clockRecord1.setMornClock(cards.get(0).getCardDate());
                                final var i3 = clockRecordMapper.updateById(clockRecord1);
                                if (i3 == 1 && insert == 1) {
                                    return 1;
                                } else {
                                    throw new ArithmeticException("999");
                                }
                            } else if ("未签退".equals(cards.get(0).getCardType())) {
                                ClockRecord clockRecord1 = new ClockRecord();
                                clockRecord1.setClockRecordId(clockRecords.get(0).getClockRecordId());
                                clockRecord1.setAfternoonClock(cards.get(0).getCardDate());
                                final var i4 = clockRecordMapper.updateById(clockRecord1);
                                if (i4 == 1 && insert == 1) {
                                    return 1;
                                } else {
                                    throw new ArithmeticException("999");
                                }
                            } else {
                                throw new ArithmeticException("999");
                            }
                        } else {
                            throw new ArithmeticException("100");
                        }

                    } else {
                        throw new ArithmeticException("999");
                    }
                } else {
                    throw new ArithmeticException("999");
                }
            } else {
                throw new ArithmeticException("999");
            }
        } else {
            throw new ArithmeticException("999");
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
    public int rejectApprovalState(Auditflowdetail auditflowdetail) throws ArithmeticException {
        // 获取第二个审批人
        final var auditflowdetailId2 = auditflowdetail.getAuditflowdetailId2();
        // 获取第三个审批人
        final var auditflowdetailId3 = auditflowdetail.getAuditflowdetailId3();
        // 获取审批类型
        final var auditflowType = auditflowdetail.getAuditflowType();
        // 获取审批主表编号
        final var auditflowId = auditflowdetail.getAuditflowId();
        // 获取审批主表信息
        final var auditflow = auditflowMapper.selectById(auditflowId);
        // 获取审批申请人
        final var staffName1 = auditflowdetail.getStaffName1();
        // 根据申请人名称去获取其员工信息
        QueryWrapper<Staff> queryWrapper6 = new QueryWrapper<>();
        queryWrapper6.eq("STAFF_NAME", staffName1);
        final var satffNO = auditflowdetailMapper.selectStaffID(queryWrapper6);
        // 转日期格式 审批主表创建时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String CreatedTime = sdf.format(auditflow.getCreatedTime());
        // 驳回转正后发消息给申请人
        News workerNews = new News();
        workerNews.setNewsTitle(auditflowType + "驳回:");
        workerNews.setStaffId(satffNO.get(0).getStaffId());
        workerNews.setNewsMatter("您与" + CreatedTime + "发起的" + auditflowType + "审批被驳回,请知悉。");

        // 驳回调岗后发消息给申请人
        News TransferNews = new News();
        TransferNews.setNewsTitle(auditflowType + "驳回:");
        TransferNews.setStaffId(satffNO.get(0).getStaffId());
        TransferNews.setNewsMatter("您与" + CreatedTime + "发起的" + auditflowType + "审批被驳回,请知悉。");

        // 驳回调薪后发消息给申请人
        News SalaryNews = new News();
        SalaryNews.setNewsTitle(auditflowType + "驳回:");
        SalaryNews.setStaffId(satffNO.get(0).getStaffId());
        SalaryNews.setNewsMatter("您与" + CreatedTime + "发起的" + auditflowType + "审批被驳回,请知悉。");

        // 驳回离职后发消息给申请人
        News QuitNews = new News();
        QuitNews.setNewsTitle(auditflowType + "驳回:");
        QuitNews.setStaffId(satffNO.get(0).getStaffId());
        QuitNews.setNewsMatter("您与" + CreatedTime + "发起的" + auditflowType + "审批被驳回,请知悉。");

        // 驳回加班后发消息给申请人
        News overtimeNews = new News();
        overtimeNews.setNewsTitle(auditflowType + "驳回:");
        overtimeNews.setStaffId(satffNO.get(0).getStaffId());
        overtimeNews.setNewsMatter("您与" + CreatedTime + "发起的" + auditflowType + "审批被驳回,请知悉。");

        // 驳回补打卡后发消息给申请人
        News CardNews = new News();
        CardNews.setNewsTitle(auditflowType + "驳回:");
        CardNews.setStaffId(satffNO.get(0).getStaffId());
        CardNews.setNewsMatter("您与" + CreatedTime + "发起的" + auditflowType + "审批被驳回,请知悉。");

        // 驳回出差后发消息给申请人
        News TravelNews = new News();
        TravelNews.setNewsTitle(auditflowType + "驳回:");
        TravelNews.setStaffId(satffNO.get(0).getStaffId());
        TravelNews.setNewsMatter("您与" + CreatedTime + "发起的" + auditflowType + "审批被驳回,请知悉。");

        // 驳回请假后发消息给申请人
        News LeaveNews = new News();
        LeaveNews.setNewsTitle(auditflowType + "驳回:");
        LeaveNews.setStaffId(satffNO.get(0).getStaffId());
        LeaveNews.setNewsMatter("您与" + CreatedTime + "发起的" + auditflowType + "审批被驳回,请知悉。");
        System.out.println(auditflowType);
        // 如果第二个审批人不为空 并且 第三个审批人也不为空
        if (auditflowdetailId2 != null && auditflowdetailId3 != null) {
            // 驳回第一个审批明细记录
            final var i = auditflowdetailMapper.updateById(auditflowdetail);
            QueryWrapper<Auditflowdetail> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("auditflowdetail_Id", auditflowdetailId2);
            // 驳回第二个审批明细记录
            final var i1 = auditflowdetailMapper.rejectApprovalState(queryWrapper);
            QueryWrapper<Auditflowdetail> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("auditflowdetail_Id", auditflowdetailId3);
            // 驳回第三个审批明细记录
            final var i2 = auditflowdetailMapper.rejectApprovalState2(queryWrapper1);
            QueryWrapper<Auditflow> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("auditflow_Id", auditflowId);
            final var i3 = auditflowMapper.rejectApprovalState(queryWrapper2);
            // 如果以上操作都成功，则根据审批类型去添加消息表
            if (i == 1 && i1 == 1 && i2 == 1 && i3 == 1) {
                if ("转正".equals(auditflowType)) {
                    final var insert = newsMapper.insert(workerNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("调动".equals(auditflowType)) {
                    final var insert = newsMapper.insert(TransferNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("调薪".equals(auditflowType)) {
                    final var insert = newsMapper.insert(SalaryNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("离职".equals(auditflowType)) {
                    final var insert = newsMapper.insert(QuitNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("加班".equals(auditflowType)) {
                    final var insert = newsMapper.insert(overtimeNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("补打卡".equals(auditflowType)) {
                    final var insert = newsMapper.insert(CardNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("出差".equals(auditflowType)) {
                    final var insert = newsMapper.insert(TravelNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("请假".equals(auditflowType)) {
                    final var insert = newsMapper.insert(LeaveNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else {
                    throw new ArithmeticException("999");
                }
            } else {
                throw new ArithmeticException("999");
            }
            // 如果第二个审批人和第三个审批人都为空 则代表目前是最后一个审批人
        } else if (auditflowdetailId2 == null && auditflowdetailId3 == null) {
            // 驳回第一个审批明细记录
            final var i = auditflowdetailMapper.updateById(auditflowdetail);
            QueryWrapper<Auditflow> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("auditflow_Id", auditflowId);
            final var i1 = auditflowMapper.rejectApprovalState(queryWrapper2);
            // 如果以上操作都成功，则根据审批类型去添加消息表
            if (i == 1 && i1 == 1) {
                if ("转正".equals(auditflowType)) {
                    final var insert = newsMapper.insert(workerNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("调动".equals(auditflowType)) {
                    final var insert = newsMapper.insert(TransferNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("调薪".equals(auditflowType)) {
                    final var insert = newsMapper.insert(SalaryNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("离职".equals(auditflowType)) {
                    final var insert = newsMapper.insert(QuitNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("加班".equals(auditflowType)) {
                    final var insert = newsMapper.insert(overtimeNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("补打卡".equals(auditflowType)) {
                    final var insert = newsMapper.insert(CardNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("出差".equals(auditflowType)) {
                    final var insert = newsMapper.insert(TravelNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("请假".equals(auditflowType)) {
                    final var insert = newsMapper.insert(LeaveNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else {
                    throw new ArithmeticException("999");
                }
            } else {
                throw new ArithmeticException("999");
            }
            // 如果其中一个审批人为空，则代表是目前是第二个审批人
        } else if (auditflowdetailId2 == null || auditflowdetailId3 == null) {
            // 驳回第一个审批明细记录
            final var i = auditflowdetailMapper.updateById(auditflowdetail);
            QueryWrapper<Auditflowdetail> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("auditflowdetail_Id", auditflowdetailId2);
            final var i1 = auditflowdetailMapper.rejectApprovalState(queryWrapper);
            QueryWrapper<Auditflow> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("auditflow_Id", auditflowId);
            final var i2 = auditflowMapper.rejectApprovalState(queryWrapper2);
            // 如果以上操作都成功，则根据审批类型去添加消息表
            if (i == 1 && i1 == 1 && i2 == 1) {
                if ("转正".equals(auditflowType)) {
                    final var insert = newsMapper.insert(workerNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("调动".equals(auditflowType)) {
                    final var insert = newsMapper.insert(TransferNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("调薪".equals(auditflowType)) {
                    final var insert = newsMapper.insert(SalaryNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("离职".equals(auditflowType)) {
                    final var insert = newsMapper.insert(QuitNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("加班".equals(auditflowType)) {
                    final var insert = newsMapper.insert(overtimeNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("补打卡".equals(auditflowType)) {
                    final var insert = newsMapper.insert(CardNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("出差".equals(auditflowType)) {
                    final var insert = newsMapper.insert(TravelNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else if ("请假".equals(auditflowType)) {
                    final var insert = newsMapper.insert(LeaveNews);
                    if (insert == 1) {
                        return 1;
                    } else {
                        throw new ArithmeticException("999");
                    }
                } else {
                    throw new ArithmeticException("999");
                }
            } else {
                throw new ArithmeticException("999");
            }
        } else {
            throw new ArithmeticException("999");
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

    /**
     * 根据员工名称是否有加班记录
     *
     * @param overtimeaskVo
     * @return
     */
    @Override
    public List<OvertimeaskVo> selectOvertimeExamine(OvertimeaskVo overtimeaskVo) {
        QueryWrapper<OvertimeaskVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("c.STAFF_NAME", overtimeaskVo.getStaffName());
        queryWrapper.eq("a.IS_DELETED", 0);
        queryWrapper.eq("b.IS_DELETED", 0);
        queryWrapper.eq("c.IS_DELETED", 0);
        final var i = ovimeaskMapper.selectOvertimeExamine(queryWrapper);
        return i;
    }

    /**
     * 添加加班 添加三个审批人
     *
     * @param overtimeaskVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int submitToOvertime3(OvertimeaskVo overtimeaskVo) throws ArithmeticException{
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(overtimeaskVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(overtimeaskVo.getAuditflowType());
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
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(overtimeaskVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2 = new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(overtimeaskVo.getStaffName2());
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3 = new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(overtimeaskVo.getStaffName3());
            final var i3 = auditflowdetailMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加加班表
            if (i1 == 1 && i2 == 1 && i3 == 1) {
                Overtimeask overtimeask = new Overtimeask();
                // 加班表-审批编号
                overtimeask.setAuditflowId(auditflow1.getAuditFlowId());
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
                overtimeask.setOvertimeaskTotalDate(overtimeaskVo.getOvertimeaskTotalDate());
                final val i4 = ovimeaskMapper.insert(overtimeask);
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
     * 添加加班 添加两个审批人
     *
     * @param overtimeaskVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int submitToOvertime2(OvertimeaskVo overtimeaskVo) throws ArithmeticException{
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(overtimeaskVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(overtimeaskVo.getAuditflowType());
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
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(overtimeaskVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2 = new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(overtimeaskVo.getStaffName2());
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);

            // 如果三个审批明细表添加成功，则添加加班表
            if (i1 == 1 && i2 == 1) {
                Overtimeask overtimeask = new Overtimeask();
                // 加班表-审批编号
                overtimeask.setAuditflowId(auditflow1.getAuditFlowId());
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
                overtimeask.setOvertimeaskTotalDate(overtimeaskVo.getOvertimeaskTotalDate());
                final val i4 = ovimeaskMapper.insert(overtimeask);
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
     * 添加加班 添加一个审批人
     *
     * @param overtimeaskVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer submitToOvertime1(OvertimeaskVo overtimeaskVo) throws ArithmeticException{
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditFlowTitle(overtimeaskVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditFlowType(overtimeaskVo.getAuditflowType());
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
            auditflowdetail1.setAuditflowId(auditflow1.getAuditFlowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(overtimeaskVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);

            // 如果三个审批明细表添加成功，则添加加班表
            Overtimeask overtimeask = new Overtimeask();
            // 加班表-审批编号
            overtimeask.setAuditflowId(auditflow1.getAuditFlowId());
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
            overtimeask.setOvertimeaskTotalDate(overtimeaskVo.getOvertimeaskTotalDate());
            final val i4 = ovimeaskMapper.insert(overtimeask);
            if (i1 == 1 && i4 == 1) {
                return 1111;
            } else {
                throw new ArithmeticException("0");
            }
        } else {
            throw new ArithmeticException("0");
        }
    }

    /**
     * 查询部门职位
     *
     * @param staff
     * @return
     */
    @Override
    public String inquirePosition(Staff staff) {
        // 先根据员工编号查询员工数据
        final var staff1 = staffMapper.selectById(staff);
        // 取到员工部门职位编号
        final var deptPostId = staff1.getDeptPostId();
        // 再根据部门职位编号查询部门职位数据
        final var deptPost = deptPostMapper.selectById(deptPostId);
        return deptPost.getPostName();
    }

    /**
     * 撤销审批
     *
     * @param auditflow
     * @return
     */
    @Override
    public Integer revocation(Auditflow auditflow) {
        // 获取审批主表编号
        final val auditflowId = auditflow.getAuditFlowId();
        // 根据审批编号去查询对应的审批明细编号
        QueryWrapper<Auditflowdetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("AUDITFLOW_ID", auditflowId);
        final val auditflowdetails = auditflowdetailMapper.selectList(queryWrapper);
        var i = 0;
        for (i = 0; i < auditflowdetails.size(); i++) {
            // 如果审批明细编号1不为空则去修改其状态
            if (auditflowdetails.get(i).getAuditflowdetailId() != null) {
                Auditflowdetail auditflowdetail1 = new Auditflowdetail();
                auditflowdetail1.setAuditflowdetaiState(4);
                auditflowdetail1.setAuditflowdetailId(auditflowdetails.get(i).getAuditflowdetailId());
                auditflowdetailMapper.updateById(auditflowdetail1);
            }
        }
        // 修改完审批明细表状态则修改审批主表状态(撤销)
        Auditflow auditflow1 = new Auditflow();
        auditflow1.setAuditFlowId(auditflowId);
        auditflow1.setAuditFlowState(3L);
        final var i1 = auditflowMapper.updateById(auditflow1);
        if (i1 == 1) {
            return 1;
        } else {
            return 999;
        }

    }

    /**
     * 查询调薪审批详情
     *
     * @param salaryVo
     * @return
     */
    @Override
    public List<SalaryVo> selectSalaryDetails(SalaryVo salaryVo) {
        // 取出审批主表编号
        final var auditflowId = salaryVo.getAuditflowId();
        // 申请人
        final var staffName = salaryVo.getStaffName();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("AUDITFLOW_ID", auditflowId);
        queryWrapper.eq("STAFF_NAME", staffName);
        return auditflowMapper.selectSalaryDetails(queryWrapper);
    }

    /**
     * 查询当天的加班审批记录
     *
     * @param auditflow
     * @return
     */
    @Override
    public List<Auditflow> selectTodayOverTimeExamine(Auditflow auditflow) {
        QueryWrapper<Auditflow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("STAFF_NAME", auditflow.getStaffName());
        queryWrapper.eq("AUDITFLOW_TYPE", auditflow.getAuditFlowType());
        // 当前日期转格式
        Date now = new Date();
        LocalDate localDate = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date newDate = java.sql.Date.valueOf(localDate);
        // 再转成string型
        java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(newDate);
        queryWrapper.apply("TO_CHAR(CREATED_TIME,'yyyy-MM-dd') like {0}", date);
        return auditflowMapper.selectList(queryWrapper);
    }

    /**
     * 查询当天的加班审批记录
     *
     * @param leave
     * @return
     */
    @Override
    public List<Leave> inquireUnderwayLeave(Leave leave) {
        QueryWrapper<Leave> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("STAFF_NAME", leave.getStaffName());
        queryWrapper.eq("LEAVE_CONDITION", 1);
        return leaveMapper.selectList(queryWrapper);
    }

    /**
     * 查询当前员工是否有正在进行中的加班
     *
     * @param overtimeask
     * @return
     */
    @Override
    public List<Overtimeask> inquireUnderwayOverTime(Overtimeask overtimeask) {
        QueryWrapper<Overtimeask> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("STAFF_NAME", overtimeask.getStaffName());
        queryWrapper.eq("OVERTIMEASK_CONDITION", 1);
        return ovimeaskMapper.selectList(queryWrapper);
    }

    /**
     * 查询当前员工是否有正在进行中的出差
     *
     * @param travel
     * @return
     */
    @Override
    public List<Travel> inquireUnderwayTravel(Travel travel) {
        QueryWrapper<Travel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("STAFF_NAME", travel.getStaffName());
        queryWrapper.eq("TRAVEL_CONDITION", 1);
        return travelMapper.selectList(queryWrapper);
    }
}
