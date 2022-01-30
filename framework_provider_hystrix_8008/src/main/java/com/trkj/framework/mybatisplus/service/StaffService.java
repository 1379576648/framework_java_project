package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.framework.entity.mybatisplus.Worker;
import com.trkj.framework.vo.FullVo;
import com.trkj.framework.vo.StaffQuitVo;
import com.trkj.framework.vo.StaffVo;
import com.trkj.framework.vo.TransferVo;

import java.util.List;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author suki
 * @since 2022-01-04
 */
public interface StaffService {
    /**
     * 查询员工花名册
     * @param staffVo
     * @return
     */
    IPage<StaffVo> selectStaff(StaffVo staffVo);

    /**
     * 根据id查询员工信息
     * @param staffVo
     * @return
     */
    List<StaffVo> selectStaffAll(StaffVo staffVo);

    /**
     * 查询历史花名册
     * @param staffQuitVo
     * @return
     */
    IPage<StaffQuitVo> selectQuit(StaffQuitVo staffQuitVo);



    /**
     * 修改员工信息
     * @param staff
     * @return
     */
    int updateStaff(Staff staff);

    /**
     * 修改员工信息2
     * @param staff
     * @return
     */
    int updateStaffTwo(Staff staff);

    /**
     * 修改员工状态为正式
     * @param staff
     * @return
     */
    int updateStaffState(Staff staff);

    /**
     * 修改员工状态为离职
     * @param staff
     * @return
     */
    int updateStaffStateTwo(Staff staff);

    /**
     * 修改转正日期
     * @param staff
     * @return
     */
    int updateWorkerDate(Staff staff);

    /**
     * 快要转正名单
     * @param fullVo
     * @return
     */
    IPage<FullVo> selectQuick(FullVo fullVo);

    /**
     * 统计快要转正名单
     * @param
     * @return
     */
    List<Staff> countByStaffState();

    /**
     * 转正已生效
     * @param fullVo
     * @return
     */
    IPage<FullVo> selectStateOne(FullVo fullVo);

    /**
     * 统计转正已生效
     * @return
     */
    List<Staff> countStateOne();

    /**
     * 统计试用期人员
     * @return
     */
    List<Staff> countStateTwo();

    /**
     * 本月离职
     * @return
     */
    List<Staff> countStateThree();

    /**
     * 正式
     * @return
     */
    List<Staff> countStateFour();

    /**
     * 试用
     * @return
     */
    List<Staff> countStateFive();

    /**
     *本月新入职
     * @return
     */
    List<Staff> countStateSix();
}
