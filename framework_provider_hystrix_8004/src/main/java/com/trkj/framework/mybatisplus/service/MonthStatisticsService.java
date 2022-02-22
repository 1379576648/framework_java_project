package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Archive;
import com.trkj.framework.entity.mybatisplus.Staff;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 考勤月统计 服务类
 *
 * @author 里予
 * @since 2022-1-29
 */
public interface MonthStatisticsService {

    /**
     * 查询所有员工的考勤状态次数
     * @param staff
     * @return
     */
    IPage<Staff> selectStaffNameAll(Staff staff);

    /**
     * 添加归档表
     * @param
     * @return
     */
    String archivedData(Staff staff) throws ArithmeticException;

    /**
     * 查询所有考勤归档
     * @param archive
     * @return
     */
    IPage<Archive>selectArchiveAll(Archive archive);

    /**
     * 根据名称查询考勤归档
     * @param archive
     * @return
     */
    List<Archive> selectArchiveByName(Archive archive);

    /**
     * 根据名称查询考勤归档
     * @param archive
     * @return
     */
    IPage<Archive> selectArchiveByNameAndIPage(Archive archive);
}
