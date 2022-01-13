package com.trkj.framework.mybatisplus.controller;

import com.trkj.framework.entity.mybatisplus.WorkExperience;
import com.trkj.framework.mybatisplus.service.WorkExperienceService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkExperienceController {
    @Autowired
    private WorkExperienceService workExperienceService;

    /**
     * 添加工作经历
     * @param workExperience
     * @return
     */
    @PostMapping("/insertWorkExperience")
    public int insertWorkExperience(@RequestBody WorkExperience workExperience){
        return workExperienceService.insertWorkExperience(workExperience);
    }

    /**
     * 修改工作经历
     * @param workExperienceId
     * @return
     */
    @PutMapping("/updateWork")
    public Object updateWork(@RequestBody WorkExperience workExperienceId){
        //开始时间
        workExperienceId.setWorkStareTime(workExperienceId.getWorkStareTime());
        //结束时间
        workExperienceId.setWorkEndTime(workExperienceId.getWorkEndTime());
        //任职公司
        workExperienceId.setCompanyName(workExperienceId.getCompanyName());
        //职位名称
        workExperienceId.setPositionName(workExperienceId.getPositionName());
        //离职原因
        workExperienceId.setPositionDescribe(workExperienceId.getPositionDescribe());
        final var i = workExperienceService.updateWork(workExperienceId);
        if (i==999){
            return 666;
        }else {
            return 100;
        }
    }
}
