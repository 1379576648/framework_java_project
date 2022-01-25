package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Travel;
import com.trkj.framework.vo.*;

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


    /**
     * 根据员工名称是否有出差记录
     * @param travelDetailsVo
     * @return
     */
    List<TravelDetailsVo> selectEvectionExamine(TravelDetailsVo travelDetailsVo);

    /**
     * 添加出差 添加三个审批人
     * @param travelVo
     * @return
     */
    int submitToTravel3(TravelVo travelVo);

    /**
     * 添加出差 添加两个审批人
     * @param travelVo
     * @return
     */
    int submitToTravel2(TravelVo travelVo);

    /**
     * 添加出差 添加一个审批人
     * @param travelVo
     * @return
     */
    Integer submitToTravel1(TravelVo travelVo);
}
