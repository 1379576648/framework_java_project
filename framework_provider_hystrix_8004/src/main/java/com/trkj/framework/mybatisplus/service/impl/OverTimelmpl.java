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
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OverTimelmpl implements OverTimeService {
    @Autowired
    OverTimeMapper overTimeMapper;

    /**
     * 根据员工名称查询加班记录
     *
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
        queryWrapper.eq("OVERTIMEASK_STATE", 1);
        queryWrapper.eq("STAFF_NAME", staffName);
        return overTimeMapper.selectPage(page, queryWrapper);
    }

    /**
     * 删除加班记录
     *
     * @param overtimeask
     * @return
     */
    @Override
    public Integer deleteOverTime(Overtimeask overtimeask) {
        final var overtimeaskId = overtimeask.getOvertimeaskId();
        Overtimeask overtimeask1 = new Overtimeask();
        overtimeask1.setIsDeleted(1L);
        overtimeask1.setOvertimeaskId(overtimeaskId);
        overtimeask1.setUpdatedTime(new Date());
        return overTimeMapper.deleteById(overtimeask1);
    }

    @Override
    public String updateBeginOverTime(Overtimeask overtimeask) {
        Overtimeask overtimeask1 = new Overtimeask();
        overtimeask1.setOvertimeaskId(overtimeask.getOvertimeaskId());
        overtimeask1.setOvertimeaskActualTime(new Date());
        overtimeask1.setOvertimeaskCondition(1L);
        final var i = overTimeMapper.updateById(overtimeask1);
        if (i == 1) {
            return "开始加班成功";
        } else {
            return "开始加班失败";
        }
    }

    @Override
    public String updateEndOverTime(Overtimeask overtimeask) {
        Overtimeask overtimeask1 = new Overtimeask();
        overtimeask1.setOvertimeaskId(overtimeask.getOvertimeaskId());
        overtimeask1.setOvertimeaskActualOvertime(new Date());
        overtimeask1.setOvertimeaskCondition(2L);
        // 实际开始加班时间
        final var overtimeaskActualTime = overtimeask.getOvertimeaskActualTime();
        final var newDate = new Date();
        //时间差的毫秒数
        final var dateDiff = newDate.getTime() - overtimeaskActualTime.getTime();
        //计算出小时数
        final var hours = Math.floor(dateDiff / (3600 * 1000));
        overtimeask1.setOvertimeaskActualTokinaga((int) hours);
        final var i = overTimeMapper.updateById(overtimeask1);
        if (i == 1) {
            return "结束加班成功";
        } else {
            return "结束加班失败";
        }
    }
}
