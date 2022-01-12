package com.trkj.framework.mybatisplus.service;


import com.trkj.framework.entity.mybatisplus.WorkExperience;

public interface WorkExperienceService {
    /**
     * 添加工作经历
     * @param workExperience
     * @return
     */
    int insertWorkExperience(WorkExperience workExperience);

    /**
     * 修改工作经历
     * @param workExperience
     * @return
     */
    int updateWork(WorkExperience workExperience);
}
