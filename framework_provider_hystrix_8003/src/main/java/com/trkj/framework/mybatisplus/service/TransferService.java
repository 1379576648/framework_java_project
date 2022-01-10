package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.TransferDetailsVo;
import java.util.List;

public interface TransferService {
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
}
