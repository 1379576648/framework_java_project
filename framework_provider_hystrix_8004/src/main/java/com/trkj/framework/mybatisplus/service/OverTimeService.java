package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Overtimeask;

import java.util.List;

/**
 * 加班记录 服务类
 *
 * @author 里予
 * @since 2022-1-29
 */
public interface OverTimeService {

    /**
     * 根据员工名称查询打卡记录
     * @param overtimeask
     * @return
     */
    IPage<Overtimeask> selectOverTimeRecordAll(Overtimeask overtimeask);

    /**
     * 删除加班记录
     * @param overtimeask
     * @return
     */
    Integer deleteOverTime(Overtimeask overtimeask);

    /**
     * 开始加班
     * @param overtimeask
     * @return
     */
    String updateBeginOverTime(Overtimeask overtimeask);

    /**
     * 结束加班
     * @param overtimeask
     * @return
     */
    String updateEndOverTime(Overtimeask overtimeask);
}
