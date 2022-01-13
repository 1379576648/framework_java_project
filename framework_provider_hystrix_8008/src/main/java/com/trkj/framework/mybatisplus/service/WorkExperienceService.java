package com.trkj.framework.mybatisplus.service;


import com.trkj.framework.entity.mybatisplus.WorkExperience;

import java.util.ArrayList;

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

    /**
     * 删除工作经历
     * @param list
     * @return
     */
    String deleteWork(ArrayList<Integer> list);
}
