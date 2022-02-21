package com.trkj.framework.mybatisplus.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trkj.framework.entity.mybatisplus.WorkExperience;
import com.trkj.framework.mybatisplus.service.WorkExperienceService;
import com.trkj.framework.util.Fuse8008Util;
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


    @Autowired
    private Fuse8008Util fuse8008Util;

    /**
     * 添加工作经历
     *
     * @param workExperience
     * @return
     */
    @PostMapping("/insertWorkExperience")
    @HystrixCommand(fallbackMethod = "hystixGet")
    public Map<String, Object> insertWorkExperience(@RequestBody WorkExperience workExperience) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info",workExperienceService.insertWorkExperience(workExperience));
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet(@RequestBody WorkExperience workExperience) {
        return fuse8008Util.main();
    }

    /**
     * 修改工作经历
     *
     * @param workExperienceId
     * @return
     */
    @PutMapping("/updateWork")
    @HystrixCommand(fallbackMethod = "updateWorkHystix")
    public Map<String, Object> updateWork(@RequestBody WorkExperience workExperienceId) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", workExperienceService.updateWork(workExperienceId));
        return map1;
    }

    //备选方案
    public Map<String, Object> updateWorkHystix(@RequestBody WorkExperience workExperienceId) {
        return fuse8008Util.main();
    }

    /**
     * 删除工作经历
     *
     * @param list
     * @return
     */
    @DeleteMapping("/deleteWork")
    @HystrixCommand(fallbackMethod = "hystixGet2")
    public Map<String, Object> deleteWork(@RequestBody ArrayList<Integer> list) {
        Map<String, Object> map1 = new HashMap<>(2);
        //状态码
        map1.put("state", 200);
        //返回结果
        map1.put("info", workExperienceService.deleteWork(list));
        return map1;
    }

    //备选方案
    public Map<String, Object> hystixGet2(@RequestBody ArrayList<Integer> list) {
        return fuse8008Util.main();
    }
}
