package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
     *  查询已录用待入职的员工
     */
    IPage<HireVo> selectpage(HireVo hireVo);

    /**
     * 查询已经淘汰的员工
     */
    IPage<HireVo> selectabandon(HireVo hireVo);

    /**
     * 查询工作经历
     */
    IPage<WorkVo> selectwork(WorkVo workVo);

    /**
     * 查询转正
     */
    IPage<FullVo> selectpost(FullVo fullVo);

    /**
     * 添加员工
     */
    String insertStaff(HireVo hireVo);

}
