package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Auditflowdetail;
import com.trkj.framework.entity.mybatisplus.RegisterLog;
import com.trkj.framework.vo.AuditflowDetailsVo;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.OvertimeaskVo;
import com.trkj.framework.vo.WorkerVo;
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
    Integer selectOvertimeExamine(OvertimeaskVo overtimeaskVo);

}
