package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.mybatisplus.mapper.EmploymentTableMapper;
import com.trkj.framework.mybatisplus.service.EmploymentTableService;
import com.trkj.framework.vo.HireVo;
import com.trkj.framework.vo.WorkVo;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 录用表 服务实现类
 * </p>
 *
 * @author 劉祁
 * @since 2021-12-28
 */
@Service
public class EmploymentTableServiceImpl implements EmploymentTableService {
    @Autowired
    private EmploymentTableMapper employmentTableMapper;

    /**
     * 查询已录用待入职的员工
     */
    @Override
    public IPage<HireVo> selectpage(Page<HireVo> page) {
        return employmentTableMapper.selectpage(page);
    }

    /**
     * 查询已经淘汰的员工
     */
    @Override
    public IPage<HireVo> selectabandon(Page<HireVo> page) {
        return employmentTableMapper.selectabandon(page);
    }

    /**
     * 查询工作经历
     */
    @Override
    public IPage<WorkVo> selectwork(Page<WorkVo> page) {
        return employmentTableMapper.selectwork(page);
    }
}
