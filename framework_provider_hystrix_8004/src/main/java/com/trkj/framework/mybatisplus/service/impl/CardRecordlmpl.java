package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.mybatisplus.mapper.CardRecordMapper;
import com.trkj.framework.mybatisplus.mapper.StaffMapper;
import com.trkj.framework.mybatisplus.service.CardRecordService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CardRecordlmpl implements CardRecordService {
    @Autowired
    private CardRecordMapper cardRecordMapper;
    @Autowired
    private StaffMapper staffMapper;

    /**
     * 根据员工名称查询打卡记录
     *
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
        queryWrapper.eq("STAFF_NAME", staffName);
        return cardRecordMapper.selectPage(page, queryWrapper);
    }

    /**
     * 删除打卡记录
     *
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

    /**
     * 导入打卡记录数据
     *
     * @param list
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer importCard(List<ClockRecord> list) {
        var insert = "";
        for (int i = 0; i < list.size(); i++) {
            insert = String.valueOf(cardRecordMapper.insert(list.get(i)));
        }
        if ("1".equals(insert)) {
            return 99;
        } else {
            return 66;
        }
    }

    @Override
    public Integer selcetCardRecord(List<Object> objects) {
        QueryWrapper<ClockRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("STAFF_NAME", objects.get(0).toString());
        queryWrapper.eq("DEPT_NAME", objects.get(1).toString());
        System.out.println("111111111111111111111111111111111");
        queryWrapper.apply("TO_CHAR(MORN_CLOCK,'yyyy-mm-dd') = {0}",objects.get(2).toString().substring(0,10));
        queryWrapper.apply("TO_CHAR(AFTERNOON_CLOCK,'yyyy-mm-dd') = {0}",objects.get(3).toString().substring(0,10));
        return cardRecordMapper.selectCount(queryWrapper);
    }
}
