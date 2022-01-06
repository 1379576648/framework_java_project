package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.TravelDetailsVo;
import com.trkj.framework.vo.WorkerDetaIsVo;

import java.util.List;

/**
 * 转正表 服务类
 *
 * @author 里予
 * @since 2022-1-2
 */
public interface WorkerService {
    /**
     *  根据审批类型的转正/审批人查询待处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectWorkerlAll(Auditflowone auditflowone);

    /**
     *  根据审批类型的转正/审批人查询已处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectEndWorkerlAll(Auditflowone auditflowone);

    /**
     * 根据审批类型的转正/审批人查询已处理的详情信息
     * @param
     * @return
     */
    List<WorkerDetaIsVo> selectDetailsWorker(WorkerDetaIsVo workerDetaIsVo);
}
