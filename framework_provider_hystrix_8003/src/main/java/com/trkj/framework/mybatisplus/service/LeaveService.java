package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Card;
import com.trkj.framework.entity.mybatisplus.Leave;
import com.trkj.framework.vo.*;
import org.springframework.web.bind.annotation.PostMapping;

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
     * 根据审批类型的加班/审批人查询待处理的审批
     *
     * @param
     * @return
     */
    IPage<Auditflowone> selectLeaveAll(Auditflowone auditflowone);

    /**
     * 根据审批类型的加班/审批人查询已处理的审批
     *
     * @param
     * @return
     */
    IPage<Auditflowone> selectEndLeaveAll(Auditflowone auditflowone);

    /**
     * 根据审批类型的加班/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    List<LeaveDetailsVo> selectDetailsLeaves(LeaveDetailsVo leaveDetailsVo);

    /**
     * 根据员工名称是否有补打卡记录
     *
     * @param leaveDetailsVo
     * @return
     */
    @PostMapping("/selectLeaveExamine")
    List<LeaveDetailsVo> selectLeaveExamine(LeaveDetailsVo leaveDetailsVo);

    /**
     * 添加请假 添加三个审批人
     *
     * @param leaveVo
     * @return
     */
    int submitToAskForLeave3(LeaveVo leaveVo) throws ArithmeticException;

    /**
     * 添加请假 添加两个审批人
     *
     * @param leaveVo
     * @return
     */
    int submitToAskForLeave2(LeaveVo leaveVo) throws ArithmeticException;

    /**
     * 添加请假 添加一个审批人
     *
     * @param leaveVo
     * @return
     */
    Integer submitToAskForLeave1(LeaveVo leaveVo) throws ArithmeticException;
}
