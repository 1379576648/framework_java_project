package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Leave;
import com.trkj.framework.entity.mybatisplus.Overtimeask;

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

    /**
     * 开始请假
     * @param leave
     * @return
     */
    String updateBeginLeave(Leave leave);

    /**
     * 结束请假
     * @param leave
     * @return
     */
    String updateEndLeave(Leave leave);

}
