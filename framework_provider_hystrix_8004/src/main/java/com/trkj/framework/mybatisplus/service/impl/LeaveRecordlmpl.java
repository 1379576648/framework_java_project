package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Leave;
import com.trkj.framework.mybatisplus.mapper.CardRecordMapper;
import com.trkj.framework.mybatisplus.mapper.LeaveRecordMapper;
import com.trkj.framework.mybatisplus.service.LeaveRecordService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LeaveRecordlmpl implements LeaveRecordService {
    @Autowired
    private LeaveRecordMapper leaveRecordMapper;

    @Override
    public IPage<Leave> selectLeaveRecordAll(Leave leave) {
        Page<Leave> page = new Page<>(leave.getCurrentPage(), leave.getPagesize());
        final var staffName = leave.getStaffName();
        QueryWrapper<Leave> queryWrapper = new QueryWrapper<>();
        if (leave.getStartTime() != null || leave.getEndTime() != null) {
            //根据开始日期结束日期范围查询
            queryWrapper.between("CREATED_TIME", leave.getStartTime(), leave.getEndTime());
        }
        queryWrapper.eq("STAFF_NAME",staffName);
        return leaveRecordMapper.selectPage(page,queryWrapper);
    }

    /**
     * 删除请假记录
     * @param leave
     * @return
     */
    @Override
    public Integer deleteLeave(Leave leave) {
        final var leaveId = leave.getLeaveId();
        Leave leave1 = new Leave();
        leave1.setIsDeleted(1);
        leave1.setLeaveId(leaveId);
        leave1.setUpdatedTime(new Date());
        return leaveRecordMapper.deleteById(leave1);
    }

    @Override
    public void save(Leave leave) {

    }


}
