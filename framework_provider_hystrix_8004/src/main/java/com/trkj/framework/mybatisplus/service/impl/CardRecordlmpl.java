package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.mybatisplus.mapper.CardRecordMapper;
import com.trkj.framework.mybatisplus.service.CardRecordService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CardRecordlmpl implements CardRecordService {
    @Autowired
    private CardRecordMapper cardRecordMapper;

    /**
     * 根据员工名称查询打卡记录
     * @param cardRecord
     * @return
     */
    @Override
    public IPage<ClockRecord> selectCardRecordAll(ClockRecord cardRecord) {
        Page<ClockRecord> page = new Page<>(cardRecord.getCurrentPage(), cardRecord.getPagesize());
        final var staffName = cardRecord.getStaffName();
        QueryWrapper<ClockRecord> queryWrapper = new QueryWrapper<>();
        if (cardRecord.getStartTime() != null || cardRecord.getEndTime() != null) {
            //根据开始日期结束日期范围查询
            queryWrapper.between("CREATED_TIME", cardRecord.getStartTime(), cardRecord.getEndTime());
        }
        queryWrapper.eq("STAFF_NAME",staffName);
        return cardRecordMapper.selectPage(page,queryWrapper);
    }

    /**
     * 删除打卡记录
     * @param clockRecord
     * @return
     */
    @Override
    public Integer deleteClock(ClockRecord clockRecord) {
        final var clockRecordId = clockRecord.getClockRecordId();
        ClockRecord cardRecord = new ClockRecord();
        cardRecord.setIsDeleted(1L);
        cardRecord.setClockRecordId(clockRecordId);
        cardRecord.setUpdatedTime(new Date());
        return cardRecordMapper.deleteById(cardRecord);
    }
}
