package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.EmploymentTable;
import com.trkj.framework.entity.mybatisplus.Resume;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.vo.Auditflowone;
import com.trkj.framework.vo.FullVo;
import com.trkj.framework.vo.HireVo;
import com.trkj.framework.vo.WorkVo;

import java.util.List;

/**
 * <p>
 * 录用表 服务类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-28
 */

public interface EmploymentTableService {

    /**
     * 查询已录用待入职的员工
     * @param hireVo
     * @return
     */
    IPage<HireVo> selectpage(HireVo hireVo);

    /**
     * 查询已经淘汰的员工
     * @param hireVo
     * @return
     */
    IPage<HireVo> selectabandon(HireVo hireVo);

    /**
     * 查询工作经历
     * @param workVo
     * @return
     */
    IPage<WorkVo> selectwork(WorkVo workVo);

    /**
     * 根据id查询工作经历
     * @param workVo
     * @return
     */
    List<WorkVo> selectWorkAll(WorkVo workVo);

    /**
     * 根据id查询奖励
     * @param workVo
     * @return
     */
    List<WorkVo> selectGloryAll(WorkVo workVo);

    /**
     * 根据id查询惩罚
     * @param workVo
     * @return
     */
    List<WorkVo> selectPunishAll(WorkVo workVo);

    /**
     * 根据id查询教育经历
     * @param workVo
     * @return
     */
    List<WorkVo> selectEducationAll(WorkVo workVo);

    /**
     * 查询转正
     * @param fullVo
     * @return
     */
    IPage<FullVo> selectpost(FullVo fullVo);

    /**
     * 添加员工
     * @param hireVo
     * @return
     */
    String insertStaff(HireVo hireVo);

    /**
     * 修改录用状态为已录用
     * @param employmentTable
     * @return
     */
    int updateEmploymentState(EmploymentTable employmentTable);

    /**
     * 修改录用状态为已淘汰以及放弃原因
     * @param employmentTable
     * @return
     */
    int updateEmploymentStateAndWaiveReasonInt(EmploymentTable employmentTable);

    /**
     * 根据工作经历id查询工作经历
     * @param workVo
     * @return
     */
    List<WorkVo> selectWorkOne(WorkVo workVo);

}
