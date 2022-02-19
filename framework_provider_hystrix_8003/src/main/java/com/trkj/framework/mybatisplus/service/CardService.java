package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Card;
import com.trkj.framework.vo.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 补打卡表 服务类
 *
 * @author 里予
 * @since 2022-1-2
 */
public interface CardService {
    /**
     * 根据审批类型的补打卡/审批人查询待处理的审批
     *
     * @param
     * @return
     */
    IPage<Auditflowone> selectCardAll(Auditflowone auditflowone);

    /**
     * 根据审批类型的补打卡/审批人查询已处理的审批
     *
     * @param
     * @return
     */
    IPage<Auditflowone> selectEndCardAll(Auditflowone auditflowone);

    /**
     * 根据审批类型的补打卡/审批人查询已处理的详情信息
     *
     * @param
     * @return
     */
    List<CardDetailsVo> selectDetailsCards(CardDetailsVo cardDetailsVo);

    /**
     * 根据员工名称是否有补打卡记录
     *
     * @param cardDetailsVo
     * @return
     */
    List<CardDetailsVo> selectCardExamine(CardDetailsVo cardDetailsVo);

    /**
     * 添加补打卡 添加三个审批人
     *
     * @param cardVo
     * @return
     */
    int submitToCard3(CardVo cardVo) throws ArithmeticException;

    /**
     * 添加补打卡 添加两个审批人
     *
     * @param cardVo
     * @return
     */
    int submitToCard2(CardVo cardVo) throws ArithmeticException;

    /**
     * 添加补打卡 添加一个审批人
     *
     * @param cardVo
     * @return
     */
    Integer submitToCard1(CardVo cardVo) throws ArithmeticException;
}
