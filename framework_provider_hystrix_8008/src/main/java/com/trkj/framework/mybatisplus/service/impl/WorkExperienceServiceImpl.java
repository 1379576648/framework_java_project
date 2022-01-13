package com.trkj.framework.mybatisplus.service.impl;

import com.trkj.framework.entity.mybatisplus.WorkExperience;
import com.trkj.framework.mybatisplus.mapper.WorkExperienceMapper;
import com.trkj.framework.mybatisplus.service.WorkExperienceService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {
    @Autowired
    private WorkExperienceMapper workExperienceMapper;

    /**
     * 添加工作经历
     * @param workExperience
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertWorkExperience(WorkExperience workExperience) {
        return workExperienceMapper.insert(workExperience);
    }

    /**
     * 修改工作经历
     * @param workExperience
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateWork(WorkExperience workExperience) {
        final var i = workExperienceMapper.updateById(workExperience);
        if (i>=1){
            return 999;
        }else {
            return 100;
        }
    }
}
