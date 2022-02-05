package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Leave;

public interface LeaveRecordService {
    /**
     * 根据员工名称查询请假记录
     * @param leave
     * @return
     */
    IPage<Leave> selectLeaveRecordAll(Leave leave);

    /**
     * 删除请假记录
     * @param leave
     * @return
     */
    Integer deleteLeave(Leave leave);
}
