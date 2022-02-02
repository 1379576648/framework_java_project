package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Overtimeask;
import com.trkj.framework.mybatisplus.mapper.OverTimeMapper;
import com.trkj.framework.mybatisplus.service.OverTimeService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OverTimelmpl implements OverTimeService{
    @Autowired
    OverTimeMapper overTimeMapper;

    /**
     * 根据员工名称查询加班记录
     * @param overtimeask
     * @return
     */
    @Override
    public IPage<Overtimeask> selectOverTimeRecordAll(Overtimeask overtimeask) {
        Page<Overtimeask> page = new Page<>(overtimeask.getCurrentPage(), overtimeask.getPagesize());
        final var staffName = overtimeask.getStaffName();
        QueryWrapper<Overtimeask> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("STAFF_NAME",staffName);
        return overTimeMapper.selectOverTimeRecordAll(page,queryWrapper);
    }
}
