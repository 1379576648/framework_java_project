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

    /**
     * 根据员工名称查询出差记录
     * @param travel
     * @return
     */
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

    /**
     * 删除出差记录
     * @param travel
     * @return
     */
    @Override
    public Integer deleteEvection(Travel travel) {
        final var travelId = travel.getTravelId();
        Travel travel1 = new Travel();
        travel1.setIsDeleted(1L);
        travel1.setTravelId(travelId);
        travel1.setUpdatedTime(new Date());
        return evectionRecordMapper.deleteById(travel1);
    }

    /**
     * 开始请假
     * @param travel
     * @return
     */
    @Override
    public String updateBeginTravel(Travel travel) {
        Travel travel1 = new Travel();
        travel1.setTravelId(travel.getTravelId());
        travel1.setTravelActualTime(new Date());
        travel1.setTravelCondition(1);
        final var i = evectionRecordMapper.updateById(travel1);
        if (i == 1) {
            return "开始出差成功";
        } else {
            return "开始出差失败";
        }
    }

    /**
     * 结束请假
     * @param travel
     * @return
     */
    @Override
    public String updateEndTravel(Travel travel) {
        Travel travel1 = new Travel();
        travel1.setTravelId(travel.getTravelId());
        travel1.setTravelActualOvertime(new Date());
        travel1.setTravelCondition(2);
        // 实际开始请假时间
        final var travelActualTime = travel.getTravelActualTime();
        final var newDate = new Date();
        //时间差的毫秒数
        final var dateDiff = newDate.getTime() - travelActualTime.getTime();
        //计算出小时数
        final var hours = Math.floor(dateDiff / (3600 * 1000));
        travel1.setTravelActualTokinaga((int) hours);
        final var i = evectionRecordMapper.updateById(travel1);
        if (i == 1) {
            return "结束出差成功";
        } else {
            return "结束出差失败";
        }
    }
}
