package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Auditflow;
import com.trkj.framework.entity.mybatisplus.Auditflowdetail;
import com.trkj.framework.entity.mybatisplus.Card;
import com.trkj.framework.entity.mybatisplus.Overtimeask;
import com.trkj.framework.mybatisplus.mapper.AuditflowMapper;
import com.trkj.framework.mybatisplus.mapper.AuditflowdetailMapper;
import com.trkj.framework.mybatisplus.mapper.AuditflowoneMapper;
import com.trkj.framework.mybatisplus.mapper.CardMapper;
import com.trkj.framework.mybatisplus.service.CardService;
import com.trkj.framework.vo.*;
import lombok.val;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardServicelmpl implements CardService {
    @Autowired
    private AuditflowoneMapper auditflowoneMapper;
    @Autowired
    private CardMapper cardMapper;
    @Autowired
    private AuditflowMapper auditflowMapper;
    @Autowired
    private AuditflowdetailMapper auditflowdetailMapper;

    @Override
    public IPage<Auditflowone> selectCardAll(Auditflowone auditflowone) {
        Page<Auditflowone> page = new Page<>(auditflowone.getCurrentPage(), auditflowone.getPagesize());
        QueryWrapper<Auditflowone> queryWrapper = new QueryWrapper<>();
        if (auditflowone.getStaffName1() != null) {
            //根据申请人名称模糊查询
            queryWrapper.like("a.STAFF_NAME", auditflowone.getStaffName1());
        }
        if (auditflowone.getStartTime() != null || auditflowone.getEndTime() != null) {
            //根据开始日期结束日期范围查询
            queryWrapper.between("a.CREATED_TIME", auditflowone.getStartTime(), auditflowone.getEndTime());
        }
        queryWrapper.eq("b.STAFF_NAME", auditflowone.getStaffName2());
        queryWrapper.eq("b.AUDITFLOWDETAI_STATE", 1);
        queryWrapper.eq("a.AUDITFLOW_TYPE", "补打卡");
        return auditflowoneMapper.selectAuditflowoneAll(page, queryWrapper);
    }

    @Override
    public IPage<Auditflowone> selectEndCardAll(Auditflowone auditflowone) {
        Page<Auditflowone> page = new Page<>(auditflowone.getCurrentPage(), auditflowone.getPagesize());
        QueryWrapper<Auditflowone> queryWrapper = new QueryWrapper<>();
        if (auditflowone.getStaffName1() != null) {
            //用户名称模糊查询
            queryWrapper.like("a.STAFF_NAME", auditflowone.getStaffName1());
        }
        if (auditflowone.getStartTime() != null || auditflowone.getEndTime() != null) {
            //根据开始日期结束日期范围查询
            queryWrapper.between("a.CREATED_TIME", auditflowone.getStartTime(), auditflowone.getEndTime());
        }
        // eq 等于 ne 不等于
        queryWrapper.ne("b.AUDITFLOWDETAI_STATE", 1);
        queryWrapper.ne("b.AUDITFLOWDETAI_STATE", 0);
        queryWrapper.eq("a.AUDITFLOW_TYPE", "补打卡");
        queryWrapper.eq("b.STAFF_NAME", auditflowone.getStaffName2());
        return auditflowoneMapper.selectEnddAuditflow(page, queryWrapper);
    }

    @Override
    public List<CardDetailsVo> selectDetailsCards(CardDetailsVo cardDetailsVo) {
        QueryWrapper<CardDetailsVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("b.STAFF_NAME", cardDetailsVo.getStaffName2());
        queryWrapper.eq("a.AUDITFLOW_ID", cardDetailsVo.getAuditflowId());
        queryWrapper.eq("c.STAFF_NAME", cardDetailsVo.getStaffName1());
        return auditflowoneMapper.selectDetailsCards(queryWrapper);
    }

    @Override
    public List<CardDetailsVo> selectCardExamine(CardDetailsVo cardDetailsVo) {
        QueryWrapper<CardDetailsVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("c.STAFF_NAME", cardDetailsVo.getStaffName1());
        queryWrapper.eq("a.IS_DELETED", 0);
        queryWrapper.eq("b.IS_DELETED", 0);
        queryWrapper.eq("c.IS_DELETED", 0);
        final var i = cardMapper.selectCardExamine(queryWrapper);
        return i;
    }

    /**
     * 添加补打卡 添加三个审批人
     *
     * @param cardVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int submitToCard3(CardVo cardVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditflowTitle(cardVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditflowType(cardVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(cardVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", cardVo.getStaffName())
                    .eq("AUDITFLOW_TITLE", cardVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(cardVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);

            // 添加审批明细表2
            Auditflowdetail auditflowdetail2 = new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(cardVo.getStaffName2());
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);

            // 添加审批明细表3
            Auditflowdetail auditflowdetail3 = new Auditflowdetail();
            // 审批明细表3-审批编号
            auditflowdetail3.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表3-审批人
            auditflowdetail3.setStaffName(cardVo.getStaffName3());
            final var i3 = auditflowdetailMapper.insert(auditflowdetail3);
            // 如果三个审批明细表添加成功，则添加补打卡表
            if (i1 == 1 && i2 == 1 && i3 == 1) {
                Card card = new Card();
                // 补打卡表-审批编号
                card.setAuditflowId(auditflow1.getAuditflowId());
                // 补打卡表-员工名称
                card.setStaffName(cardVo.getStaffName());
                // 补打卡表-补打卡类型
                card.setCardType(cardVo.getCardType());
                // 补打卡表-补打卡时间
                card.setCardDate(cardVo.getCardDate());
                // 补打卡表-补打卡备注
                card.setCardRemarks(cardVo.getCardRemarks());
                final val i4 = cardMapper.insert(card);
                if (i4 == 1) {
                    return 1111;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    /**
     * 添加补打卡 添加两个审批人
     *
     * @param cardVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int submitToCard2(CardVo cardVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditflowTitle(cardVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditflowType(cardVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(cardVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        if (i == 1) {
            // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
            Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                    .eq("STAFF_NAME", cardVo.getStaffName())
                    .eq("AUDITFLOW_TITLE", cardVo.getAuditflowTitle())
                    .eq("IS_DELETED", 0));
            // 添加审批明细表1
            Auditflowdetail auditflowdetail1 = new Auditflowdetail();
            // 审批明细表1-审批编号
            auditflowdetail1.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表1-审批人
            auditflowdetail1.setStaffName(cardVo.getStaffName1());
            // 审批明细表1-审核状态-待我审批
            auditflowdetail1.setAuditflowdetaiState(1);
            final var i1 = auditflowdetailMapper.insert(auditflowdetail1);
            // 添加审批明细表2
            Auditflowdetail auditflowdetail2 = new Auditflowdetail();
            // 审批明细表2-审批编号
            auditflowdetail2.setAuditflowId(auditflow1.getAuditflowId());
            // 审批明细表2-审批人
            auditflowdetail2.setStaffName(cardVo.getStaffName2());
            final var i2 = auditflowdetailMapper.insert(auditflowdetail2);
            // 如果三个审批明细表添加成功，则添加补打卡表
            if (i1 == 1 && i2 == 1) {
                Card card = new Card();
                // 补打卡表-审批编号
                card.setAuditflowId(auditflow1.getAuditflowId());
                // 补打卡表-员工名称
                card.setStaffName(cardVo.getStaffName());
                // 补打卡表-补打卡类型
                card.setCardType(cardVo.getCardType());
                // 补打卡表-补打卡时间
                card.setCardDate(cardVo.getCardDate());
                // 补打卡表-补打卡备注
                card.setCardRemarks(cardVo.getCardRemarks());
                final val i4 = cardMapper.insert(card);
                if (i4 == 1) {
                    return 1111;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    /**
     * 添加补打卡 添加一个审批人
     *
     * @param cardVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer submitToCard1(CardVo cardVo) {
        // 添加审批主表
        Auditflow auditflow = new Auditflow();
        //审批主表-标题
        auditflow.setAuditflowTitle(cardVo.getAuditflowTitle());
        // 审批主表-审批类型
        auditflow.setAuditflowType(cardVo.getAuditflowType());
        // 审批主表-申请人
        auditflow.setStaffName(cardVo.getStaffName());
        final var i = auditflowMapper.insert(auditflow);
        // 如果添加审批主表添加成功，则再去添加审批明细表
        // 根据员工名称（申请人）以及审批标题 查询已添加的审批主表编号
        Auditflow auditflow1 = auditflowMapper.selectOne(new QueryWrapper<Auditflow>()
                .eq("STAFF_NAME", cardVo.getStaffName())
                .eq("AUDITFLOW_TITLE", cardVo.getAuditflowTitle())
                .eq("IS_DELETED", 0));
        // 添加审批明细表1
        Auditflowdetail auditflowdetail1 = new Auditflowdetail();
        // 审批明细表1-审批编号
        auditflowdetail1.setAuditflowId(auditflow1.getAuditflowId());
        // 审批明细表1-审批人
        auditflowdetail1.setStaffName(cardVo.getStaffName2());
        // 审批明细表1-审核状态-待我审批
        auditflowdetail1.setAuditflowdetaiState(1);
        final var i1 = auditflowdetailMapper.insert(auditflowdetail1);
        // 如果三个审批明细表添加成功，则添加补打卡表
        Card card = new Card();
        // 补打卡表-审批编号
        card.setAuditflowId(auditflow1.getAuditflowId());
        // 补打卡表-员工名称
        card.setStaffName(cardVo.getStaffName());
        // 补打卡表-补打卡类型
        card.setCardType(cardVo.getCardType());
        // 补打卡表-补打卡时间
        card.setCardDate(cardVo.getCardDate());
        // 补打卡表-补打卡备注
        card.setCardRemarks(cardVo.getCardRemarks());
        final val i4 = cardMapper.insert(card);
        if (i == 1 && i1 == 1 && i4 == 1) {
            return 1111;
        } else {
            return 0;
        }
    }

}
