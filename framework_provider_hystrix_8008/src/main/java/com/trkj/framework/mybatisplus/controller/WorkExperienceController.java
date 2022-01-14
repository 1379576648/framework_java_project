package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.WorkExperience;
import com.trkj.framework.mybatisplus.service.WorkExperienceService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    @HystrixCommand(fallbackMethod = "HystixGet")
    public Object insertWorkExperience(@RequestBody WorkExperience workExperience){
        return workExperienceService.insertWorkExperience(workExperience);
    }

    //备选方案
    public Object HystixGet(@RequestBody WorkExperience workExperience){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
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

    /**
     * 删除工作经历
     * @param list
     * @return
     */
    @DeleteMapping("/deleteWork")
    @HystrixCommand(fallbackMethod = "HystixGet2")
    public Object deleteWork(@RequestBody ArrayList<Integer> list){
        Map<String ,Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state",200);
        //返回结果
        map1.put("info",workExperienceService.deleteWork(list));
        return map1;
    }

    //备选方案
    public Object HystixGet2(@RequestBody ArrayList<Integer> list){
        Map<String,Object> map1 = new HashMap<>(2);
        map1.put("state",300);
        map1.put("info","服务发生雪崩");
        return map1;
    }
}
