package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Auditflow;
import com.trkj.framework.entity.mybatisplus.Auditflowdetail;
import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.vo.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 审批主表 服务类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-27
 */
public interface AuditflowService {

    /**
     *  根据审批类型的加班/审批人查询待处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectAuditflowoneAll(Auditflowone auditflowone);

    /**
     *  根据审批类型的加班/审批人查询已处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectEnddAuditflow(Auditflowone auditflowone);

    /**
     * 根据审批类型的加班/审批人查询已处理的详情信息
     * @param auditflowDetailsVo
     * @return
     */
    List<AuditflowDetailsVo> selectDetailsAuditflow(AuditflowDetailsVo auditflowDetailsVo);

    /**
     * 根据员工名称查询员工状态
     * @param staff
     * @return
     */
    Integer selectStaffState(Staff staff);

    /**
     * 根据审批明细表ID修改其状态 通过
     * @param
     * @return
     */
    int updateApprovalState(Auditflowdetail auditflowdetail);

    /**
     * 根据审批明细表ID修改其状态 驳回
     * @param
     * @return
     */
    int rejectApprovalState(Auditflowdetail auditflowdetail);

    /**
     *根据审批编号查询对应的审批明细表编号
     * @param auditflowdetail
     * @return
     */
    List<Auditflowdetail> queryDetail(Auditflowdetail auditflowdetail);

    /**
     * 根据员工名称是否有加班记录
     * @param overtimeaskVo
     * @return
     */
    @PostMapping("/selectOvertimeExamine")
    List<OvertimeaskVo> selectOvertimeExamine(OvertimeaskVo overtimeaskVo);

    /**
     * 添加加班 添加三个审批人
     * @param overtimeaskVo
     * @return
     */
    int submitToOvertime3(OvertimeaskVo overtimeaskVo);

    /**
     * 添加加班 添加两个审批人
     * @param overtimeaskVo
     * @return
     */
    int submitToOvertime2(OvertimeaskVo overtimeaskVo);

    /**
     * 添加加班 添加两个审批人
     * @param overtimeaskVo
     * @return
     */
    Integer submitToOvertime1(OvertimeaskVo overtimeaskVo);

    /**
     * 根据员工编号查询部门职位
     * @param staff
     * @return
     */
    String inquirePosition(Staff staff);

    /**
     * 撤销审批
     * @param auditflow
     * @return
     */
    Integer revocation(Auditflow auditflow);

    /**
     * 查询调薪审批详情
     * @param salaryVo
     * @return
     */
    List<SalaryVo>selectSalaryDetails(SalaryVo salaryVo);

    /**
     * 查询当天的加班审批记录
     * @param auditflow
     * @return
     */
    List<Auditflow>selectTodayOverTimeExamine(Auditflow auditflow);
}
