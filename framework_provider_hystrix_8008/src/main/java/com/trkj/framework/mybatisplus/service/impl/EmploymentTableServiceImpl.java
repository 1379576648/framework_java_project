package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.framework.mybatisplus.mapper.EmploymentTableMapper;
import com.trkj.framework.mybatisplus.service.EmploymentTableService;
import com.trkj.framework.vo.HireVo;
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

    @Override
    public IPage<HireVo> selectpage(Page<HireVo> page) {
        return employmentTableMapper.selectpage(page);
    }
}
