package com.trkj.framework.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.framework.entity.mybatisplus.Travel;
import com.trkj.framework.mybatisplus.mapper.EvectionRecordMapper;
import com.trkj.framework.mybatisplus.service.EvectionRecordService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EvectionRecordlmpl implements EvectionRecordService {
    @Autowired
    private EvectionRecordMapper evectionRecordMapper;

    @Override
    public IPage<Travel> selectEvectionRecordAll(Travel travel) {
        Page<Travel> page = new Page<>(travel.getCurrentPage(), travel.getPagesize());
        final var staffName = travel.getStaffName();
        QueryWrapper<Travel> queryWrapper = new QueryWrapper<>();
        if (travel.getStartTime() != null || travel.getEndTime() != null) {
            //根据开始日期结束日期范围查询
            queryWrapper.between("CREATED_TIME", travel.getStartTime(), travel.getEndTime());
        }
        queryWrapper.eq("STAFF_NAME",staffName);
        return evectionRecordMapper.selectPage(page,queryWrapper);
    }

    @Override
    public Integer deleteEvection(Travel travel) {
        final var travelId = travel.getTravelId();
        Travel travel1 = new Travel();
        travel1.setIsDeleted(1L);
        travel1.setTravelId(travelId);
        travel1.setUpdatedTime(new Date());
        return evectionRecordMapper.deleteById(travel1);
    }
}
