package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.CardDetailsVo;
import com.trkj.framework.vo.LeaveDetailsVo;

import java.util.List;

/**
 * <p>
 * 补打卡表 服务类
 * </p>
 *
 * @author 里予
 * @since 2022-1-2
 */
public interface CardService {
    /**
     *  根据审批类型的加班/审批人查询待处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectCardAll(Auditflowone auditflowone);

    /**
     *  根据审批类型的加班/审批人查询已处理的审批
     * @param
     * @return
     */
    IPage<Auditflowone> selectEndCardAll(Auditflowone auditflowone);

    /**
     * 根据审批类型的加班/审批人查询已处理的详情信息
     * @param
     * @return
     */
    List<CardDetailsVo> selectDetailsCards(CardDetailsVo cardDetailsVo);
}
