package com.trkj.framework.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.vo.HireVo;

/**
 * <p>
 * 录用表 服务类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-28
 */

public interface EmploymentTableService {
    IPage<HireVo> selectpage(Page<HireVo> page);
}
