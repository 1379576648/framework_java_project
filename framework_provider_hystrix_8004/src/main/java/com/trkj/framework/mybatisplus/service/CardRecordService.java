package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.ClockRecord;

/**
 * 打卡记录 服务类
 *
 * @author 里予
 * @since 2022-1-29
 */
public interface CardRecordService {

    /**
     * 根据员工名称查询打卡记录
     * @param cardRecord
     * @return
     */
    IPage<ClockRecord> selectCardRecordAll(ClockRecord cardRecord);

    /**
     * 删除打卡记录
     * @param clockRecord
     * @return
     */
    Integer deleteClock(ClockRecord clockRecord);
}
