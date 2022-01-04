package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.vo.AuditflowDetailsVo;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.LeaveDetailsVo;

import java.util.List;

/**
 * <p>
 * 请假表 服务类
 * </p>
 *
 * @author 里予
 * @since 2022-1-2
 */
public interface LeaveService {
    /**
     *  根据审批类型的加班/审批人查询待处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectLeaveAll(Auditflowone auditflowone);

    /**
     *  根据审批类型的加班/审批人查询已处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectEndLeaveAll(Auditflowone auditflowone);

    /**
     * 根据审批类型的加班/审批人查询已处理的详情信息
     * @param
     * @return
     */
    List<LeaveDetailsVo> selectDetailsLeaves(LeaveDetailsVo leaveDetailsVo);
}
