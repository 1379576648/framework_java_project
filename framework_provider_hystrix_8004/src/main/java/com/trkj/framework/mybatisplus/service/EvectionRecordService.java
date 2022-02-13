package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Leave;
import com.trkj.framework.entity.mybatisplus.Travel;

public interface EvectionRecordService {

    /**
     * 根据员工名称查询出差记录
     * @param travel
     * @return
     */
    IPage<Travel> selectEvectionRecordAll(Travel travel);

    /**
     * 删除出差记录
     * @param travel
     * @return
     */
    Integer deleteEvection(Travel travel);

    /**
     * 开始请假
     * @param travel
     * @return
     */
    String updateBeginTravel(Travel travel);

    /**
     * 结束请假
     * @param travel
     * @return
     */
    String updateEndTravel(Travel travel);
}
