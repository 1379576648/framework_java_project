package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.vo.HireVo;
import com.trkj.framework.vo.WorkVo;

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
     */
    IPage<HireVo> selectpage(Page<HireVo> page);

    /**
     * 查询已经淘汰的员工
     */
    IPage<HireVo> selectabandon(Page<HireVo> page);

    /**
     * 查询工作经历
     */
    IPage<WorkVo> selectwork(Page<WorkVo> page);

}
