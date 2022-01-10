package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.baomidou.mybatisplus.extension.service.IService;
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
     * 查询调动管理
     * @param transferVo
     * @return
     */
    IPage<TransferVo> selectTransfer(TransferVo transferVo);

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


}
