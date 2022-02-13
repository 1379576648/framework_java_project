package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.entity.mybatisplus.ClockRecord;

import java.util.List;

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

    /**
     * 导入打卡记录
     * @param list
     * @return
     */
    Integer importCardRecord(List<ClockRecord> list);

    /**
     * 获取Excel表中的数据去数据库中查有无相同数据
     * @param objects
     * @return
     */
    Integer selcetCardRecord(List<Object> objects);


}
