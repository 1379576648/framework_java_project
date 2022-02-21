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
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteClock(ClockRecord clockRecord) throws ArithmeticException{
        final var clockRecordId = clockRecord.getClockRecordId();
        ClockRecord cardRecord = new ClockRecord();
        cardRecord.setIsDeleted(1L);
        cardRecord.setClockRecordId(clockRecordId);
        cardRecord.setUpdatedTime(new Date());
        final var i = cardRecordMapper.deleteById(cardRecord);
        if (i == 1){
            return 1;
        }else {
            throw new ArithmeticException("删除失败");
        }
    }

    /**
     * 导入打卡记录数据
     *
     * @param list
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer importCardRecord(List<ClockRecord> list) {
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

    /**
     * 获取Excel表中的数据去数据库中查有无相同数据
     * @param objects
     * @return
     */
    @Override
    public Integer selcetCardRecord(List<Object> objects) {
        QueryWrapper<ClockRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("STAFF_NAME", objects.get(0).toString());
        queryWrapper.eq("DEPT_NAME", objects.get(1).toString());
        queryWrapper.apply("TO_CHAR(MORN_CLOCK,'yyyy-mm-dd') = {0}",objects.get(2).toString().substring(0,10));
        queryWrapper.apply("TO_CHAR(AFTERNOON_CLOCK,'yyyy-mm-dd') = {0}",objects.get(3).toString().substring(0,10));
        return cardRecordMapper.selectCount(queryWrapper);
    }

    /**
     * 根据员工名称查询打卡记录2
     *
     * @param
     * @return
     */
    @Override
    public List<ClockRecord> selectCardRecordAllByName(ClockRecord clockRecord) {
        QueryWrapper<ClockRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("STAFF_NAME", clockRecord.getStaffName());
        return cardRecordMapper.selectList(queryWrapper);
    }
}
