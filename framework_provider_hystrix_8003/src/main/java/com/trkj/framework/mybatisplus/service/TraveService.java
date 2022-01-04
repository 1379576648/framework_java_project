package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.LeaveDetailsVo;
import com.trkj.framework.vo.TravelDetailsVo;

import java.util.List;

/**
 * <p>
 * 出差表 服务类
 * </p>
 *
 * @author 里予
 * @since 2022-1-2
 */
public interface TraveService {
    /**
     *  根据审批类型的出差/审批人查询待处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectTravelAll(Auditflowone auditflowone);

    /**
     *  根据审批类型的出差/审批人查询已处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectEndTravelAll(Auditflowone auditflowone);

    /**
     * 根据审批类型的出差/审批人查询已处理的详情信息
     * @param
     * @return
     */
    List<TravelDetailsVo> selectDetailsTrave(TravelDetailsVo traveService);
}
