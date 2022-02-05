package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Card;
import com.trkj.framework.entity.mybatisplus.Travel;
import com.trkj.framework.mybatisplus.mapper.ReissueCardManager;
import com.trkj.framework.mybatisplus.service.ReissueCardRecordService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReissueCardRecordlmpl implements ReissueCardRecordService {
    @Autowired
    private ReissueCardManager reissueCardManager;

    @Override
    public IPage<Card> selectReissueCardRecordAll(Card card) {
        Page<Card> page = new Page<>(card.getCurrentPage(), card.getPagesize());
        final var staffName = card.getStaffName();
        QueryWrapper<Card> queryWrapper = new QueryWrapper<>();
        if (card.getStartTime() != null || card.getEndTime() != null) {
            //根据开始日期结束日期范围查询
            queryWrapper.between("CREATED_TIME", card.getStartTime(), card.getEndTime());
        }
        queryWrapper.eq("STAFF_NAME",staffName);
        return reissueCardManager.selectPage(page,queryWrapper);
    }

    @Override
    public Integer deleteCard(Card card) {
        final var cardId = card.getCardId();
        Card card1 = new Card();
        card1.setIsDeleted(1L);
        card1.setCardId(cardId);
        card1.setUpdatedTime(new Date());
        return reissueCardManager.deleteById(card1);
    }
}
