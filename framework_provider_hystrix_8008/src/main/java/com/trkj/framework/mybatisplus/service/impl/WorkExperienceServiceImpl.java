package com.trkj.framework.mybatisplus.service.impl;

import com.trkj.framework.entity.mybatisplus.WorkExperience;
import com.trkj.framework.entity.mybatisplus.staff_workvo;
import com.trkj.framework.mybatisplus.mapper.WorkExperienceMapper;
import com.trkj.framework.mybatisplus.service.WorkExperienceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 工作经历表 服务实现类
 * </p>
 *
 * @author suki
 * @since 2021-12-22
 */
@Service
public class WorkExperienceServiceImpl extends ServiceImpl<WorkExperienceMapper, staff_workvo> implements WorkExperienceService {

    @Autowired
    private WorkExperienceMapper workExperienceMapper;

    public List<staff_workvo> staffSelect() {
        return workExperienceMapper.staffSelect();
    }
}
