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
        queryWrapper.eq("STAFF_NAME",staffName);
        return cardRecordMapper.selectCardRecordAll(page,queryWrapper);
    }
}
