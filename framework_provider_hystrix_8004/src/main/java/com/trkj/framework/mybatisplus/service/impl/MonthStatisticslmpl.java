package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Dept;
import com.trkj.framework.entity.mybatisplus.Leave;
import com.trkj.framework.entity.mybatisplus.Staff;
import com.trkj.framework.mybatisplus.mapper.CardRecordMapper;
import com.trkj.framework.mybatisplus.mapper.DeptMapper;
import com.trkj.framework.mybatisplus.mapper.StaffMapper;
import com.trkj.framework.mybatisplus.service.MonthStatisticsService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthStatisticslmpl implements MonthStatisticsService {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private CardRecordMapper cardRecordMapper;

    @Override
    public IPage<Staff> selectStaffNameAll(Staff staff) {
        Page<Staff> page = new Page<>(staff.getCurrentPage(), staff.getPageSize());
        QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("STAFF_NAME", staff.getStaffName());
        final var staff1 = staffMapper.selectPage(page, queryWrapper);
        for (int i = 0; i < staff1.getRecords().size(); i++) {
            Dept dept = deptMapper.selectById(staff1.getRecords().get(i).getDeptId());
            if (dept == null) {
                return staff1;
            }
            staff1.getRecords().get(i).setDeptName(dept.getDeptName());
            QueryWrapper<ClockRecord> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("STAFF_NAME", staff1.getRecords().get(i).getStaffName());
            final var clockRecords = cardRecordMapper.selectCountState(queryWrapper1);
            staff1.getRecords().get(i).setList(clockRecords);
        }
        return staff1;
    }
}
