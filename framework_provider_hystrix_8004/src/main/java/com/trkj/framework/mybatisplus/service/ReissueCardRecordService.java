package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Card;

public interface ReissueCardRecordService {
    /**
     * 根据员工名称查询补打卡记录
     * @param card
     * @return
     */
    IPage<Card> selectReissueCardRecordAll(Card card);

    /**
     * 删除补打卡记录
     * @param card
     * @return
     */
    Integer deleteCard(Card card);
}
