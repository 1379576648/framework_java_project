package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Staff;

import java.util.List;

/**
 * 考勤月统计 服务类
 *
 * @author 里予
 * @since 2022-1-29
 */
public interface MonthStatisticsService {

    IPage<Staff> selectStaffNameAll(Staff staff);
}
