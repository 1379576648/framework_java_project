package com.trkj.framework.mybatisplus.service;

import com.trkj.framework.entity.mybatisplus.Staff;


public interface WageTableService {
    /**
     * 查询工资表
     * @param
     * @return
     */
    String selectWage();

    /**
     * 统计工资表
     * @param staff
     * @return
     */
    Object countWage(Staff staff);


}
