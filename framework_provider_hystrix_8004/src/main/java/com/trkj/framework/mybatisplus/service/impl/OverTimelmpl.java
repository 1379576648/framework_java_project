package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Overtimeask;
import com.trkj.framework.mybatisplus.mapper.OverTimeMapper;
import com.trkj.framework.mybatisplus.service.OverTimeService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
        if (overtimeask.getStartTime() != null || overtimeask.getEndTime() != null) {
            //根据开始日期结束日期范围查询
            queryWrapper.between("CREATED_TIME", overtimeask.getStartTime(), overtimeask.getEndTime());
        }
        queryWrapper.eq("STAFF_NAME",staffName);
        return overTimeMapper.selectPage(page,queryWrapper);
    }

    /**
     * 删除加班记录
     * @param overtimeask
     * @return
     */
    @Override
    public Integer deleteOverTime(Overtimeask overtimeask) {
        final var overtimeaskId = overtimeask.getOvertimeaskId();
        Overtimeask overtimeask1 =new Overtimeask();
        overtimeask1.setIsDeleted(1L);
        overtimeask1.setOvertimeaskId(overtimeaskId);
        overtimeask1.setUpdatedTime(new Date());
        return overTimeMapper.deleteById(overtimeask1);
    }
}
