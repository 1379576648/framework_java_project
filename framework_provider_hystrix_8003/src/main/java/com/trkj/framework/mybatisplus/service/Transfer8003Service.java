package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.vo.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface Transfer8003Service {
    /**
     *  根据审批类型的调动/审批人查询待处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectTransferAll(Auditflowone auditflowone);

    /**
     *  根据审批类型的调动/审批人查询已处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectEndTransferAll(Auditflowone auditflowone);

    /**
     * 根据审批类型的调动/审批人查询已处理的详情信息
     * @param
     * @return
     */
    List<TransferDetailsVo> selectDetailsTransfer(TransferDetailsVo transferDetailsVo);

    /**
     * 点击异动查询所有部门
     * @param
     * @return
     */
    List<Dept>selectDeptAll();

    /**
     * 根据员工名称是否有异动记录
     * @param transferVo
     * @return
     */
    Integer selectTransferRecord(Transfer8003Vo transferVo);

    /**
     * 添加调动 添加三个审批人
     * @param transferVo
     * @return
     */
    int SubmitTransfer3(Transfer8003Vo transferVo);

    /**
     * 添加调动 添加两个审批人
     * @param transferVo
     * @return
     */
    int SubmitTransfer2(Transfer8003Vo transferVo);

}
