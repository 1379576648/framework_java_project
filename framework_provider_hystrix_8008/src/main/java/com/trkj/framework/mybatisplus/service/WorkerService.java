package com.trkj.framework.mybatisplus.service;

import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.vo.FullVo;

public interface WorkerService {

    /**
     * 添加转正
     * @param fullVo
     * @return
     */
    String insertWorker(FullVo fullVo);

}
