package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.ClockRecord;
import com.trkj.framework.entity.mybatisplus.Leave;
import com.trkj.framework.entity.mybatisplus.Overtimeask;
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
        queryWrapper.eq("LEAVE_STATE",1);
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
    public String updateBeginLeave(Leave leave) {
        Leave leave1 = new Leave();
        leave1.setLeaveId(leave.getLeaveId());
        leave1.setLeaveActualTime(new Date());
        leave1.setLeaveCondition(1);
        final var i = leaveRecordMapper.updateById(leave1);
        if (i == 1) {
            return "开始请假成功";
        } else {
            return "开始请假失败";
        }
    }

    @Override
    public String updateEndLeave(Leave leave) {
        Leave leave1 = new Leave();
        leave1.setLeaveId(leave.getLeaveId());
        leave1.setLeaveActualOvertime(new Date());
        leave1.setLeaveCondition(2);
        // 实际开始请假时间
        final var leaveActualTime = leave.getLeaveActualTime();
        final var newDate = new Date();
        //时间差的毫秒数
        final var dateDiff = newDate.getTime() - leaveActualTime.getTime();
        //计算出小时数
        final var hours = Math.floor(dateDiff / (3600 * 1000));
        leave1.setLeaveActualToKinAga((int) hours);
        final var i = leaveRecordMapper.updateById(leave1);
        if (i == 1) {
            return "结束请假成功";
        } else {
            return "结束请假失败";
        }
    }
}
